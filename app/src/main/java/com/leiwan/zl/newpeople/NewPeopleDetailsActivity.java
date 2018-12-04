package com.leiwan.zl.newpeople;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.SharedPreferencesUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPeopleDetailsActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.titlename)
    TextView titlename;
    @BindView(R.id.webview)
    WebView webview;
    private WebSettings webSettings;
    private String id;
    private String lat, lng;
    @Override
    protected int setLayout() {
        return R.layout.activity_new_people_details;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        lat = SharedPreferencesUtil.getInstance(this).getSP("lat");
        lng = SharedPreferencesUtil.getInstance(this).getSP("lng");
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        getData();
        webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setTextZoom(250);
        webview.loadDataWithBaseURL(null, getNewContent("<p>\\r\\n\\t的司法地方\\r\\n</p>\\r\\n<p>\\r\\n\\t<strong>1</strong> \\r\\n</p>\\r\\n<p>\\r\\n\\t<br />\\r\\n</p>\\r\\n<p>\\r\\n\\t<strong>3dddddddddd</strong> \\r\\n</p>\\r\\n<p>\\r\\n\\t<br />\\r\\n</p>\\r\\n<p>\\r\\n\\t4\\r\\n</p>\\r\\n<p>\\r\\n\\t3\\r\\n</p>\\r\\n<p>\\r\\n\\t43434\\r\\n</p>"), "text/html", "utf-8", null);
        webview.setWebViewClient(new WebViewClient());
    }

    private String getNewContent(String htmltext) {
        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }
        return doc.toString();
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
    private void getData(){
        Connector.TeachDetails(this, lat, lng, id, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag","新手详情"+result);
            }
        });
    }
}
