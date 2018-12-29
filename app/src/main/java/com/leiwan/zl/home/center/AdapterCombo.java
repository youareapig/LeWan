package com.leiwan.zl.home.center;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.ComboData;
import com.leiwan.zl.data.YuYueData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class AdapterCombo extends BaseQuickAdapter<ComboData.DataBean, BaseViewHolder> {


    public AdapterCombo(@LayoutRes int layoutResId, @Nullable List<ComboData.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, ComboData.DataBean item) {
        helper.setText(R.id.item_name, item.getProduct_name())
                .setText(R.id.item_size,item.getProperty())
                .setText(R.id.item_num,"可约数量："+item.getUsenum())
                .setText(R.id.item_money,"额外加收："+item.getAddprice()+"元");

    }

}




