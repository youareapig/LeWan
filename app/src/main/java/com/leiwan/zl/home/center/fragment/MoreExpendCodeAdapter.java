package com.leiwan.zl.home.center.fragment;

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

public class MoreExpendCodeAdapter extends BaseQuickAdapter<NoAppointmentData.DataBean.CodeBean, BaseViewHolder> {


    public MoreExpendCodeAdapter(@LayoutRes int layoutResId, @Nullable List<NoAppointmentData.DataBean.CodeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoAppointmentData.DataBean.CodeBean item) {
        helper.setText(R.id.item_code, item.getConsume_code());
        switch (item.getStatus()) {
            case 1:
                helper.setText(R.id.item_tag, "去预约");
                break;
            case 2:
                helper.setText(R.id.item_tag, "已使用");
                break;
            case 3:
                helper.setText(R.id.item_tag, "已过期");
                break;
            case 4:
                helper.setText(R.id.item_tag, "冻结");
                break;
        }
    }
}
