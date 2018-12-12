package com.leiwan.zl.home.index;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SnapUpCountDownTimerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        long endtime = item.getProduct_endtime();
        long[] timetype = DateUtils.timeOver(endtime);
        long day = timetype[0];
        long hour = timetype[1];
        long min = timetype[2];
        long second = timetype[3];


        helper.setText(R.id.index_list_item_title, item.getProduct_name())
                .setText(R.id.index_list_item_jiage, "¥" + item.getTemp_price())
                .setText(R.id.index_list_item_xiaoliang, "已售" + item.getProduct_sold())
                .setText(R.id.index_list_item_location, item.getRegion())
                .setText(R.id.index_list_item_juli, item.getDistance() + "KM")
                .setText(R.id.index_list_item_youhui, "赚" + item.getTemp_commission().getFenxiang());
        ImageView imageView = helper.getView(R.id.index_list_item_image);
        SnapUpCountDownTimerView timerView = helper.getView(R.id.item_timer);
        LinearLayout timeLayout = helper.getView(R.id.timeview);
        if (day <= 0 && hour <= 0 && min <= 0 && second <= 0) {
            timeLayout.setVisibility(View.GONE);
        } else {
            timeLayout.setVisibility(View.VISIBLE);
            timerView.setTime(day, hour, min, second);
            timerView.start();
        }

        Glide.with(App.content)
                .load(item.getProduct_pic())
                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);

    }


}
