package com.leiwan.zl.home.center;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.AppointmentDetailsData;
import com.leiwan.zl.data.GoodsDetailsData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class AdapterSize extends BaseQuickAdapter<AppointmentDetailsData.DataBean.PriceBean, BaseViewHolder> {
    private int selectItem = 0;

    public AdapterSize(@LayoutRes int layoutResId, @Nullable List<AppointmentDetailsData.DataBean.PriceBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, AppointmentDetailsData.DataBean.PriceBean item) {
        helper.setText(R.id.item_name, item.getProduct_property());
        if (helper.getAdapterPosition() == selectItem) {
            //选中
            helper.setBackgroundRes(R.id.item_name, R.drawable.line20);
            helper.setTextColor(R.id.item_name, Color.parseColor("#FFFFFF"));
        } else {
            //未选中
            helper.setBackgroundRes(R.id.item_name, R.drawable.line19);
            helper.setTextColor(R.id.item_name,Color.parseColor("#999999"));
        }

    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

}
