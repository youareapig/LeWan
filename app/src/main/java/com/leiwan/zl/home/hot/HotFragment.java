package com.leiwan.zl.home.hot;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.home.index.*;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;

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
    private List<HomeData.DataBean> testList;
    private Adapter adapter;
    private int page = 1;
    @Override
    protected int setLayout() {
        return R.layout.hot_fragment;
    }

    @Override
    protected void setView() {
        shareList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        shareList.setNestedScrollingEnabled(false);
        LogUtil.d("test","lat---");
    }

    @Override
    protected void setData() {
        getHotData();
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        if (testList!=null){
//                            testList.clear();
//                        }
//                        page=1;
//                        getHotData();
                        refresh.finishRefresh();
                    }
                }, 1000);

            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        page++;
//                        getHotData();
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });
    }
    private void getHotData(){
        Connector.HotList(getActivity(), token, lat, lng,page+"", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("hot","hot---"+result);
                HomeData data= JSON.parseObject(result,HomeData.class);
                if (data.getCode()==200){
                    testList=data.getData();
                    adapter = new Adapter(R.layout.share_item, testList);
                    shareList.setAdapter(adapter);
                    adapter.openLoadAnimation();
                }

            }
        });
    }

}
