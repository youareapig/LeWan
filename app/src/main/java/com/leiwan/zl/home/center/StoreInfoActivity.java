package com.leiwan.zl.home.center;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.CalenderData;
import com.leiwan.zl.data.ComboData;
import com.leiwan.zl.data.FenDianData;
import com.leiwan.zl.details.DetailsActivity;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.DividerGridItemDecoration;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoreInfoActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler_store)
    RecyclerView recyclerStore;
    @BindView(R.id.recycler_calendar)
    RecyclerView recyclerCalendar;

    private String orderId, code;
    private String date;
    private AdapterFenDian adapterFenDian;
    private AdapterCalender adapterCalender;
    private RecyclerView dialogRecycler;
    private TextView dialogDate;
    private AdapterCombo adapterCombo;

    @Override
    protected int setLayout() {
        return R.layout.activity_store_info;
    }

    @Override
    protected void setView() {
        recyclerStore.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerStore.addItemDecoration(new SpacesItemDecoration(10));
        recyclerCalendar.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerCalendar.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        orderId = getIntent().getStringExtra("orderid");
        code = getIntent().getStringExtra("code");
        LogUtil.d("tag", "code---" + code);
        getFendian();
    }

    private void getFendian() {
        Connector.GetFenDian(this, token, orderId, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "fendian--" + result);
                final FenDianData data = JSON.parseObject(result, FenDianData.class);
                if (data.getCode() == 200) {
                    adapterFenDian = new AdapterFenDian(R.layout.guige_item, data.getData());
                    recyclerStore.setAdapter(adapterFenDian);
                    adapterFenDian.openLoadAnimation();
                    adapterFenDian.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            adapterFenDian.setSelectItem(position);
                            adapterFenDian.notifyDataSetChanged();
                            getCanlander(data.getData().get(position).getMerchant_id() + "");
                        }
                    });

                }
            }
        });
    }

    private void getCanlander(String mid) {
        Connector.Calander(this, token, code, mid, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "can---" + result);
                final CalenderData data = JSON.parseObject(result, CalenderData.class);
                if (data.getCode() == 200) {
                    adapterCalender = new AdapterCalender(R.layout.calendar_item, data.getData());
                    recyclerCalendar.setAdapter(adapterCalender);
                    adapterCalender.openLoadAnimation();
                    adapterCalender.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            adapterCalender.setSelectItem(position);
                            adapterCalender.notifyDataSetChanged();
                            date = data.getData().get(position).getCalendar() + "";
                            appointmentDialog(view, data.getData().get(position).getReservationday_id() + "");

                        }
                    });
                }
            }
        });
    }


    //已购买,去预约
    private void appointmentDialog(View v, String calanderId) {
        final AlertDialog builder = new AlertDialog.Builder(v.getContext()).create();
        //去掉白色背景
        builder.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.appointment_dialog,
                null);
        builder.setView(layout);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        dialogRecycler = (RecyclerView) layout.findViewById(R.id.dialog_recycler);
        dialogDate = (TextView) layout.findViewById(R.id.expense_date);
        dialogRecycler.setLayoutManager(new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false));
        getCase(calanderId);

        layout.findViewById(R.id.dialog_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.cancel();
            }
        });
    }

    private void getCase(String calendarId) {
        Connector.GetCase(this, token, calendarId, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "套餐--" + result);
                ComboData data = JSON.parseObject(result, ComboData.class);
                if (data.getCode() == 200) {
                    dialogDate.setText("消费日期：" + DateUtils.timeslash(date));
                    adapterCombo = new AdapterCombo(R.layout.appointment_dialog_item, data.getData());
                    dialogRecycler.setAdapter(adapterCombo);
                    adapterCombo.openLoadAnimation();
                }
            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
