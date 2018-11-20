package com.leiwan.zl.address;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateAddressActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.diqu)
    EditText diqu;
    @BindView(R.id.dizhi)
    EditText dizhi;
    @BindView(R.id.save)
    RelativeLayout save;

    @Override
    protected int setLayout() {
        return R.layout.activity_update_address;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.back, R.id.save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.save:
                break;
        }
    }
}
