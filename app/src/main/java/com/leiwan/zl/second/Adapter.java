package com.leiwan.zl.second;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.HomeData;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.FontStyle;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.SnapUpCountDownTimerView;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


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
        long endtime = item.getProduct_endtime();
        long[] timetype = DateUtils.timeOver(endtime);
        long day = timetype[0];
        long hour = timetype[1];
        long min = timetype[2];
        long second = timetype[3];
        String zigou = item.getTemp_commission().getZigou();
        String fenxiang = item.getTemp_commission().getFenxiang();
        if (level == 1) {
            //普通会员，不显示佣金
            helper.setText(R.id.index_list_item_youhui, "");
        } else if (level == 2) {
            //超级会员显示自购和分享佣金
            helper.setText(R.id.index_list_item_youhui, "¥" + zigou + "～" + fenxiang);
        } else {
            //超过2的只显示购买佣金
            helper.setText(R.id.index_list_item_youhui, "¥" + zigou);
        }
        RelativeLayout relativeLayout = helper.getView(R.id.topview);
        RelativeLayout saleout=helper.getView(R.id.saleout_view);
        helper.setText(R.id.index_list_item_title, item.getProduct_name())
                .setText(R.id.index_list_item_jiage, "¥" + item.getTemp_price())
                .setTypeface(R.id.index_list_item_jiage, FontStyle.getFont(App.content))
                .setText(R.id.index_list_item_xiaoliang, "已售" + item.getProduct_sold())
                .setTypeface(R.id.index_list_item_xiaoliang, FontStyle.getFont(App.content))
                .setText(R.id.index_list_item_location, item.getRegion())
                .setText(R.id.index_list_item_juli, item.getDistance() + "KM")
                .setTypeface(R.id.index_list_item_youhui, FontStyle.getFont(App.content));
        relativeLayout.setVisibility(View.GONE);
        if (item.getSold_out()==1){
            //售罄，显示售罄图标
            saleout.setVisibility(View.VISIBLE);
        }else {
            saleout.setVisibility(View.GONE);
        }

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
