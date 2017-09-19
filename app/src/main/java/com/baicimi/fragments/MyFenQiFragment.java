package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2016/10/10.
 * 我的分期界面
 */
public class MyFenQiFragment extends PersonCenteredFragment{
    private Button btn_open_xinyong;
    private RelativeLayout relativeLayout1,relativeLayout2,relativeLayout3;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_my_fenqi,container,false);
        btn_open_xinyong= (Button) view.findViewById(R.id.btn_kaitong_fenqi);
        btn_open_xinyong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starFenQiFragmented();
            }
        });
        relativeLayout1= (RelativeLayout) view.findViewById(R.id.re_mifenqi);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starFenQiFragmented();
            }
        });
        relativeLayout2= (RelativeLayout) view.findViewById(R.id.re_kafenqi);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starKaFenqiFragment();
            }
        });

        relativeLayout3= (RelativeLayout) view.findViewById(R.id.re_chakan);
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starFenQiFragment();
            }
        });
        return view;
    }
}
