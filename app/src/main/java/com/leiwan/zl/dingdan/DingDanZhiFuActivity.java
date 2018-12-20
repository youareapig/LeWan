package com.leiwan.zl.dingdan;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.App;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.ConfirmPayData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.DateUtils;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.tencent.mm.opensdk.modelpay.PayReq;

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
    private String goodsID, saleID;

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
        Bundle bundle = getIntent().getExtras();
        goodsID = bundle.getString("goodsid");
        saleID = bundle.getString("saleid");
        LogUtil.d("tag", "goodsid:" + goodsID + "  saldid:" + saleID);
        getData();
    }

    private void getData() {
        Connector.ConfirmPay(this, token, saleID, goodsID, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "确认购买" + result);
                ConfirmPayData data = JSON.parseObject(result, ConfirmPayData.class);
                if (data.getCode() == 200) {
                    name.setText(data.getData().getProduct().getProduct_name());
                    name1.setText(data.getData().getProduct().getProduct_property());
                    price.setText(data.getData().getProduct().getPrice_sale()+"");
                    yuanjia.setText(data.getData().getProduct().getPrice_market()+"");
                    zongjia.setText(data.getData().getProduct().getPrice_sale()+"");
                    zongyuanjia.setText(data.getData().getProduct().getPrice_sale()+"");
                    time.setText(DateUtils.timeslashData(data.getData().getProduct().getProduct_startusetime()+"")+"至"+DateUtils.timeslashData(data.getData().getProduct().getProduct_endusetime()+""));
                }
            }
        });
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
                PayReq req = new PayReq();//PayReq就是订单信息对象
//给req对象赋值
                req.appId = App.APP_ID;//APPID
                req.partnerId = "123";//    商户号
                req.prepayId = "10";//  预付款ID
                req.nonceStr = "12";//随机数
                req.timeStamp = "456123";//时间戳
                req.packageValue = "Sign=WXPay";//固定值Sign=WXPay
                req.sign = "zl";//签名
                App.mWxApi.sendReq(req);//将订单信息对象发送给微信服务器，即发送支付请求

                break;
        }
    }


    private String xiaoshu(double d) {
        DecimalFormat format = new DecimalFormat("0.00");
        String mynum = format.format(d);
        return mynum;
    }

}
