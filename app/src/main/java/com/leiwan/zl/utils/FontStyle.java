package com.leiwan.zl.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by Administrator on 2018/12/14.
 */

public class FontStyle {
    public static Typeface getFont(Context context) {
        AssetManager assetManager = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/dina.ttf");
        return typeface;
    }
}
