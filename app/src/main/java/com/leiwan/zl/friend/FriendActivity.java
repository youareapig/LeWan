package com.leiwan.zl.friend;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.FriendData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FriendActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.friend_num)
    TextView friendNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.titlename)
    TextView titlename;
    @BindView(R.id.myhead)
    ImageView myhead;
    @BindView(R.id.myname)
    TextView myname;
    @BindView(R.id.mytype)
    TextView mytype;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    @BindView(R.id.dixian)
    TextView dixian;
    private Adapter adapter;
    private int page = 1;
    private String friendType, friendTitle;
    private List<FriendData.DataBean.ListBean> list;

    @Override
    protected int setLayout() {
        return R.layout.activity_friend;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
    }

    @Override
    protected void setData() {
        list = new ArrayList<FriendData.DataBean.ListBean>();
        Bundle bundle = getIntent().getExtras();
        friendType = bundle.getString("friendtype");
        friendTitle = bundle.getString("friendtitle");
        titlename.setText(friendTitle);
        getFriends();
        refresh.setCanRefresh(false);
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.finishRefresh();
                    }
                }, 1000);

            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        loadmore();
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });

    }

    private void getFriends() {
        Connector.MyFriends(this, friendType, token, "", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "haoyou---" + result);
                final FriendData data = JSON.parseObject(result, FriendData.class);
                if (data.getCode() == 200) {
                    friendNum.setText("共" + data.getData().getCount() + "人");

                    list.addAll(data.getData().getList());
                    adapter = new Adapter(R.layout.friend_item, list);
                    recycler.setAdapter(adapter);
                    if (list.size() < 10) {
                        refresh.setCanLoadMore(false);
                        dixian.setVisibility(View.GONE);
                    }
                }

            }
        });
    }

    private void loadmore() {
        Connector.MyFriends(this, friendType, token, page + "", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "loadmore---" + result);
                final FriendData data = JSON.parseObject(result, FriendData.class);
                if (data.getCode() == 200) {
                    if (data.getData().getList().size() == 0) {
                        dixian.setVisibility(View.VISIBLE);
                        refresh.setCanLoadMore(false);
                    } else {
                        dixian.setVisibility(View.GONE);
                        list.addAll(data.getData().getList());
                        adapter.notifyItemChanged(data.getData().getList().size());
                        refresh.setCanLoadMore(true);
                    }

                }

            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


}
