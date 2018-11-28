package com.leiwan.zl.utils;

import android.content.Context;

import com.leiwan.zl.App;

/**
 * Created by Administrator on 2018/11/28.
 */

public class DialogUtils {
    private static CustomDialog customDialog;
    private static DialogUtils dialogUtils;

    public DialogUtils(Context context) {
        customDialog = new CustomDialog(context, "正在加载...");
    }

    public static DialogUtils getInstance(Context context) {
        if (dialogUtils == null) {
            dialogUtils = new DialogUtils(context);
        }

        return dialogUtils;
    }

    public void showDialog() {
        customDialog.show();
    }

    public void dissmissDialog() {
        customDialog.dismiss();
    }
}
