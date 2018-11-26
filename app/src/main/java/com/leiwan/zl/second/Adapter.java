package com.leiwan.zl.second;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.utils.SnapUpCountDownTimerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public Adapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        long endtime = item.getProduct_endtime();
//        long nowtime = dateToStamp();
//        long time = endtime - nowtime;
//        Long day = time / (1000 * 60 * 60 * 24);   //以天数为单位取整
//        Long hour = (time / (60 * 60 * 1000) - day * 24);    //以小时为单位取整
//        Long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60); //以分钟为单位取整
//        Long second = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);//秒
//        Log.d("tag", "当前时间戳" + dateToStamp());

        helper.setText(R.id.index_list_item_jiage, "¥" + item);

        SnapUpCountDownTimerView timerView = helper.getView(R.id.item_timer);
        timerView.setTime(0, 2, 12, 30);
        timerView.start();
//        Glide.with(App.content)
//                .load(item.getProduct_pic())
//                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(imageView);

    }


    //当前时间转换成时间戳
    public long dateToStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String s = simpleDateFormat.format(date);
        try {
            date = simpleDateFormat.parse(s);
            long ts = date.getTime();
            return ts;
        } catch (Exception e) {
            return 0;
        }

    }


}
