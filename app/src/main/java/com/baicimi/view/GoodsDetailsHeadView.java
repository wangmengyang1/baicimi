package com.baicimi.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import com.baicimi.R;

/**
 * Created by tan on 2016/9/19.
 * 商品详情ListView上方布局
 */
public class GoodsDetailsHeadView extends BaseView{
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    public GoodsDetailsHeadView(Context context) {
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
//        view=View.inflate(mcontext, R.layout.view_goods_details_head,this);
        view= LayoutInflater.from(mcontext).inflate( R.layout.view_goods_details_head,this);
        checkBox1= (CheckBox) view.findViewById(R.id.jifen_check1);
        checkBox1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(true);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
            }
        });
        checkBox2= (CheckBox) view.findViewById(R.id.jifen_check2);
        checkBox2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(true);
                checkBox3.setChecked(false);
            }
        });
        checkBox3= (CheckBox) view.findViewById(R.id.jifen_check3);
        checkBox3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(true);
            }
        });
    }
}
