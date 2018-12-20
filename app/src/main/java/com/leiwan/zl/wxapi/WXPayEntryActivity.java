package com.leiwan.zl.wxapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {


    @Override
    protected int setLayout() {
        return R.layout.activity_wxpay_entry;
    }

    @Override
    protected void setView() {

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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        App.mWxApi.handleIntent(intent, this);
        finish();
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        LogUtil.d("zhenglei" + "支付回调------------" + JSON.toJSONString(baseResp));
        finish();
    }
}
