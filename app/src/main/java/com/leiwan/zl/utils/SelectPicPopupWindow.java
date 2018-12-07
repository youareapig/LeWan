package com.leiwan.zl.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.leiwan.zl.R;

public class SelectPicPopupWindow extends PopupWindow {
  
  

    public SelectPicPopupWindow(Activity context,View mMenuView) {
        super(context);  
//        LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        mMenuView = inflater.inflate(R.layout.dingdan_pop, null);
//        popDate = (TextView) mMenuView.findViewById(R.id.pop_date);
//        popNumber = (TextView) mMenuView.findViewById(R.id.pop_number);

        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);  
        //设置SelectPicPopupWindow弹出窗体的宽  
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高  
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击  
        this.setFocusable(true);  
        //设置SelectPicPopupWindow弹出窗体动画效果  
//        this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明  
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景  
        this.setBackgroundDrawable(dw);  
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框  
//        mMenuView.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//
//                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
//                int y=(int) event.getY();
//                if(event.getAction()== MotionEvent.ACTION_UP){
//                    if(y<height){
//                        dismiss();
//                    }
//                }
//                return true;
//            }
//        });
  
    }  
  
}  