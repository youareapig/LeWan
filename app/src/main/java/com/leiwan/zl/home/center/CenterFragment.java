package com.leiwan.zl.home.center;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.home.center.fragment.WeiYuYue;
import com.leiwan.zl.home.center.fragment.YiShiYong;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/14.
 */

public class CenterFragment extends BaseFragment {
    @BindView(R.id.center_tab)
    XTabLayout centerTab;
    @BindView(R.id.center_viewpager)
    ViewPager centerViewpager;
    private List<String> titleList;
    private List<Fragment> fragmentList;

    @Override
    protected int setLayout() {
        return R.layout.center_fragment;
    }

    @Override
    protected void setView() {
        titleList = new ArrayList<>();
        titleList.add("未预约");
        titleList.add("已使用");
        fragmentList = new ArrayList<>();
        fragmentList.add(new WeiYuYue());
        fragmentList.add(new YiShiYong());

        centerViewpager.setAdapter(new TabAdapter(getActivity().getSupportFragmentManager(), titleList, fragmentList));
        centerViewpager.setOffscreenPageLimit(0);
        centerTab.setupWithViewPager(centerViewpager);
        centerTab.getTabAt(0).select();
        centerTab.getTabAt(1).select();
        centerViewpager.setCurrentItem(0);
    }

    @Override
    protected void setData() {

    }


}
