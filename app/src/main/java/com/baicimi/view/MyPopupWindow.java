package com.baicimi.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.baicimi.R;

/**
 * Created by Administrator on 2017/12/11.
 */

public class MyPopupWindow extends PopupWindow {

    private View mainView;
    private LinearLayout layoutShare, layoutCopy;


    public MyPopupWindow(Activity paramActivity, View paramOnClickListener, int paramInt1, int paramInt2){
        super(paramActivity);
        //窗口布局
//        mainView = LayoutInflater.from(paramActivity).inflate(R.layout.mi_people_chat_add_popup, null);

        setContentView(paramOnClickListener);
        //设置宽度
        setWidth(paramInt1);
        //设置高度
        setHeight(paramInt2);
        //设置显示隐藏动画
//        setAnimationStyle(R.style.AnimTools);
        //设置背景透明
        setBackgroundDrawable(new ColorDrawable(0));
    }
}
