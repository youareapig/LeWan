package com.leiwan.zl.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.ToastUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class LoginActivity extends BaseActivity {


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

    public void login(View v) {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "lewan_wechat_login";
        App.mWxApi.sendReq(req);
    }
}
