package com.leiwan.zl.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidkun.xtablayout.XTabLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.details.fragment.GMXZ;
import com.leiwan.zl.details.fragment.TSJS;
import com.leiwan.zl.home.center.TabAdapter;
import com.leiwan.zl.newpeople.fragment.KeTang;
import com.leiwan.zl.newpeople.fragment.ShouCe;
import com.leiwan.zl.newpeople.fragment.YongJin;
import com.youth.banner.view.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity {


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.points)
    LinearLayout points;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.banner)
    BannerViewPager banner;
    @BindView(R.id.details_tab)
    XTabLayout detailsTab;
    @BindView(R.id.details_viewpager)
    ViewPager detailsViewpager;
    private ImageView[] ivPoints;//小圆点图片的集合
    private int totalPage; //总的页数
    private int mPageSize = 4; //每页显示的最大的数量
    private List<String> listDatas;//总的数据源
    private List<View> viewPagerList;//GridView作为一个View对象添加到ViewPager集合中

    private List<String> titleList;
    private List<Fragment> fragmentList;
    @Override
    protected int setLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void setView() {
        titleList = new ArrayList<>();
        titleList.add("购买须知");
        titleList.add("特色介绍");
        fragmentList = new ArrayList<>();
        fragmentList.add(new GMXZ());
        fragmentList.add(new TSJS());

        detailsViewpager.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        detailsViewpager.setOffscreenPageLimit(0);
        detailsTab.setupWithViewPager(detailsViewpager);
        detailsTab.getTabAt(0).select();
        detailsTab.getTabAt(1).select();
        detailsViewpager.setCurrentItem(0);
    }

    @Override
    protected void setData() {
        listDatas = new ArrayList<>();
        listDatas.add("【万达瑞华国际酒店】");
        listDatas.add("【4人团套餐温泉票】");
        listDatas.add("【海鲜牛排自助】");
        listDatas.add("【三生有幸花店】");
        listDatas.add("【万达瑞华国际酒店】");
        listDatas.add("【4人团套餐温泉票】");
        listDatas.add("【海鲜牛排自助】");
        listDatas.add("【三生有幸花店】");


        totalPage = (int) Math.ceil(listDatas.size() * 1.0 / mPageSize);
        viewPagerList = new ArrayList<View>();
        for (int i = 0; i < totalPage; i++) {
            //每个页面都是inflate出一个新实例
            final GridView gridView = (GridView) View.inflate(this, R.layout.pagergrid, null);
            gridView.setAdapter(new MyGridViewAdpter(this, listDatas, i, mPageSize));
            //添加item点击监听
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                                        int position, long arg3) {
                    // TODO Auto-generated method stub
                    Object obj = gridView.getItemAtPosition(position);
                    if (obj != null && obj instanceof String) {
                        System.out.println(obj);
                        Toast.makeText(DetailsActivity.this, ((String) obj), Toast.LENGTH_SHORT).show();
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
            ImageView imageView=new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            imageView.setLayoutParams(layoutParams);
            ivPoints[i]=imageView;
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




    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
