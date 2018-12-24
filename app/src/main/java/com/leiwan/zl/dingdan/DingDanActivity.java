package com.leiwan.zl.dingdan;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.androidkun.xtablayout.XTabLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.dingdan.fragment.All;
import com.leiwan.zl.dingdan.fragment.DFK;
import com.leiwan.zl.dingdan.fragment.TK;
import com.leiwan.zl.dingdan.fragment.YFK;
import com.leiwan.zl.dingdan.fragment.YWC;
import com.leiwan.zl.home.center.TabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DingDanActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.dingdan_tab)
    XTabLayout dingdanTab;
    @BindView(R.id.dingdan_viewpager)
    ViewPager dingdanViewpager;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    @Override
    protected int setLayout() {
        return R.layout.activity_ding_dan;
    }

    @Override
    protected void setView() {
        titleList = new ArrayList<>();
        titleList.add("全部");
        titleList.add("待付款");
        titleList.add("已付款");
        titleList.add("已完成");
        titleList.add("退款");
        fragmentList = new ArrayList<>();
        fragmentList.add(new All());
        fragmentList.add(new DFK());
        fragmentList.add(new YFK());
        fragmentList.add(new YWC());
        fragmentList.add(new TK());

        dingdanViewpager.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        dingdanViewpager.setOffscreenPageLimit(0);
        dingdanTab.setupWithViewPager(dingdanViewpager);
        dingdanTab.getTabAt(0).select();
        dingdanTab.getTabAt(1).select();
        dingdanViewpager.setCurrentItem(0);
    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
