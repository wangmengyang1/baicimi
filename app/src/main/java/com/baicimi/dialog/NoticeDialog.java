package com.baicimi.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.NoticeDialogPagerAdapterpa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */

public class NoticeDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private List<View> list = new ArrayList<>();
    private NoticeDialogPagerAdapterpa adapter;
    public ViewPager viewPager;
    private LinearLayout relative;
    private ImageView image;
    private String str;//简介
    private String lible;//标题
    private String date;//有效期
    private TextView text;

    public void setStr(String str) {
        this.str = str;
    }

    public void setLible(String lible) {
        this.lible = lible;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NoticeDialog(Context context) {
        super(context);
        this.context = context;
    }

    public NoticeDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        relative = (LinearLayout) findViewById(R.id.dialog_notice_choise_relative);
        viewPager = (ViewPager) findViewById(R.id.notice_image_vp);
        TextView textView = (TextView) findViewById(R.id.notice_value);//简介
        TextView lible_tv = (TextView) findViewById(R.id.dialog_notice_title);//标题
        TextView date_tv = (TextView) findViewById(R.id.notice_date);//有效期
        textView.setText(str);
        lible_tv.setText(lible);
        date_tv.setText(date);
        //此数据为虚假数据
        for(int i = 0 ; i < 8 ; i++){
            View view = LayoutInflater.from(context).inflate(R.layout.noticedialog_view , null);
            image = (ImageView) view.findViewById(R.id.noticedialog_view_image);
            text = (TextView) view.findViewById(R.id.noticedialog_view_text);

            if(i / 3 == 0){
                image.setImageResource(R.mipmap.ic_product_01);
                text.setText("PINCH洁面乳15ML");
            }else if(i / 3 == 1){
                image.setImageResource(R.mipmap.ic_product_02);
                text.setText("PINCH精华35ML");
            }else if(i / 3 == 2){
                image.setImageResource(R.mipmap.ic_product_03);
                text.setText("PINCH护肤乳50ML");
            }
            list.add(view);
        }
        viewPager.setOffscreenPageLimit(3); // viewpager缓存页数
        adapter = new NoticeDialogPagerAdapterpa(list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);//显示在第二条数据

         //将父节点Layout事件分发给viewpager，否则只能滑动中间的一个view对象
        relative.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
