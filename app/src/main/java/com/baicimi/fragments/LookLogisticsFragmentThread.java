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
public class LookLogisticsFragmentThread extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout layout_01 ,layout_02 ,layout_03 ,layout_04 ,layout_05 ,layout_06 ,
            layout_07 ,layout_08 ,layout_09 ,layout_10 ,layout_11 ,layout_12 ,layout_13 ,
            layout_14 ,layout_15 ,layout_16 ,layout_17 ,layout_18 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.look_loginstics_fragment_thread , container , false);
        back = (ImageView) view.findViewById(R.id.look_logistics_fragment_thread_back);
        back.setOnClickListener(this);

        initShow();

        return view;
    }

    private void initShow() {
        layout_01 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_04);
        layout_05 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_05);
        layout_06 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_06);
        layout_07 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_07);
        layout_08 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_08);
        layout_09 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_09);
        layout_10 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_10);
        layout_11 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_11);
        layout_12 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_12);
        layout_13 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_13);
        layout_14 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_14);
        layout_15 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_15);
        layout_16 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_16);
        layout_17 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_17);
        layout_18 = (LinearLayout) view.findViewById(R.id.lood_logistics_fragment_thread_layout_18);

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
        layout_01.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
        layout_02.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
        layout_03.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
        layout_04.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_04);
    }
    private void showSecond(){
        layout_05.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
        layout_06.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
        layout_07.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }

    private void showThread(){
        layout_08.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
        layout_09.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
        layout_10.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
        layout_11.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }

    private void showFour(){
        layout_12.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
        layout_13.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
        layout_14.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }


    private void showFive(){
        layout_15.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_01);
        layout_16.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_02);
        layout_17.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_03);
        layout_18.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_off_shape_05);
    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.look_logistics_fragment_thread_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.lood_logistics_fragment_thread_layout_01:
                showFirst();
                layout_01.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_02:
                showFirst();
                layout_02.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_03:
                showFirst();
                layout_03.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_04:
                showFirst();
                layout_04.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_05:
                showSecond();
                layout_05.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_06:
                showSecond();
                layout_06.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_07:
                showSecond();
                layout_07.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_08:
                showThread();
                layout_08.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_09:
                showThread();
                layout_09.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_10:
                showThread();
                layout_10.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_11:
                showThread();
                layout_11.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_12:
                showFour();
                layout_12.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_13:
                showFour();
                layout_13.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_14:
                showFour();
                layout_14.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_15:
                showFive();
                layout_15.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_16:
                showFive();
                layout_16.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_17:
                showFive();
                layout_17.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;
            case R.id.lood_logistics_fragment_thread_layout_18:
                showFive();
                layout_18.setBackgroundResource(R.drawable.look_logistics_fragment_second_layout_checkde_on_shape);
                break;

        }
    }
}
