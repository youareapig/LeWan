package com.leiwan.zl.bank;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.BandCardEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddBankActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userbankId)
    BandCardEditText userbankId;
    @BindView(R.id.userbanktype)
    EditText userbanktype;
    @BindView(R.id.userkaihu)
    EditText userkaihu;
    @BindView(R.id.userphone)
    EditText userphone;
    @BindView(R.id.add)
    RelativeLayout add;

    @Override
    protected int setLayout() {
        return R.layout.activity_add_bank;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        userbankId.setBankCardListener(new BandCardEditText.BankCardListener() {
            @Override
            public void success(String name) {
                Log.d("tag","查询成功"+name);
                userbanktype.setText(name);
                userbanktype.setFocusable(false);
                userbanktype.setEnabled(false);
            }

            @Override
            public void failure() {
                Log.d("tag","查询失败");
                userbanktype.setText("没有查到所属银行");
                userbanktype.setFocusable(true);
                userbanktype.setEnabled(true);
            }
        });
    }

    @OnClick({R.id.back, R.id.add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.add:
                break;
        }
    }
}
