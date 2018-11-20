package com.leiwan.zl.lianxi;

import android.os.Bundle;
import android.widget.ImageView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LianXiActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;

    @Override
    protected int setLayout() {
        return R.layout.activity_lian_xi;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
