package com.leiwan.zl.dingdan.fragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.OrderListData;
import com.leiwan.zl.utils.DateUtils;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends BaseQuickAdapter<OrderListData.DataBean, BaseViewHolder> {


    public Adapter(@LayoutRes int layoutResId, @Nullable List<OrderListData.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, OrderListData.DataBean item) {
        String tag = "";
        switch (item.getOrder_status()) {
            case 0:
                tag = "订单过期";
                break;
            case 1:
                tag = "待付款";
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                tag = "已付款";
                break;
            case 6:
                break;
            case 7:
                tag = "已完成";
                break;
            case 8:
                break;
            case 9:
                tag = "退款";
                break;

        }
        helper.setText(R.id.dingdan_item_id, item.getOrder_no())
                .setText(R.id.dingdan_item_tag, tag)
                .setText(R.id.dingdan_item_num, "X" + item.getNum())
                .setText(R.id.dingdan_item_name, item.getProduct_name())
                .setText(R.id.dingdan_item_address, item.getRegion().trim())
                .setText(R.id.dingdan_item_price, "¥" + item.getOrder_totalfee())
                .setText(R.id.dingdan_item_time, "商品有效期:" + DateUtils.timeslashData(item.getStartusetime() + "") + "至" + DateUtils.timeslashData(item.getEndusetime() + ""));

    }


}
