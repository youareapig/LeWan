package com.leiwan.zl.dingdan.details;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.OrderDetalsData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.TimeOverView2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaiFuKuanDetailsActivity extends BaseActivity {


    @BindView(R.id.noticeview)
    LinearLayout noticeview;
    @BindView(R.id.noticeviewshow)
    LinearLayout noticeviewshow;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.points)
    LinearLayout points;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.dingdan_tag)
    TextView dingdanTag;
    @BindView(R.id.dingdan_time)
    TimeOverView2 dingdanTime;
    @BindView(R.id.dingdan_name)
    TextView dingdanName;
    @BindView(R.id.dingdan_guige)
    TextView dingdanGuige;
    @BindView(R.id.dingdan_youhui)
    TextView dingdanYouhui;
    @BindView(R.id.dingdan_price)
    TextView dingdanPrice;
    @BindView(R.id.dingdan_id)
    TextView dingdanId;
    @BindView(R.id.dingdan_day)
    TextView dingdanDay;
    @BindView(R.id.dingdan_submittime)
    TextView dingdanSubmittime;
    @BindView(R.id.dingdan_address)
    TextView dingdanAddress;
    @BindView(R.id.phonenumber)
    TextView phonenumber;
    @BindView(R.id.dingdan_people)
    TextView dingdanPeople;
    @BindView(R.id.dingdan_people_tel)
    TextView dingdanPeopleTel;
    @BindView(R.id.dingdan_pay)
    TextView dingdanPay;
    private Handler handler;
    private String orderID;

    @Override
    protected int setLayout() {
        return R.layout.activity_ding_dan_details;
    }

    @Override
    protected void setView() {
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
                noticeviewshow.setVisibility(View.VISIBLE);
                noticeview.setVisibility(View.GONE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Message message = new Message();
                            message.what = 1;
                            Thread.sleep(3000);
                            handler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                LogUtil.d("tag", "onAnimationRepeat");
            }
        });
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, -75);
                    translateAnimation.setDuration(1000);
                    noticeviewshow.startAnimation(translateAnimation);
                    noticeviewshow.setVisibility(View.GONE);
                }
            }
        };
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
                OrderDetalsData data = JSON.parseObject(result, OrderDetalsData.class);
                if (data.getCode() == 200) {
                    //倒计时
                    long endetime = data.getData().getPayendtime();
                    initTimeOver(endetime);
                }
            }
        });
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

    @OnClick({R.id.back, R.id.dingdan_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.dingdan_pay:
                break;
        }
    }
}
