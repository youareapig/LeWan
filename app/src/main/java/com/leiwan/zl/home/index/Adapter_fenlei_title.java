package com.leiwan.zl.home.index;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.IndexFenLeiBean;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter_fenlei_title extends BaseQuickAdapter<IndexFenLeiBean.DataBean, BaseViewHolder> {


    public Adapter_fenlei_title(@LayoutRes int layoutResId, @Nullable List<IndexFenLeiBean.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, IndexFenLeiBean.DataBean item) {
        helper.setText(R.id.name, item.getCate_name());

    }


}
