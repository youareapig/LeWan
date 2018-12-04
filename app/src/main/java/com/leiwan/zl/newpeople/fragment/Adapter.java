package com.leiwan.zl.newpeople.fragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.TeachListData;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<TeachListData.DataBean, BaseViewHolder> {


    public Adapter(@LayoutRes int layoutResId, @Nullable List<TeachListData.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, TeachListData.DataBean item) {
        ImageView imageView = helper.getView(R.id.itme_img);
        Glide.with(App.content)
                .load(item.getPic())
                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
        helper.setText(R.id.item_content,item.getTitle());

    }


}
