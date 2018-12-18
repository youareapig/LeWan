package com.leiwan.zl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.data.LoginData;
import com.leiwan.zl.data.RefreshTokenData;
import com.leiwan.zl.data.WXData;
import com.leiwan.zl.data.WXUserInfo;
import com.leiwan.zl.login.LoginActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;

public class SplashActivity extends BaseActivity {

    private String headimgurl, nickname, country, province, city;

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        if (isLogin == 1) {
            isToken();
        } else {
            toClass(this, LoginActivity.class);
            finish();
        }
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
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //需要判断微信返回是否有错误码，如果没有，表示refresh_token有效，反之无效；再判断错误码进行操作（通常都是表示refresh_token超时，需要重新授权）
                    RefreshTokenData data = JSON.parseObject(result, RefreshTokenData.class);
                    //TODO 获取刷新后的用户信息
                    Connector.getWXUserInfo(SplashActivity.this, data.getAccess_token(), openid, new Connector.MyCallback() {
                        @Override
                        public void MyResult(String result) {
                            LogUtil.d("shuaxin", "shuaxin---" + result);
                            WXUserInfo info = JSON.parseObject(result, WXUserInfo.class);
                            headimgurl = info.getHeadimgurl();
                            nickname = info.getNickname();
                            country = info.getCountry();
                            province = info.getProvince();
                            city = info.getCity();

                            Connector.WeChatLogin(SplashActivity.this, toJson(), new Connector.MyCallback() {
                                @Override
                                public void MyResult(String result) {
                                    //TODO 将用户信息上传到服务器
                                    LogUtil.d("login", "login----" + result);
                                    LoginData data = JSON.parseObject(result, LoginData.class);
                                    if (data.getCode() == 200) {
                                        //保存用户等级，便于佣金的展示
                                        SharedPreferencesUtil.getInstance(SplashActivity.this).putSP("level", data.getData().getLevel());
                                        //保存用户token
                                        SharedPreferencesUtil.getInstance(SplashActivity.this).putSP("token", data.getData().getToken() + "");

                                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
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
}
