package com.leiwan.zl.home.center.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/19.
 */

public class YiShiYong extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;
    private Adapter adapter;

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
        list = new ArrayList<>();
        list.add("串串香");
        list.add("一门");
        list.add("琼花饺子店");
        list.add("一个农民");
        adapter = new Adapter(R.layout.center_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
    }

}
