package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.MiFriendsJurisdictionDialog;

/**
 * Created by Administrator on 2017/10/27.
 * 个人中心  设置  隐私管理  幂友权限
 */
public class MiFriendsJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ImageView image_first , image_second;

    private LinearLayout layout_01 , layout_02 ;
    private CheckBox checkBox_01 , checkBox_02 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_friends_jurisdition , container , false);
        back = (ImageView) view.findViewById(R.id.mi_fridends_jurisdiction_back);
        back.setOnClickListener(this);
        image_first = (ImageView) view.findViewById(R.id.mi_friends_jurisdtion_image_first);
        image_second = (ImageView) view.findViewById(R.id.mi_friends_jurisdtion_image_second);
        image_first.setOnClickListener(this);
        image_second.setOnClickListener(this);

        layout_01 = (LinearLayout) view.findViewById(R.id.mi_fridends_jurisdition_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.mi_fridends_jurisdition_layout_02);
        checkBox_01 = (CheckBox) view.findViewById(R.id.mi_fridends_jurisdition_checkbox_01);
        checkBox_02 = (CheckBox) view.findViewById(R.id.mi_fridends_jurisdition_checkbox_02);

        layout_01.setOnClickListener(this);
        layout_02.setOnClickListener(this);
        checkBox_01.setOnClickListener(this);
        checkBox_02.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_fridends_jurisdiction_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.mi_friends_jurisdtion_image_first:
//                MiFriendsJurisdictionDialog miFriendsJurisdictionDialog = new MiFriendsJurisdictionDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
//                miFriendsJurisdictionDialog.show();
                break;
            case R.id.mi_friends_jurisdtion_image_second:
                MiFriendsJurisdictionDialog miFriendsJurisdictionDialog = new MiFriendsJurisdictionDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                miFriendsJurisdictionDialog.show();
                break;

            case R.id.mi_fridends_jurisdition_layout_01:
                checkBox_01.setChecked(true);
                checkBox_02.setChecked(false);
                break;
            case R.id.mi_fridends_jurisdition_layout_02:
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(true);
                break;
            case R.id.mi_fridends_jurisdition_checkbox_01:
                checkBox_01.setChecked(true);
                checkBox_02.setChecked(false);
                break;
            case R.id.mi_fridends_jurisdition_checkbox_02:
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(true);
                break;
        }
    }
}
