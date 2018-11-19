package com.leiwan.zl.home.index;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.testdata.TestData;
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


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends RecyclerView.Adapter {


    private List<HomeData.DataBean> list;
    private Activity activity;

    public Adapter(List<HomeData.DataBean> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.index_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        HomeData.DataBean data = list.get(position);
        long endtime = data.getProduct_endtime();
        long nowtime = dateToStamp();
        long time = endtime - nowtime;

        Long day = time / (1000 * 60 * 60 * 24);   //以天数为单位取整
        Long hour = (time / (60 * 60 * 1000) - day * 24);    //以小时为单位取整
        Long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60); //以分钟为单位取整
        Long second = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);//秒
        Log.d("tag", "当前时间戳" + dateToStamp());


        Glide.with(activity)
                .load(data.getProduct_pic())
                .bitmapTransform(new CenterCrop(activity), new RoundedCornersTransformation(activity, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imageView);
        viewHolder.title.setText(data.getProduct_name());
        viewHolder.price.setText("¥" + data.getTemp_price());
        viewHolder.num.setText("已售" + data.getProduct_sold());
        viewHolder.youhui.setText("赚" + data.getTemp_commission());
        viewHolder.timerView.setTime(1, 2, 55, 3);
        viewHolder.timerView.start();

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, price, num, youhui;
        private SnapUpCountDownTimerView timerView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.index_list_item_image);
            title = (TextView) itemView.findViewById(R.id.index_list_item_title);
            price = (TextView) itemView.findViewById(R.id.index_list_item_jiage);
            num = (TextView) itemView.findViewById(R.id.index_list_item_xiaoliang);
            timerView = (SnapUpCountDownTimerView) itemView.findViewById(R.id.item_timer);
            youhui = (TextView) itemView.findViewById(R.id.index_list_item_youhui);
        }
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
