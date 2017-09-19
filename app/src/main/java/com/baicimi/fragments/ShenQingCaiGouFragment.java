package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2016/9/20.
 * 申请采购
 */
public class ShenQingCaiGouFragment extends BaseFragment{
    private TextView tv_gouwuche_goods_num;
    private TextView tv_add;
    private TextView tv_jian;
    private int num = 1;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_shenqincaigou,container,false);
        tv_gouwuche_goods_num= (TextView) view.findViewById(R.id.gouwuche_goods_num);
        tv_add= (TextView) view.findViewById(R.id.gouwuche_goods_add);
        tv_jian= (TextView) view.findViewById(R.id.gouwuche_goods_jian);

        //加减法
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                String s=String.valueOf(num);
                tv_gouwuche_goods_num.setText(s);
            }
        });
        tv_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num>0){
                    num--;
                }
                String s=String.valueOf(num);
                tv_gouwuche_goods_num.setText(s);
            }
        });
        return view;
    }

    @Override
    protected void initData() {

    }
}
