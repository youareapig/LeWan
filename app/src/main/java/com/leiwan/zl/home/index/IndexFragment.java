package com.leiwan.zl.home.index;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.BannerBean;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.data.IndexFenLeiBean;
import com.leiwan.zl.details.DetailsActivity;
import com.leiwan.zl.notice.NoticeActivity;
import com.leiwan.zl.second.SecondActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.GlideImageLoader;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ObservableScrollView;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.StatusBarUtils;
import com.leiwan.zl.utils.ToastUtil;
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
    HorizontalScrollView hengxiangtitle;
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
    @BindView(R.id.notice)
    ImageView notice;
    @BindView(R.id.menu1)
    RelativeLayout menu1;
    @BindView(R.id.zonghe1_text)
    TextView zonghe1Text;
    @BindView(R.id.zonghe1_line)
    View zonghe1Line;
    @BindView(R.id.zonghe1)
    RelativeLayout zonghe1;
    @BindView(R.id.xiaoliang1_text)
    TextView xiaoliang1Text;
    @BindView(R.id.xiaoliang1_line)
    View xiaoliang1Line;
    @BindView(R.id.xiaoliang1)
    RelativeLayout xiaoliang1;
    @BindView(R.id.price1_text)
    TextView price1Text;
    @BindView(R.id.price1_line)
    View price1Line;
    @BindView(R.id.price1)
    RelativeLayout price1;
    @BindView(R.id.juli1_text)
    TextView juli1Text;
    @BindView(R.id.juli1_line)
    View juli1Line;
    @BindView(R.id.juli1)
    RelativeLayout juli1;
    @BindView(R.id.newpeople_icon)
    ImageView newpeopleIcon;
    @BindView(R.id.newpeople_text)
    TextView newpeopleText;
    @BindView(R.id.food_icon)
    ImageView foodIcon;
    @BindView(R.id.food_text)
    TextView foodText;
    @BindView(R.id.hotel_icon)
    ImageView hotelIcon;
    @BindView(R.id.hotel_text)
    TextView hotelText;
    @BindView(R.id.lipin_icon)
    ImageView lipinIcon;
    @BindView(R.id.lipin_text)
    TextView lipinText;
    @BindView(R.id.qinzi_icon)
    ImageView qinziIcon;
    @BindView(R.id.qinzi_text)
    TextView qinziText;
    @BindView(R.id.leyuan_icon)
    ImageView leyuanIcon;
    @BindView(R.id.leyuan_text)
    TextView leyuanText;
    @BindView(R.id.jingqu_icon)
    ImageView jingquIcon;
    @BindView(R.id.jingqu_text)
    TextView jingquText;
    @BindView(R.id.chuxing_icon)
    ImageView chuxingIcon;
    @BindView(R.id.chuxing_text)
    TextView chuxingText;
    @BindView(R.id.zonghe_text)
    TextView zongheText;
    @BindView(R.id.xiaoliang_text)
    TextView xiaoliangText;
    @BindView(R.id.price_text)
    TextView priceText;
    @BindView(R.id.juli_text)
    TextView juliText;
    @BindView(R.id.inputsearch)
    EditText inputsearch;
    @BindView(R.id.title_newpeople)
    TextView titleNewpeople;
    @BindView(R.id.title_food)
    TextView titleFood;
    @BindView(R.id.title_hotel)
    TextView titleHotel;
    @BindView(R.id.title_lipin)
    TextView titleLipin;
    @BindView(R.id.title_qinzi)
    TextView titleQinzi;
    @BindView(R.id.title_leyuan)
    TextView titleLeyuan;
    @BindView(R.id.title_jingqu)
    TextView titleJingqu;
    @BindView(R.id.title_chuxing)
    TextView titleChuxing;
    Unbinder unbinder;

    private int heigh = 380;
    private int heigh1 = 750;
    private int heigh2 = 770;
    private List<HomeData.DataBean> datalist;
    public AMapLocationClient mLocationClient = null;
    public AMapLocationListener mLocationListener = new MyAMapLocationListener();
    public AMapLocationClientOption mLocationOption = null;
    private Adapter adapter;
    private Bundle bundle;
    private String token, lat, lng;
    private boolean b = true;
    private String num = "1";
    private String jiage = "1";
    private List<String> list;
    private List<ImageView> imageViewList;
    private List<TextView> textViewList, textViewList_title;
    private List<String> titleList;
    private List<String> idList;

    @Override
    protected int setLayout() {
        return R.layout.index_fragment;
    }

    @Override
    protected void setView() {
        list = new ArrayList<>();
        bundle = new Bundle();
        indexRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        indexRecycler.setNestedScrollingEnabled(false);

        imageViewList = new ArrayList<>();
        imageViewList.add(newpeopleIcon);
        imageViewList.add(foodIcon);
        imageViewList.add(hotelIcon);
        imageViewList.add(lipinIcon);
        imageViewList.add(qinziIcon);
        imageViewList.add(leyuanIcon);
        imageViewList.add(jingquIcon);
        imageViewList.add(chuxingIcon);

        textViewList = new ArrayList<>();
        textViewList.add(newpeopleText);
        textViewList.add(foodText);
        textViewList.add(hotelText);
        textViewList.add(lipinText);
        textViewList.add(qinziText);
        textViewList.add(leyuanText);
        textViewList.add(jingquText);
        textViewList.add(chuxingText);

        textViewList_title = new ArrayList<>();
        textViewList_title.add(titleNewpeople);
        textViewList_title.add(titleFood);
        textViewList_title.add(titleHotel);
        textViewList_title.add(titleLipin);
        textViewList_title.add(titleQinzi);
        textViewList_title.add(titleLeyuan);
        textViewList_title.add(titleJingqu);
        textViewList_title.add(titleChuxing);

        titleList = new ArrayList<>();
        idList = new ArrayList<>();
    }

    @Override
    protected void setData() {
        token = SharedPreferencesUtil.getInstance(getActivity()).getSP("token");
        Log.d("tag", "token------>" + token);
        showDialog();
        getIndexFenlei();
        ViewTreeObserver observer = indexBanner.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                indexBanner.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //heigh=indexBanner.getHeight();
                obscrollview.setScrollViewListener(IndexFragment.this);
            }
        });


        //TODO 文字高亮
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        //TODO 设置状态栏颜色
        StatusBarUtils.setStatusBarColor(getActivity(), R.color.bar);
        MPermissions.requestPermissions(IndexFragment.this, 1, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
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
        ToastUtil.showShortToast("定位权限申请失败");
    }


    class MyAMapLocationListener implements AMapLocationListener {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    city.setText(aMapLocation.getCity());

                    lng = aMapLocation.getLongitude() + "";
                    lat = aMapLocation.getLatitude() + "";
                    SharedPreferencesUtil.getInstance(getActivity()).putSP("lat", lat);
                    SharedPreferencesUtil.getInstance(getActivity()).putSP("lng", lng);

                    getData(lat, lng);
                    getBanner(lat, lng);
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


    @OnClick({R.id.title_newpeople, R.id.title_food, R.id.title_hotel, R.id.title_lipin, R.id.title_qinzi, R.id.title_leyuan, R.id.title_jingqu, R.id.title_chuxing, R.id.zonghe1, R.id.xiaoliang1, R.id.price1, R.id.juli1, R.id.notice, R.id.zonghe, R.id.xiaoliang, R.id.price, R.id.juli, R.id.newpeople, R.id.food, R.id.hotel, R.id.lipin, R.id.qinzi, R.id.leyuan, R.id.jingqu, R.id.chuxing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.newpeople:
                bundle.putString("title", titleList.get(0));
                bundle.putString("caseID", idList.get(0));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.food:
                bundle.putString("title", titleList.get(1));
                bundle.putString("caseID", idList.get(1));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.hotel:
                bundle.putString("title", titleList.get(2));
                bundle.putString("caseID", idList.get(2));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.lipin:
                bundle.putString("title", titleList.get(3));
                bundle.putString("caseID", idList.get(3));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.qinzi:
                bundle.putString("title", titleList.get(4));
                bundle.putString("caseID", idList.get(4));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.leyuan:
                bundle.putString("title", titleList.get(5));
                bundle.putString("caseID", idList.get(5));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.jingqu:
                bundle.putString("title", titleList.get(6));
                bundle.putString("caseID", idList.get(6));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.chuxing:
                bundle.putString("title", titleList.get(7));
                bundle.putString("caseID", idList.get(7));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_newpeople:
                bundle.putString("title", titleList.get(0));
                bundle.putString("caseID", idList.get(0));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_food:
                bundle.putString("title", titleList.get(1));
                bundle.putString("caseID", idList.get(1));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_hotel:
                bundle.putString("title", titleList.get(2));
                bundle.putString("caseID", idList.get(2));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_lipin:
                bundle.putString("title", titleList.get(3));
                bundle.putString("caseID", idList.get(3));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_qinzi:
                bundle.putString("title", titleList.get(4));
                bundle.putString("caseID", idList.get(4));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_leyuan:
                bundle.putString("title", titleList.get(5));
                bundle.putString("caseID", idList.get(5));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_jingqu:
                bundle.putString("title", titleList.get(6));
                bundle.putString("caseID", idList.get(6));
                toClass(getActivity(), SecondActivity.class, bundle);
                break;
            case R.id.title_chuxing:
                bundle.putString("title", titleList.get(7));
                bundle.putString("caseID", idList.get(7));
                toClass(getActivity(), SecondActivity.class, bundle);
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

                getData(lat, lng);

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
                getData_num(lat, lng, num);
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
                getData_sale(lat, lng, jiage);
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

                getData_juli(lat, lng);
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

                getData(lat, lng);
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
                getData_num(lat, lng, num);
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
                getData_sale(lat, lng, jiage);
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

                getData_juli(lat, lng);
                break;
            case R.id.notice:
                toClass(getActivity(), NoticeActivity.class);
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
        if (y <= heigh2) {
            menu1.setVisibility(View.GONE);
        }
        if (y > heigh2) {
            menu1.setVisibility(View.VISIBLE);
            menu1.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("tag", "停止定位");
        mLocationClient.stopLocation();
        indexBanner.stopAutoPlay();
    }

    private void showDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(getActivity(), R.style.FullScreenDialog).create();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.index_show_dialog, null);
        dialog.setCancelable(false);
        v.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.setView(v);
        dialog.show();
    }

    private void getData(String lat, String lng) {
        Connector.IndexList(getActivity(), token, lat, null, lng, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                Log.d("tag", "成功" + result);
                resultItem(result);
            }
        });
    }

    private void getData_sale(String lat, String lng, String price) {
        Connector.IndexList_sale(getActivity(), token, lat, lng, null, price, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                resultItem(result);
            }
        });
    }

    private void getData_num(String lat, String lng, String num) {
        Connector.IndexList_num(getActivity(), token, lat, lng, null, num, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                resultItem(result);
            }
        });
    }

    private void getData_juli(String lat, String lng) {
        Connector.IndexList_away(getActivity(), token, lat, lng, null, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                resultItem(result);
            }
        });
    }

    private void getBanner(String lat, String lng) {
        Connector.indexBannerList(getActivity(), lat, lng, null, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("banner", "bannershuju---" + result);
                BannerBean bannerBean = JSON.parseObject(result, BannerBean.class);
                if (bannerBean.getCode() == 200) {
                    for (int i = 0; i < bannerBean.getData().size(); i++) {
                        list.add(bannerBean.getData().get(i).getPic());
                    }

                    indexBanner.setImageLoader(new GlideImageLoader(1));
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

    private void resultItem(String result) {
        final HomeData data = JSON.parseObject(result, HomeData.class);
        if (data.getCode() == 200) {
            datalist = data.getData();
            adapter = new Adapter(R.layout.index_list_item, datalist);
            indexRecycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                    intent.putExtra("id", data.getData().get(position).getProduct_id()+"");
                    startActivity(intent);
                }
            });
        }
    }

    private void getIndexFenlei() {
        Connector.indexFenlei(getActivity(), new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("indexfenlei", "数据" + result);
                final IndexFenLeiBean bean = JSON.parseObject(result, IndexFenLeiBean.class);
                if (bean.getCode() == 200) {
                    for (int i = 0; i < bean.getData().size(); i++) {
                        Glide.with(getActivity())
                                .load(bean.getData().get(i).getCate_icon())
                                .into(imageViewList.get(i));
                        textViewList.get(i).setText(bean.getData().get(i).getCate_name());
                        textViewList_title.get(i).setText(bean.getData().get(i).getCate_name());

                        titleList.add(bean.getData().get(i).getCate_name());
                        idList.add(bean.getData().get(i).getCate_id() + "");
                    }
                }
            }
        });
    }

}
