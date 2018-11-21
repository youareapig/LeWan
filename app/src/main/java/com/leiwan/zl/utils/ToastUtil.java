package com.leiwan.zl.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.Toast;

import com.leiwan.zl.App;

public class ToastUtil {
    private Context mContext;
    private Resources mResources;

    private ToastUtil() {
        super();
    }
    
    private ToastUtil(Context context){
        this.mContext = context;
        this.mResources = context.getResources();
    }
    
    public static void showShortToast(String msg) {
        showToast(App.content, msg, Toast.LENGTH_SHORT);
    }  
  
    public void showShortToast(int strRes) {
        showShortToast(mResources.getString(strRes));
    }  
  
    public void showLongToast(String msg) {
        showToast(mContext, msg, Toast.LENGTH_LONG);  
    } 
    
    public void showLongToast(int strRes) {  
        showLongToast(mResources.getString(strRes));
    }  
  
    public static void showToast(Context context, String msg, int duration){
        showToast(msg, duration,Gravity.CENTER);
    }
    public static void showToast( String msg, int duration,int gravity){
        Toast toast = Toast.makeText(App.content, msg, duration);
//        toast.setGravity(gravity, 0, 0);
        toast.show();
    }
}