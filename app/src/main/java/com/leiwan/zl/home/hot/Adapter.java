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
import com.leiwan.zl.utils.SharedPreferencesUtil;
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
    private int level;

    public Adapter(@LayoutRes int layoutResId, @Nullable List<HomeData.DataBean> data) {
        super(layoutResId, data);
        level = SharedPreferencesUtil.getInstance(App.content).getSP("level", 0);
    }


    @Override
    protected void convert(BaseViewHolder helper, HomeData.DataBean item) {
        String zigou = item.getTemp_commission().getZigou();
        String fenxiang = item.getTemp_commission().getFenxiang();
        if (level == 1) {
            //普通会员，不显示佣金
            helper.setText(R.id.item_fenxiang,"");
        } else if (level == 2) {
            //超级会员显示自购和分享佣金
            helper.setText(R.id.item_fenxiang,"返¥" + zigou + "～" + fenxiang);
        } else {
            //超过2的只显示购买佣金
            helper.setText(R.id.item_fenxiang,"返¥" + zigou);
        }

        ImageView image;
        image = helper.getView(R.id.item_img);

        Glide.with(App.content)
                .load(item.getProduct_pic())
                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
                .placeholder(R.mipmap.defult_banner)
                .error(R.mipmap.defult_banner)
                .into(image);

        helper.setText(R.id.item_content, item.getProduct_name())
                .setText(R.id.share_item_jiage, "¥" + item.getTemp_price())
                .setText(R.id.item_date, DateUtils.timedate(item.getProduct_addtime() + ""));


    }


}
