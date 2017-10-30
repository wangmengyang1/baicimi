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
 * 个人中心  设置  隐私设置  推荐好友权限
 */
public class RemFriendsPrivacyJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout layout_01, layout_02,layout_03,layout_04;
    private CheckBox checkBox_01 , checkBox_02 ,checkBox_03 ,checkBox_04 ;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rem_friends_privacy_jurisdiction , container , false);

        back = (ImageView) view.findViewById(R.id.rem_friends_privacy_jurisdiction_back);
        back.setOnClickListener(this);

        layout_01 = (LinearLayout) view.findViewById(R.id.rem_friends_privacy_jurisdiction_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.rem_friends_privacy_jurisdiction_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.rem_friends_privacy_jurisdiction_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.rem_friends_privacy_jurisdiction_layout_04);

        checkBox_01 = (CheckBox) view.findViewById(R.id.rem_friends_privacy_jurisdiction_checkbox_01);
        checkBox_02 = (CheckBox) view.findViewById(R.id.rem_friends_privacy_jurisdiction_checkbox_02);
        checkBox_03 = (CheckBox) view.findViewById(R.id.rem_friends_privacy_jurisdiction_checkbox_03);
        checkBox_04 = (CheckBox) view.findViewById(R.id.rem_friends_privacy_jurisdiction_checkbox_04);

        layout_01.setOnClickListener(this);
        layout_02.setOnClickListener(this);
        layout_03.setOnClickListener(this);
        layout_04.setOnClickListener(this);
        checkBox_01.setOnClickListener(this);
        checkBox_02.setOnClickListener(this);
        checkBox_03.setOnClickListener(this);
        checkBox_04.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rem_friends_privacy_jurisdiction_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.rem_friends_privacy_jurisdiction_layout_01:
                checkBox_01.setChecked(true);
                checkBox_02.setChecked(false);
                break;
            case R.id.rem_friends_privacy_jurisdiction_layout_02:
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(true);
                break;
            case R.id.rem_friends_privacy_jurisdiction_layout_03:
                checkBox_03.setChecked(true);
                checkBox_04.setChecked(false);
                break;
            case R.id.rem_friends_privacy_jurisdiction_layout_04:
                checkBox_03.setChecked(false);
                checkBox_04.setChecked(true);
                break;
            case R.id.rem_friends_privacy_jurisdiction_checkbox_01:
                checkBox_01.setChecked(true);
                checkBox_02.setChecked(false);
                break;
            case R.id.rem_friends_privacy_jurisdiction_checkbox_02:
                checkBox_01.setChecked(false);
                checkBox_02.setChecked(true);
                break;
            case R.id.rem_friends_privacy_jurisdiction_checkbox_03:
                checkBox_03.setChecked(true);
                checkBox_04.setChecked(false);
                break;
            case R.id.rem_friends_privacy_jurisdiction_checkbox_04:
                checkBox_03.setChecked(false);
                checkBox_04.setChecked(true);
                break;
        }
    }
}
