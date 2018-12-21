package com.leiwan.zl.utils.pop;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;

import com.leiwan.zl.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * Created by Administrator on 2018/12/21.
 */

public class MyPop extends BasePopupWindow {
    public MyPop(Context context) {
        super(context);
    }

    public MyPop(Context context, int width, int height) {
        super(context, width, height);
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop);
    }
    @Override
    protected Animation onCreateShowAnimation() {
        TranslateAnimation translateAnimation=new TranslateAnimation(0,0,412,0);
        translateAnimation.setDuration(200);
        return translateAnimation;
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        TranslateAnimation translateAnimation=new TranslateAnimation(0,0,0,412);
        translateAnimation.setDuration(200);
        return translateAnimation;
    }
}
