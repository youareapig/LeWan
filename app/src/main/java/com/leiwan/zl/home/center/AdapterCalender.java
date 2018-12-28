package com.leiwan.zl.home.center;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.AppointmentDetailsData;
import com.leiwan.zl.data.CalenderData;
import com.leiwan.zl.utils.LogUtil;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class AdapterCalender extends BaseQuickAdapter<CalenderData.DataBean, BaseViewHolder> {
    private int selectItem = -1;

    public AdapterCalender(@LayoutRes int layoutResId, @Nullable List<CalenderData.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, CalenderData.DataBean item) {
        TextView day = helper.getView(R.id.item_day);
        TextView week = helper.getView(R.id.item_week);
        TextView num = helper.getView(R.id.item_num);
        LinearLayout view = helper.getView(R.id.item_view);
        day.setText(item.getDay());
        week.setText(item.getWeek());
        LogUtil.d("tag", "position" + helper.getAdapterPosition());
        if (helper.getAdapterPosition() == selectItem) {
            //选中
            view.setBackgroundColor(Color.parseColor("#FC9929"));
            day.setTextColor(Color.parseColor("#ffffff"));
            week.setTextColor(Color.parseColor("#ffffff"));
            num.setTextColor(Color.parseColor("#ffffff"));
        } else {
            //未选中
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            day.setTextColor(Color.parseColor("#333333"));
            week.setTextColor(Color.parseColor("#333333"));
            num.setTextColor(Color.parseColor("#FC9929"));
        }

    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

}
