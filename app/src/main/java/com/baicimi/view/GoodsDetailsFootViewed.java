package com.baicimi.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.baicimi.MainActivity;
import com.baicimi.R;

/**
 * Created by tan on 2016/9/19.
 * 商品详情ListView上方布局2
 */
public class GoodsDetailsFootViewed extends BaseView{

    public GoodsDetailsFootViewed(Context context) {
        super(context);
    }

    @Override
    public void initEvent() {
    }

    @Override
    protected void initData() {
    }

    @Override
    public void initView() {
        view= LayoutInflater.from(mcontext).inflate( R.layout.view_goods_details_foot,this);
    }

}
