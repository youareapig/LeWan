package com.leiwan.zl.home.fragment;

import com.leiwan.zl.BaseFragment;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;

/**
 * Created by Administrator on 2018/12/26.
 */

public class IsAppointment extends BaseFragment {
    @Override
    protected int setLayout() {
        return R.layout.isappointment;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {
        getData();
    }

    private void getData() {
        Connector.IsAppointment(getActivity(), token, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "已预约--" + result);
            }
        });
    }
}
