package com.leiwan.zl.home.center.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.NoAppointmentData;
import com.leiwan.zl.details.DetailsActivity;
import com.leiwan.zl.home.center.AppointmentDetalsActivity;
import com.leiwan.zl.home.center.StoreInfoActivity;
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
    private RecyclerView dialogRecycler;
    private MoreExpendCodeAdapter moreExpendCodeAdapter;
    private String orderId;

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
                final NoAppointmentData data = JSON.parseObject(result, NoAppointmentData.class);
                if (data.getCode() == 200) {
                    list = data.getData();
                    adapter = new NoAdapter(R.layout.noappointment_item, list);
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                    adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            if (data.getData().get(position).getCode_count() > 1) {
                                //多个电子码
                                ExpendcodeDialog(view, data.getData().get(position));
                            } else {
                                //一个电子码
                                orderId = data.getData().get(0).getOrder_id() + "";
                                Intent intent = new Intent(view.getContext(), StoreInfoActivity.class);
                                intent.putExtra("orderid", orderId);
                                intent.putExtra("code", data.getData().get(position).getCode().get(0).getConsume_code());
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
    }

    //查看多个电子码
    private void ExpendcodeDialog(View view, final NoAppointmentData.DataBean bean) {
        final AlertDialog builder = new AlertDialog.Builder(view.getContext()).create();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.expendcodedialog,
                null);
        builder.setView(layout);
        builder.show();
        dialogRecycler = (RecyclerView) layout.findViewById(R.id.dialog_recycler);
        dialogRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        moreExpendCodeAdapter = new MoreExpendCodeAdapter(R.layout.expendcodeitem, bean.getCode());
        dialogRecycler.setAdapter(moreExpendCodeAdapter);
        moreExpendCodeAdapter.openLoadAnimation();
        moreExpendCodeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(view.getContext(), StoreInfoActivity.class);
                intent.putExtra("orderid", bean.getOrder_id() + "");
                intent.putExtra("code", bean.getCode().get(position).getConsume_code());
                startActivity(intent);
            }
        });
    }
}
