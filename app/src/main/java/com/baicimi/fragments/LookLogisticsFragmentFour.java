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
 * 个人中心我的订单，发货中页面，查看物流页面04
 */
public class LookLogisticsFragmentFour extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private LinearLayout layout_01 ,layout_02 ,layout_03 ,layout_04 ,layout_05 ,layout_06 ,
            layout_07 ,layout_08 ,layout_09 ,layout_10 ,layout_11 ,layout_12 ,layout_13 ,
            layout_14 ,layout_15 ,layout_16 ,layout_17 ,layout_18 ;

    private CheckBox checkbox_01 , checkbox_02 ,checkbox_03 ,checkbox_04 ,checkbox_05 ,checkbox_06 ,
            checkbox_07 ,checkbox_08 ,checkbox_09 ,checkbox_10 ,checkbox_11 ,checkbox_12 ,checkbox_13 ,
            checkbox_14 ,checkbox_15 ,checkbox_16 ,checkbox_17 ,checkbox_18 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.look_logistics_fragment_four , container , false);

        back = (ImageView) view.findViewById(R.id.look_logistics_fragment_four_back);
        back.setOnClickListener(this);

        initShow();
        return view;
    }


    private void initShow() {
        layout_01 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_04);
        layout_05 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_05);
        layout_06 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_06);
        layout_07 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_07);
        layout_08 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_08);
        layout_09 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_09);
        layout_10 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_10);
        layout_11 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_11);
        layout_12 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_12);
        layout_13 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_13);
        layout_14 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_14);
        layout_15 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_15);
        layout_16 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_16);
        layout_17 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_17);
        layout_18 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_four_layout_18);


        checkbox_01 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_01);
        checkbox_02 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_02);
        checkbox_03 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_03);
        checkbox_04 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_04);
        checkbox_05 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_05);
        checkbox_06 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_06);
        checkbox_07 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_07);
        checkbox_08 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_08);
        checkbox_09 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_09);
        checkbox_10 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_10);
        checkbox_11 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_11);
        checkbox_12 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_12);
        checkbox_13 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_13);
        checkbox_14 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_14);
        checkbox_15 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_15);
        checkbox_16 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_16);
        checkbox_17 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_17);
        checkbox_18 = (CheckBox) view.findViewById(R.id.lood_logistics_fragment_four_checkbox_18);


        checkbox_01.setOnClickListener(this);
        checkbox_02.setOnClickListener(this);
        checkbox_03.setOnClickListener(this);
        checkbox_04.setOnClickListener(this);
        checkbox_05.setOnClickListener(this);
        checkbox_06.setOnClickListener(this);
        checkbox_07.setOnClickListener(this);
        checkbox_08.setOnClickListener(this);
        checkbox_09.setOnClickListener(this);
        checkbox_10.setOnClickListener(this);
        checkbox_11.setOnClickListener(this);
        checkbox_12.setOnClickListener(this);
        checkbox_13.setOnClickListener(this);
        checkbox_14.setOnClickListener(this);
        checkbox_15.setOnClickListener(this);
        checkbox_16.setOnClickListener(this);
        checkbox_17.setOnClickListener(this);
        checkbox_18.setOnClickListener(this);

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

    }

    private void showFirst(){
        checkbox_01.setChecked(false);
        checkbox_02.setChecked(false);
        checkbox_03.setChecked(false);
        checkbox_04.setChecked(false);
//        layout_01.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_02.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_03.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_04.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
    }
    private void showSecond(){
        checkbox_05.setChecked(false);
        checkbox_06.setChecked(false);
        checkbox_07.setChecked(false);
//        layout_05.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_06.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_07.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }

    private void showThread(){
        checkbox_08.setChecked(false);
        checkbox_09.setChecked(false);
        checkbox_10.setChecked(false);
        checkbox_11.setChecked(false);
//        layout_08.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_09.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_10.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_11.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }

    private void showFour(){
        checkbox_12.setChecked(false);
        checkbox_13.setChecked(false);
        checkbox_14.setChecked(false);
//        layout_12.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_13.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_14.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }


    private void showFive(){
        checkbox_15.setChecked(false);
        checkbox_16.setChecked(false);
        checkbox_17.setChecked(false);
        checkbox_18.setChecked(false);
//        layout_15.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_16.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_17.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_18.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }




    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.look_logistics_fragment_four_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;

            case R.id.lood_logistics_fragment_four_layout_01:
                showFirst();
                checkbox_01.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_02:
                showFirst();
                checkbox_02.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_03:
                showFirst();
                checkbox_03.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_04:
                showFirst();
                checkbox_04.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_05:
                showSecond();
                checkbox_05.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_06:
                showSecond();
                checkbox_06.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_07:
                showSecond();
                checkbox_07.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_08:
                showThread();
                checkbox_08.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_09:
                showThread();
                checkbox_09.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_10:
                showThread();
                checkbox_10.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_11:
                showThread();
                checkbox_11.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_12:
                showFour();
                checkbox_12.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_13:
                showFour();
                checkbox_13.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_14:
                showFour();
                checkbox_14.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_15:
                showFive();
                checkbox_15.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_16:
                showFive();
                checkbox_16.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_17:
                showFive();
                checkbox_17.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_layout_18:
                showFive();
                checkbox_18.setChecked(true);
                break;



            case R.id.lood_logistics_fragment_four_checkbox_01:
                showFirst();
                checkbox_01.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_02:
                showFirst();
                checkbox_02.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_03:
                showFirst();
                checkbox_03.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_04:
                showFirst();
                checkbox_04.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_05:
                showSecond();
                checkbox_05.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_06:
                showSecond();
                checkbox_06.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_07:
                showSecond();
                checkbox_07.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_08:
                showThread();
                checkbox_08.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_09:
                showThread();
                checkbox_09.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_10:
                showThread();
                checkbox_10.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_11:
                showThread();
                checkbox_11.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_12:
                showFour();
                checkbox_12.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_13:
                showFour();
                checkbox_13.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_14:
                showFour();
                checkbox_14.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_15:
                showFive();
                checkbox_15.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_16:
                showFive();
                checkbox_16.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_17:
                showFive();
                checkbox_17.setChecked(true);
                break;
            case R.id.lood_logistics_fragment_four_checkbox_18:
                showFive();
                checkbox_18.setChecked(true);
                break;

        }
    }
}
