package com.leiwan.zl.regist;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.leiwan.zl.BaseActivity;
import com.leiwan.zl.R;
import com.leiwan.zl.data.SendMessageData;
import com.leiwan.zl.utils.Connector;
import com.leiwan.zl.utils.CountDownTimerUtils;
import com.leiwan.zl.utils.LogUtil;
import com.leiwan.zl.utils.ToastUtil;
import com.leiwan.zl.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JoinVIPActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.fuwu)
    TextView fuwu;
    @BindView(R.id.yinsi)
    TextView yinsi;
    @BindView(R.id.fatherlayout)
    LinearLayout fatherlayout;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.yaoqingma)
    EditText yaoqingma;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.recode)
    EditText recode;
    @BindView(R.id.regist)
    TextView regist;
    @BindView(R.id.getcode)
    TextView getCode;
    private String yaoqingcode, mobile, yanzhengcode;

    @Override
    protected int setLayout() {
        return R.layout.activity_join_vip;
    }

    @Override
    protected void setView() {
        keepLoginBtnNotOver(container, fatherlayout);
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Utils.closeKeyboard(JoinVIPActivity.this);
                return false;
            }
        });
    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.back, R.id.fuwu, R.id.yinsi, R.id.regist, R.id.getcode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.fuwu:
                break;
            case R.id.yinsi:
                break;
            case R.id.getcode:
                mobile = tel.getText().toString().trim();
                if (TextUtils.isEmpty(mobile)) {
                    ToastUtil.showShortToast("请输入电话号码");
                } else {
                    if (mobile.length() < 11) {
                        ToastUtil.showShortToast("请输入正确电话号码");
                    } else {
                        getRecode();
                    }
                }
                break;
            case R.id.regist:
                yanzhengcode = recode.getText().toString().trim();
                mobile = tel.getText().toString().trim();
                yaoqingcode = yaoqingma.getText().toString().trim();
                if (TextUtils.isEmpty(yanzhengcode) || TextUtils.isEmpty(mobile) || TextUtils.isEmpty(yaoqingcode)) {
                    ToastUtil.showShortToast("请完善信息");
                } else {
                    Regist();
                }
                break;
        }
    }

    private void Regist() {
        Connector.SuperVip(this, token, yaoqingcode, mobile, yanzhengcode, new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "注册成功" + result);
            }
        });
    }

    //获取短信验证码
    private void getRecode() {
        Connector.SendMessage(this, mobile, "1", new Connector.MyCallback() {
            @Override
            public void MyResult(String result) {
                LogUtil.d("tag", "获取验证码" + result);
                SendMessageData data = JSON.parseObject(result, SendMessageData.class);
                if (data.getCode() == 200) {
                    CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(getCode, 60000, 1000);
                    mCountDownTimerUtils.start();
                }
            }
        });
    }

    //解决软键盘遮挡问题
    private void keepLoginBtnNotOver(final View root, final View subView) {
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                // 获取root在窗体的可视区域
                root.getWindowVisibleDisplayFrame(rect);
                // 获取root在窗体的不可视区域高度(被其他View遮挡的区域高度)
                int rootInvisibleHeight = root.getRootView().getHeight() - rect.bottom;
                // 若不可视区域高度大于200，则键盘显示,其实相当于键盘的高度
                if (rootInvisibleHeight > 200) {
                    // 显示键盘时
                    int srollHeight = rootInvisibleHeight - (root.getHeight() - subView.getHeight()) - Utils.getNavigationBarHeight(root.getContext());
                    if (srollHeight > 0) {
                        root.scrollTo(0, srollHeight);
                    }
                } else {
                    // 隐藏键盘时
                    root.scrollTo(0, 0);
                }
            }
        });
    }

    //点击外部隐藏软键盘
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    assert v != null;
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    /** here */
                    v.clearFocus();
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

}
