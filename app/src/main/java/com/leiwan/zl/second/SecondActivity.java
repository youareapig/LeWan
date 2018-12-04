package com.leiwan.zl.second;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.BannerBean;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.details.DetailsActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.GlideImageLoader;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

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
    @BindView(R.id.noData)
    RelativeLayout noData;
    private List<String> bannerList;
    private Adapter adapter;
    private String caseId;
    private String token, lat, lng;
    private List<HomeData.DataBean> datalist;
    private boolean b = true;
    private String num = "1";
    private String jiage = "1";

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
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        caseId = intent.getStringExtra("caseID");
        titleText.setText(title);
        token = SharedPreferencesUtil.getInstance(this).getSP("token");
        lat = SharedPreferencesUtil.getInstance(this).getSP("lat");
        lng = SharedPreferencesUtil.getInstance(this).getSP("lng");

        bannerList = new ArrayList<>();

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
        getBanner();
        getData();
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
                getData();
                break;
            case R.id.xiaoliang:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.VISIBLE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.GONE);
                if (b) {
                    num = "1";
                    b = false;
                } else {
                    num = "2";
                    b = true;
                }
                getData_num(num);
                break;
            case R.id.price:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.VISIBLE);
                juliLine.setVisibility(View.GONE);
                if (b) {
                    jiage = "1";
                    b = false;
                } else {
                    jiage = "2";
                    b = true;
                }
                getData_sale(jiage);
                break;
            case R.id.juli:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.VISIBLE);
                getData_juli();
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        secondBanner.stopAutoPlay();
    }

    private void getBanner() {
        Connector.indexBannerList(this, lat, lng, caseId, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("zhenglei", "zhengleibanner---" + result);
                BannerBean bannerBean = JSON.parseObject(result, BannerBean.class);
                if (bannerBean.getCode() == 200) {
                    for (int i = 0; i < bannerBean.getData().size(); i++) {
                        bannerList.add(bannerBean.getData().get(i).getPic());
                    }

                    secondBanner.setImageLoader(new GlideImageLoader(2));
                    secondBanner.setImages(bannerList);
                    secondBanner.setBannerAnimation(Transformer.DepthPage);
                    secondBanner.isAutoPlay(true);
                    secondBanner.setDelayTime(3000);
                    secondBanner.setIndicatorGravity(BannerConfig.RIGHT);
                    secondBanner.start();
                }
            }
        });
    }

    private void getData() {
        Connector.IndexList(this, token, lat, caseId, lng, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                Log.d("tag", "成功" + result);
                resultItem(result);
            }
        });
    }

    private void getData_sale(String price) {
        Connector.IndexList_sale(this, token, lat, lng, caseId, price, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                resultItem(result);
            }
        });
    }

    private void getData_num(String num) {
        Connector.IndexList_num(this, token, lat, lng, caseId, num, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                resultItem(result);
            }
        });
    }

    private void getData_juli() {
        Connector.IndexList_away(this, token, lat, lng, caseId, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                resultItem(result);
            }
        });
    }

    private void resultItem(String result) {
        final HomeData data = JSON.parseObject(result, HomeData.class);
        if (data.getCode() == 200) {
            if (data.getData().size() == 0) {
                noData.setVisibility(View.VISIBLE);
            } else {
                noData.setVisibility(View.GONE);
                datalist = data.getData();
                adapter = new Adapter(R.layout.index_list_item, datalist);
                recycler.setAdapter(adapter);
                adapter.openLoadAnimation();
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                        intent.putExtra("id", data.getData().get(position).getProduct_id());
                        startActivity(intent);
                    }
                });
            }

        }
    }
}
