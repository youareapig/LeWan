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

public class Adapter_Tag extends BaseQuickAdapter<GoodsDetailsData.DataBean.DetailsBean.ProductTagsBean, BaseViewHolder> {

    public Adapter_Tag(@LayoutRes int layoutResId, @Nullable List<GoodsDetailsData.DataBean.DetailsBean.ProductTagsBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, GoodsDetailsData.DataBean.DetailsBean.ProductTagsBean item) {
        helper.setText(R.id.goods_tag, item.getTag_name());

    }
}
