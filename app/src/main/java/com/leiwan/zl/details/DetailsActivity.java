package com.leiwan.zl.details;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.MainActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.GoodsDetailsData;
import com.leiwan.zl.dingdan.DingDanZhiFuActivity;
import com.leiwan.zl.home.index.IndexFragment;
import com.leiwan.zl.second.SecondActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.GlideImageLoader;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ObservableScrollView;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity implements ObservableScrollView.ScrollViewListener {


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.points)
    LinearLayout points;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.goods_price)
    TextView goodsPrice;
    @BindView(R.id.goods_price1)
    TextView goodsPrice1;
    @BindView(R.id.goods_name)
    TextView goodsName;
    @BindView(R.id.goods_content)
    TextView goodsContent;
    @BindView(R.id.goods_tag1)
    TextView goodsTag1;
    @BindView(R.id.goods_tag2)
    TextView goodsTag2;
    @BindView(R.id.goods_yongjin)
    TextView goodsYongjin;
    @BindView(R.id.goods_address)
    TextView goodsAddress;
    @BindView(R.id.goods_description)
    WebView goodsDescription;
    @BindView(R.id.goods_useinfo)
    WebView goodsUseinfo;
    @BindView(R.id.useinfo_icon)
    View useinfoIcon;
    @BindView(R.id.useinfo)
    RelativeLayout useinfo;
    @BindView(R.id.description_icon)
    View descriptionIcon;
    @BindView(R.id.description)
    RelativeLayout description;
    @BindView(R.id.scroll)
    ObservableScrollView scroll;
    @BindView(R.id.hideview)
    LinearLayout hideview;
    @BindView(R.id.menu)
    LinearLayout menu;
    @BindView(R.id.useinfo_icon1)
    View useinfoIcon1;
    @BindView(R.id.useinfo1)
    RelativeLayout useinfo1;
    @BindView(R.id.description_icon1)
    View descriptionIcon1;
    @BindView(R.id.description1)
    RelativeLayout description1;
    @BindView(R.id.menu1)
    RelativeLayout menu1;
    @BindView(R.id.index)
    TextView index;
    @BindView(R.id.shared)
    TextView shared;
    @BindView(R.id.shopping)
    TextView shopping;
    private ImageView[] ivPoints;//小圆点图片的集合
    private int totalPage; //总的页数
    private int mPageSize = 4; //每页显示的最大的数量
    private List<View> viewPagerList;//GridView作为一个View对象添加到ViewPager集合中
    private WebSettings webSettings1, webSettings2;
    private String  id;
    private int heigh;
    private List<GoodsDetailsData.DataBean.HotpushBean> hotList;

    @Override
    protected int setLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void setView() {
        ViewTreeObserver observer = hideview.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                hideview.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                heigh = hideview.getHeight();
                scroll.setScrollViewListener(DetailsActivity.this);
            }
        });

    }

    @Override
    protected void setData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        LogUtil.d("tag", "id------" + id);
        initWeb();
        getData();


    }

    private void getData() {
        Connector.GoodsDetails(this,token, lat, lng, id, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "商品详情" + result);
                GoodsDetailsData detailsData = JSON.parseObject(result, GoodsDetailsData.class);
                if (detailsData.getCode() == 200) {
                    //Banner
                    List<String> bannerList = detailsData.getData().getDetails().getProduct_carousel();
                    banner.setImageLoader(new GlideImageLoader(1));
                    banner.setImages(bannerList);
                    banner.setBannerAnimation(Transformer.DepthPage);
                    banner.isAutoPlay(false);
                    banner.setDelayTime(3000);
                    banner.setIndicatorGravity(BannerConfig.RIGHT);
                    banner.start();
                    goodsPrice.setText("¥"+detailsData.getData().getPrice().get(0).getPrice_sale());
                    goodsPrice1.setText("¥"+detailsData.getData().getPrice().get(0).getPrice_market());
                    goodsName.setText(detailsData.getData().getDetails().getProduct_name());
                    goodsContent.setText(detailsData.getData().getDetails().getProduct_info());
                    goodsAddress.setText(detailsData.getData().getDetails().getMerchant_address());

                    goodsUseinfo.loadDataWithBaseURL(null, getNewContent(detailsData.getData().getDetails().getProduct_description()), "text/html", "utf-8", null);
                    goodsDescription.loadDataWithBaseURL(null, getNewContent(detailsData.getData().getDetails().getProduct_useinfo()), "text/html", "utf-8", null);

                    hotList = detailsData.getData().getHotpush();
                    initHot();
                }
            }
        });
    }


    private void initWeb() {
        webSettings1 = goodsDescription.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        webSettings1.setBlockNetworkImage(false);
        webSettings1.setLoadWithOverviewMode(true);
        webSettings1.setUseWideViewPort(true);
        webSettings1.setTextZoom(250);
        goodsDescription.setWebViewClient(new WebViewClient());

        webSettings2 = goodsUseinfo.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        webSettings2.setBlockNetworkImage(false);
        webSettings2.setLoadWithOverviewMode(true);
        webSettings2.setUseWideViewPort(true);
        webSettings2.setTextZoom(250);
        goodsUseinfo.setWebViewClient(new WebViewClient());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings1.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            webSettings2.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }

    private void initHot() {
        totalPage = (int) Math.ceil(hotList.size() * 1.0 / mPageSize);
        viewPagerList = new ArrayList<View>();
        for (int i = 0; i < totalPage; i++) {
            //每个页面都是inflate出一个新实例
            final GridView gridView = (GridView) View.inflate(this, R.layout.pagergrid, null);
            gridView.setAdapter(new MyGridViewAdpter(this, hotList, i, mPageSize));
            //添加item点击监听
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                                        int position, long arg3) {
                    // TODO Auto-generated method stub
                    Object obj = gridView.getItemAtPosition(position);
                    if (obj != null && obj instanceof String) {
                        Intent intent = new Intent(arg1.getContext(), DetailsActivity.class);
                        intent.putExtra("id", hotList.get(position).getProduct_id() + "");
                        startActivity(intent);
                    }
                }
            });
            //每一个GridView作为一个View对象添加到ViewPager集合中
            viewPagerList.add(gridView);
        }
        viewpager.setAdapter(new MyViewPagerAdapter(viewPagerList));
        ivPoints = new ImageView[totalPage];
        for (int i = 0; i < totalPage; i++) {
            //循坏加入点点图片组
            ivPoints[i] = new ImageView(this);
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            imageView.setLayoutParams(layoutParams);
            ivPoints[i] = imageView;
            if (i == 0) {
                ivPoints[i].setBackgroundResource(R.drawable.vpchecked);
            } else {
                ivPoints[i].setBackgroundResource(R.drawable.vpunchecked);
            }
            ivPoints[i].setPadding(8, 8, 8, 8);
            points.addView(ivPoints[i]);
        }
        viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0; i < totalPage; i++) {
                    if (i == position) {
                        ivPoints[i].setBackgroundResource(R.drawable.vpchecked);
                    } else {
                        ivPoints[i].setBackgroundResource(R.drawable.vpunchecked);
                    }
                }
            }
        });
    }

    private String getNewContent(String htmltext) {
        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }
        return doc.toString();
    }


    @OnClick({R.id.useinfo, R.id.description, R.id.back, R.id.useinfo1, R.id.description1, R.id.index, R.id.shared, R.id.shopping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.useinfo:
                useinfoIcon.setVisibility(View.VISIBLE);
                descriptionIcon.setVisibility(View.GONE);
                useinfoIcon1.setVisibility(View.VISIBLE);
                descriptionIcon1.setVisibility(View.GONE);
                scroll.scrollTo(0, goodsUseinfo.getTop() - menu1.getHeight());
                break;
            case R.id.description:
                useinfoIcon.setVisibility(View.GONE);
                descriptionIcon.setVisibility(View.VISIBLE);
                useinfoIcon1.setVisibility(View.GONE);
                descriptionIcon1.setVisibility(View.VISIBLE);
                scroll.scrollTo(0, goodsDescription.getTop() - menu1.getHeight());
                break;
            case R.id.useinfo1:
                useinfoIcon1.setVisibility(View.VISIBLE);
                descriptionIcon1.setVisibility(View.GONE);
                useinfoIcon.setVisibility(View.VISIBLE);
                descriptionIcon.setVisibility(View.GONE);
                scroll.scrollTo(0, goodsUseinfo.getTop() - menu1.getHeight());
                break;
            case R.id.description1:
                useinfoIcon1.setVisibility(View.GONE);
                descriptionIcon1.setVisibility(View.VISIBLE);
                useinfoIcon.setVisibility(View.GONE);
                descriptionIcon.setVisibility(View.VISIBLE);
                scroll.scrollTo(0, goodsDescription.getTop() - menu1.getHeight());
                break;
            case R.id.index:
                toClassApp(this, MainActivity.class);
                break;
            case R.id.shared:
                break;
            case R.id.shopping:
                toClass(this, DingDanZhiFuActivity.class);
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= heigh) {
            menu1.setVisibility(View.GONE);
        }
        if (y > heigh) {
            menu1.setVisibility(View.VISIBLE);
            menu1.setBackgroundColor(Color.WHITE);
        }

    }


}
