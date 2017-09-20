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
 * 玫瑰社区个人中心设置：绑定
 */
public class RosePersonMessageFragment extends BaseFragment {
    private CheckBox che_aite,che_zan,che_sixin,che_weiguanzhu,che_new,che_mifriend,che_tuding;
    private LinearLayout aite,zan,sixin,weiguanzhu,xinfensi,mifriend,tuding;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_rose_personmessage,container,false);

        che_aite= (CheckBox) view.findViewById(R.id.che_aite);
        che_zan= (CheckBox) view.findViewById(R.id.che_zan);
        che_sixin= (CheckBox) view.findViewById(R.id.che_sixin);
        che_weiguanzhu= (CheckBox) view.findViewById(R.id.che_weiguanzhu);
        che_new= (CheckBox) view.findViewById(R.id.che_new);
        che_mifriend= (CheckBox) view.findViewById(R.id.che_mifriend);
        che_tuding= (CheckBox) view.findViewById(R.id.che_tuding);

        aite= (LinearLayout) view.findViewById(R.id.ll_aite);
        zan= (LinearLayout) view.findViewById(R.id.ll_zan);
        sixin= (LinearLayout) view.findViewById(R.id.ll_sixin);
        weiguanzhu= (LinearLayout) view.findViewById(R.id.ll_weiguanzhu);
        xinfensi= (LinearLayout) view.findViewById(R.id.ll_newlove);
        mifriend= (LinearLayout) view.findViewById(R.id.ll_friend);
        tuding= (LinearLayout) view.findViewById(R.id.ll_tuding);

        /**
         * @我的
         * */
        che_aite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_aite.isChecked()){
                    aite.setVisibility(View.VISIBLE);
                }else {
                    aite.setVisibility(View.GONE);
                }
            }
        });

        /**
         * @赞
         * */
        che_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_zan.isChecked()){
                    zan.setVisibility(View.VISIBLE);
                }else {
                    zan.setVisibility(View.GONE);
                }
            }
        });

        /**
         * 私信
         * */
        che_sixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_sixin.isChecked()){
                    sixin.setVisibility(View.VISIBLE);
                }else {
                    sixin.setVisibility(View.GONE);
                }
            }
        });

        /**
         * 未关注人私信
         * */
        che_weiguanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_weiguanzhu.isChecked()){
                    weiguanzhu.setVisibility(View.VISIBLE);
                }else {
                    weiguanzhu.setVisibility(View.GONE);
                }
            }
        });

        /**
         * 新粉丝
         * */
        che_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_new.isChecked()){
                    xinfensi.setVisibility(View.VISIBLE);
                }else {
                    xinfensi.setVisibility(View.GONE);
                }
            }
        });


        /**
         * 幂友圈
         * */
        che_mifriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_mifriend.isChecked()){
                    mifriend.setVisibility(View.VISIBLE);
                }else {
                    mifriend.setVisibility(View.GONE);
                }
            }
        });

        /**
         * 图钉
         * */
        che_tuding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (che_tuding.isChecked()){
                    tuding.setVisibility(View.VISIBLE);
                }else {
                    tuding.setVisibility(View.GONE);
                }
            }
        });


        return view;
    }

    @Override
    protected void initData() {

    }
}
