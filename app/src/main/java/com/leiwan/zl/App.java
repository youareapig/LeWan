package com.leiwan.zl;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/11/14.
 */

public class App extends Application{
    public static Context content;
    @Override
    public void onCreate() {
        super.onCreate();
        content=this.getApplicationContext();
    }
}
