package com.leiwan.zl.login;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.gyf.barlibrary.ImmersionBar;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.LoginData;
import com.leiwan.zl.data.RefreshTokenData;
import com.leiwan.zl.data.WXData;
import com.leiwan.zl.data.WXUserInfo;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.wechat_login)
    RelativeLayout wechatLogin;
    @BindView(R.id.other_login)
    LinearLayout otherLogin;
    @BindView(R.id.fuwu)
    TextView fuwu;
    @BindView(R.id.yinsi)
    TextView yinsi;
    private String headimgurl, nickname, country, province, city;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setView() {
        ImmersionBar.with(this)
                .transparentBar().fullScreen(true).fitsSystemWindows(false).statusBarDarkFont(false).init();
    }

    @Override
    protected void setData() {

    }


    @Override
    protected void onResume() {
        super.onResume();

        isToken();
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
//                        Glide.with(LoginActivity.this).load(headimgurl).into(head);

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


    @OnClick({R.id.wechat_login, R.id.other_login, R.id.fuwu, R.id.yinsi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wechat_login:
                if (App.mWxApi != null && App.mWxApi.isWXAppInstalled()) {
                    SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "lewan_wechat_login";
                    App.mWxApi.sendReq(req);

                } else {
                    ToastUtil.showShortToast("用户未安装微信");
                }
                break;
            case R.id.other_login:
                break;
            case R.id.fuwu:
                break;
            case R.id.yinsi:
                break;
        }
    }
}
