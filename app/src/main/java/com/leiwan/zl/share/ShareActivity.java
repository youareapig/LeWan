package com.leiwan.zl.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.WXSharedUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ShareActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.quanxuan)
    TextView quanxuan;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.share_link)
    RelativeLayout shareLink;
    @BindView(R.id.share_img)
    RelativeLayout shareImg;
    @BindView(R.id.save_img)
    RelativeLayout saveImg;
    private String goodscontent;
    private List<String> imgList;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_share;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
    }

    @Override
    protected void setData() {

        Bundle bundle = getIntent().getExtras();
        imgList = bundle.getStringArrayList("arr");
        goodscontent = bundle.getString("content");
        content.setText(goodscontent);
        adapter = new Adapter(R.layout.shareimage_item, imgList);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
    }


    @OnClick({R.id.back, R.id.quanxuan, R.id.share_link, R.id.share_img, R.id.save_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.quanxuan:
                for (int i = 0; i < imgList.size(); i++) {
                    adapter.map.put(i, true);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.share_link:

                //TODO 分享链接
//                WXSharedUtils.getImage("http://file2.zhituad.com/thumb/201102/15/201102150839088669kNhyE.jpg", new WXSharedUtils.HttpCallBackListener() {
//                    @Override
//                    public void onFinish(final Bitmap bitmap) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                WXSharedUtils.Shared_Web("https://blog.csdn.net/qq_42618969/article/details/81030941", "csdn", "微信分享", 2, bitmap);
//                            }
//                        });
//                    }
//                });
                //TODO 分享图片
//                WXSharedUtils.getImage("http://file2.zhituad.com/thumb/201102/15/201102150839088669kNhyE.jpg", new WXSharedUtils.HttpCallBackListener() {
//                    @Override
//                    public void onFinish(final Bitmap bitmap) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                WXSharedUtils.Shared_Image(2, bitmap);
//                            }
//                        });
//                    }
//                });
                break;
            case R.id.share_img:
                break;
            case R.id.save_img:
                break;
        }
    }
}
