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
 * 个人中心  设置  隐私设置  消息管理
 */
public class MessageJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private LinearLayout layout_01 , layout_02 ,layout_03 ,layout_04 ,layout_05 ,layout_06 ,layout_07 ,
            layout_08 ,layout_09 ,layout_10 ;

    private CheckBox checkBox_01 , checkBox_02 ,checkBox_03 ,checkBox_04 ,checkBox_05 ,checkBox_06 ,checkBox_07 ,
            checkBox_08 ,checkBox_09 ,checkBox_10 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.message_jurisdiction , container , false);

        back = (ImageView) view.findViewById(R.id.comment_manager_jurisdiction_fragment_back);
        back.setOnClickListener(this);

        init();

        return view;
    }

    private void init() {
        layout_01 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_04);
        layout_05= (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_05);
        layout_06 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_06);
        layout_07 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_07);
        layout_08 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_08);
        layout_09 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_09);
        layout_10 = (LinearLayout) view.findViewById(R.id.message_jurisdiction_layout_10);

        checkBox_01 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_01);
        checkBox_02 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_02);
        checkBox_03 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_03);
        checkBox_04 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_04);
        checkBox_05 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_05);
        checkBox_06 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_06);
        checkBox_07 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_07);
        checkBox_08 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_08);
        checkBox_09 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_09);
        checkBox_10 = (CheckBox) view.findViewById(R.id.message_jurisdiction_checkbox_10);

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
    }


    private void initFirstLayout(){
        checkBox_01.setChecked(false);
        checkBox_02.setChecked(false);
        checkBox_03.setChecked(false);
        checkBox_04.setChecked(false);
        checkBox_05.setChecked(false);
    }

    private void initSecondLayout(){
        checkBox_06.setChecked(false);
        checkBox_07.setChecked(false);
        checkBox_08.setChecked(false);
    }

    private void initThreadLayout(){
        checkBox_09.setChecked(false);
        checkBox_10.setChecked(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.comment_manager_jurisdiction_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.message_jurisdiction_layout_01:
                initFirstLayout();
                checkBox_01.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_02:
                initFirstLayout();
                checkBox_02.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_03:
                initFirstLayout();
                checkBox_03.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_04:
                initFirstLayout();
                checkBox_04.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_05:
                initFirstLayout();
                checkBox_05.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_06:
                initFirstLayout();
                checkBox_06.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_07:
                initFirstLayout();
                checkBox_07.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_08:
                initFirstLayout();
                checkBox_08.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_09:
                initFirstLayout();
                checkBox_09.setChecked(true);
                break;
            case R.id.message_jurisdiction_layout_10:
                initFirstLayout();
                checkBox_10.setChecked(true);
                break;

            case R.id.message_jurisdiction_checkbox_01:
                initFirstLayout();
                checkBox_01.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_02:
                initFirstLayout();
                checkBox_02.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_03:
                initFirstLayout();
                checkBox_03.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_04:
                initFirstLayout();
                checkBox_04.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_05:
                initFirstLayout();
                checkBox_05.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_06:
                initFirstLayout();
                checkBox_06.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_07:
                initFirstLayout();
                checkBox_07.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_08:
                initFirstLayout();
                checkBox_08.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_09:
                initFirstLayout();
                checkBox_09.setChecked(true);
                break;
            case R.id.message_jurisdiction_checkbox_10:
                initFirstLayout();
                checkBox_10.setChecked(true);
                break;
        }
    }
}
