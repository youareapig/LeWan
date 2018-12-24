package com.leiwan.zl.dingdan.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.dingdan.details.DaiFuKuanDetailsActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/22.
 */

public class DFK extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.dingdan_fragment;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list = new ArrayList<>();
        list.add("待付款");
        list.add("待付款");
        adapter = new Adapter(R.layout.dingdan_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(view.getContext(), DaiFuKuanDetailsActivity.class);
                startActivity(intent);
            }
        });
        getData();
    }
    private void getData() {
        Connector.Order(getActivity(), token, "2",new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
            }
        });
    }
}
