package com.leiwan.zl.details;

import java.util.List;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.leiwan.zl.data.GoodsDetailsData;
import com.leiwan.zl.utils.FontStyle;
import com.leiwan.zl.utils.SharedPreferencesUtil;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * GridView加载数据的适配器
 *
 * @author Administrator
 */
public class MyGridViewAdpter extends BaseAdapter {

    private Context context;
    private List<GoodsDetailsData.DataBean.HotpushBean> lists;//数据源
    private int mIndex; // 页数下标，标示第几页，从0开始
    private int mPargerSize;// 每页显示的最大的数量
    private int level;

    public MyGridViewAdpter(Context context, List<GoodsDetailsData.DataBean.HotpushBean> lists,
                            int mIndex, int mPargerSize) {
        this.context = context;
        this.lists = lists;
        this.mIndex = mIndex;
        this.mPargerSize = mPargerSize;
        level = SharedPreferencesUtil.getInstance(context).getSP("level", 0);
    }

    /**
     * 先判断数据及的大小是否显示满本页lists.size() > (mIndex + 1)*mPagerSize
     * 如果满足，则此页就显示最大数量lists的个数
     * 如果不够显示每页的最大数量，那么剩下几个就显示几个
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lists.size() > (mIndex + 1) * mPargerSize ?
                mPargerSize : (lists.size() - mIndex * mPargerSize);
    }

    @Override
    public String getItem(int arg0) {
        // TODO Auto-generated method stub
        return lists.get(arg0 + mIndex * mPargerSize).getProduct_name();
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0 + mIndex * mPargerSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        GoodsDetailsData.DataBean.HotpushBean bean = lists.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.tuijian_item, null);
            holder.tv_name = (TextView) convertView.findViewById(R.id.item_name);
            holder.iv_img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.tv_content = (TextView) convertView.findViewById(R.id.item_content);
            holder.tv_price = (TextView) convertView.findViewById(R.id.item_price);
            holder.tv_yongjin = (TextView) convertView.findViewById(R.id.item_yongjin);
            holder.tv_address = (TextView) convertView.findViewById(R.id.item_address);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //重新确定position因为拿到的总是数据源，数据源是分页加载到每页的GridView上的
        final int pos = position + mIndex * mPargerSize;//假设mPageSiez
        //假设mPagerSize=8，假如点击的是第二页（即mIndex=1）上的第二个位置item(position=1),那么这个item的实际位置就是pos=9
        String zigou = bean.getTemp_commission().getZigou();
        String fenxiang = bean.getTemp_commission().getFenxiang();
        if (level == 1) {
            //普通会员，不显示佣金
            holder.tv_yongjin.setText("");
        } else if (level == 2) {
            //超级会员显示自购和分享佣金
            holder.tv_yongjin.setText("¥" + zigou + "～" + fenxiang);
        } else {
            //超过2的只显示购买佣金
            holder.tv_yongjin.setText("¥" + zigou);
        }
        holder.tv_name.setText(bean.getMerchant_name());
        holder.tv_content.setText(bean.getProduct_name());
        holder.tv_price.setText("¥ " + bean.getTemp_price());
        holder.tv_address.setText(bean.getRegion());
        Glide.with(App.content)
                .load(bean.getProduct_pic())
                .bitmapTransform(new CenterCrop(App.content), new RoundedCornersTransformation(App.content, 10, 0))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.iv_img);
        holder.tv_price.setTypeface(FontStyle.getFont(App.content));
        holder.tv_yongjin.setTypeface(FontStyle.getFont(App.content));
        return convertView;
    }

    static class ViewHolder {
        private TextView tv_name, tv_content, tv_price, tv_yongjin, tv_address;
        private ImageView iv_img;
    }
}