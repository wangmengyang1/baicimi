package com.baicimi.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页
 */
public class FootPaintFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 6;

    private FootPaintEveryTaskFragment footPaintEveryTaskFragment;//每日任务
    private FootPaintEveryTaskFragmentSecond footPaintNewPeopleTaskFragment;//新手任务
    private FootPaintPlayFragment footPaintPlayFragment;//运动
    private FootPaintActivityFragment footPaintActivityFragment;//赛事活动
    private FootPaintHealthManagerFragment footPaintHealthManagerFragment;//健康管理

    private LinearLayout everyTask , newPeopleTask , play , activityFragmetn , managerFragment;
    private CheckBox checkBox_01 ,checkBox_02 ,checkBox_03 ,checkBox_04 ,checkBox_05 ;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.foot_paint_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.foot_paint_fragment_back);
        back.setOnClickListener(this);


        fm = getChildFragmentManager();
        init();
        initShowFragment(0);


        everyTask = (LinearLayout) view.findViewById(R.id.foot_paint_fragment_everytask);
        newPeopleTask = (LinearLayout) view.findViewById(R.id.foot_paint_fragment_newpeopletask);
        play = (LinearLayout) view.findViewById(R.id.foot_paint_fragment_play);
        activityFragmetn = (LinearLayout) view.findViewById(R.id.foot_paint_fragment_activity);
        managerFragment = (LinearLayout) view.findViewById(R.id.foot_paint_fragment_manager);


        everyTask.setOnClickListener(this);
        newPeopleTask.setOnClickListener(this);
        play.setOnClickListener(this);
        activityFragmetn.setOnClickListener(this);
        managerFragment.setOnClickListener(this);


        checkBox_01 = (CheckBox) view.findViewById(R.id.foot_paint_fragment_everytask_checkbox);
        checkBox_02 = (CheckBox) view.findViewById(R.id.foot_paint_fragment_newpeopletask_checkbox);
        checkBox_03 = (CheckBox) view.findViewById(R.id.foot_paint_fragment_play_checkbox);
        checkBox_04 = (CheckBox) view.findViewById(R.id.foot_paint_fragment_activity_checkbox);
        checkBox_05 = (CheckBox) view.findViewById(R.id.foot_paint_fragment_manager_checkbox);
        return view;
    }



    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(footPaintEveryTaskFragment = new FootPaintEveryTaskFragment(true));
        listFragment.add(footPaintNewPeopleTaskFragment = new FootPaintEveryTaskFragmentSecond());
        listFragment.add(footPaintPlayFragment = new FootPaintPlayFragment());
        listFragment.add(footPaintActivityFragment = new FootPaintActivityFragment());
        listFragment.add(footPaintHealthManagerFragment = new FootPaintHealthManagerFragment());
    }


    //fragment切换
    private void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag() + "i";
        FragmentTransaction transaction =  fm.beginTransaction();
        if (fragmentTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));
            index = i;
        }else {
            if (fragmentTag.isEmpty()){
                fragmentTag.add(tag);
                transaction.add(R.id.foot_paint_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.foot_paint_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.foot_paint_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.foot_paint_fragment_everytask:
                initShowFragment(0);
                checkBox_01.setChecked(true);
                checkBox_02.setChecked(false);
                checkBox_03.setChecked(false);
                checkBox_04.setChecked(false);
                checkBox_05.setChecked(false);

                break;
            case R.id.foot_paint_fragment_newpeopletask:
                initShowFragment(1);
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(true);
                checkBox_03.setChecked(false);
                checkBox_04.setChecked(false);
                checkBox_05.setChecked(false);
                break;
            case R.id.foot_paint_fragment_play:
                initShowFragment(2);
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(false);
                checkBox_03.setChecked(true);
                checkBox_04.setChecked(false);
                checkBox_05.setChecked(false);
                break;
            case R.id.foot_paint_fragment_activity:
                initShowFragment(3);
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(false);
                checkBox_03.setChecked(false);
                checkBox_04.setChecked(true);
                checkBox_05.setChecked(false);
                break;
            case R.id.foot_paint_fragment_manager:
                initShowFragment(4);
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(false);
                checkBox_03.setChecked(false);
                checkBox_04.setChecked(false);
                checkBox_05.setChecked(true);
                break;
        }
    }
}
