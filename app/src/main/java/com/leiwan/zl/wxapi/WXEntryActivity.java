package com.leiwan.zl.wxapi;

import android.content.Intent;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.WXAccessTokenEntity;
import com.leiwan.zl.data.WXBaseRespEntity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
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
        App.mWxApi.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {
        LogUtil.d("onReq" + "baseReq" + baseReq);
    }

    @Override
    public void onResp(BaseResp baseResp) {
        LogUtil.d("onResp" + "baseResp" + JSON.toJSONString(baseResp));
        String baseJson = JSON.toJSONString(baseResp);
        WXBaseRespEntity tokenEntity = JSON.parseObject(baseJson, WXBaseRespEntity.class);

        if (tokenEntity.getErrCode() == 0) {
            //用户同意授权
            Connector.getWXcode(this, tokenEntity.getCode(), new Connector.MyCallback() {
                @Override
                public void MyResult(String result) {
                    LogUtil.d("result", "result---" + result);
                    WXAccessTokenEntity entity = JSON.parseObject(result, WXAccessTokenEntity.class);

                    Connector.getWXUserInfo(WXEntryActivity.this, entity.getAccess_token(), entity.getOpenid(), new Connector.MyCallback() {
                        @Override
                        public void MyResult(String result) {
                            //resutl为用户信息
                        }
                    });
                }
            });
        }
        if (tokenEntity.getErrCode() == -4) {
            //用户拒绝授权
        }
        if (tokenEntity.getErrCode() == -2) {
            //用户取消
        }

    }


}
