package com.leiwan.zl.dingdan;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DingDanZhiFuActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.name1)
    TextView name1;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.moneytag)
    TextView moneytag;
    @BindView(R.id.yuanjia)
    TextView yuanjia;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.jian)
    TextView jian;
    @BindView(R.id.goodsnum)
    TextView goodsnum;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.nametag)
    TextView nametag;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.teltag)
    TextView teltag;
    @BindView(R.id.telnumber)
    EditText telnumber;
    @BindView(R.id.beizhu)
    EditText beizhu;
    @BindView(R.id.zongjia)
    TextView zongjia;
    @BindView(R.id.zongyuanjia)
    TextView zongyuanjia;
    @BindView(R.id.dingdan)
    LinearLayout dingdan;
    @BindView(R.id.pay)
    TextView pay;
    private int num = 1;
    private double totleprice, totleyuanjia, danprice, danyuanjia;

    @Override
    protected int setLayout() {
        return R.layout.activity_ding_dan_zhi_fu;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.back, R.id.jian, R.id.add, R.id.dingdan, R.id.pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.jian:
                num--;
                if (num < 1) {
                    num = 1;
                }
                goodsnum.setText(num + "");
                danprice = Double.parseDouble(price.getText().toString());
                totleprice = danprice * num;
                danyuanjia = Double.parseDouble(yuanjia.getText().toString());
                totleyuanjia = danyuanjia * num;
                zongjia.setText(xiaoshu(totleprice));
                zongyuanjia.setText(xiaoshu(totleyuanjia));
                break;
            case R.id.add:
                num++;
                goodsnum.setText(num + "");
                danprice = Double.parseDouble(price.getText().toString());
                totleprice = danprice * num;
                danyuanjia = Double.parseDouble(yuanjia.getText().toString());
                totleyuanjia = danyuanjia * num;

                zongjia.setText(xiaoshu(totleprice));
                zongyuanjia.setText(xiaoshu(totleyuanjia));
                break;
            case R.id.dingdan:
                break;
            case R.id.pay:
                break;
        }
    }

    private String xiaoshu(double d) {
        DecimalFormat format = new DecimalFormat("0.00");
        String mynum = format.format(d);
        return mynum;
    }
}
