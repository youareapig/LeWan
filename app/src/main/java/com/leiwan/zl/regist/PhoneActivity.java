package com.leiwan.zl.regist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

public class PhoneActivity extends BaseActivity {


    @Override
    protected int setLayout() {
        return R.layout.activity_regist;
    }

    @Override
    protected void setView() {
        ImmersionBar.with(this)
                .transparentBar().fullScreen(true).fitsSystemWindows(false).statusBarDarkFont(false).init();
    }

    @Override
    protected void setData() {

    }
}
