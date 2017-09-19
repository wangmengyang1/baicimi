package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.AuthenticationDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class PersonCenteredActhenticationUser extends BaseFragment implements View.OnClickListener {

    private View view;
    private Spinner spinner , spinner_02 , spinner_03;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;

    private TextView change_acthentication;//点击更换认证
    private ImageView back;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.person_centered_acthentication_user_fragment , container , false);

        spinner = (Spinner)view.findViewById(R.id.person_cnetered_spinner);
        initSpinner(spinner);
        spinner_02 = (Spinner)view.findViewById(R.id.person_centered_spinner_02);
        initSpinner(spinner_02);
        spinner_03 = (Spinner)view.findViewById(R.id.person_centered_spinner_03);
        initSpinnerthree(spinner_03);

        change_acthentication = (TextView) view.findViewById(R.id.person_centered_acthentication_user_fragment_textview_change);
        change_acthentication.setOnClickListener(this);

        back = (ImageView) view.findViewById(R.id.back_acthentication_user);
        back.setOnClickListener(this);


        return view;
    }



    //数字选择器进行适配
    private void initSpinner(Spinner spinner) {
        //数据
        data_list = new ArrayList<String>();
        data_list.add("  --请选择--  ");
        data_list.add("      2       ");
        data_list.add("      3      ");

        //适配器
        arr_adapter= new ArrayAdapter<String>(getContext(), R.layout.person_centered_spinner_item_textview, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }
    //数字选择器进行适配
    private void initSpinnerthree(Spinner spinner) {
        //数据
        data_list = new ArrayList<String>();
        data_list.add(" 购物 ");
        data_list.add(" 交友 ");
        data_list.add(" 赚积分 ");

        //适配器
        arr_adapter= new ArrayAdapter<String>(getContext(), R.layout.person_centered_spinner_item_textview, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }




    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.person_centered_acthentication_user_fragment_textview_change:
                AuthenticationDialog authenticationDialog = new AuthenticationDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderThere , this , new String("个人认证"));
                authenticationDialog.show();
                break;
            case R.id.back_acthentication_user:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
