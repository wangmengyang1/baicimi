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
 * 个人中心  设置  隐私设置  个人资料查看权限
 */
public class UserDateFindJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout layout_01 , layout_02 ,layout_03 ,layout_04 ,layout_05 ,layout_06 ,layout_07 ,
            layout_08 ,layout_09 ,layout_10 ,layout_11 ,layout_12 ,layout_13 ,layout_14 ,layout_15 ,
            layout_16 ,layout_17 ,layout_18 ,layout_19 ,layout_20 ,layout_21 ,layout_22 ,layout_23 ,
            layout_24 ,layout_25 ,layout_26 ;

    private CheckBox checkBox_01 , checkBox_02 ,checkBox_03 ,checkBox_04 ,checkBox_05 ,checkBox_06 ,checkBox_07 ,
            checkBox_08 ,checkBox_09 ,checkBox_10 ,checkBox_11 ,checkBox_12 ,checkBox_13 ,checkBox_14 ,checkBox_15 ,
            checkBox_16 ,checkBox_17 ,checkBox_18 ,checkBox_19 ,checkBox_20 ,checkBox_21 ,checkBox_22 ,checkBox_23 ,
            checkBox_24 ,checkBox_25 ,checkBox_26 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_date_find_jurisdtion , container , false);

        back = (ImageView) view.findViewById(R.id.userdate_find_jurisdiction_back);
        back.setOnClickListener(this);

        init();
        return view;
    }

    private void init() {
        layout_01 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_04);
        layout_05 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_05);
        layout_06 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_06);
        layout_07 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_07);
        layout_08 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_08);
        layout_09 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_09);
        layout_10 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_10);
        layout_11 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_11);
        layout_12 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_12);
        layout_13 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_13);
        layout_14 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_14);
        layout_15 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_15);
        layout_16 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_16);
        layout_17 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_17);
        layout_18 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_18);
        layout_19 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_19);
        layout_20 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_20);
        layout_21 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_21);
        layout_22 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_22);
        layout_23 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_23);
        layout_24 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_24);
        layout_25 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_25);
        layout_26 = (LinearLayout) view.findViewById(R.id.user_date_find_jurisdtion_layout_26);

        checkBox_01 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_01);
        checkBox_02 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_02);
        checkBox_03 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_03);
        checkBox_04 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_04);
        checkBox_05 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_05);
        checkBox_06 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_06);

        checkBox_07 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_07);
        checkBox_08 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_08);
        checkBox_09 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_09);
        checkBox_10 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_10);
        checkBox_11 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_11);
        checkBox_12 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_12);
        checkBox_13 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_13);
        checkBox_14 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_14);

        checkBox_15 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_15);
        checkBox_16 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_16);
        checkBox_17 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_17);
        checkBox_18 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_18);
        checkBox_19 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_19);
        checkBox_20 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_20);


        checkBox_21 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_21);
        checkBox_22 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_22);
        checkBox_23 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_23);
        checkBox_24 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_24);
        checkBox_25 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_25);
        checkBox_26 = (CheckBox) view.findViewById(R.id.user_date_find_jurisdtion_checkbox_26);

    }

    private void showFirstLaout(){
        checkBox_01.setChecked(false);
        checkBox_02.setChecked(false);
        checkBox_03.setChecked(false);
        checkBox_04.setChecked(false);
        checkBox_05.setChecked(false);
        checkBox_06.setChecked(false);
    }
    private void showSecondLaout(){
        checkBox_07.setChecked(false);
        checkBox_08.setChecked(false);
        checkBox_09.setChecked(false);
        checkBox_10.setChecked(false);
        checkBox_11.setChecked(false);
        checkBox_12.setChecked(false);
        checkBox_13.setChecked(false);
        checkBox_14.setChecked(false);

    }
    private void showThreadLaout(){
        checkBox_15.setChecked(false);
        checkBox_16.setChecked(false);
        checkBox_17.setChecked(false);
        checkBox_18.setChecked(false);
        checkBox_19.setChecked(false);
        checkBox_20.setChecked(false);

    }
    private void showFourLaout(){
        checkBox_21.setChecked(false);
        checkBox_22.setChecked(false);
        checkBox_23.setChecked(false);
        checkBox_24.setChecked(false);
        checkBox_25.setChecked(false);
        checkBox_26.setChecked(false);

    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.userdate_find_jurisdiction_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.user_date_find_jurisdtion_layout_01:
                showFirstLaout();
                checkBox_01.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_02:
                showFirstLaout();
                checkBox_02.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_03:
                showFirstLaout();
                checkBox_03.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_04:
                showFirstLaout();
                checkBox_04.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_05:
                showFirstLaout();
                checkBox_05.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_06:
                showFirstLaout();
                checkBox_06.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_07:
                showSecondLaout();
                checkBox_07.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_08:
                showSecondLaout();
                checkBox_08.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_09:
                showSecondLaout();
                checkBox_09.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_10:
                showSecondLaout();
                checkBox_10.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_11:
                showSecondLaout();
                checkBox_11.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_12:
                showSecondLaout();
                checkBox_12.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_13:
                showSecondLaout();
                checkBox_13.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_14:
                showSecondLaout();
                checkBox_14.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_15:
                showThreadLaout();
                checkBox_15.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_16:
                showThreadLaout();
                checkBox_16.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_17:
                showThreadLaout();
                checkBox_17.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_18:
                showThreadLaout();
                checkBox_18.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_19:
                showThreadLaout();
                checkBox_19.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_20:
                showThreadLaout();
                checkBox_20.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_21:
                showFourLaout();
                checkBox_21.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_22:
                showFourLaout();
                checkBox_22.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_23:
                showFourLaout();
                checkBox_23.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_24:
                showFourLaout();
                checkBox_24.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_25:
                showFourLaout();
                checkBox_25.setChecked(true);
                break;
            case R.id.user_date_find_jurisdtion_layout_26:
                showFourLaout();
                checkBox_26.setChecked(true);
                break;

        }
    }
}
