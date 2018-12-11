package com.leiwan.zl.home.hot;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.JsonObject;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SnapUpCountDownTimerView;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static android.R.id.list;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<HomeData.DataBean, BaseViewHolder> {


    public Adapter(@LayoutRes int layoutResId, @Nullable List<HomeData.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, HomeData.DataBean item) {
        ImageView imageLift, imageRight;
        imageLift = helper.getView(R.id.item_image_left);
        imageRight = helper.getView(R.id.item_image_right);

        Glide.with(App.content)
                .load(item.getProduct_pic())
                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageLift);
        Glide.with(App.content)
                .load(item.getProduct_compic())
                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageRight);

        helper.setText(R.id.item_name, item.getProduct_name())
                .setText(R.id.share_item_jiage, "¥" + item.getTemp_price())
                .setText(R.id.item_fenxiang, "分享赚" + item.getTemp_commission().getFenxiang())
                .setText(R.id.item_date, DateUtils.timedate(item.getProduct_addtime() + ""));


    }


}
