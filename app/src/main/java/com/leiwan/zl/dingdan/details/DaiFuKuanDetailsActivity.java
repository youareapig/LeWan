package com.leiwan.zl.dingdan.details;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaiFuKuanDetailsActivity extends BaseActivity {


    @BindView(R.id.noticeview)
    LinearLayout noticeview;
    @BindView(R.id.noticeviewshow)
    LinearLayout noticeviewshow;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.points)
    LinearLayout points;
    private Handler handler;

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

    }

}
