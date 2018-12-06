package com.leiwan.zl.utils.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
    @Override
    public void onPageFinished(WebView view, String url) {
        view.getSettings().setJavaScriptEnabled(true);
        super.onPageFinished(view, url);
        //待网页加载完全后设置图片点击的监听方法
        addImageClickListener(view);
        Log.e("huangxiaoguo","url=====》"+url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // 调用系统默认浏览器处理url
        view.stopLoading();
        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        view.getSettings().setJavaScriptEnabled(true);
        super.onPageStarted(view, url, favicon);
    }

    private void addImageClickListener(WebView webView) {
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName(\"img\"); " +
                "for(var i=0;i<objs.length;i++) " +
                "{"
                + " objs[i].onclick=function() " +
                " { "
                //通过js代码找到标签为img的代码块，设置点击的监听方法与本地的openImage方法进行连接
                + "  window.imagelistener.openImage(this.src); " +
                " } " +
                "}" +
                "})()");
    }
}