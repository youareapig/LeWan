package com.leiwan.zl.home.center;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.androidkun.xtablayout.XTabLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.home.center.fragment.IsAppointment;
import com.leiwan.zl.home.center.fragment.NoAppointment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AppointmentActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tab)
    XTabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    @Override
    protected int setLayout() {
        return R.layout.activity_appointment;
    }

    @Override
    protected void setView() {
        titleList = new ArrayList<>();
        titleList.add("未预约");
        titleList.add("已预约");
        fragmentList = new ArrayList<>();
        fragmentList.add(new NoAppointment());
        fragmentList.add(new IsAppointment());
        viewpager.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        viewpager.setOffscreenPageLimit(0);
        tab.setupWithViewPager(viewpager);
        tab.getTabAt(0).select();
        tab.getTabAt(1).select();
        viewpager.setCurrentItem(0);
    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
