package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tan on 2017/2/13.
 * 个人中心我的图片
 */
public class RosePersonalSetFragment extends BaseFragment {
    private CheckBox checkBox_love,checkBox_bang,checkBox_yinsi,checkBox_ziliao;

    private FragmentManager fManager;
    private FragmentTransaction ftTransaction;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private LinkedList<String> mFragments2 = new LinkedList<String>();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_rose_personset,container,false);

        checkBox_love= (CheckBox) view.findViewById(R.id.love_check);
        checkBox_bang= (CheckBox) view.findViewById(R.id.bangding_check);
        checkBox_yinsi= (CheckBox) view.findViewById(R.id.yinsi_check);
        checkBox_ziliao= (CheckBox) view.findViewById(R.id.ziliao_check);

        fragments.add(new RosePersonLoveFragment());
        fragments.add(new RosePersonMessageFragment());
        fragments.add(new RosePersonYinSiFragment());
        fragments.add(new RosePersonZiLiaoFragment());

        fManager = getChildFragmentManager();
        RosePersonLoveFragment rosePersonLoveFragment=new RosePersonLoveFragment();
        selectFragment(rosePersonLoveFragment,"love");
        checkBox_love.setSelected(true);


        /**
         * 偏好
         * */
        checkBox_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_love.setChecked(true);
                checkBox_bang.setChecked(false);
                checkBox_yinsi.setChecked(false);
                checkBox_ziliao.setChecked(false);
                selectFragment(new RosePersonLoveFragment(),"love");
            }
        });

        /**
         * 消息
         * */
        checkBox_bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_love.setChecked(false);
                checkBox_bang.setChecked(true);
                checkBox_yinsi.setChecked(false);
                checkBox_ziliao.setChecked(false);
                selectFragment(new RosePersonMessageFragment(),"bang");
            }
        });

        /**
         * 隐私
         * */
        checkBox_yinsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_love.setChecked(false);
                checkBox_bang.setChecked(false);
                checkBox_yinsi.setChecked(true);
                checkBox_ziliao.setChecked(false);
                selectFragment(new RosePersonYinSiFragment(),"yinsi");
            }
        });

        /**
         * 资料
         * */
        checkBox_ziliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_love.setChecked(false);
                checkBox_bang.setChecked(false);
                checkBox_yinsi.setChecked(false);
                checkBox_ziliao.setChecked(true);
                selectFragment(new RosePersonZiLiaoFragment(),"ziliao");
            }
        });



        return view;
    }

    @Override
    protected void initData() {

    }

    public void selectFragment(Fragment f, String tag){
        ftTransaction = fManager.beginTransaction();
        if (mFragments2 != null) {
            if (mFragments2.contains(tag)) {
                for (String str : mFragments2) {
                    if (tag.equals(str)) {
                        ftTransaction.show(fManager.findFragmentByTag(tag));
                    }else {
                        ftTransaction.hide(fManager.findFragmentByTag(str));
                    }
                }
            }else {
                ftTransaction.add(R.id.personal_set_vp,f, tag);
                mFragments2.add(tag);
            }

        }else {
            ftTransaction.add(R.id.personal_set_vp,f, tag);
            mFragments2.add(tag);
        }
        ftTransaction.commit();
    }

}
