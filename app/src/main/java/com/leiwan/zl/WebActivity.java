package com.leiwan.zl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {
    @BindView(R.id.weblayout)
    LinearLayout weblayout;
    private AgentWeb agentWeb;

    @Override
    protected int setLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        Intent intent=getIntent();
        String url=intent.getStringExtra("weburl");
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent(weblayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(url);
    }


}
