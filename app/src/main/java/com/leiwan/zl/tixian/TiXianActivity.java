package com.leiwan.zl.tixian;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TiXianActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.toAlipay)
    RelativeLayout toAlipay;
    @BindView(R.id.toBank)
    RelativeLayout toBank;
    @BindView(R.id.withdraw_explain)
    TextView withdrawExplain;

    @Override
    protected int setLayout() {
        return R.layout.activity_ti_xian;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.back, R.id.toAlipay, R.id.toBank, R.id.withdraw_explain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.toAlipay:
                break;
            case R.id.toBank:
                break;
            case R.id.withdraw_explain:
                break;
        }
    }
}
