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
import com.baicimi.dialog.EnterpriseUplogingDialog;
import com.baicimi.view.AuthenticationDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class PersonCenteredActhenticationEnterprise extends BaseFragment implements View.OnClickListener {

    private View view;
    private Spinner spinner , spinner_02 , spinner_03;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;

    private TextView change_acthentication;//点击更换认证
    private ImageView back;

    private TextView uploading_textview;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.person_centered_acthentication_enterprise_fragment , container , false);

        spinner = (Spinner)view.findViewById(R.id.person_cnetered_spinner_enterprise);
        initSpinnerOne(spinner);
        spinner_02 = (Spinner)view.findViewById(R.id.person_centered_spinner_02_enterprise);
        initSpinnerTwo(spinner_02);
        spinner_03 = (Spinner)view.findViewById(R.id.person_centered_spinner_03_enterprise);
        initSpinnerThree(spinner_03);

        change_acthentication = (TextView) view.findViewById(R.id.person_centered_acthentication_user_fragment_textview_change_enterprise);
        change_acthentication.setOnClickListener(this);

        back = (ImageView) view.findViewById(R.id.back_enterprise);
        back.setOnClickListener(this);

        uploading_textview = (TextView) view.findViewById(R.id.person_cnetred_acthentication_enterprise_uploading);
        uploading_textview.setOnClickListener(this);


        return view;
    }



    //数字选择器进行适配
    private void initSpinnerTwo(Spinner spinner) {
        //数据
        data_list = new ArrayList<String>();
        data_list.add("国有企业");
        data_list.add("集体企业");
        data_list.add("私营企业");
        data_list.add("中外合作");
        data_list.add("中外合资");
        data_list.add("外商独资");

        //适配器
        arr_adapter= new ArrayAdapter<String>(getContext(), R.layout.person_centered_spinner_item_textview, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }
    //数字选择器进行适配
    private void initSpinnerOne(Spinner spinner) {
        //数据
        data_list = new ArrayList<String>();
        data_list.add("  --请选择--  ");
        data_list.add("    2     ");
        data_list.add("    3    ");

        //适配器
        arr_adapter= new ArrayAdapter<String>(getContext(), R.layout.person_centered_spinner_item_textview, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }
    //数字选择器进行适配
    private void initSpinnerThree(Spinner spinner) {
        //数据
        data_list = new ArrayList<String>();
        data_list.add("农、林、牧、渔业 ");
        data_list.add("采矿业 、 制造业");
        data_list.add("交通运输、仓储");
        data_list.add("信息传输、软件业");
        data_list.add("批发和零售业");
        data_list.add("住宿和餐饮业");
//        data_list.add("交通运输、仓储和邮政业");
//        data_list.add("交通运输、仓储和邮政业");
//        data_list.add("交通运输、仓储和邮政业");

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
            case R.id.person_centered_acthentication_user_fragment_textview_change_enterprise:
                AuthenticationDialog authenticationDialog = new AuthenticationDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderThere , this , new String("普通企业认证"));
                authenticationDialog.show();
                break;
            case R.id.back_enterprise:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.person_cnetred_acthentication_enterprise_uploading:

                EnterpriseUplogingDialog enterpriseUplogingDialog = new EnterpriseUplogingDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFour , this);
                enterpriseUplogingDialog.show();
                break;
        }
    }
}
