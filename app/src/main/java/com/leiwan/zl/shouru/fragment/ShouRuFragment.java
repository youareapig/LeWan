package com.leiwan.zl.shouru.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.EventBusRespon;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/22.
 */

public class ShouRuFragment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;

    private Adapter adapter;
    private List<String> list;

    @Override
    protected int setLayout() {
        return R.layout.shouru_fragment;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list = new ArrayList<>();
        list.add("+10.3");
        list.add("+11.3");
        list.add("+15.3");
        list.add("+16.3");
        list.add("+102.3");
        list.add("+1.3");
        list.add("+1.3");
        list.add("+1.3");
        list.add("+1.3");
        adapter = new Adapter(R.layout.shouru_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
    }


}
