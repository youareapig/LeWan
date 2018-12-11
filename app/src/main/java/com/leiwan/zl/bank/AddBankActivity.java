package com.leiwan.zl.bank;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.CityData;
import com.leiwan.zl.utils.BandCardEditText;
import com.leiwan.zl.utils.LogUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddBankActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userbankId)
    BandCardEditText userbankId;
    @BindView(R.id.userbanktype)
    EditText userbanktype;
    @BindView(R.id.userkaihu)
    EditText userkaihu;
    @BindView(R.id.userphone)
    EditText userphone;
    @BindView(R.id.add)
    RelativeLayout add;

    @Override
    protected int setLayout() {
        return R.layout.activity_add_bank;
    }

    @Override
    protected void setView() {


//        CityData data= JSON.parseObject(getJson().trim(),CityData.class);
//        List<CityData.CitiesBean> list=data.getCities();
//        for (int i=0;i<list.size();i++){
//            String city=list.get(i).getAreaName();
//            LogUtil.d("tag","city--"+city);
//        }
    }

    @Override
    protected void setData() {
        userbankId.setBankCardListener(new BandCardEditText.BankCardListener() {
            @Override
            public void success(String name) {
                Log.d("tag", "查询成功" + name);
                userbanktype.setText(name);
                userbanktype.setFocusable(false);
                userbanktype.setEnabled(false);
            }

            @Override
            public void failure() {
                Log.d("tag", "查询失败");
                userbanktype.setText("没有查到所属银行");
                userbanktype.setFocusable(true);
                userbanktype.setEnabled(true);
            }
        });
    }

    public String getJson() {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open("city.json")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @OnClick({R.id.back, R.id.add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.add:
                break;
        }
    }
}
