package com.leiwan.zl;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.leiwan.zl.utils.SharedPreferencesUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    public String token, lat, lng, access_token, openid, refresh_token, unionid;
    public int isLogin;
    public Bundle savedInstanceState;
    public Typeface typeface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        this.savedInstanceState = savedInstanceState;
        unbinder = ButterKnife.bind(this);
        AssetManager assetManager = getAssets();
        typeface = Typeface.createFromAsset(assetManager, "fonts/dina.ttf");

        token = SharedPreferencesUtil.getInstance(this).getSP("token");
        lat = SharedPreferencesUtil.getInstance(this).getSP("lat");
        lng = SharedPreferencesUtil.getInstance(this).getSP("lng");
        //1表示登录，0表示未登录
        isLogin = SharedPreferencesUtil.getInstance(this).getSP("loginTag", 0);

        access_token = SharedPreferencesUtil.getInstance(this).getSP("access_token");
        openid = SharedPreferencesUtil.getInstance(this).getSP("openid");
        refresh_token = SharedPreferencesUtil.getInstance(this).getSP("refresh_token");
        unionid = SharedPreferencesUtil.getInstance(this).getSP("unionid");

        ImmersionBar.with(this).statusBarColor(R.color.bar).fitsSystemWindows(true).statusBarDarkFont(true).init();
        setView();
        setData();
    }

    /**
     * 绑定布局
     *
     * @return
     */
    protected abstract int setLayout();

    /**
     * 初始化组件
     */
    protected abstract void setView();

    /**
     * 设置数据等逻辑代码
     */
    protected abstract void setData();

    /**
     * 简化findViewById()
     *
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T fvbi(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * Intent跳转
     *
     * @param context
     * @param clazz
     */
    protected void toClass(Context context, Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    protected void toClassApp(Context context, Class<? extends AppCompatActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    /**
     * Intent带值跳转
     *
     * @param context
     * @param clazz
     * @param bundle
     */
    protected void toClass(Context context, Class<? extends BaseActivity> clazz, Bundle bundle) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 带返回值的跳转
     *
     * @param context
     * @param clazz
     * @param bundle
     * @param reuqestCode
     */
    protected void toClass(Context context, Class<? extends BaseActivity> clazz, Bundle bundle, int reuqestCode) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, reuqestCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
