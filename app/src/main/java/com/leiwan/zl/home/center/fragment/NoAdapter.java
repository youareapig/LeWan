package com.leiwan.zl.home.center.fragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.R;
import com.leiwan.zl.data.NoAppointmentData;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class NoAdapter extends BaseQuickAdapter<NoAppointmentData.DataBean, BaseViewHolder> {


    public NoAdapter(@LayoutRes int layoutResId, @Nullable List<NoAppointmentData.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoAppointmentData.DataBean item) {
        TextView goodsName = helper.getView(R.id.goodsname);
        TextView orderCode = helper.getView(R.id.ordercode);
        TextView expendCode = helper.getView(R.id.expendcode);
        TextView validDate = helper.getView(R.id.validdate);
        TextView orderTag = helper.getView(R.id.ordertag);
        LinearLayout expendView = helper.getView(R.id.expendview);

        goodsName.setText(item.getProduct_name());
        orderCode.setText(item.getOrdernumber());
        if (item.getExpress() == 1) {
            //到店
            expendView.setVisibility(View.VISIBLE);
            validDate.setVisibility(View.VISIBLE);
            expendCode.setText(item.getCode().get(0).getConsume_code());
            if (item.getCode_count() > 1) {
                //多个电子码
                orderTag.setText("去查看");
            } else {
                switch (item.getCode().get(0).getStatus()) {
                    case 1:
                        orderTag.setText("去预约");
                        break;
                    case 2:
                        orderTag.setText("已使用");
                        break;
                    case 3:
                        orderTag.setText("已过期");
                        break;
                    case 4:
                        orderTag.setText("冻结");
                        break;
                }
            }


        }
        if (item.getExpress() == 2) {
            //快递
            expendView.setVisibility(View.GONE);
            validDate.setVisibility(View.GONE);
        }
        helper.setText(R.id.goodsname, item.getProduct_name())
                .setText(R.id.ordercode, item.getOrdernumber());

    }
}
