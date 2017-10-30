package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/27.
 * 个人中心 设置  隐私设置  个人中心查找权限
 */
public class UserCenterFindJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private LinearLayout layout_01 , layout_02 ,layout_03 ,layout_04 ,layout_05 ,layout_06 ;
    private CheckBox checkBox_01 , checkBox_06 ,checkBox_02 ,checkBox_03 ,checkBox_04 ,checkBox_05 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_find_jurisdiction , container , false);
        back = (ImageView) view.findViewById(R.id.usercenter_find_jurisdiction_back);
        back.setOnClickListener(this);

        init();

        return view;
    }

    private void init() {
        layout_01 = (LinearLayout) view.findViewById(R.id.usercenter_find_jurisdiction_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.usercenter_find_jurisdiction_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.usercenter_find_jurisdiction_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.usercenter_find_jurisdiction_layout_04);
        layout_05 = (LinearLayout) view.findViewById(R.id.usercenter_find_jurisdiction_layout_05);
        layout_06 = (LinearLayout) view.findViewById(R.id.usercenter_find_jurisdiction_layout_06);

        checkBox_01 = (CheckBox) view.findViewById(R.id.usercenter_find_jurisdiction_checkbox_01);
        checkBox_02 = (CheckBox) view.findViewById(R.id.usercenter_find_jurisdiction_checkbox_02);
        checkBox_03 = (CheckBox) view.findViewById(R.id.usercenter_find_jurisdiction_checkbox_03);
        checkBox_04 = (CheckBox) view.findViewById(R.id.usercenter_find_jurisdiction_checkbox_04);
        checkBox_05 = (CheckBox) view.findViewById(R.id.usercenter_find_jurisdiction_checkbox_05);
        checkBox_06 = (CheckBox) view.findViewById(R.id.usercenter_find_jurisdiction_checkbox_06);

        layout_01.setOnClickListener(this);
        layout_02.setOnClickListener(this);
        layout_03.setOnClickListener(this);
        layout_04.setOnClickListener(this);
        layout_05.setOnClickListener(this);
        layout_06.setOnClickListener(this);
        checkBox_01.setOnClickListener(this);
        checkBox_02.setOnClickListener(this);
        checkBox_03.setOnClickListener(this);
        checkBox_04.setOnClickListener(this);
        checkBox_05.setOnClickListener(this);
        checkBox_06.setOnClickListener(this);
    }


    private void initShowLayout(){
        checkBox_01.setChecked(false);
        checkBox_02.setChecked(false);
        checkBox_03.setChecked(false);
        checkBox_04.setChecked(false);
        checkBox_05.setChecked(false);
        checkBox_06.setChecked(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_find_jurisdiction_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.usercenter_find_jurisdiction_layout_01:
                initShowLayout();
                checkBox_01.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_layout_02:
                initShowLayout();
                checkBox_02.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_layout_03:
                initShowLayout();
                checkBox_03.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_layout_04:
                initShowLayout();
                checkBox_04.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_layout_05:
                initShowLayout();
                checkBox_05.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_layout_06:
                initShowLayout();
                checkBox_06.setChecked(true);
                break;

            case R.id.usercenter_find_jurisdiction_checkbox_01:
                initShowLayout();
                checkBox_01.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_checkbox_02:
                initShowLayout();
                checkBox_02.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_checkbox_03:
                initShowLayout();
                checkBox_03.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_checkbox_04:
                initShowLayout();
                checkBox_04.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_checkbox_05:
                initShowLayout();
                checkBox_05.setChecked(true);
                break;
            case R.id.usercenter_find_jurisdiction_checkbox_06:
                initShowLayout();
                checkBox_06.setChecked(true);
                break;
        }
    }
}
