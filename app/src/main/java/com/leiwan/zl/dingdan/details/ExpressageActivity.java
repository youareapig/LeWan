package com.leiwan.zl.dingdan.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.OrderDetalsData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.HiddenAnimUtils;
import com.leiwan.zl.utils.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpressageActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.expressage_tag)
    TextView expressageTag;
    @BindView(R.id.dingdan_time)
    TextView dingdanTime;
    @BindView(R.id.expressage_price)
    TextView expressagePrice;
    @BindView(R.id.dingdan_name)
    TextView dingdanName;
    @BindView(R.id.dingdan_day)
    TextView dingdanDay;
    @BindView(R.id.dingdan_guige)
    TextView dingdanGuige;
    @BindView(R.id.physical)
    TextView physical;
    @BindView(R.id.physical_id)
    TextView physicalId;
    @BindView(R.id.dingdan_dianpu)
    TextView dingdanDianpu;
    @BindView(R.id.zhankai)
    ImageView zhankai;
    @BindView(R.id.zhankaiview)
    RelativeLayout zhankaiview;
    @BindView(R.id.dingdan_address)
    TextView dingdanAddress;
    @BindView(R.id.dingdan_daohang)
    TextView dingdanDaohang;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.dingdan_more)
    LinearLayout dingdanMore;
    @BindView(R.id.dingdan_id)
    TextView dingdanId;
    @BindView(R.id.dingdan_submittime)
    TextView dingdanSubmittime;
    @BindView(R.id.dingdan_people)
    TextView dingdanPeople;
    @BindView(R.id.dingdan_tel)
    TextView dingdanTel;
    @BindView(R.id.Receiving)
    TextView Receiving;

    private String title;
    private String orderID;
    private int height = 0;
    private int itemnum = 0;
    private AdapterMoreStore adapter;
    private List<OrderDetalsData.DataBean.ShopBean> shopList;
    private String address;

    @Override
    protected int setLayout() {
        return R.layout.activity_expressage;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
    }

    @Override
    protected void setData() {
        title = getIntent().getStringExtra("title");
        orderID = getIntent().getStringExtra("orderid");
        expressageTag.setText(title);
        getData();
    }


    @OnClick({R.id.back, R.id.zhankaiview, R.id.Receiving})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.zhankaiview:
                HiddenAnimUtils.newInstance(this, dingdanMore, zhankai, height).toggle();
                break;
            case R.id.Receiving:
                break;
        }
    }

    private void getData() {
        Connector.OrderDetails(this, token, orderID, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "收货详情" + result);
                final OrderDetalsData data = JSON.parseObject(result, OrderDetalsData.class);
                if (data.getCode() == 200) {
                    //多店
                    shopList = data.getData().getShop();
                    itemnum = shopList.size();
                    height = 50 + 44 * itemnum;
                    MoreStore(0, data.getData());

                    expressagePrice.setText("已支付：" + data.getData().getTotalmoney());
                    dingdanName.setText(data.getData().getProduct_name());
                    dingdanDay.setText(DateUtils.timeslashData(data.getData().getStartusetime() + "") + "至" + DateUtils.timeslashData(data.getData().getEndusetime() + ""));
                    dingdanGuige.setText("¥" + data.getData().getPrice() + "*" + data.getData().getNum() + "份" + "   " + data.getData().getProduct_property());

                    if (data.getData().getExpress_no() == null) {
                        physicalId.setText("物流单号：");
                    } else {
                        physicalId.setText("物流单号：" + data.getData().getExpress_no());
                    }
                    if (data.getData().getExpress_firm() == null) {
                        physical.setText("物流公司:");
                    } else {
                        physical.setText("物流公司:" + data.getData().getExpress_firm());
                    }


                    dingdanId.setText("订单编号: " + data.getData().getOrder_no());
                    dingdanSubmittime.setText("下单时间: " + DateUtils.timedate(data.getData().getAddtime() + ""));
                    dingdanPeople.setText("联系人: " + data.getData().getFullname());
                    dingdanTel.setText("联系电话: " + data.getData().getMobile());

                    adapter = new AdapterMoreStore(R.layout.ordermorestoreitem, shopList);
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                    adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                            MoreStore(position, data.getData());
                            adapter.setSelectItem(position);
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    private void MoreStore(int item, OrderDetalsData.DataBean bean) {
        address = bean.getShop().get(item).getMerchant_address();
        dingdanDianpu.setText(bean.getShop().get(item).getMerchant_name() + bean.getShop().get(item).getMerchant_400tel());
        dingdanAddress.setText(address);
    }
}
