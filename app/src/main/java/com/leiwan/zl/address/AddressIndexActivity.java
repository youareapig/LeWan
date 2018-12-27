package com.leiwan.zl.address;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.AddressData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressIndexActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.addadr)
    RelativeLayout addadr;
    @BindView(R.id.noData)
    TextView noData;
    private List<AddressData.DataBean> list;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_address_index;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        getData();

    }


    @OnClick({R.id.back, R.id.addadr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.addadr:
                toClass(this, UpdateAddressActivity.class);
                break;
        }
    }

    private void getData() {
        Connector.AddressList(this, token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "收货地址" + result);
                AddressData data = JSON.parseObject(result, AddressData.class);
                if (data.getCode() == 200) {
                    list=data.getData();
                    adapter = new Adapter(R.layout.address_item, list);
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                    adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            switch (view.getId()) {
                                case R.id.bianji:
                                    Intent intent = new Intent(App.content, UpdateAddressActivity.class);
                                    startActivity(intent);
                                    break;
                                case R.id.delete:
                                    list.remove(position);
                                    adapter.notifyItemRemoved(position);
                                    break;
                            }
                        }
                    });
                    //判断是否有数据
                    if (list.size() == 0) {
                        noData.setVisibility(View.VISIBLE);
                    } else {
                        noData.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

}
