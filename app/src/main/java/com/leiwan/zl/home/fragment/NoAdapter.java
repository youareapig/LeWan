package com.leiwan.zl.home.fragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.NoAppointmentData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class NoAdapter extends BaseQuickAdapter<NoAppointmentData.DataBean, BaseViewHolder> {


    public NoAdapter(@LayoutRes int layoutResId, @Nullable List<NoAppointmentData.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoAppointmentData.DataBean item) {
        helper.setText(R.id.goodsname, item.getProduct_name())
                .setText(R.id.ordercode, item.getOrdernumber());

    }
}
