package com.leiwan.zl.details;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.GoodsDetailsData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter1 extends BaseQuickAdapter<GoodsDetailsData.DataBean.DetailsBean.ShopBean, BaseViewHolder> {
    private int selectItem = 0;

    public Adapter1(@LayoutRes int layoutResId, @Nullable List<GoodsDetailsData.DataBean.DetailsBean.ShopBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, GoodsDetailsData.DataBean.DetailsBean.ShopBean item) {
        helper.setText(R.id.item_name, item.getMerchant_name());
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
