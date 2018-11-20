package com.leiwan.zl.yaoqing;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class YaoqingActivity extends BaseActivity {
    private static String testImageUrl = "http://img2.imgtn.bdimg.com/it/u=3097866831,856626641&fm=26&gp=0.jpg";
    private static String testImageUrl1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542696295977&di=b148b3a8dcccabc9389dd541fac0f951&imgtype=0&src=http%3A%2F%2Fy3.ifengimg.com%2Fnews_spider%2Fdci_2013%2F09%2Fb85234c4801f8b2d7771353867a7a0f8.jpg";
    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.erweima)
    ImageView erweima;
    @BindView(R.id.back)
    ImageView back;

    @Override
    protected int setLayout() {
        return R.layout.activity_yaoqing;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        Glide.with(this)
                .load(testImageUrl)
                .placeholder(R.mipmap.yuan)
                .error(R.mipmap.yuan)
                .bitmapTransform(new CenterCrop(this), new CropCircleTransformation(this))
                .into(head);

        Glide.with(this)
                .load(testImageUrl1)
                .placeholder(R.mipmap.yuan)
                .error(R.mipmap.yuan)
                .into(erweima);
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
