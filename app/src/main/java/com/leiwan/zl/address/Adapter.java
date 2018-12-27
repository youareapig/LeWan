package com.leiwan.zl.address;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.AddressData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<AddressData.DataBean, BaseViewHolder> {


    public Adapter(@LayoutRes int layoutResId, @Nullable List<AddressData.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, AddressData.DataBean item) {
        helper.setText(R.id.name, item.getContact())
                .setText(R.id.tel, item.getMobile())
                .setText(R.id.adr, item.getAddress())
                .addOnClickListener(R.id.bianji)
                .addOnClickListener(R.id.delete);
    }


}
