package com.leiwan.zl.details;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.GoodsDetailsData;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.utils.DateUtils;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<GoodsDetailsData.DataBean.PriceBean, BaseViewHolder> {
    private int selectItem = 0;

    public Adapter(@LayoutRes int layoutResId, @Nullable List<GoodsDetailsData.DataBean.PriceBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, GoodsDetailsData.DataBean.PriceBean item) {
        helper.setText(R.id.item_name, item.getProduct_property());
        if (helper.getAdapterPosition() == selectItem) {
            //选中
            helper.setBackgroundRes(R.id.item_name, R.drawable.line20);
        } else {
            //未选中
            helper.setBackgroundRes(R.id.item_name, R.drawable.line19);
        }

    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

}
