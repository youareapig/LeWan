package com.leiwan.zl.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.leiwan.zl.App;
import com.leiwan.zl.R;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2018/12/11.
 */

public class WXSharedUtils {

    //文本分享
    public static void Shared_Text(String content, int type) {
        String text = content;
        WXTextObject textObject = new WXTextObject();
        textObject.text = text;
        WXMediaMessage mediaMessage = new WXMediaMessage();
        mediaMessage.mediaObject = textObject;
        mediaMessage.description = text;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = mediaMessage;
        if (type == 1) {
            req.scene = SendMessageToWX.Req.WXSceneTimeline;//分享到朋友圈
        }
        if (type == 2) {
            req.scene = SendMessageToWX.Req.WXSceneSession;//分享给微信好友
        }

        App.mWxApi.sendReq(req);

    }

    //网页分享网络缩略图
    public static void Shared_Web(String weburl, String title, String content, int type, Bitmap bitmap) {

        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = weburl;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = content;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        //不加这行分享的图片为logo图
        msg.setThumbImage(bitmap);
        req.message = msg;
        if (type == 1) {
            req.scene = SendMessageToWX.Req.WXSceneTimeline;//分享到朋友圈
        }
        if (type == 2) {
            req.scene = SendMessageToWX.Req.WXSceneSession;//分享给微信好友
        }
        App.mWxApi.sendReq(req);
    }

    //网页分享本地缩略图
    public static void Shared_Web_locatin(Context context, String weburl, String title, String content, int type) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = weburl;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = content;
        Bitmap thumb = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        msg.thumbData = Util.bmpToByteArray(thumb, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = msg;
        if (type == 1) {
            req.scene = SendMessageToWX.Req.WXSceneTimeline;//分享到朋友圈
        }
        if (type == 2) {
            req.scene = SendMessageToWX.Req.WXSceneSession;//分享给微信好友
        }
        App.mWxApi.sendReq(req);
    }

    //分享网络图片
    public static void Shared_Image(int type, Bitmap bitmap) {

        WXImageObject imgObj = new WXImageObject(bitmap);
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        msg.setThumbImage(bitmap);
        req.message = msg;
        if (type == 1) {
            req.scene = SendMessageToWX.Req.WXSceneTimeline;//分享到朋友圈
        }
        if (type == 2) {
            req.scene = SendMessageToWX.Req.WXSceneSession;//分享给微信好友
        }
        App.mWxApi.sendReq(req);

    }


    public interface HttpCallBackListener {
        void onFinish(Bitmap bitmap);

    }

    /**
     * bitmap转换
     *
     * @param
     * @return 参数：1，缩略图网络地址
     */
    public static void getImage(final String path, final HttpCallBackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL imageUrl = null;
                try {
                    imageUrl = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    Bitmap bitmap1 = createBitmapThumbnail(bitmap, false);
                    if (listener != null) {
                        listener.onFinish(bitmap1);
                    }
                    is.close();

                } catch (Exception e) {

                }
            }
        }).start();
    }

    private static Bitmap createBitmapThumbnail(Bitmap bitmap, boolean needRecycler) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int newWidth = 80;
        int newHeight = 80;
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newBitMap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (needRecycler) bitmap.recycle();
        return newBitMap;
    }

}
