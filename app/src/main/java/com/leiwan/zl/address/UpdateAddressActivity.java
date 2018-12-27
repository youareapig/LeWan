package com.leiwan.zl.address;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.AddressPickTask;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

public class UpdateAddressActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.diqu)
    EditText diqu;
    @BindView(R.id.dizhi)
    EditText dizhi;
    @BindView(R.id.save)
    RelativeLayout save;

    @Override
    protected int setLayout() {
        return R.layout.activity_update_address;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.back, R.id.save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.save:
              /*  AddressPickTask task = new AddressPickTask(this);
                task.setHideCounty(false);
                task.setHideProvince(false);
                task.setCallback(new AddressPickTask.Callback() {
                    @Override
                    public void onAddressInitFailed() {
                        //showToast("数据初始化失败");
                    }

                    @Override
                    public void onAddressPicked(Province province, City city, County county) {
                        Log.d("tag", "地址：" + province.getAreaName() + city.getAreaName() + county.getAreaName());
                    }
                });
                task.execute("四川", "成api/UserAddress/UserAppendAddress都", "锦江");*/

                add();
                break;
        }
    }

    private void add() {
        Connector.AddAddress(this, token, "旺财", "15889988899", "510000", "510100", "510104", "四川省成都市锦江区龙舟路", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "添加收货地址" + result);
            }
        });
    }
}
