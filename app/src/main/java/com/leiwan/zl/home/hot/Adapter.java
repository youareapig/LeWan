package com.leiwan.zl.home.hot;

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
import com.leiwan.zl.utils.SnapUpCountDownTimerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends RecyclerView.Adapter {


    private List<Map<String,String>> list;
    private Activity activity;

    public Adapter(List<Map<String,String>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.share_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        Map<String,String> map=list.get(position);


        Glide.with(activity)
                .load(map.get("first"))
                .bitmapTransform(new CenterCrop(activity), new RoundedCornersTransformation(activity, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imageLift);
        Glide.with(activity)
                .load(map.get("second"))
                .bitmapTransform(new CenterCrop(activity), new RoundedCornersTransformation(activity, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imageRight);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageLift,imageRight;

        public ViewHolder(View itemView) {
            super(itemView);
            imageLift = (ImageView) itemView.findViewById(R.id.item_image_left);
            imageRight = (ImageView) itemView.findViewById(R.id.item_image_right);
        }
    }




}
