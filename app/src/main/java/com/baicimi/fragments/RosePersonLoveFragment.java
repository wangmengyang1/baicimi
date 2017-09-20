package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2017/2/22.
 * 玫瑰社区个人中心设置：偏好
 */
public class RosePersonLoveFragment extends BaseFragment {
    private CheckBox che_tixing,che_shuiyin,che_languge;
    private LinearLayout tixing,shuiyin,languge;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_rose_love,container,false);

        che_tixing= (CheckBox) view.findViewById(R.id.tixing);
        che_shuiyin= (CheckBox) view.findViewById(R.id.shuiyin);
        che_languge= (CheckBox) view.findViewById(R.id.languge);

        tixing= (LinearLayout) view.findViewById(R.id.ll_lixian);
        shuiyin= (LinearLayout) view.findViewById(R.id.ll_setshuiyin);
        languge= (LinearLayout) view.findViewById(R.id.ll_languge);

        /**
         * @邮件提醒设置
         * */
        che_tixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_tixing.isChecked()){
                    tixing.setVisibility(View.VISIBLE);
                }else {
                    tixing.setVisibility(View.GONE);
                }
            }
        });

        /**
         * @图片水印设置
         * */
        che_shuiyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_shuiyin.isChecked()){
                    shuiyin.setVisibility(View.VISIBLE);
                }else {
                    shuiyin.setVisibility(View.GONE);
                }
            }
        });

        /**
         * @图片水印设置
         * */
        che_languge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_languge.isChecked()){
                    languge.setVisibility(View.VISIBLE);
                }else {
                    languge.setVisibility(View.GONE);
                }
            }
        });


        return view;
    }


    @Override
    protected void initData() {

    }
}
