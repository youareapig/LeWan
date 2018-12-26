package com.leiwan.zl.dingdan.details;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.GoodsDetailsData;
import com.leiwan.zl.data.OrderDetalsData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class AdapterMoreStore extends BaseQuickAdapter<OrderDetalsData.DataBean.ShopBean, BaseViewHolder> {
    private int selectItem = 0;

    public AdapterMoreStore(@LayoutRes int layoutResId, @Nullable List<OrderDetalsData.DataBean.ShopBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, OrderDetalsData.DataBean.ShopBean item) {
        helper.setText(R.id.item_store, item.getMerchant_name() + item.getMerchant_400tel());
        if (helper.getAdapterPosition() == selectItem) {
            //选中
            helper.setBackgroundRes(R.id.item_store_view, R.drawable.line24);
            helper.setTextColor(R.id.item_store, Color.parseColor("#FFFFFF"));
        } else {
            //未选中
            helper.setBackgroundRes(R.id.item_store_view, R.drawable.line25);
            helper.setTextColor(R.id.item_store, Color.parseColor("#333333"));
        }

    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

}
