package com.leiwan.zl.dingdan.details;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.OrderDetalsData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class AdapterCode extends BaseQuickAdapter<OrderDetalsData.DataBean.CodeBean, BaseViewHolder> {

    public AdapterCode(@LayoutRes int layoutResId, @Nullable List<OrderDetalsData.DataBean.CodeBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, OrderDetalsData.DataBean.CodeBean item) {
        helper.setText(R.id.item_code, item.getConsume_code());
        TextView textView = helper.getView(R.id.item_codetag);
        if (item.getConsume_type() == 1) {
            //已预约
            textView.setText("已预约");
            textView.setBackgroundResource(R.drawable.line27);
        } else if (item.getConsume_type() == 2) {
            //未预约
            textView.setText("未预约");
            textView.setBackgroundResource(R.drawable.line27);
        }
        if (item.getConsume_status() == 1) {
            //未使用
            textView.setText("未使用");
            textView.setBackgroundResource(R.drawable.line27);
        } else if (item.getConsume_status() == 2) {
            //已使用
            textView.setText("已使用");
            textView.setBackgroundResource(R.drawable.line27);
        } else if (item.getConsume_status() == 3) {
            //已过期
            textView.setText("已过期");
            textView.setBackgroundResource(R.drawable.line26);
        } else if (item.getConsume_status() == 4) {
            //冻结
            textView.setText("已冻结");
            textView.setBackgroundResource(R.drawable.line26);
        }

    }


}
