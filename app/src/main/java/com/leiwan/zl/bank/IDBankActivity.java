package com.leiwan.zl.bank;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IDBankActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.addbank)
    RelativeLayout addbank;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_idbank;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list = new ArrayList<>();
        list.add("1235");
        list.add("1236");
        list.add("1237");
        list.add("1238");
        list.add("1239");
        list.add("1226");
        adapter = new Adapter(R.layout.bank_list_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();

    }


    @OnClick({R.id.back, R.id.addbank})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.addbank:
                toClass(this, AddBankActivity.class);
                break;
            case R.id.back:
                finish();
                break;
        }

    }

}
