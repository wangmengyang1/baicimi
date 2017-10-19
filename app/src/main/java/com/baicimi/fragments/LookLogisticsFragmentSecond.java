package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
//    private LinearLayout layout_01 , layout_02 , layout_03 , layout_04 , layout_05, layout_06, layout_07, layout_08
//            , layout_09, layout_10, layout_11, layout_12, layout_13 , layout_14 , layout_15, layout_16, layout_17, layout_18
//            , layout_19, layout_20, layout_21, layout_22, layout_23, layout_24, layout_25, layout_26, layout_27;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.look_logistics_fragment_second , container ,false);
        back = (ImageView) view.findViewById(R.id.look_logistics_fragment_second_back);
        back.setOnClickListener(this);

//        init();
        return view;
    }

//    private void init() {
//        layout_01 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_01);
//        layout_02 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_02);
//        layout_03 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_03);
//        layout_04 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_04);
//        layout_05 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_05);
//        layout_06 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_06);
//        layout_07 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_07);
//        layout_08 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_08);
//        layout_09 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_09);
//        layout_10 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_10);
//        layout_11 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_11);
//        layout_12 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_12);
//        layout_13 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_13);
//        layout_14 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_14);
//        layout_15 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_15);
//        layout_16 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_16);
//        layout_17 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_17);
//        layout_18 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_18);
//        layout_19 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_19);
//        layout_20 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_20);
//        layout_21 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_21);
//        layout_22 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_22);
//        layout_23 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_23);
//        layout_24 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_24);
//        layout_25 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_25);
//        layout_26 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_26);
//        layout_27 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_second_layout_27);
//
//        layout_01.setOnClickListener(this);
//        layout_02.setOnClickListener(this);
//        layout_03.setOnClickListener(this);
//        layout_04.setOnClickListener(this);
//        layout_05.setOnClickListener(this);
//        layout_06.setOnClickListener(this);
//        layout_07.setOnClickListener(this);
//        layout_08.setOnClickListener(this);
//        layout_09.setOnClickListener(this);
//        layout_10.setOnClickListener(this);
//        layout_11.setOnClickListener(this);
//        layout_12.setOnClickListener(this);
//        layout_13.setOnClickListener(this);
//        layout_14.setOnClickListener(this);
//        layout_15.setOnClickListener(this);
//        layout_16.setOnClickListener(this);
//        layout_17.setOnClickListener(this);
//        layout_18.setOnClickListener(this);
//        layout_19.setOnClickListener(this);
//        layout_20.setOnClickListener(this);
//        layout_21.setOnClickListener(this);
//        layout_22.setOnClickListener(this);
//        layout_23.setOnClickListener(this);
//        layout_24.setOnClickListener(this);
//        layout_25.setOnClickListener(this);
//        layout_26.setOnClickListener(this);
//        layout_27.setOnClickListener(this);
//    }
//
//    private void initShow(){
//        layout_01.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_02.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_03.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_04.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
//    }
//    private void initShowSecond(){
//        layout_05.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_06.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_07.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_08.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
//    }
//    private void initShowThread(){
//        layout_09.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_10.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_11.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_12.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
//        layout_13.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
//    }
//    private void initShowFour(){
//        layout_14.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_15.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_16.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_17.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
//        layout_18.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
//    }
//    private void initShowFive(){
//        layout_19.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_20.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_21.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_22.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
//        layout_23.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
//    }
//
//    private void initShowSix(){
//        layout_24.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
//        layout_25.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
//        layout_26.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
//        layout_27.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
//    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.look_logistics_fragment_second_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
//            case R.id.lood_logistics_fragment_second_layout_01:
//                initShow();
//                layout_01.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_02:
//                initShow();
//                layout_02.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_03:
//                initShow();
//                layout_03.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_04:
//                initShow();
//                layout_04.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_05:
//                initShowSecond();
//                layout_05.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_06:
//                initShowSecond();
//                layout_06.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_07:
//                initShowSecond();
//                layout_07.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_08:
//                initShowSecond();
//                layout_08.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_09:
//                initShowThread();
//                layout_09.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_10:
//                initShowThread();
//                layout_10.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_11:
//                initShowThread();
//                layout_11.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_12:
//                initShowThread();
//                layout_12.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_13:
//                initShowThread();
//                layout_13.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_14:
//                initShowFour();
//                layout_14.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_15:
//                initShowFour();
//                layout_15.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_16:
//                initShowFour();
//                layout_16.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_17:
//                initShowFour();
//                layout_17.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_18:
//                initShowFour();
//                layout_18.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_19:
//                initShowFive();
//                layout_19.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_20:
//                initShowFive();
//                layout_20.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_21:
//                initShowFive();
//                layout_21.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_22:
//                initShowFive();
//                layout_22.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_23:
//                initShowFive();
//                layout_23.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_24:
//                initShowSix();
//                layout_24.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_25:
//                initShowSix();
//                layout_25.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_26:
//                initShowSix();
//                layout_26.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
//            case R.id.lood_logistics_fragment_second_layout_27:
//                initShowSix();
//                layout_27.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
//                break;
        }
    }
}
