package com.leiwan.zl.dingdan.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;

public class YiFuKuanDetailsActivity extends BaseActivity {

    private String orderID;
    @Override
    protected int setLayout() {
        return R.layout.activity_yi_fu_kuan_details;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        Intent intent = getIntent();
        orderID = intent.getStringExtra("orderid");
        getData();
    }
    private void getData() {
        Connector.OrderDetails(this, token, orderID, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag","已付款"+result);
            }
        });
    }
}
