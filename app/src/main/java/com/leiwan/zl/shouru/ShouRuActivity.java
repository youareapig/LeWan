package com.leiwan.zl.shouru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.androidkun.xtablayout.XTabLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.home.center.TabAdapter;
import com.leiwan.zl.shouru.fragment.ShouRuFragment;
import com.leiwan.zl.shouru.fragment.TiXianFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShouRuActivity extends BaseActivity {


    @BindView(R.id.shouru_tab)
    XTabLayout shouruTab;
    @BindView(R.id.shouru_viewpager)
    ViewPager shouruViewpager;
    @BindView(R.id.back)
    ImageView back;
    private List<String> titleList;
    private List<Fragment> fragmentList;

    @Override
    protected int setLayout() {
        return R.layout.activity_shou_ru;
    }

    @Override
    protected void setView() {
        titleList = new ArrayList<>();
        titleList.add("佣金收入");
        titleList.add("收入提现");
        fragmentList = new ArrayList<>();
        fragmentList.add(new ShouRuFragment());
        fragmentList.add(new TiXianFragment());

        shouruViewpager.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        shouruViewpager.setOffscreenPageLimit(0);
        shouruTab.setupWithViewPager(shouruViewpager);
        shouruTab.getTabAt(0).select();
        shouruTab.getTabAt(1).select();
        shouruViewpager.setCurrentItem(0);

    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
