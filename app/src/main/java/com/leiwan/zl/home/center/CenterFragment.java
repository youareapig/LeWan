package com.leiwan.zl.home.center;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.data.YuYueData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/14.
 */

public class CenterFragment extends BaseFragment {


    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.myyuyue)
    LinearLayout myyuyue;
    @BindView(R.id.mydingdan)
    LinearLayout mydingdan;
    @BindView(R.id.mywenti)
    LinearLayout mywenti;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private Adapter adapter;
    private List<YuYueData.DataBean> list;

    @Override
    protected int setLayout() {
        return R.layout.center_fragment;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String content=search.getText().toString().trim();
                    if (TextUtils.isEmpty(content)){
                        ToastUtil.showShortToast("请输入关键字");
                    }else {
                        getData(content);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void setData() {
        getData(null);
    }

    private void getData(String content) {
        Connector.YuYueList(getActivity(), token, content, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "预约--" + result);
                YuYueData data = JSON.parseObject(result, YuYueData.class);
                if (data.getCode() == 200) {
                    list=data.getData();
                    adapter = new Adapter(R.layout.center_item, list);
                    recycler.setAdapter(adapter);
                    adapter.openLoadAnimation();
                }
            }
        });
    }

    @OnClick({R.id.myyuyue, R.id.mydingdan, R.id.mywenti})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myyuyue:
                break;
            case R.id.mydingdan:
                break;
            case R.id.mywenti:
                break;
        }
    }
}
