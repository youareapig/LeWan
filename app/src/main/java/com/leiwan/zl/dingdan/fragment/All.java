package com.leiwan.zl.dingdan.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.OrderListData;
import com.leiwan.zl.dingdan.details.DaiFuKuanDetailsActivity;
import com.leiwan.zl.dingdan.details.ExpressageActivity;
import com.leiwan.zl.dingdan.details.YiFuKuanDetailsActivity;
import com.leiwan.zl.dingdan.details.YiWanChengActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/22.
 */

public class All extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
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


        getData();
    }

    private void getData() {
        Connector.Order(getActivity(), token, "1", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "全部订单---" + result);
                final OrderListData data = JSON.parseObject(result, OrderListData.class);
                if (data.getCode() == 200) {
                    adapter = new Adapter(R.layout.dingdan_item, data.getData());
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                    adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            switch (data.getData().get(position).getOrder_status()) {
                                case 1:
                                    //待付款
                                    Intent intent = new Intent(view.getContext(), DaiFuKuanDetailsActivity.class);
                                    intent.putExtra("orderid", data.getData().get(position).getOrder_id() + "");
                                    startActivity(intent);
                                    break;
                                case 5:
                                    //已付款
                                    Intent intent1 = new Intent(view.getContext(), YiFuKuanDetailsActivity.class);
                                    intent1.putExtra("orderid", data.getData().get(position).getOrder_id() + "");
                                    startActivity(intent1);
                                    break;
                                case 2:
                                    Intent intent3 = new Intent(view.getContext(), ExpressageActivity.class);
                                    intent3.putExtra("orderid", data.getData().get(position).getOrder_id() + "");
                                    intent3.putExtra("title", "待发货");
                                    startActivity(intent3);
                                    //待发货
                                    break;
                                case 4:
                                    Intent intent4 = new Intent(view.getContext(), ExpressageActivity.class);
                                    intent4.putExtra("orderid", data.getData().get(position).getOrder_id() + "");
                                    intent4.putExtra("title", "待收货");
                                    startActivity(intent4);
                                    //待收货
                                    break;
                                case 7:
                                    //已完成
                                    Intent intent2 = new Intent(view.getContext(), YiWanChengActivity.class);
                                    intent2.putExtra("orderid", data.getData().get(position).getOrder_id() + "");
                                    startActivity(intent2);
                                    break;
                            }
                        }
                    });
                }
            }
        });
    }

}
