package com.leiwan.zl.home.center.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/19.
 */

public class WeiYuYue extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;

    @Override
    protected int setLayout() {
        return R.layout.weiyuyue;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list=new ArrayList<>();
        list.add("麻辣烫");
        list.add("九锅一堂");
        list.add("越吃越好吃");
        list.add("刘二娃干锅");
        recycler.setAdapter(new Adapter(list,getActivity()));
    }

}
