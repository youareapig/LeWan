package com.leiwan.zl;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.leiwan.zl.home.center.CenterFragment;
import com.leiwan.zl.home.hot.HotFragment;
import com.leiwan.zl.home.index.IndexFragment;
import com.leiwan.zl.home.mine.MineFragment;
import com.leiwan.zl.login.LoginActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.index_view)
    RelativeLayout indexView;
    @BindView(R.id.hot_view)
    RelativeLayout hotView;
    @BindView(R.id.center_view)
    RelativeLayout centerView;
    @BindView(R.id.mine_view)
    RelativeLayout mineView;
    @BindView(R.id.index_icon)
    ImageView indexIcon;
    @BindView(R.id.index_name)
    TextView indexName;
    @BindView(R.id.hot_icon)
    ImageView hotIcon;
    @BindView(R.id.hot_name)
    TextView hotName;
    @BindView(R.id.center_icon)
    ImageView centerIcon;
    @BindView(R.id.center_name)
    TextView centerName;
    @BindView(R.id.mine_icon)
    ImageView mineIcon;
    @BindView(R.id.mine_name)
    TextView mineName;
    private Fragment fragment;
    private List<Fragment> fragmentList;
    private int currentIndex = 0;
    private FragmentManager fragmentManager;
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setView() {

        Intent intent = getIntent();
        currentIndex = intent.getIntExtra("indextag", 0);
        if (currentIndex == 3) {
            indexName.setTextColor(getResources().getColor(R.color.weixuanzhong));
            hotName.setTextColor(getResources().getColor(R.color.weixuanzhong));
            centerName.setTextColor(getResources().getColor(R.color.weixuanzhong));
            mineName.setTextColor(getResources().getColor(R.color.xuanzhong));

            indexIcon.setImageResource(R.mipmap.index1);
            hotIcon.setImageResource(R.mipmap.hot1);
            centerIcon.setImageResource(R.mipmap.time1);
            mineIcon.setImageResource(R.mipmap.wode);
        }
        fragment = new Fragment();
        fragmentList = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT, 0);
            fragmentList.removeAll(fragmentList);
            fragmentList.add(fragmentManager.findFragmentByTag(0 + ""));
            fragmentList.add(fragmentManager.findFragmentByTag(1 + ""));
            fragmentList.add(fragmentManager.findFragmentByTag(2 + ""));
            fragmentList.add(fragmentManager.findFragmentByTag(3 + ""));
            restoreFragment();
        } else {
            fragmentList.add(new IndexFragment());
            fragmentList.add(new HotFragment());
            fragmentList.add(new CenterFragment());
            fragmentList.add(new MineFragment());

            showFragment();
        }
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_FRAGMENT, currentIndex);
        super.onSaveInstanceState(outState);
    }

    private void showFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!fragmentList.get(currentIndex).isAdded()) {
            transaction
                    .hide(fragment)
                    .add(R.id.container, fragmentList.get(currentIndex), "" + currentIndex);
        } else {
            transaction
                    .hide(fragment)
                    .show(fragmentList.get(currentIndex));
        }
        fragment = fragmentList.get(currentIndex);
        transaction.commit();
    }

    private void restoreFragment() {
        FragmentTransaction mBeginTreansaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragmentList.size(); i++) {

            if (i == currentIndex) {
                mBeginTreansaction.show(fragmentList.get(i));
            } else {
                mBeginTreansaction.hide(fragmentList.get(i));
            }
        }
        mBeginTreansaction.commit();
        fragment = fragmentList.get(currentIndex);
    }

    @OnClick({R.id.index_view, R.id.hot_view, R.id.center_view, R.id.mine_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.index_view:
                ImmersionBar.with(this).statusBarColor(R.color.bar1).fitsSystemWindows(true).statusBarDarkFont(true).init();
                currentIndex = 0;
                showFragment();
                indexName.setTextColor(getResources().getColor(R.color.xuanzhong));
                hotName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                centerName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                mineName.setTextColor(getResources().getColor(R.color.weixuanzhong));

                indexIcon.setImageResource(R.mipmap.index);
                hotIcon.setImageResource(R.mipmap.hot1);
                centerIcon.setImageResource(R.mipmap.time1);
                mineIcon.setImageResource(R.mipmap.wode1);
                break;
            case R.id.hot_view:
                ImmersionBar.with(this).statusBarColor(R.color.bar).fitsSystemWindows(true).statusBarDarkFont(true).init();
                currentIndex = 1;
                showFragment();
                indexName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                hotName.setTextColor(getResources().getColor(R.color.xuanzhong));
                centerName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                mineName.setTextColor(getResources().getColor(R.color.weixuanzhong));

                indexIcon.setImageResource(R.mipmap.index1);
                hotIcon.setImageResource(R.mipmap.hot);
                centerIcon.setImageResource(R.mipmap.time1);
                mineIcon.setImageResource(R.mipmap.wode1);
                break;
            case R.id.center_view:
                ImmersionBar.with(this).statusBarColor(R.color.bar).fitsSystemWindows(true).statusBarDarkFont(true).init();
                currentIndex = 2;
                showFragment();
                indexName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                hotName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                centerName.setTextColor(getResources().getColor(R.color.xuanzhong));
                mineName.setTextColor(getResources().getColor(R.color.weixuanzhong));

                indexIcon.setImageResource(R.mipmap.index1);
                hotIcon.setImageResource(R.mipmap.hot1);
                centerIcon.setImageResource(R.mipmap.time);
                mineIcon.setImageResource(R.mipmap.wode1);
                break;
            case R.id.mine_view:
                ImmersionBar.with(this).statusBarColor(R.color.bar).fitsSystemWindows(true).statusBarDarkFont(true).init();
                    currentIndex = 3;
                    showFragment();
                    indexName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                    hotName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                    centerName.setTextColor(getResources().getColor(R.color.weixuanzhong));
                    mineName.setTextColor(getResources().getColor(R.color.xuanzhong));

                    indexIcon.setImageResource(R.mipmap.index1);
                    hotIcon.setImageResource(R.mipmap.hot1);
                    centerIcon.setImageResource(R.mipmap.time1);
                    mineIcon.setImageResource(R.mipmap.wode);

                break;
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    assert v != null;
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    /** here */
                    v.clearFocus();
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }




}
