package com.leiwan.zl.friend;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public Adapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView head = helper.getView(R.id.head);
        Glide.with(App.content)
                .load(item)
                .placeholder(R.mipmap.yuan)
                .error(R.mipmap.yuan)
                .bitmapTransform(new CenterCrop(App.content), new CropCircleTransformation(App.content))
                .into(head);
    }
}
