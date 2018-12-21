package com.leiwan.zl.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.leiwan.zl.R.id.textView;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public Map<Integer, Boolean> map;

    public Adapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        map = new HashMap<>();
    }

    @Override
    protected void convert(final BaseViewHolder helper, final String item) {
        ImageView img = helper.getView(R.id.item_img);
        CheckBox checkBox = helper.getView(R.id.item_check);

        //解决checkBox混乱
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    map.put(helper.getAdapterPosition(), true);
                } else {
                    map.remove(helper.getAdapterPosition());
                }
            }
        });
        checkBox.setChecked(map.get(helper.getAdapterPosition()) == null ? false : true);


        Glide.with(App.content)
                .load(item)
                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 5, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(img);

    }

}
