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
 * Created by Administrator on 2017/10/18.
 * 个人中心我的订单，发货中页面，查看物流页面02
 */
public class LookLogisticsFragmentSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout layout_01 , layout_02 , layout_03 , layout_04 , layout_05, layout_06, layout_07, layout_08
            , layout_09, layout_10, layout_11, layout_12, layout_13 , layout_14 , layout_15, layout_16, layout_17, layout_18
            , layout_19, layout_20, layout_21, layout_22, layout_23, layout_24, layout_25, layout_26, layout_27;

    private CheckBox checkBox_01 , checkBox_02 ,checkBox_03 ,checkBox_04 ,checkBox_05 ,checkBox_06 ,checkBox_07 ,
            checkBox_08 ,checkBox_09 ,checkBox_10 ,checkBox_11 ,checkBox_12 ,checkBox_13 ,checkBox_14 ,checkBox_15 ,
            checkBox_16 ,checkBox_17 ,checkBox_18 ,checkBox_19 ,checkBox_20 ,checkBox_21 ,checkBox_22 ,checkBox_23 ,
            checkBox_24 ,checkBox_25 ,checkBox_26 ,checkBox_27 ;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.look_logistics_fragment_second , container ,false);
        back = (ImageView) view.findViewById(R.id.look_logistics_fragment_second_back);
        back.setOnClickListener(this);

        init();
        return view;
    }

    private void init() {
        layout_01 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_04);
        layout_05 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_05);
        layout_06 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_06);
        layout_07 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_07);
        layout_08 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_08);
        layout_09 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_09);
        layout_10 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_10);
        layout_11 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_11);
        layout_12 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_12);
        layout_13 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_13);
        layout_14 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_14);
        layout_15 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_15);
        layout_16 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_16);
        layout_17 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_17);
        layout_18 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_18);
        layout_19 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_19);
        layout_20 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_20);
        layout_21 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_21);
        layout_22 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_22);
        layout_23 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_23);
        layout_24 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_24);
        layout_25 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_25);
        layout_26 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_26);
        layout_27 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_27);

        checkBox_01 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_01);
        checkBox_02 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_02);
        checkBox_03 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_03);
        checkBox_04 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_04);
        checkBox_05 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_05);
        checkBox_06 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_06);
        checkBox_07 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_07);
        checkBox_08 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_08);
        checkBox_09 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_09);
        checkBox_10 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_10);
        checkBox_11 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_11);
        checkBox_12 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_12);
        checkBox_13 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_13);
        checkBox_14 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_14);
        checkBox_15 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_15);
        checkBox_16 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_16);
        checkBox_17 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_17);
        checkBox_18 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_18);
        checkBox_19 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_19);
        checkBox_20 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_20);
        checkBox_21 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_21);
        checkBox_22 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_22);
        checkBox_23 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_23);
        checkBox_24 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_24);
        checkBox_25 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_25);
        checkBox_26 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_26);
        checkBox_27 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_second_checkbox_27);


        checkBox_01.setOnClickListener(this);
        checkBox_02.setOnClickListener(this);
        checkBox_03.setOnClickListener(this);
        checkBox_04.setOnClickListener(this);
        checkBox_05.setOnClickListener(this);
        checkBox_06.setOnClickListener(this);
        checkBox_07.setOnClickListener(this);
        checkBox_08.setOnClickListener(this);
        checkBox_09.setOnClickListener(this);
        checkBox_10.setOnClickListener(this);
        checkBox_11.setOnClickListener(this);
        checkBox_12.setOnClickListener(this);
        checkBox_13.setOnClickListener(this);
        checkBox_14.setOnClickListener(this);
        checkBox_15.setOnClickListener(this);
        checkBox_16.setOnClickListener(this);
        checkBox_17.setOnClickListener(this);
        checkBox_18.setOnClickListener(this);
        checkBox_19.setOnClickListener(this);
        checkBox_20.setOnClickListener(this);
        checkBox_21.setOnClickListener(this);
        checkBox_22.setOnClickListener(this);
        checkBox_23.setOnClickListener(this);
        checkBox_24.setOnClickListener(this);
        checkBox_25.setOnClickListener(this);
        checkBox_26.setOnClickListener(this);
        checkBox_27.setOnClickListener(this);

        layout_01.setOnClickListener(this);
        layout_02.setOnClickListener(this);
        layout_03.setOnClickListener(this);
        layout_04.setOnClickListener(this);
        layout_05.setOnClickListener(this);
        layout_06.setOnClickListener(this);
        layout_07.setOnClickListener(this);
        layout_08.setOnClickListener(this);
        layout_09.setOnClickListener(this);
        layout_10.setOnClickListener(this);
        layout_11.setOnClickListener(this);
        layout_12.setOnClickListener(this);
        layout_13.setOnClickListener(this);
        layout_14.setOnClickListener(this);
        layout_15.setOnClickListener(this);
        layout_16.setOnClickListener(this);
        layout_17.setOnClickListener(this);
        layout_18.setOnClickListener(this);
        layout_19.setOnClickListener(this);
        layout_20.setOnClickListener(this);
        layout_21.setOnClickListener(this);
        layout_22.setOnClickListener(this);
        layout_23.setOnClickListener(this);
        layout_24.setOnClickListener(this);
        layout_25.setOnClickListener(this);
        layout_26.setOnClickListener(this);
        layout_27.setOnClickListener(this);
    }

    private void initShow(){
        checkBox_01.setChecked(false);
        checkBox_02.setChecked(false);
        checkBox_03.setChecked(false);
        checkBox_04.setChecked(false);

    }
    private void initShowSecond(){
        checkBox_05.setChecked(false);
        checkBox_06.setChecked(false);
        checkBox_07.setChecked(false);
        checkBox_08.setChecked(false);
//        layout_05.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_06.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_07.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_08.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }
    private void initShowThread(){
        checkBox_09.setChecked(false);
        checkBox_10.setChecked(false);
        checkBox_11.setChecked(false);
        checkBox_12.setChecked(false);
        checkBox_13.setChecked(false);
//        layout_09.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_10.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_11.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_12.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
//        layout_13.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }
    private void initShowFour(){
        checkBox_14.setChecked(false);
        checkBox_15.setChecked(false);
        checkBox_16.setChecked(false);
        checkBox_17.setChecked(false);
        checkBox_18.setChecked(false);
//        layout_14.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_15.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_16.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_17.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
//        layout_18.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }
    private void initShowFive(){
        checkBox_19.setChecked(false);
        checkBox_20.setChecked(false);
        checkBox_21.setChecked(false);
        checkBox_22.setChecked(false);
        checkBox_23.setChecked(false);
//        layout_19.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_20.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_21.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_22.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
//        layout_23.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }

    private void initShowSix(){
        checkBox_24.setChecked(false);
        checkBox_25.setChecked(false);
        checkBox_26.setChecked(false);
        checkBox_27.setChecked(false);
//        layout_24.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_25.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_26.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_27.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.look_logistics_fragment_second_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.lood_logistics_fragment_second_layout_01:
                initShow();
                checkBox_01.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_02:
                initShow();
                checkBox_02.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_03:
                initShow();
                checkBox_03.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_04:
                initShow();
                checkBox_04.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_05:
                initShowSecond();
                checkBox_05.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_06:
                initShowSecond();
                checkBox_06.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_07:
                initShowSecond();
                checkBox_07.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_08:
                initShowSecond();
                checkBox_08.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_09:
                initShowThread();
                checkBox_09.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_10:
                initShowThread();
                checkBox_10.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_11:
                initShowThread();
                checkBox_11.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_12:
                initShowThread();
                checkBox_12.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_13:
                initShowThread();
                checkBox_13.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_14:
                initShowFour();
                checkBox_14.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_15:
                initShowFour();
                checkBox_15.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_16:
                initShowFour();
                checkBox_16.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_17:
                initShowFour();
                checkBox_17.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_18:
                initShowFour();
                checkBox_18.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_19:
                initShowFive();
                checkBox_19.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_20:
                initShowFive();
                checkBox_20.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_21:
                initShowFive();
                checkBox_21.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_22:
                initShowFive();
                checkBox_22.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_23:
                initShowFive();
                checkBox_23.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_24:
                initShowSix();
                checkBox_24.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_25:
                initShowSix();
                checkBox_25.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_26:
                initShowSix();
                checkBox_26.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_layout_27:
                initShowSix();
                checkBox_27.setChecked(true);
                break;

            case R.id.lood_logistics_fragment_second_checkbox_01:
                initShow();
                checkBox_01.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_02:
                initShow();
                checkBox_02.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_03:
                initShow();
                checkBox_03.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_04:
                initShow();
                checkBox_04.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_05:
                initShowSecond();
                checkBox_05.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_06:
                initShowSecond();
                checkBox_06.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_07:
                initShowSecond();
                checkBox_07.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_08:
                initShowSecond();
                checkBox_08.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_09:
                initShowThread();
                checkBox_09.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_10:
                initShowThread();
                checkBox_10.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_11:
                initShowThread();
                checkBox_11.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_12:
                initShowThread();
                checkBox_12.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_13:
                initShowThread();
                checkBox_13.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_14:
                initShowFour();
                checkBox_14.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_15:
                initShowFour();
                checkBox_15.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_16:
                initShowFour();
                checkBox_16.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_17:
                initShowFour();
                checkBox_17.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_18:
                initShowFour();
                checkBox_18.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_19:
                initShowFive();
                checkBox_19.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_20:
                initShowFive();
                checkBox_20.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_21:
                initShowFive();
                checkBox_21.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_22:
                initShowFive();
                checkBox_22.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_23:
                initShowFive();
                checkBox_23.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_24:
                initShowSix();
                checkBox_24.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_25:
                initShowSix();
                checkBox_25.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_26:
                initShowSix();
                checkBox_26.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_second_checkbox_27:
                initShowSix();
                checkBox_27.setChecked(true);
                break;
        }
    }
}
