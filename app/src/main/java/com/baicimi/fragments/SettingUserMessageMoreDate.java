package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.SettingUerMesMoerDateClick;
import com.baicimi.view.SettingUerMessageMoreDateDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/17.
 * 个人中心，设置，个人信息界面 更多资料
 */
public class SettingUserMessageMoreDate extends BaseFragment implements View.OnClickListener  , SettingUerMesMoerDateClick{

    private View view;

    private TextView spinnerFirst , spinnerSecond , spinnerThread;

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_user_message_more_date , container , false);

        spinnerFirst = (TextView) view.findViewById(R.id.setting_user_message_more_spinner_first);
        spinnerSecond = (TextView) view.findViewById(R.id.setting_user_message_more_spinner_thread);
        spinnerThread = (TextView) view.findViewById(R.id.setting_user_message_more_spinner_four);

        initSpinnerFirst();
        initSpinnerThread();
        initSpinnerFour();

        back = (ImageView) view.findViewById(R.id.setting_user_message_more_date_back);
        back.setOnClickListener(this);
        return view;
    }

    private void initSpinnerFour() {
        final List<String> listFirst = new ArrayList<>();
        listFirst.add("农民");
        listFirst.add("工人");
        listFirst.add("白领");
        listFirst.add("个体户");
        listFirst.add("其他");
        spinnerThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingUerMessageMoreDateDialog settintfirst = new SettingUerMessageMoreDateDialog(
                        getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , listFirst ,
                        SettingUserMessageMoreDate.this , R.id.setting_user_message_more_spinner_four);
                settintfirst.show();
            }
        });
    }

    private void initSpinnerThread() {
        final List<String> listFirst = new ArrayList<>();
        listFirst.add("小学");
        listFirst.add("初中");
        listFirst.add("高中");
        listFirst.add("大学");
        listFirst.add("研究生,博士");
        spinnerSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingUerMessageMoreDateDialog settintfirst = new SettingUerMessageMoreDateDialog(
                        getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , listFirst
                        , SettingUserMessageMoreDate.this , R.id.setting_user_message_more_spinner_thread);
                settintfirst.show();
            }
        });
    }

    private void initSpinnerFirst() {
        final List<String> listFirst = new ArrayList<>();
        listFirst.add("5000元以下");
        listFirst.add("5000元-10000元");
        listFirst.add("10000元-15000元");
        listFirst.add("15000元-20000元");
        listFirst.add("20000万元以上");
        spinnerFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingUerMessageMoreDateDialog settintfirst = new SettingUerMessageMoreDateDialog(
                        getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , listFirst
                        , SettingUserMessageMoreDate.this , R.id.setting_user_message_more_spinner_first);
                settintfirst.show();
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_user_message_more_date_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }


    @Override
    public void getShowLible(String lible, int id) {
        switch (id){
            case R.id.setting_user_message_more_spinner_first:
                spinnerFirst.setText(lible);
                break;
            case R.id.setting_user_message_more_spinner_thread:
                spinnerSecond.setText(lible);
                break;
            case R.id.setting_user_message_more_spinner_four:
                spinnerThread.setText(lible);
                break;
        }
    }
}
