package com.leiwan.zl.newpeople.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.TeachListData;
import com.leiwan.zl.newpeople.NewPeopleDetailsActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/22.
 */
@SuppressLint("ValidFragment")
public class ShouCe extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<TeachListData.DataBean> list;
    private Adapter adapter;
    private int pageID;

    public ShouCe(){}
    public ShouCe(int pageID) {
        this.pageID = pageID;
    }

    @Override
    protected int setLayout() {
        return R.layout.xinshou_tab;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        getData();

    }

    private void getData() {
        Connector.TeachList(getActivity(), token,lat, lng, pageID + "", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "手册" + result);
                final TeachListData data = JSON.parseObject(result, TeachListData.class);
                if (data.getCode() == 200) {
                    list = data.getData();
                    adapter = new Adapter(R.layout.xinshou_tab_item, list);
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                    adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            Intent intent = new Intent(App.content, NewPeopleDetailsActivity.class);
                            intent.putExtra("id", data.getData().get(position).getId());
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }

}
