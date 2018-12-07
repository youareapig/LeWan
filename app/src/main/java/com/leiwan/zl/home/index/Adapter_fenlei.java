package com.leiwan.zl.home.index;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.data.IndexFenLeiBean;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SnapUpCountDownTimerView;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter_fenlei extends BaseQuickAdapter<IndexFenLeiBean.DataBean, BaseViewHolder> {


    public Adapter_fenlei(@LayoutRes int layoutResId, @Nullable List<IndexFenLeiBean.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, IndexFenLeiBean.DataBean item) {
        ImageView icon = helper.getView(R.id.icon);
        Glide.with(App.content)
                .load(item.getCate_icon())
                .into(icon);
        helper.setText(R.id.name, item.getCate_name());

    }


}
