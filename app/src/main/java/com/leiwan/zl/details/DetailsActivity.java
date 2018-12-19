package com.leiwan.zl.details;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.MainActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.GoodsDetailsData;
import com.leiwan.zl.dingdan.DingDanZhiFuActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.GlideImageLoader;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ObservableScrollView;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.TimeOverView;
import com.leiwan.zl.utils.ToastUtil;
import com.leiwan.zl.utils.WXSharedUtils;
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
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

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
    @BindView(R.id.goods_address_view)
    RelativeLayout goodsAddressView;
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
    @BindView(R.id.yongjintext)
    TextView yongjinText;
    @BindView(R.id.shopping)
    TextView shopping;
    @BindView(R.id.timeover)
    TimeOverView timeover;
    @BindView(R.id.kucun)
    TextView kuCun;
    @BindView(R.id.yishou)
    TextView yiShou;
    @BindView(R.id.guige_close)
    ImageView guigeClose;
    @BindView(R.id.guige_img)
    ImageView guigeImg;
    @BindView(R.id.guige_price)
    TextView guigePrice;
    @BindView(R.id.guige_name)
    TextView guigeName;
    @BindView(R.id.guige_kucun)
    TextView guigeKucun;
    @BindView(R.id.guige_yishou)
    TextView guigeYishou;
    @BindView(R.id.guigetype)
    TextView guigeType;
    @BindView(R.id.goods_end_text)
    TextView goodsEndText;
    @BindView(R.id.shopping_end)
    TextView shoppingEnd;
    @BindView(R.id.guige_recycler)
    RecyclerView guigeRecycler;
    @BindView(R.id.include_view)
    RelativeLayout includeView;
    @BindView(R.id.guige_view)
    RelativeLayout guigeView;
    @BindView(R.id.page2)
    LinearLayout page2;
    @BindView(R.id.goods_web1)
    WebView goodsWeb1;
    @BindView(R.id.goods_web2)
    WebView goodsWeb2;

    private ImageView[] ivPoints;//小圆点图片的集合
    private int totalPage; //总的页数
    private int mPageSize = 4; //每页显示的最大的数量
    private List<View> viewPagerList;//GridView作为一个View对象添加到ViewPager集合中
    private WebSettings webSettings1, webSettings2, webSettings01, webSettings02;
    private String id;
    private int heigh;
    private List<GoodsDetailsData.DataBean.HotpushBean> hotList;
    private int level;
    private List<GoodsDetailsData.DataBean.PriceBean> priceList;
    private Adapter adapter;
    private String zigou, fenxiang;
    private int guigeShow = 0;
    private String address;
    private static final String BAIDU = "com.baidu.BaiduMap";
    private static final String GAODE = "com.autonavi.minimap";

    @Override
    protected int setLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void setView() {
        page2.setOnClickListener(null);
        guigeRecycler.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));

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
        level = SharedPreferencesUtil.getInstance(this).getSP("level", 0);
        LogUtil.d("tag", "id------" + id + "----level----" + level);
        initWeb();
        getData();


    }

    private void getData() {
        Connector.GoodsDetails(this, token, lat, lng, id, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "商品详情" + result);
                final GoodsDetailsData detailsData = JSON.parseObject(result, GoodsDetailsData.class);
                if (detailsData.getCode() == 200) {
                    //规格
                    priceList = detailsData.getData().getPrice();
                    //Banner
                    List<String> bannerList = detailsData.getData().getDetails().getProduct_carousel();
                    banner.setImageLoader(new GlideImageLoader(2));
                    banner.setImages(bannerList);
                    banner.setBannerAnimation(Transformer.DepthPage);
                    banner.isAutoPlay(false);
                    banner.setDelayTime(3000);
                    banner.setIndicatorGravity(BannerConfig.RIGHT);
                    banner.start();

                    MoreType(0, detailsData.getData().getDetails());

                    goodsPrice.setTypeface(typeface);
                    goodsPrice1.setTypeface(typeface);
                    goodsYongjin.setTypeface(typeface);
                    kuCun.setTypeface(typeface);
                    yiShou.setTypeface(typeface);
                    guigePrice.setTypeface(typeface);
                    guigeKucun.setTypeface(typeface);
                    guigeYishou.setTypeface(typeface);

                    address = detailsData.getData().getDetails().getMerchant_address();
                    goodsName.setText(detailsData.getData().getDetails().getProduct_name());
                    goodsContent.setText(detailsData.getData().getDetails().getProduct_info());
                    goodsAddress.setText(address);

                    //商品标签
                    if (detailsData.getData().getDetails().getProduct_tags().size() > 1) {
                        goodsTag1.setText(detailsData.getData().getDetails().getProduct_tags().get(0).getTag_name());
                        goodsTag2.setText(detailsData.getData().getDetails().getProduct_tags().get(1).getTag_name());
                    } else {
                        goodsTag1.setText(detailsData.getData().getDetails().getProduct_tags().get(0).getTag_name());
                    }

                    //popwindow数据
                    adapter = new Adapter(R.layout.guige_item, priceList);
                    guigeRecycler.setAdapter(adapter);
                    adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                            MoreType(position, detailsData.getData().getDetails());
                            adapter.setSelectItem(position);
                            adapter.notifyDataSetChanged();
                        }
                    });
                    //商品图
                    Glide.with(App.content)
                            .load(detailsData.getData().getDetails().getProduct_pic())
                            .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
                            .placeholder(R.mipmap.defult_banner)
                            .error(R.mipmap.defult_banner)
                            .into(guigeImg);
                    //商品名称
                    guigeName.setText(detailsData.getData().getDetails().getProduct_name());
                    //倒计时
                    long endetime = detailsData.getData().getDetails().getProduct_endtime();
                    initTimeOver(endetime);
                    //富文本
                    goodsUseinfo.loadDataWithBaseURL(null, getNewContent(detailsData.getData().getDetails().getProduct_description()), "text/html", "utf-8", null);
                    goodsDescription.loadDataWithBaseURL(null, getNewContent(detailsData.getData().getDetails().getProduct_useinfo()), "text/html", "utf-8", null);
                    goodsWeb1.loadDataWithBaseURL(null, getNewContent(detailsData.getData().getDetails().getProduct_info()), "text/html", "utf-8", null);
                    goodsWeb2.loadDataWithBaseURL(null, getNewContent(detailsData.getData().getDetails().getProduct_notice()), "text/html", "utf-8", null);

                    //推荐
                    hotList = detailsData.getData().getHotpush();
                    initHot();
                }
            }
        });
    }

    //多规格
    private void MoreType(int item, GoodsDetailsData.DataBean.DetailsBean bean) {
        zigou = priceList.get(item).getPrice_commission().getZigou();
        fenxiang = priceList.get(item).getPrice_commission().getFenxiang();
        if (level == 1) {
            //普通会员，不显示佣金
            goodsYongjin.setText("");
            yongjinText.setVisibility(View.GONE);
        } else if (level == 2) {
            //超级会员显示自购和分享佣金
            goodsYongjin.setText("¥" + zigou + "～" + fenxiang);
            yongjinText.setVisibility(View.VISIBLE);
        } else {
            //超过2的只显示购买佣金
            goodsYongjin.setText("¥" + zigou);
            yongjinText.setVisibility(View.VISIBLE);
        }
        //规格名
        guigeType.setText(priceList.get(item).getProduct_property());
        //商品价格
        goodsPrice.setText("¥" + priceList.get(item).getPrice_sale());
        goodsPrice1.setText("¥" + priceList.get(item).getPrice_market());
        //商品库存
        kuCun.setText("库存：" + priceList.get(item).getProduct_totalnum());
        yiShou.setText("已售数量：" + priceList.get(item).getProduct_buynum());
        guigePrice.setText("¥" + priceList.get(item).getPrice_sale());//商品价格
        guigeKucun.setText("库存：" + priceList.get(item).getProduct_totalnum());
        guigeYishou.setText("已售：" + priceList.get(item).getProduct_buynum());
        if (bean.getSold_out() == 1) {
            //售罄
            shopping.setVisibility(View.GONE);
            shoppingEnd.setVisibility(View.VISIBLE);
            shared.setVisibility(View.GONE);
        } else if (bean.getSold_out() == 1) {
            //未售罄
            shopping.setVisibility(View.VISIBLE);
            shoppingEnd.setVisibility(View.GONE);
            shared.setVisibility(View.VISIBLE);
        }
    }

    private void initTimeOver(long endtime) {
        long[] arr = DateUtils.timeOver(endtime);
        long day = arr[0];
        long hour = arr[1];
        long min = arr[2];
        long second = arr[3];
        if (day <= 0 && hour <= 0 && min <= 0 && second <= 0) {
            timeover.setVisibility(View.GONE);
            goodsEndText.setVisibility(View.GONE);
        } else {
            timeover.setVisibility(View.VISIBLE);
            goodsEndText.setVisibility(View.VISIBLE);
            timeover.setTime(day, hour, min, second);
            timeover.start();
        }

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

        webSettings01 = goodsWeb1.getSettings();
        webSettings01.setJavaScriptEnabled(true);
        webSettings01.setBlockNetworkImage(false);
        webSettings01.setLoadWithOverviewMode(true);
        webSettings01.setUseWideViewPort(true);
        webSettings01.setTextZoom(250);
        goodsWeb1.setWebViewClient(new WebViewClient());

        webSettings02 = goodsWeb2.getSettings();
        webSettings02.setJavaScriptEnabled(true);
        webSettings02.setBlockNetworkImage(false);
        webSettings02.setLoadWithOverviewMode(true);
        webSettings02.setUseWideViewPort(true);
        webSettings02.setTextZoom(250);
        goodsWeb2.setWebViewClient(new WebViewClient());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings1.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            webSettings2.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            webSettings01.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            webSettings02.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
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


    @OnClick({R.id.goods_address_view, R.id.guige_view, R.id.guige_close, R.id.useinfo, R.id.description, R.id.back, R.id.useinfo1, R.id.description1, R.id.index, R.id.shared, R.id.shopping})
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
                toClass(this, MainActivity.class);
                break;
            case R.id.guige_view:
                includeView.setVisibility(View.VISIBLE);
                guigeShow = 1;
                break;
            case R.id.guige_close:
                includeView.setVisibility(View.GONE);
                guigeShow = 0;
                break;
            case R.id.shared:
                //TODO 分享链接
                WXSharedUtils.getImage("http://file2.zhituad.com/thumb/201102/15/201102150839088669kNhyE.jpg", new WXSharedUtils.HttpCallBackListener() {
                    @Override
                    public void onFinish(final Bitmap bitmap) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                WXSharedUtils.Shared_Web("https://blog.csdn.net/qq_42618969/article/details/81030941", "csdn", "微信分享", 2, bitmap);
                            }
                        });
                    }
                });
                //TODO 分享图片
//                WXSharedUtils.getImage("http://file2.zhituad.com/thumb/201102/15/201102150839088669kNhyE.jpg", new WXSharedUtils.HttpCallBackListener() {
//                    @Override
//                    public void onFinish(final Bitmap bitmap) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                WXSharedUtils.Shared_Image(2, bitmap);
//                            }
//                        });
//                    }
//                });
                break;
            case R.id.shopping:
                if (guigeShow == 0) {
                    includeView.setVisibility(View.VISIBLE);
                    guigeShow = 1;
                } else {
                    includeView.setVisibility(View.GONE);
                    guigeShow = 0;
                    toClass(this, DingDanZhiFuActivity.class);
                }
                break;
            case R.id.goods_address_view:
                if (isInstalled(BAIDU) && !isInstalled(GAODE)) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse("baidumap://map/geocoder?src=openApiDemo&address=" + address));
                    startActivity(intent);
                } else if (!isInstalled(BAIDU) && isInstalled(GAODE)) {
                    String act = "android.intent.action.VIEW";
                    String dat = "androidamap://keywordNavi?sourceApplication=softname&keyword=" + address + " &style=2";
                    Intent intent = new Intent(act, Uri.parse(dat));
                    intent.setPackage(GAODE);
                    startActivity(intent);
                } else if (!isInstalled(BAIDU) && !isInstalled(GAODE)) {
                    ToastUtil.showShortToast("请安装地图客户端");
                } else {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse("baidumap://map/geocoder?src=openApiDemo&address=" + address));
                    startActivity(intent);
                }

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

    //检测程序是否安装
    private boolean isInstalled(String packageName) {
        PackageManager manager = getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> installedPackages = manager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo info : installedPackages) {
                if (info.packageName.equals(packageName))
                    return true;
            }
        }
        return false;
    }

}
