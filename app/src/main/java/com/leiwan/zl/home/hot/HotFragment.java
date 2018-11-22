package com.leiwan.zl.home.hot;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.home.index.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/14.
 */

public class HotFragment extends BaseFragment {
    @BindView(R.id.share_list)
    RecyclerView shareList;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    private List<Map<String, String>> testList;
    private Map<String, String> map;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.hot_fragment;
    }

    @Override
    protected void setView() {
        shareList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        shareList.setNestedScrollingEnabled(false);
    }

    @Override
    protected void setData() {
        map = new HashMap<>();
        map.put("first", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542622085340&di=25d7163de1083a13cb37cd322b9b4069&imgtype=0&src=http%3A%2F%2Fpic157.nipic.com%2Ffile%2F20180301%2F21485791_202149495000_2.jpg");
        map.put("second", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542622085340&di=5cfcc7195f458e20408ccc92c282c13f&imgtype=0&src=http%3A%2F%2Fpic41.nipic.com%2F20140510%2F9899750_140054382000_2.jpg");
        testList = new ArrayList<>();
        testList.add(map);
        testList.add(map);
        testList.add(map);
        testList.add(map);
        testList.add(map);
        adapter = new Adapter(R.layout.share_item, testList);
        shareList.setAdapter(adapter);
        adapter.openLoadAnimation();
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.finishRefresh();
                    }
                }, 1000);

            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });
    }

}
