package com.leiwan.zl.login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.gyf.barlibrary.ImmersionBar;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.MainActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.LoginData;
import com.leiwan.zl.data.RefreshTokenData;
import com.leiwan.zl.data.WXData;
import com.leiwan.zl.data.WXUserInfo;
import com.leiwan.zl.regist.PhoneActivity;
import com.leiwan.zl.regist.RegistActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.leiwan.zl.wxapi.WXEntryActivity;
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
    @BindView(R.id.login_more_wechat)
    LinearLayout loginMoreWechat;
    @BindView(R.id.login_more_phone)
    LinearLayout loginMorePhone;
    @BindView(R.id.regist)
    LinearLayout regist;
    @BindView(R.id.up)
    RelativeLayout up;
    @BindView(R.id.login_other_view)
    LinearLayout loginOtherView;
    @BindView(R.id.login_wechat_view)
    LinearLayout loginWechatView;
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
            isToken();
    }


    private void isToken() {
        //TODO 刷新微信token
        Connector.WXreFreshToken(this, refresh_token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "isToken---" + result);
                if (result.indexOf("errcode") >= 1) {
                    //把本地的登录状态抹掉,重新登录
                    LogUtil.d("tag", "退出登录状态");
                } else {
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

                            Connector.WeChatLogin(LoginActivity.this, toJson(), new Connector.MyCallback() {
                                @Override
                                public void MyResult(String result) {
                                    //TODO 将用户信息上传到服务器
                                    LogUtil.d("login", "login----" + result);
                                    LoginData data = JSON.parseObject(result, LoginData.class);
                                    if (data.getCode() == 200) {
                                        SharedPreferencesUtil.getInstance(LoginActivity.this).putSP("token", data.getData().getToken() + "");
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        }
                    });
                }


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


    @OnClick({R.id.login_more_wechat, R.id.login_more_phone, R.id.regist, R.id.up, R.id.wechat_login, R.id.other_login, R.id.fuwu, R.id.yinsi})
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
                loginOtherView.setVisibility(View.VISIBLE);
                loginWechatView.setVisibility(View.GONE);
                break;
            case R.id.fuwu:
                break;
            case R.id.yinsi:
                break;
            case R.id.login_more_wechat:
                //微信登录
                break;
            case R.id.login_more_phone:
                //手机登录
                toClass(this, PhoneActivity.class);
                break;
            case R.id.regist:
                toClass(this, RegistActivity.class);
                break;
            case R.id.up:
                loginOtherView.setVisibility(View.GONE);
                loginWechatView.setVisibility(View.VISIBLE);
                break;
        }
    }


}
