package com.leiwan.zl.second;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.details.DetailsActivity;
import com.leiwan.zl.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.second_banner)
    Banner secondBanner;
    @BindView(R.id.zonghe_text)
    TextView zongheText;
    @BindView(R.id.zonghe_line)
    View zongheLine;
    @BindView(R.id.zonghe)
    RelativeLayout zonghe;
    @BindView(R.id.xiaoliang_text)
    TextView xiaoliangText;
    @BindView(R.id.xiaoliang_line)
    View xiaoliangLine;
    @BindView(R.id.xiaoliang)
    RelativeLayout xiaoliang;
    @BindView(R.id.price_text)
    TextView priceText;
    @BindView(R.id.price_line)
    View priceLine;
    @BindView(R.id.price)
    RelativeLayout price;
    @BindView(R.id.juli_text)
    TextView juliText;
    @BindView(R.id.juli_line)
    View juliLine;
    @BindView(R.id.juli)
    RelativeLayout juli;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    private List<String> list, imgList;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
    }

    @Override
    protected void setData() {
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        switch (title) {
            case "1":
                titleText.setText("新人");
                break;
            case "2":
                titleText.setText("美食");
                break;
            case "3":
                titleText.setText("酒店");
                break;
            case "4":
                titleText.setText("礼品");
                break;
            case "5":
                titleText.setText("亲子");
                break;
            case "6":
                titleText.setText("乐园");
                break;
            case "7":
                titleText.setText("景区");
                break;
            case "8":
                titleText.setText("出行");
                break;

        }

        list = new ArrayList<>();
        list.add("30.25");
        list.add("30.26");
        list.add("30.24");
        list.add("30.20");
        list.add("40.2");
        list.add("90.25");
        adapter = new Adapter(R.layout.index_list_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(view.getContext(), DetailsActivity.class);
                startActivity(intent);

            }
        });
        imgList = new ArrayList<>();
        imgList.add("http://img03.tooopen.com/uploadfile/downs/images/20110714/sy_20110714135215645030.jpg");
        imgList.add("http://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/lvpics/w=600/sign=3da54689a11ea8d38a227704a70a30cf/ac6eddc451da81cb378472ff5566d016092431a5.jpg");
        imgList.add("http://pic.qiantucdn.com/58pic/22/72/01/57c6578859e1e_1024.jpg");
        imgList.add("http://pic9.nipic.com/20100905/2531170_095210291877_2.jpg");
        secondBanner.setImageLoader(new GlideImageLoader(2));
        secondBanner.setImages(imgList);
        secondBanner.setBannerAnimation(Transformer.DepthPage);
        secondBanner.isAutoPlay(true);
        secondBanner.setDelayTime(3000);
        secondBanner.setIndicatorGravity(BannerConfig.RIGHT);
        secondBanner.start();
//        secondBanner.setOnBannerListener(new OnBannerListener() {
//            @Override
//            public void OnBannerClick(int position) {
//
//            }
//        });
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.finishRefresh();
                    }
                }, 1000);

            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });
    }


    @OnClick({R.id.back, R.id.zonghe, R.id.xiaoliang, R.id.price, R.id.juli})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.zonghe:
                zongheLine.setVisibility(View.VISIBLE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.GONE);
                break;
            case R.id.xiaoliang:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.VISIBLE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.GONE);
                break;
            case R.id.price:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.VISIBLE);
                juliLine.setVisibility(View.GONE);
                break;
            case R.id.juli:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        secondBanner.stopAutoPlay();
    }
}
