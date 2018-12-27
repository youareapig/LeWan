package com.leiwan.zl.dingdan.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.OrderDetalsData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YiFuKuanDetailsActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.dingdan_tag)
    TextView dingdanTag;
    @BindView(R.id.dingdan_time)
    TextView dingdanTime;
    @BindView(R.id.dingdan_price)
    TextView dingdanPrice;
    @BindView(R.id.dingdan_name)
    TextView dingdanName;
    @BindView(R.id.dingdan_day)
    TextView dingdanDay;
    @BindView(R.id.dingdan_guige)
    TextView dingdanGuige;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.dingdan_id)
    TextView dingdanId;
    @BindView(R.id.dingdan_submittime)
    TextView dingdanSubmittime;
    @BindView(R.id.dingdan_people)
    TextView dingdanPeople;
    @BindView(R.id.dingdan_tel)
    TextView dingdanTel;
    @BindView(R.id.goindex)
    TextView goindex;
    private String orderID;
    private AdapterCode adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_yi_fu_kuan_details;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
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
                LogUtil.d("tag", "已付款" + result);
                final OrderDetalsData data = JSON.parseObject(result, OrderDetalsData.class);
                if (data.getCode() == 200) {

                    dingdanName.setText(data.getData().getProduct_name());
                    dingdanDay.setText(DateUtils.timeslashData(data.getData().getStartusetime() + "") + "至" + DateUtils.timeslashData(data.getData().getEndusetime() + ""));
                    dingdanPrice.setText("需支付:¥" + data.getData().getTotalmoney());
                    dingdanGuige.setText("¥" + data.getData().getPrice() + "*" + data.getData().getNum() + "份" + "   " + data.getData().getProduct_property());
                    dingdanId.setText("订单编号: " + data.getData().getOrder_no());
                    dingdanSubmittime.setText("下单时间: " + DateUtils.timedate(data.getData().getAddtime() + ""));
                    dingdanPeople.setText("联系人: " + data.getData().getFullname());
                    dingdanTel.setText("联系电话: " + data.getData().getMobile());

                    adapter=new AdapterCode(R.layout.ordercodeitem,data.getData().getCode());
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();

                }
            }
        });
    }


    @OnClick({R.id.back, R.id.goindex})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.goindex:
                break;
        }
    }
}
