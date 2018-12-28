package com.leiwan.zl.home.center.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.NoAppointmentData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/12/26.
 */

public class NoAppointment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;

    private NoAdapter adapter;
    private List<NoAppointmentData.DataBean> list;
    @Override
    protected int setLayout() {
        return R.layout.noappointment;
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
        Connector.NoAppointment(getActivity(), token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "未预约--" + result);
                NoAppointmentData data = JSON.parseObject(result, NoAppointmentData.class);
                if (data.getCode() == 200) {
                    list=data.getData();
                    adapter=new NoAdapter(R.layout.noappointment_item,list);
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                }
            }
        });
    }
}
