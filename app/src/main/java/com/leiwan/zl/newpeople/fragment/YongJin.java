package com.leiwan.zl.newpeople.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.TeachListData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/22.
 */

public class YongJin extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<TeachListData.DataBean> list;
    private Adapter adapter;
    private int pageID;
    private String lat, lng;
    public YongJin(int pageID) {
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
        lat = SharedPreferencesUtil.getInstance(getActivity()).getSP("lat");
        lng = SharedPreferencesUtil.getInstance(getActivity()).getSP("lng");
        getData();
    }
    private void getData() {
        Connector.TeachList(getActivity(), lat, lng, pageID + "", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "佣金" + result);
                TeachListData data = JSON.parseObject(result, TeachListData.class);
                if (data.getCode() == 200) {
                    list = data.getData();
                    adapter = new Adapter(R.layout.xinshou_tab_item, list);
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                }
            }
        });
    }
}
