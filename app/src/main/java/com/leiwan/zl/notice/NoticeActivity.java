package com.leiwan.zl.notice;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoticeActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_notice;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list = new ArrayList<>();
        list.add("新订单");
        list.add("版本更新v.20 已上线");
        list.add("订单预约成功");
        list.add("新订单");
        list.add("版本更新v.20 已上线");
        list.add("订单预约成功");
        list.add("新订单");
        list.add("版本更新v.20 已上线");
        list.add("订单预约成功");
        adapter = new Adapter(R.layout.notice_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
