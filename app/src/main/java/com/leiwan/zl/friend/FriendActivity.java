package com.leiwan.zl.friend;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;

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
    private List<String> list;
    private Adapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_friend;
    }

    @Override
    protected void setView() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void setData() {
        list = new ArrayList<>();
        list.add("http://tpic2.eastlady.cn/info/201806/28/e98bbb94-29b9-78c3-78e4-92bfc9e9571f.jpg");
        list.add("http://tva2.sinaimg.cn/crop.0.0.711.400/90eb2137ly1fmpof6iuesj20jr0b4afn.jpg");
        adapter = new Adapter(R.layout.friend_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        getFriends();
    }

    private void getFriends() {
        Connector.MyFriends(this, "3",token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "haoyou---" + result);
            }
        });
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
