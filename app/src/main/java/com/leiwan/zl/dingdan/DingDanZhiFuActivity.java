package com.leiwan.zl.dingdan;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.utils.ToastUtil;

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
    @BindView(R.id.bottom_view)
    LinearLayout bottomView;
    @BindView(R.id.page1)
    LinearLayout page1;
    @BindView(R.id.pop_date)
    TextView popDate;
    @BindView(R.id.pop_number)
    TextView popNumber;
    @BindView(R.id.include_view)
    RelativeLayout includeView;
    @BindView(R.id.icon)
    ImageView icon;
    private int num = 1;
    private double totleprice, totleyuanjia, danprice, danyuanjia;
    private boolean isshow = true;

    @Override
    protected int setLayout() {
        return R.layout.activity_ding_dan_zhi_fu;
    }

    @Override
    protected void setView() {
        page1.setOnClickListener(null);
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
                if (isshow) {
                    includeView.setVisibility(View.VISIBLE);
                    isshow = false;
                    popDate.setText(time.getText().toString());
                    popNumber.setText("¥" + price.getText() + "x" + goodsnum.getText() + "份");
                    icon.setImageResource(R.mipmap.down);
                } else {
                    includeView.setVisibility(View.GONE);
                    icon.setImageResource(R.mipmap.up);
                    isshow = true;
                }
                break;
            case R.id.pay:
                ToastUtil.showShortToast("支付");
                break;
        }
    }


    private String xiaoshu(double d) {
        DecimalFormat format = new DecimalFormat("0.00");
        String mynum = format.format(d);
        return mynum;
    }

}
