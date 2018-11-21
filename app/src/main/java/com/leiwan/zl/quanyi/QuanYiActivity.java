package com.leiwan.zl.quanyi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuanYiActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.name)
    TextView name;

    @Override
    protected int setLayout() {
        return R.layout.activity_quan_yi;
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
