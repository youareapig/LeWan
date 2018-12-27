package com.leiwan.zl.home.fragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class IsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public IsAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
       helper.setText(R.id.dingdan,item);
    }
}
