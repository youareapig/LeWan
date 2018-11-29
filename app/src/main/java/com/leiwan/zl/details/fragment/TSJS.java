package com.leiwan.zl.details.fragment;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/27.
 */

public class TSJS extends BaseFragment {
    @BindView(R.id.webview)
    WebView webview;
    private WebSettings webSettings;

    @Override
    protected int setLayout() {
        return R.layout.details_rich;
    }

    @Override
    protected void setView() {
        webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setTextZoom(250);
        webview.loadDataWithBaseURL(null, getNewContent("<p>等级分类数据的分类及时登录福建省砥砺奋进上了飞机上的垃圾分类时代峻峰</p>"), "text/html", "utf-8", null);
        webview.setWebViewClient(new WebViewClient());
    }

    @Override
    protected void setData() {

    }

    private String getNewContent(String htmltext) {
        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }
        return doc.toString();
    }
}
