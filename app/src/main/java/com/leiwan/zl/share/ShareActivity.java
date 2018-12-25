package com.leiwan.zl.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.QRCodeUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;
import com.leiwan.zl.utils.WXSharedUtils;
import com.leiwan.zl.utils.pop.SharePop;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
    @BindView(R.id.copeshow)
    TextView copeshow;
    @BindView(R.id.haibao_img)
    ImageView haibaoImg;
    @BindView(R.id.haibao_check)
    CheckBox haibaoCheck;
    private String goodscontent;
    private List<String> imgList;
    private Adapter adapter;
    private String BaseUrl = "http://weixin.lewan6.ren/wechat_html/page/homePage/productDetails.html?";
    private String recode, id, bg;
    private Bitmap recodeBitmap, bgBitmap, endBitmap;
    private Handler handler = new Handler();

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
        recode = SharedPreferencesUtil.getInstance(this).getSP("recode");
        Bundle bundle = getIntent().getExtras();
        imgList = bundle.getStringArrayList("arr");
        goodscontent = bundle.getString("content");
        bg = bundle.getString("bg");
        id = bundle.getString("id");


        LogUtil.d("tag", "bg" + bg);
        content.setText(goodscontent);
        adapter = new Adapter(R.layout.shareimage_item, imgList);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();

        recodeBitmap = QRCodeUtil.createQRCodeBitmap(BaseUrl + "productId=" + id + "&recode=" + recode, 150, 150);
        new Thread(new Runnable() {
            @Override
            public void run() {
                bgBitmap = getBitmap(bg);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        endBitmap = mergeBitmap(bgBitmap, recodeBitmap);
                        LogUtil.d("tag", bgBitmap + "   " + recodeBitmap + "  " + endBitmap);

                        DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);
                        int screenWidth = dm.widthPixels;
                        if (endBitmap.getWidth() <= screenWidth) {
                            haibaoImg.setImageBitmap(endBitmap);
                        } else {
                            Bitmap bmp = Bitmap.createScaledBitmap(endBitmap, screenWidth, endBitmap.getHeight() * screenWidth / endBitmap.getWidth(), true);
                            haibaoImg.setImageBitmap(bmp);
                        }
                    }
                });


            }
        }).start();

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
                MyToast();
                SharePop m = new SharePop(this);
                m.showPopupWindow();
                m.findViewById(R.id.share_haoyou).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO 分享链接
                        WXSharedUtils.getImage(imgList.get(0), new WXSharedUtils.HttpCallBackListener() {
                            @Override
                            public void onFinish(final Bitmap bitmap) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        WXSharedUtils.Shared_Web(BaseUrl + "productId=" + id + "&recode=" + recode, "乐玩联盟", goodscontent, 2, bitmap);
                                    }
                                });
                            }
                        });
                    }
                });
                m.findViewById(R.id.share_pengyouquan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WXSharedUtils.getImage(imgList.get(0), new WXSharedUtils.HttpCallBackListener() {
                            @Override
                            public void onFinish(final Bitmap bitmap) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        WXSharedUtils.Shared_Web(BaseUrl + "productId=" + id + "&recode=" + recode, "乐玩联盟", goodscontent, 1, bitmap);
                                    }
                                });
                            }
                        });
                    }
                });


                break;
            case R.id.share_img:
                //TODO 分享图片
                WXSharedUtils.getImage(bg, new WXSharedUtils.HttpCallBackListener() {
                    @Override
                    public void onFinish(final Bitmap bitmap) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                WXSharedUtils.Shared_Image(2, bitmap);
                            }
                        });
                    }
                });
                break;
        }
    }


    private void MyToast() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, -150, 350);
        translateAnimation.setDuration(1000);
        copeshow.startAnimation(translateAnimation);
    }

    //图片地址转换成bitmap
    public Bitmap getBitmap(String imgUrl) {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        URL url = null;
        try {
            url = new URL(imgUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(2000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                //网络连接成功
                inputStream = httpURLConnection.getInputStream();
                outputStream = new ByteArrayOutputStream();
                byte buffer[] = new byte[1024 * 8];
                int len = -1;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                byte[] bu = outputStream.toByteArray();
                Bitmap bitmap = BitmapFactory.decodeByteArray(bu, 0, bu.length);


                return bitmap;
            } else {
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //合成图片,生成新的bitmap
    private Bitmap mergeBitmap(Bitmap firstBitmap, Bitmap secondBitmap) {
        Bitmap bitmap = Bitmap.createBitmap(firstBitmap.getWidth(), firstBitmap.getHeight(), firstBitmap.getConfig());
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(firstBitmap, new Matrix(), null);
        canvas.drawBitmap(secondBitmap, 0, 1180, null);
        return bitmap;
    }


}
