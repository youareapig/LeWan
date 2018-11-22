package com.leiwan.zl.newpeople;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.androidkun.xtablayout.XTabLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.home.center.TabAdapter;
import com.leiwan.zl.newpeople.fragment.KeTang;
import com.leiwan.zl.newpeople.fragment.ShouCe;
import com.leiwan.zl.newpeople.fragment.YongJin;
import com.leiwan.zl.shouru.fragment.ShouRuFragment;
import com.leiwan.zl.shouru.fragment.TiXianFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPeopleActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.xinshou_tab)
    XTabLayout xinshouTab;
    @BindView(R.id.xinshou_viewpager)
    ViewPager xinshouViewpager;
    private List<String> titleList;
    private List<Fragment> fragmentList;

    @Override
    protected int setLayout() {
        return R.layout.activity_new_people;
    }

    @Override
    protected void setView() {
        titleList = new ArrayList<>();
        titleList.add("使用手册");
        titleList.add("推广大课堂");
        titleList.add("分享得佣金");
        fragmentList = new ArrayList<>();
        fragmentList.add(new ShouCe());
        fragmentList.add(new KeTang());
        fragmentList.add(new YongJin());

        xinshouViewpager.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        xinshouViewpager.setOffscreenPageLimit(0);
        xinshouTab.setupWithViewPager(xinshouViewpager);
        xinshouTab.getTabAt(0).select();
        xinshouTab.getTabAt(1).select();
        xinshouViewpager.setCurrentItem(0);
    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
