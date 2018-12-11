package com.leiwan.zl.daren;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaRenActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_da_ren;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list = new ArrayList<>();
        list.add("【成都青羊区小龙坎2人火锅餐】");
        list.add("【成都青羊区小龙坎2人火锅餐】");
        list.add("【成都青羊区小龙坎2人火锅餐】");
        list.add("【成都青羊区小龙坎2人火锅餐】");
        list.add("【成都青羊区小龙坎2人火锅餐】");
        adapter = new Adapter(R.layout.daren_item, list);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.showShortToast(list.get(position));
            }
        });
        adapter.openLoadAnimation();
        getData();
    }

    private void getData() {
        Connector.DaRenService(this, token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "daren---" + result);
            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
