package com.leiwan.zl.wxapi;

import android.content.Intent;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.MainActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.WXAccessTokenEntity;
import com.leiwan.zl.data.WXBaseRespEntity;
import com.leiwan.zl.data.WXUserInfo;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    private String access_token, openid, refresh_token, unionid, userHead, nickname, country, province, city;

    @Override
    protected int setLayout() {
        return R.layout.activity_wxentry;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        App.mWxApi.handleIntent(data, this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        App.mWxApi.handleIntent(intent, this);
        finish();
    }

    @Override
    protected void setData() {
        try {
            boolean result = App.mWxApi.handleIntent(getIntent(), this);
            if (!result) {
                ToastUtil.showShortToast("参数不合法");
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onReq(BaseReq baseReq) {
        LogUtil.d("onReq" + "baseReq" + baseReq);
    }

    /**
     * 40001 invalid credential 不合法的调用凭证
     * 40014 invalid access_token 不合法的access_token
     * 40029 invalid code 不合法或已过期的code
     * 40030 invalid refresh_token 不合法的refresh_token
     * <p>
     * 42001 access_token expired access_token超时
     * 42002 refresh_token expired refresh_token超时
     * 42003 code expired code超时
     * <p>
     * 50001 api unauthorized 接口未授权
     */

    @Override
    public void onResp(BaseResp baseResp) {
        LogUtil.d("zhenglei" + "baseResp------------" + JSON.toJSONString(baseResp));
        String baseJson = JSON.toJSONString(baseResp);
        WXBaseRespEntity tokenEntity = JSON.parseObject(baseJson, WXBaseRespEntity.class);
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                if (tokenEntity.getErrCode() == 0) {
                    //用户同意授权
                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("wxcode", tokenEntity.getCode() + "");
                    //同意授权后存入登录状态1
                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("loginTag", 1);

                    Connector.getWXcode(this, tokenEntity.getCode(), new Connector.MyCallback() {
                        @Override
                        public void MyResult(String result) {
                            LogUtil.d("result", "result---" + result);
                            WXAccessTokenEntity entity = JSON.parseObject(result, WXAccessTokenEntity.class);

                            access_token = entity.getAccess_token();
                            openid = entity.getOpenid();
                            refresh_token = entity.getRefresh_token();
                            unionid = entity.getUnionid();

                            SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("access_token", access_token);
                            SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("openid", openid);
                            SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("refresh_token", refresh_token);
                            SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("unionid", unionid);

                            Connector.getWXUserInfo(WXEntryActivity.this, access_token, openid, new Connector.MyCallback() {
                                @Override
                                public void MyResult(String result) {
                                    //resutl为用户信息
                                    LogUtil.d("result", "userinfo---" + result);
                                    WXUserInfo info = JSON.parseObject(result, WXUserInfo.class);
                                    userHead = info.getHeadimgurl();
                                    nickname = info.getNickname();
                                    country = info.getCountry();
                                    province = info.getProvince();
                                    city = info.getCity();

//                                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("userhead", userHead);
//                                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("nickname", nickname);
//                                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("country", country);
//                                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("province", province);
//                                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("city", city);
                                    Intent intent = new Intent(WXEntryActivity.this, MainActivity.class);
                                    intent.putExtra("indextag", 3);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
                if (tokenEntity.getErrCode() == -4) {
                    //用户拒绝授权
                    ToastUtil.showShortToast("用户拒绝授权");
                    finish();
                }
                if (tokenEntity.getErrCode() == -2) {
                    //用户取消
                    ToastUtil.showShortToast("用户拒绝授权");
                    finish();
                }
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                ToastUtil.showShortToast("用户拒绝授权");
                finish();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                ToastUtil.showShortToast("发送被拒绝");
                finish();
                break;
            case BaseResp.ErrCode.ERR_BAN:
                ToastUtil.showShortToast("签名错误");
                finish();
                break;
            default:
                ToastUtil.showShortToast("发送返回");
                break;

        }


    }


}
