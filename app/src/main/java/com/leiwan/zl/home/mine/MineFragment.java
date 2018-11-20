package com.leiwan.zl.home.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.address.AddressIndexActivity;
import com.leiwan.zl.bank.IDBankActivity;
import com.leiwan.zl.lianxi.LianXiActivity;
import com.leiwan.zl.yaoqing.YaoqingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2018/11/14.
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.viphead)
    ImageView viphead;
    @BindView(R.id.view_yaoqing)
    RelativeLayout viewYaoqing;
    @BindView(R.id.view_jiaocheng)
    RelativeLayout viewJiaocheng;
    @BindView(R.id.view_yinhangka)
    RelativeLayout viewYinhangka;
    @BindView(R.id.view_youhui)
    RelativeLayout viewYouhui;
    @BindView(R.id.view_dingdan)
    RelativeLayout viewDingdan;
    @BindView(R.id.view_dizhi)
    RelativeLayout viewDizhi;
    @BindView(R.id.view_shiming)
    RelativeLayout viewShiming;
    @BindView(R.id.view_lianxi)
    RelativeLayout viewLianxi;
    private static String testImageUrl = "http://img2.imgtn.bdimg.com/it/u=3097866831,856626641&fm=26&gp=0.jpg";
    @BindView(R.id.userhead)
    ImageView userhead;

    @Override
    protected int setLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        Glide.with(getActivity())
                .load(testImageUrl)
                .placeholder(R.mipmap.yuan)
                .error(R.mipmap.yuan)
                .bitmapTransform(new CenterCrop(getActivity()), new CropCircleTransformation(getActivity()))
                .into(viphead);

        Glide.with(getActivity())
                .load(testImageUrl)
                .placeholder(R.mipmap.yuan)
                .error(R.mipmap.yuan)
                .bitmapTransform(new CenterCrop(getActivity()), new CropCircleTransformation(getActivity()))
                .into(userhead);
    }


    @OnClick({R.id.view_yaoqing, R.id.view_jiaocheng, R.id.view_yinhangka, R.id.view_youhui, R.id.view_dingdan, R.id.view_dizhi, R.id.view_shiming, R.id.view_lianxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_yaoqing:
                toClass(getActivity(), YaoqingActivity.class);
                break;
            case R.id.view_jiaocheng:
                break;
            case R.id.view_yinhangka:
                toClass(getActivity(), IDBankActivity.class);
                break;
            case R.id.view_youhui:
                break;
            case R.id.view_dingdan:
                break;
            case R.id.view_dizhi:
                toClass(getActivity(), AddressIndexActivity.class);
                break;
            case R.id.view_shiming:
                break;
            case R.id.view_lianxi:
                toClass(getActivity(), LianXiActivity.class);
                break;
        }
    }


}
