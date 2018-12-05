package com.leiwan.zl.wxapi;

import android.content.Intent;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
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

    @Override
    public void onResp(BaseResp baseResp) {
        LogUtil.d("zhenglei" + "baseResp------------" + JSON.toJSONString(baseResp));
        String baseJson = JSON.toJSONString(baseResp);
        WXBaseRespEntity tokenEntity = JSON.parseObject(baseJson, WXBaseRespEntity.class);
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                if (tokenEntity.getErrCode() == 0) {
                    //用户同意授权
                    Connector.getWXcode(this, tokenEntity.getCode(), new Connector.MyCallback() {
                        @Override
                        public void MyResult(String result) {
                            LogUtil.d("result", "result---" + result);
                            WXAccessTokenEntity entity = JSON.parseObject(result, WXAccessTokenEntity.class);
                            String access_token = entity.getAccess_token();
                            String openid = entity.getOpenid();

                            Connector.getWXUserInfo(WXEntryActivity.this, access_token, openid, new Connector.MyCallback() {
                                @Override
                                public void MyResult(String result) {
                                    //resutl为用户信息
                                    LogUtil.d("result", "userinfo---" + result);
                                    WXUserInfo info = JSON.parseObject(result, WXUserInfo.class);
                                    String userHead = info.getHeadimgurl();
                                    SharedPreferencesUtil.getInstance(WXEntryActivity.this).putSP("userhead", userHead);
//                                    Intent intent = getIntent();
//                                    intent.putExtra("userhead", userHead);
//                                    WXEntryActivity.this.setResult(0, intent);
                                    finish();
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
