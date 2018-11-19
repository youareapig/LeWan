package com.leiwan.zl.home;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leiwan.zl.R;
import com.leiwan.zl.home.center.CenterFragment;
import com.leiwan.zl.home.hot.HotFragment;
import com.leiwan.zl.home.index.IndexFragment;
import com.leiwan.zl.home.mine.MineFragment;
import com.leiwan.zl.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

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
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);


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
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();

    }
}
