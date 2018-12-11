package com.leiwan.zl.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.LoginData;
import com.leiwan.zl.data.RefreshTokenData;
import com.leiwan.zl.data.WXData;
import com.leiwan.zl.data.WXUserInfo;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.leiwan.zl.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.login)
    Button login;
    private String access_token, openid, refresh_token, unionid, headimgurl, nickname, country, province, city;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {

    }


    @Override
    protected void onResume() {
        super.onResume();
        access_token = SharedPreferencesUtil.getInstance(this).getSP("access_token");
        openid = SharedPreferencesUtil.getInstance(this).getSP("openid");
        refresh_token = SharedPreferencesUtil.getInstance(this).getSP("refresh_token");
        unionid = SharedPreferencesUtil.getInstance(this).getSP("unionid");

        isToken();
    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        if (App.mWxApi != null && App.mWxApi.isWXAppInstalled()) {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "lewan_wechat_login";
            App.mWxApi.sendReq(req);

        } else {
            ToastUtil.showShortToast("用户未安装微信");
        }


    }

    private void isToken() {
        //TODO 刷新微信token
        Connector.WXreFreshToken(this, refresh_token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "isToken---" + result);
                //需要判断微信返回是否有错误码，如果没有，表示refresh_token有效，反之无效；再判断错误码进行操作（通常都是表示refresh_token超时，需要重新授权）
                RefreshTokenData data = JSON.parseObject(result, RefreshTokenData.class);
                //TODO 获取刷新后的用户信息
                Connector.getWXUserInfo(LoginActivity.this, data.getAccess_token(), openid, new Connector.MyCallback() {
                    @Override
                    public void MyResult(String result) {
                        LogUtil.d("shuaxin", "shuaxin---" + result);
                        WXUserInfo info = JSON.parseObject(result, WXUserInfo.class);
                        headimgurl = info.getHeadimgurl();
                        nickname = info.getNickname();
                        country = info.getCountry();
                        province = info.getProvince();
                        city = info.getCity();
                        Glide.with(LoginActivity.this).load(headimgurl).into(head);

                        Connector.WeChatLogin(LoginActivity.this, toJson(), new Connector.MyCallback() {
                            @Override
                            public void MyResult(String result) {
                                //TODO 将用户信息上传到服务器
                                LogUtil.d("login", "login----" + result);
                                LoginData data = JSON.parseObject(result, LoginData.class);
                                if (data.getCode() == 200) {

                                }
                            }
                        });

                    }
                });
            }
        });
    }

    //对象转json
    private String toJson() {
        WXData wxData = new WXData();
        wxData.setAccess_token(access_token);
        wxData.setOpenid(openid);
        wxData.setRefresh_token(refresh_token);
        wxData.setUnionid(unionid);
        wxData.setHeadimgurl(headimgurl);
        wxData.setNickname(nickname);
        wxData.setCountry(country);
        wxData.setProvince(province);
        wxData.setCity(city);
        String jsonString = JSON.toJSONString(wxData);
        return jsonString;
    }
}
