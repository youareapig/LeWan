package com.leiwan.zl.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.login)
    Button login;

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
        Glide.with(this).load(SharedPreferencesUtil.getInstance(this).getSP("userhead")).into(head);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        LogUtil.d("Login", "onActivityResult---"+resultCode);
//        if (resultCode == 0) {
//            String headUrl = data.getStringExtra("userhead");
//            Glide.with(this).load(headUrl).into(head);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        if (App.mWxApi!=null&&App.mWxApi.isWXAppInstalled()){
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "lewan_wechat_login";
            App.mWxApi.sendReq(req);

        }else {
            ToastUtil.showShortToast("用户未安装微信");
        }

    }
}
