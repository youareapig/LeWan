package com.leiwan.zl.home.center;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.AppointmentDetailsData;
import com.leiwan.zl.data.CalenderData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.DividerGridItemDecoration;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ObservableScrollView;
import com.leiwan.zl.utils.SpacesItemDecoration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppointmentDetalsActivity extends BaseActivity implements ObservableScrollView.ScrollViewListener {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.calendar)
    RelativeLayout calendar;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.product)
    RelativeLayout product;
    @BindView(R.id.recycler_store)
    RecyclerView recyclerStore;
    @BindView(R.id.recycler_size)
    RecyclerView recyclerSize;
    @BindView(R.id.recycler_calendar)
    RecyclerView recyclerCalendar;
    @BindView(R.id.obscrollview)
    ObservableScrollView obscrollview;
    @BindView(R.id.webview_produce)
    WebView webviewProduce;
    @BindView(R.id.webview_use)
    WebView webviewUse;
    @BindView(R.id.webview_hint)
    WebView webviewHint;
    @BindView(R.id.view1_top)
    View view1Top;
    @BindView(R.id.calendar_top)
    RelativeLayout calendarTop;
    @BindView(R.id.view2_top)
    View view2Top;
    @BindView(R.id.product_top)
    RelativeLayout productTop;
    @BindView(R.id.topview)
    LinearLayout topview;
    @BindView(R.id.titleview)
    LinearLayout titleView;
    @BindView(R.id.calendar_name)
    TextView calendarName;
    @BindView(R.id.project_name)
    TextView projectName;
    @BindView(R.id.calendar_top_name)
    TextView calendarTopName;
    @BindView(R.id.product_top_name)
    TextView productTopName;

    private String id, merchant_id, price_id;
    private List<AppointmentDetailsData.DataBean.ShopBean> shopBeanList;
    private List<AppointmentDetailsData.DataBean.PriceBean> priceBeanList;
    private AdapterStore adapterStore;
    private AdapterSize adapterSize;
    private AdapterCalender adapterCalender;
    private int height = 0;

    @Override
    protected int setLayout() {
        return R.layout.activity_appointment_detals;
    }

    @Override
    protected void setView() {
        recyclerStore.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerStore.addItemDecoration(new SpacesItemDecoration(10));

        recyclerSize.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerSize.addItemDecoration(new SpacesItemDecoration(10));

        recyclerCalendar.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerCalendar.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        recyclerCalendar.setNestedScrollingEnabled(false);

        ViewTreeObserver observer = titleView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                titleView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height = titleView.getHeight() + 58;
                obscrollview.setScrollViewListener(AppointmentDetalsActivity.this);
            }
        });
    }

    @Override
    protected void setData() {
        id = getIntent().getStringExtra("id");
        initWeb();
        getData();
    }


    @OnClick({R.id.calendar_top, R.id.product_top, R.id.back, R.id.calendar, R.id.product})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.calendar:
                calendarClick();
                break;
            case R.id.product:
                productClick();
                break;
            case R.id.calendar_top:
                calendarClick();
                break;
            case R.id.product_top:
                productClick();
                break;
        }
    }

    private void calendarClick() {
        view1Top.setVisibility(View.VISIBLE);
        view2Top.setVisibility(View.GONE);
        view1.setVisibility(View.VISIBLE);
        view2.setVisibility(View.GONE);

        calendarName.setTextColor(Color.parseColor("#FF8B30"));
        projectName.setTextColor(Color.parseColor("#333333"));
        calendarTopName.setTextColor(Color.parseColor("#FF8B30"));
        productTopName.setTextColor(Color.parseColor("#333333"));
        obscrollview.scrollTo(0, recyclerCalendar.getTop());
    }

    private void productClick() {
        view1.setVisibility(View.GONE);
        view2.setVisibility(View.VISIBLE);
        view1Top.setVisibility(View.GONE);
        view2Top.setVisibility(View.VISIBLE);

        calendarName.setTextColor(Color.parseColor("#333333"));
        projectName.setTextColor(Color.parseColor("#FF8B30"));
        calendarTopName.setTextColor(Color.parseColor("#333333"));
        productTopName.setTextColor(Color.parseColor("#FF8B30"));
        obscrollview.scrollTo(0, webviewProduce.getTop());
    }

    private void getData() {
        Connector.AppointmentDetails(this, token, id, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "预约详情--" + result);
                final AppointmentDetailsData data = JSON.parseObject(result, AppointmentDetailsData.class);
                if (data.getCode() == 200) {
                    title.setText(data.getData().getProduct_name());
                    address.setText("消费地址：" + data.getData().getMerchant_address());
                    //默认日历
                    merchant_id = data.getData().getShop().get(0).getMerchant_id() + "";
                    price_id = data.getData().getPrice().get(0).getPrice_id() + "";
                    getCalendar(merchant_id, price_id);

                    //多店
                    shopBeanList = data.getData().getShop();
                    adapterStore = new AdapterStore(R.layout.guige_item, shopBeanList);
                    recyclerStore.setAdapter(adapterStore);
                    adapterStore.openLoadAnimation();
                    adapterStore.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            adapterStore.setSelectItem(position);
                            merchant_id = data.getData().getShop().get(position).getMerchant_id() + "";
                            getCalendar(merchant_id, price_id);
                            adapterStore.notifyDataSetChanged();
                        }
                    });
                    //多规格
                    priceBeanList = data.getData().getPrice();
                    adapterSize = new AdapterSize(R.layout.guige_item, priceBeanList);
                    recyclerSize.setAdapter(adapterSize);
                    adapterSize.openLoadAnimation();
                    adapterSize.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            adapterSize.setSelectItem(position);
                            price_id = data.getData().getPrice().get(position).getPrice_id() + "";
                            getCalendar(merchant_id, price_id);
                            adapterSize.notifyDataSetChanged();
                        }
                    });
                    //富文本
                    webviewProduce.loadDataWithBaseURL(null, getNewContent(data.getData().getProduct_info()), "text/html", "utf-8", null);
                    webviewUse.loadDataWithBaseURL(null, getNewContent(data.getData().getProduct_useinfo()), "text/html", "utf-8", null);
                    webviewHint.loadDataWithBaseURL(null, getNewContent(data.getData().getProduct_notice()), "text/html", "utf-8", null);

                }
            }
        });
    }

    private void getCalendar(String merchant_id, String price_id) {
        Connector.AppointmentCalendar(this, token, id, merchant_id, price_id, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "rili--" + result);
                CalenderData data = JSON.parseObject(result, CalenderData.class);
                if (data.getCode() == 200) {
                    adapterCalender = new AdapterCalender(R.layout.calendar_item, data.getData());
                    recyclerCalendar.setAdapter(adapterCalender);
                    adapterCalender.openLoadAnimation();
                    adapterCalender.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            adapterCalender.setSelectItem(position);
                            adapterCalender.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    private void initWeb() {
        webviewProduce.getSettings().setJavaScriptEnabled(true);
        webviewProduce.getSettings().setBlockNetworkImage(false);
        webviewProduce.getSettings().setLoadWithOverviewMode(true);
        webviewProduce.getSettings().setUseWideViewPort(true);
        webviewProduce.getSettings().setTextZoom(250);
        webviewProduce.setWebViewClient(new WebViewClient());

        webviewUse.getSettings().setJavaScriptEnabled(true);
        webviewUse.getSettings().setBlockNetworkImage(false);
        webviewUse.getSettings().setLoadWithOverviewMode(true);
        webviewUse.getSettings().setUseWideViewPort(true);
        webviewUse.getSettings().setTextZoom(250);
        webviewUse.setWebViewClient(new WebViewClient());

        webviewHint.getSettings().setJavaScriptEnabled(true);
        webviewHint.getSettings().setBlockNetworkImage(false);
        webviewHint.getSettings().setLoadWithOverviewMode(true);
        webviewHint.getSettings().setUseWideViewPort(true);
        webviewHint.getSettings().setTextZoom(250);
        webviewHint.setWebViewClient(new WebViewClient());
    }

    private String getNewContent(String htmltext) {
        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }
        return doc.toString();
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= height) {
            topview.setVisibility(View.GONE);
        }
        if (y > height) {
            topview.setVisibility(View.VISIBLE);
            topview.setBackgroundColor(Color.WHITE);
        }
    }

}
