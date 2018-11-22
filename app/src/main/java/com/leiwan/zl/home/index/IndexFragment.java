package com.leiwan.zl.home.index;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.utils.GlideImageLoader;
import com.leiwan.zl.utils.MMap;
import com.leiwan.zl.utils.ObservableScrollView;
import com.leiwan.zl.utils.RetrofitUtil;
import com.leiwan.zl.utils.StatusBarUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/11/14.
 */

public class IndexFragment extends BaseFragment implements ObservableScrollView.ScrollViewListener {
    @BindView(R.id.index_banner)
    Banner indexBanner;
    @BindView(R.id.newpeople)
    RelativeLayout newpeople;
    @BindView(R.id.food)
    RelativeLayout food;
    @BindView(R.id.hotel)
    RelativeLayout hotel;
    @BindView(R.id.lipin)
    RelativeLayout lipin;
    @BindView(R.id.qinzi)
    RelativeLayout qinzi;
    @BindView(R.id.leyuan)
    RelativeLayout leyuan;
    @BindView(R.id.jingqu)
    RelativeLayout jingqu;
    @BindView(R.id.chuxing)
    RelativeLayout chuxing;
    @BindView(R.id.index_recycler)
    RecyclerView indexRecycler;
    @BindView(R.id.obscrollview)
    ObservableScrollView obscrollview;
    @BindView(R.id.title_view)
    RelativeLayout titleview;
    @BindView(R.id.hengxiangtitle)
    LinearLayout hengxiangtitle;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.zonghe_line)
    View zongheLine;
    @BindView(R.id.zonghe)
    RelativeLayout zonghe;
    @BindView(R.id.xiaoliang_line)
    View xiaoliangLine;
    @BindView(R.id.xiaoliang)
    RelativeLayout xiaoliang;
    @BindView(R.id.price_line)
    View priceLine;
    @BindView(R.id.price)
    RelativeLayout price;
    @BindView(R.id.juli_line)
    View juliLine;
    @BindView(R.id.juli)
    RelativeLayout juli;
    private List<String> list;
    private int heigh = 380;
    private int heigh1 = 750;
    private List<HomeData.DataBean> datalist;
    public AMapLocationClient mLocationClient = null;
    public AMapLocationListener mLocationListener = new MyAMapLocationListener();
    public AMapLocationClientOption mLocationOption = null;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.index_fragment;
    }

    @Override
    protected void setView() {
        indexRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        indexRecycler.setNestedScrollingEnabled(false);
    }

    @Override
    protected void setData() {
        ViewTreeObserver observer = indexBanner.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                indexBanner.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //heigh=indexBanner.getHeight();
                obscrollview.setScrollViewListener(IndexFragment.this);
            }
        });

        list = new ArrayList<>();
        list.add("http://img03.tooopen.com/uploadfile/downs/images/20110714/sy_20110714135215645030.jpg");
        list.add("http://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/lvpics/w=600/sign=3da54689a11ea8d38a227704a70a30cf/ac6eddc451da81cb378472ff5566d016092431a5.jpg");
        list.add("http://pic.qiantucdn.com/58pic/22/72/01/57c6578859e1e_1024.jpg");
        list.add("http://pic9.nipic.com/20100905/2531170_095210291877_2.jpg");

        //TODO 文字高亮
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        //TODO 设置状态栏颜色
        StatusBarUtils.setStatusBarColor(getActivity(), R.color.bar);
        MPermissions.requestPermissions(IndexFragment.this, 1, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
        getData();
    }

    private void getData() {
        Subscription subscription = RetrofitUtil.GetData().getData(MMap.getMap(0, 0), null, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomeData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("tag", "获取数据失败" + e.getMessage());
                    }

                    @Override
                    public void onNext(HomeData homeData) {

                        Log.d("tag", "获取数据成功" + homeData.getCode());
                        if (homeData.getCode() == 200) {
                            datalist = homeData.getData();
                            adapter = new Adapter(R.layout.index_list_item, datalist);
                            indexRecycler.setAdapter(adapter);
                            adapter.openLoadAnimation();


                            indexBanner.setImageLoader(new GlideImageLoader());
                            indexBanner.setImages(list);
                            indexBanner.setBannerAnimation(Transformer.DepthPage);
                            indexBanner.isAutoPlay(true);
                            indexBanner.setDelayTime(3000);
                            indexBanner.setIndicatorGravity(BannerConfig.RIGHT);
                            indexBanner.start();
                        }

                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(1)
    public void requestContactSuccess() {
        getPositioning();

    }

    @PermissionDenied(1)
    public void requestContactFailed() {
        Toast.makeText(getActivity(), "定位权限申请失败", Toast.LENGTH_SHORT).show();
    }


    class MyAMapLocationListener implements AMapLocationListener {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    city.setText(aMapLocation.getCity());
                    Log.d("tag", "-----location----");
                }

            }

        }
    }

    // 高德定位
    public void getPositioning() {
        mLocationClient = new AMapLocationClient(getActivity());
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setOnceLocationLatest(true);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setMockEnable(true);
        mLocationOption.setInterval(5000);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationClient.startLocation();
    }


    @OnClick({R.id.zonghe, R.id.xiaoliang, R.id.price, R.id.juli, R.id.newpeople, R.id.food, R.id.hotel, R.id.lipin, R.id.qinzi, R.id.leyuan, R.id.jingqu, R.id.chuxing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.newpeople:
                break;
            case R.id.food:
                break;
            case R.id.hotel:
                break;
            case R.id.lipin:
                break;
            case R.id.qinzi:
                break;
            case R.id.leyuan:
                break;
            case R.id.jingqu:
                break;
            case R.id.chuxing:
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
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= heigh) {
            titleview.setBackgroundColor(Color.WHITE);
            StatusBarUtils.setStatusBarColor(getActivity(), R.color.bar);
        }
        if (y > heigh) {
            titleview.setBackgroundColor(getResources().getColor(R.color.bar1));
            StatusBarUtils.setStatusBarColor(getActivity(), R.color.bar1);

        }
        if (y <= heigh1) {
//            float scale = (float) y / 350;
//            float alpha = (255 * scale);
            hengxiangtitle.setVisibility(View.GONE);
//            hengxiangtitle.setAlpha(alpha);
//            hengxiangtitle.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
        }
        if (y > heigh1) {
            hengxiangtitle.setVisibility(View.VISIBLE);
            hengxiangtitle.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("tag", "停止定位");
        mLocationClient.stopLocation();
    }


}
