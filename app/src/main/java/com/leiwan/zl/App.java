package com.leiwan.zl;

import android.app.Application;
import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.xutils.x;

/**
 * Created by Administrator on 2018/11/14.
 */

public class App extends Application{
    public static Context content;
    public static IWXAPI mWxApi;
    public static final String APP_ID = "wxfca63c8cf5fd3162";
    public static final String APP_SECRET = "a54910f2f26e157bb373b5ebc58322d8";
    @Override
    public void onCreate() {
        super.onCreate();
        content=this.getApplicationContext();
        x.Ext.init(this);
        registerToWX();

    }
    private void registerToWX() {
        //第二个参数是指你应用在微信开放平台上的AppID
        mWxApi = WXAPIFactory.createWXAPI(content,APP_ID, true);
        // 将该app注册到微信
        mWxApi.registerApp(APP_ID);
    }

}
