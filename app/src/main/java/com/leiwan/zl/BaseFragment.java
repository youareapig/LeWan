package com.leiwan.zl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.leiwan.zl.utils.SharedPreferencesUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/14.
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    public String token, lat, lng, access_token, openid, refresh_token, unionid;
    public int isLogin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), null);
        unbinder = ButterKnife.bind(this, view);

        access_token = SharedPreferencesUtil.getInstance(getActivity()).getSP("access_token");
        openid = SharedPreferencesUtil.getInstance(getActivity()).getSP("openid");
        refresh_token = SharedPreferencesUtil.getInstance(getActivity()).getSP("refresh_token");
        unionid = SharedPreferencesUtil.getInstance(getActivity()).getSP("unionid");
        isLogin = SharedPreferencesUtil.getInstance(getActivity()).getSP("loginTag", 0);

        token = SharedPreferencesUtil.getInstance(getActivity()).getSP("token");
        lat = SharedPreferencesUtil.getInstance(getActivity()).getSP("lat");
        lng = SharedPreferencesUtil.getInstance(getActivity()).getSP("lng");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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


    protected <T extends View> T fvbi(int resId) {
        return (T) getView().findViewById(resId);
    }

    /**
     * intent跳转
     *
     * @param context
     * @param clazz
     */
    protected void toClass(Context context, Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    /**
     * intent带值跳转
     *
     * @param context
     * @param clazz
     * @param bundle
     */
    protected void toClass(Context context, Class<? extends BaseActivity> clazz, Bundle bundle) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 带返回值的跳转
     *
     * @param context
     * @param clazz
     * @param bundle
     * @param requestCode
     */
    protected void toClass(Context context, Class<? extends BaseActivity> clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        getActivity().startActivityForResult(intent, requestCode);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
