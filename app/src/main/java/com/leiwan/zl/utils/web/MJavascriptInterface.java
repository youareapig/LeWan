package com.leiwan.zl.utils.web;

import android.content.Context;
import android.content.Intent;


/**
 * Created by Administrator on 2017/2/10.
 */

public class MJavascriptInterface {
    private Context context;
    private String[] imageUrls;

    public MJavascriptInterface(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

//    @android.webkit.JavascriptInterface
//    public void openImage(String img) {
//        Intent intent = new Intent();
//        intent.putExtra("imageUrls", imageUrls);
//        for (int i = 0; i < imageUrls.length; i++) {
//            if (imageUrls[i].equals(img))
//                intent.putExtra("position", i);
//        }
//        intent.setClass(context, LookBigPhotoActivity.class);
//        context.startActivity(intent);
//
//    }
}
