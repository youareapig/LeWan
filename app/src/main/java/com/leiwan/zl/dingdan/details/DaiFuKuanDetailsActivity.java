package com.leiwan.zl.dingdan.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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
import com.leiwan.zl.utils.TimeOverView2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaiFuKuanDetailsActivity extends BaseActivity {


    @BindView(R.id.noticeview)
    LinearLayout noticeview;
    @BindView(R.id.noticeviewshow)
    LinearLayout noticeviewshow;

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.dingdan_time)
    TimeOverView2 dingdanTime;
    @BindView(R.id.dingdan_pay)
    TextView dingdanPay;
    @BindView(R.id.dingdan_price)
    TextView dingdanPrice;
    @BindView(R.id.dingdan_name)
    TextView dingdanName;
    @BindView(R.id.dingdan_day)
    TextView dingdanDay;
    @BindView(R.id.dingdan_guige)
    TextView dingdanGuige;
    @BindView(R.id.dingdan_dianpu)
    TextView dingdanDianpu;
    @BindView(R.id.zhankai)
    ImageView zhankai;
    @BindView(R.id.dingdan_address)
    TextView dingdanAddress;
    @BindView(R.id.dingdan_daohang)
    TextView dingdanDaohang;
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
    @BindView(R.id.dingdan_more)
    LinearLayout dingdanMore;
    @BindView(R.id.zhankaiview)
    RelativeLayout zhankaiView;

    private String orderID;
    private int height = 0;
    private int itemnum = 0;
    private AdapterMoreStore adapter;
    private List<OrderDetalsData.DataBean.ShopBean> shopList;
    private String address;

    @Override
    protected int setLayout() {
        return R.layout.activity_ding_dan_details;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, 75);
        translateAnimation.setDuration(1000);
        noticeview.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                LogUtil.d("tag", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                LogUtil.d("tag", "onAnimationEnd");
                noticeview.setVisibility(View.GONE);
                noticeviewshow.setVisibility(View.VISIBLE);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                LogUtil.d("tag", "onAnimationRepeat");
            }
        });

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
                LogUtil.d("tag", "待付款" + result);
                final OrderDetalsData data = JSON.parseObject(result, OrderDetalsData.class);
                if (data.getCode() == 200) {
                    //多店
                    shopList = data.getData().getShop();
                    itemnum = shopList.size();
                    height = 50 + 44 * itemnum;
                    MoreStore(0, data.getData());

                    dingdanName.setText(data.getData().getProduct_name());
                    dingdanDay.setText(DateUtils.timeslashData(data.getData().getStartusetime() + "") + "至" + DateUtils.timeslashData(data.getData().getEndusetime() + ""));
                    dingdanPrice.setText("需支付:¥"+data.getData().getTotalmoney());
                    dingdanGuige.setText("¥" + data.getData().getPrice() + "*" + data.getData().getNum() + "份" + "   " + data.getData().getProduct_property());
                    dingdanId.setText("订单编号: "+data.getData().getOrder_no());
                    dingdanSubmittime.setText("下单时间: "+DateUtils.timedate(data.getData().getAddtime()+""));
                    dingdanPeople.setText("联系人: "+data.getData().getFullname());
                    dingdanTel.setText("联系电话: "+data.getData().getMobile());

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
                    //倒计时
                    long endetime = data.getData().getPayendtime();
                    initTimeOver(endetime);
                }
            }
        });
    }

    private void MoreStore(int item, OrderDetalsData.DataBean bean) {
        address = bean.getShop().get(item).getMerchant_address();
        dingdanDianpu.setText(bean.getShop().get(item).getMerchant_name() + bean.getShop().get(item).getMerchant_400tel());
        dingdanAddress.setText(address);
    }

    private void initTimeOver(long endtime) {
        long[] arr = DateUtils.timeOver(endtime);
        long day = arr[0];
        long hour = arr[1];
        long min = arr[2];
        long second = arr[3];
        if (day <= 0 && hour <= 0 && min <= 0 && second <= 0) {
            dingdanTime.setVisibility(View.GONE);
        } else {
            dingdanTime.setVisibility(View.VISIBLE);
            dingdanTime.setTime(min, second);
            dingdanTime.start();
        }

    }

    @OnClick({R.id.zhankaiview, R.id.back, R.id.dingdan_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.dingdan_pay:
                break;
            case R.id.zhankaiview:
                HiddenAnimUtils.newInstance(this, dingdanMore, zhankai, height).toggle();
                break;
        }
    }

}
