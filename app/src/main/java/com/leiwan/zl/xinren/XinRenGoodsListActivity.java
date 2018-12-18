package com.leiwan.zl.xinren;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.WebActivity;
import com.leiwan.zl.data.BannerBean;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.data.IndexFenLeiBean;
import com.leiwan.zl.details.DetailsActivity;
import com.leiwan.zl.home.index.Adapter_fenlei;
import com.leiwan.zl.home.index.Adapter_fenlei_title;
import com.leiwan.zl.home.index.IndexFragment;
import com.leiwan.zl.second.SecondActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.GlideImageLoader;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ObservableScrollView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XinRenGoodsListActivity extends BaseActivity implements ObservableScrollView.ScrollViewListener {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.second_banner)
    Banner secondBanner;
    @BindView(R.id.obscrollview)
    ObservableScrollView obscrollview;
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
    @BindView(R.id.recycler_title)
    RecyclerView recyclerTitle;
    @BindView(R.id.recycler_title_view)
    RelativeLayout recyclerTitleView;
    @BindView(R.id.zonghe1_line)
    View zonghe1Line;
    @BindView(R.id.zonghe1)
    RelativeLayout zonghe1;
    @BindView(R.id.xiaoliang1_line)
    View xiaoliang1Line;
    @BindView(R.id.xiaoliang1)
    RelativeLayout xiaoliang1;
    @BindView(R.id.price1_line)
    View price1Line;
    @BindView(R.id.price1)
    RelativeLayout price1;
    @BindView(R.id.juli1_line)
    View juli1Line;
    @BindView(R.id.juli1)
    RelativeLayout juli1;
    @BindView(R.id.menu1)
    RelativeLayout menu1;
    private List<String> bannerList;
    private List<BannerBean.DataBean> bannerbeanList;
    private Adapter adapter;
    private String caseId;
    private List<HomeData.DataBean> datalist;
    private boolean b = true;
    private String num = "1";
    private String jiage = "1";
    private int page = 1;
    private int pagenum = 1;
    private int heigh1 = 0;
    private int heigh2 = 0;
    private Adapter_fenlei_title adapter_fenlei_title;

    @Override
    protected int setLayout() {
        return R.layout.activity_xin_ren_goods_list;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        recyclerTitle.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
        ViewTreeObserver observer = secondBanner.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                secondBanner.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                heigh1 = secondBanner.getHeight();
                heigh2 = heigh1 - 156;
                obscrollview.setScrollViewListener(XinRenGoodsListActivity.this);
            }
        });
    }

    @Override
    protected void setData() {
        Intent intent = getIntent();
        caseId = intent.getStringExtra("caseID");

        bannerList = new ArrayList<>();
        bannerbeanList = new ArrayList<>();

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
                        page++;
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });
        getBanner();
        getData();
        getIndexFenlei();
    }


    @OnClick({R.id.back, R.id.zonghe, R.id.xiaoliang, R.id.price, R.id.juli, R.id.zonghe1, R.id.xiaoliang1, R.id.price1, R.id.juli1})
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

                zonghe1Line.setVisibility(View.VISIBLE);
                xiaoliang1Line.setVisibility(View.GONE);
                price1Line.setVisibility(View.GONE);
                juli1Line.setVisibility(View.GONE);
                getData();
                break;
            case R.id.xiaoliang:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.VISIBLE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.GONE);
                zonghe1Line.setVisibility(View.GONE);
                xiaoliang1Line.setVisibility(View.VISIBLE);
                price1Line.setVisibility(View.GONE);
                juli1Line.setVisibility(View.GONE);
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

                zonghe1Line.setVisibility(View.GONE);
                xiaoliang1Line.setVisibility(View.GONE);
                price1Line.setVisibility(View.VISIBLE);
                juli1Line.setVisibility(View.GONE);

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

                zonghe1Line.setVisibility(View.GONE);
                xiaoliang1Line.setVisibility(View.GONE);
                price1Line.setVisibility(View.GONE);
                juli1Line.setVisibility(View.VISIBLE);
                getData_juli();
                break;
            case R.id.zonghe1:
                zongheLine.setVisibility(View.VISIBLE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.GONE);

                zonghe1Line.setVisibility(View.VISIBLE);
                xiaoliang1Line.setVisibility(View.GONE);
                price1Line.setVisibility(View.GONE);
                juli1Line.setVisibility(View.GONE);

                getData();
                break;
            case R.id.xiaoliang1:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.VISIBLE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.GONE);

                zonghe1Line.setVisibility(View.GONE);
                xiaoliang1Line.setVisibility(View.VISIBLE);
                price1Line.setVisibility(View.GONE);
                juli1Line.setVisibility(View.GONE);


                if (b) {
                    num = "1";
                    b = false;
                } else {
                    num = "2";
                    b = true;
                }
                getData_num(num);
                break;
            case R.id.price1:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.VISIBLE);
                juliLine.setVisibility(View.GONE);

                zonghe1Line.setVisibility(View.GONE);
                xiaoliang1Line.setVisibility(View.GONE);
                price1Line.setVisibility(View.VISIBLE);
                juli1Line.setVisibility(View.GONE);

                if (b) {
                    jiage = "1";
                    b = false;
                } else {
                    jiage = "2";
                    b = true;
                }
                getData_sale(jiage);
                break;
            case R.id.juli1:
                zongheLine.setVisibility(View.GONE);
                xiaoliangLine.setVisibility(View.GONE);
                priceLine.setVisibility(View.GONE);
                juliLine.setVisibility(View.VISIBLE);

                zonghe1Line.setVisibility(View.GONE);
                xiaoliang1Line.setVisibility(View.GONE);
                price1Line.setVisibility(View.GONE);
                juli1Line.setVisibility(View.VISIBLE);

                getData_juli();
                break;
        }
    }


    private void getBanner() {
        Connector.indexBannerList(this, token, lat, lng, caseId, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("zhenglei", "zhengleibanner---" + result);
                BannerBean bannerBean = JSON.parseObject(result, BannerBean.class);
                if (bannerBean.getCode() == 200) {
                    for (int i = 0; i < bannerBean.getData().size(); i++) {
                        bannerList.add(bannerBean.getData().get(i).getPic());
                    }

                    bannerbeanList.addAll(bannerBean.getData());
                    secondBanner.setImageLoader(new GlideImageLoader(2));
                    secondBanner.setImages(bannerList);
                    secondBanner.setBannerAnimation(Transformer.DepthPage);
                    secondBanner.isAutoPlay(true);
                    secondBanner.setDelayTime(3000);
                    secondBanner.setIndicatorGravity(BannerConfig.RIGHT);
                    secondBanner.start();
                    secondBanner.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            if (bannerbeanList.get(position).getJump() == 1) {
                                //可以跳转
                                if (bannerbeanList.get(position).getPosition() == 1) {
                                    //跳转商品详情
                                    Intent intent = new Intent(XinRenGoodsListActivity.this, XinRenGoodsDetialsActivity.class);
                                    intent.putExtra("id", bannerbeanList.get(position).getPr_id() + "");
                                    startActivity(intent);
                                } else if (bannerbeanList.get(position).getPosition() == 2) {
                                    //跳转webview
                                    Intent intent = new Intent(XinRenGoodsListActivity.this, WebActivity.class);
                                    intent.putExtra("weburl", bannerbeanList.get(position).getRoute());
                                    startActivity(intent);
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    private void getData() {
        Connector.IndexList(this, token, lat, caseId, lng, "", "", new Connector.MyCallback() {
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
                        Intent intent = new Intent(view.getContext(), XinRenGoodsDetialsActivity.class);
                        intent.putExtra("id", data.getData().get(position).getProduct_id() + "");
                        startActivity(intent);
                    }
                });
            }

        }
    }

    private void getIndexFenlei() {
        Connector.indexFenlei(this, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "seconde----" + result);
                final IndexFenLeiBean bean = JSON.parseObject(result, IndexFenLeiBean.class);
                if (bean.getCode() == 200) {
                    adapter_fenlei_title = new Adapter_fenlei_title(R.layout.index_title_item, bean.getData());
                    recyclerTitle.setAdapter(adapter_fenlei_title);
                    adapter_fenlei_title.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            if (bean.getData().get(position).getCate_name().equals("新人")) {
                                Intent intent = new Intent(view.getContext(), XinRenGoodsListActivity.class);
                                intent.putExtra("caseID", bean.getData().get(position).getCate_id() + "");
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                                intent.putExtra("caseID", bean.getData().get(position).getCate_id() + "");
                                intent.putExtra("title", bean.getData().get(position).getCate_name());
                                startActivity(intent);
                            }

                        }
                    });
                }
            }
        });
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= heigh2) {
            menu1.setVisibility(View.GONE);
            recyclerTitleView.setVisibility(View.GONE);
        }
        if (y > heigh2) {
            menu1.setVisibility(View.VISIBLE);
            recyclerTitleView.setVisibility(View.VISIBLE);
        }
    }
}
