package com.leiwan.zl.newpeople.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/22.
 */

public class ShouCe extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.xinshou_tab;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list = new ArrayList<>();
        list.add("http://tpic2.eastlady.cn/info/201806/28/e98bbb94-29b9-78c3-78e4-92bfc9e9571f.jpg");
        list.add("http://tva2.sinaimg.cn/crop.0.0.711.400/90eb2137ly1fmpof6iuesj20jr0b4afn.jpg");
        list.add("http://tva2.sinaimg.cn/crop.0.0.711.400/90eb2137ly1fmpof6iuesj20jr0b4afn.jpg");
        list.add("http://tva2.sinaimg.cn/crop.0.0.711.400/90eb2137ly1fmpof6iuesj20jr0b4afn.jpg");
        list.add("http://dingyue.nosdn.127.net/E9CNz4kHpyBbZG1NthN7ds9LvmuyESSRiOtVhhbCtbTys1541469324321.jpg");
        list.add("http://dingyue.nosdn.127.net/E9CNz4kHpyBbZG1NthN7ds9LvmuyESSRiOtVhhbCtbTys1541469324321.jpg");
        adapter = new Adapter(R.layout.xinshou_tab_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
    }

}
