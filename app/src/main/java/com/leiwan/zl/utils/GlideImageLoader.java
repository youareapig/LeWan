package com.leiwan.zl.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.leiwan.zl.R;
import com.youth.banner.loader.ImageLoader;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Administrator on 2018/11/14.
 */

public class GlideImageLoader extends ImageLoader {
    private int isCenter;

    public GlideImageLoader(int isCenter) {
        this.isCenter = isCenter;
    }

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        switch (isCenter) {
            //有圆角
            case 1:
                Glide.with(context)
                        .load(path)
                        .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, 16, 0))
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into(imageView);
                break;
            case 2:
                //直角
                Glide.with(context)
                        .load(path)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into(imageView);
                break;
        }


    }
}
