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
 * 个人中心  设置  隐私管理  评论管理权限
 */
public class CommentManagerJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private LinearLayout layout_01 , layout_02 ,layout_03 ,layout_04 ,layout_05 ,layout_06 ,layout_07 ,layout_08 ,
            layout_09 ,layout_10 ,layout_11 ,layout_12 ,layout_13 ,layout_14 ,layout_15 ;

    private CheckBox checkBox_01 , checkBox_02 ,checkBox_03 ,checkBox_04 ,checkBox_05 ,checkBox_06 ,
            checkBox_07 ,checkBox_08 ,checkBox_09 ,checkBox_10 ,checkBox_11 ,checkBox_12 ,checkBox_13 ,checkBox_14 ,checkBox_15 ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.comment_manager_jurisdiction_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.comment_manager_jurisdiction_fragment_back);
        back.setOnClickListener(this);

        init();
        return view;
    }

    private void init() {

        layout_01 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_04);
        layout_05= (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_05);
        layout_06 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_06);
        layout_07 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_07);
        layout_08 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_08);
        layout_09 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_09);
        layout_10 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_10);
        layout_11 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_11);
        layout_12 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_12);
        layout_13 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_13);
        layout_14 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_14);
        layout_15 = (LinearLayout) view.findViewById(R.id.comment_manager_jurisdiction_fragment_layout_15);

        checkBox_01 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_01);
        checkBox_02 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_02);
        checkBox_03 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_03);
        checkBox_04 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_04);
        checkBox_05 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_05);
        checkBox_06 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_06);
        checkBox_07 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_07);
        checkBox_08 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_08);
        checkBox_09 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_09);
        checkBox_10 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_10);
        checkBox_11 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_11);
        checkBox_12 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_12);
        checkBox_13 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_13);
        checkBox_14 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_14);
        checkBox_15 = (CheckBox) view.findViewById(R.id.comment_manager_jurisdiction_fragment_checkbox_15);
    }


    private void initFirstChcekbox(){
        checkBox_01.setChecked(false);
        checkBox_02.setChecked(false);
        checkBox_03.setChecked(false);
        checkBox_04.setChecked(false);
        checkBox_05.setChecked(false);
        checkBox_06.setChecked(false);
    }
    private void initSecondChcekbox(){
        checkBox_07.setChecked(false);
        checkBox_08.setChecked(false);
        checkBox_09.setChecked(false);
        checkBox_10.setChecked(false);

    }
    private void initThreadChcekbox(){
        checkBox_11.setChecked(false);
        checkBox_12.setChecked(false);
        checkBox_13.setChecked(false);

    }
    private void initFourChcekbox(){
        checkBox_14.setChecked(false);
        checkBox_15.setChecked(false);
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
            case R.id.comment_manager_jurisdiction_fragment_layout_01:
                initFirstChcekbox();
                checkBox_01.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_02:
                initFirstChcekbox();
                checkBox_02.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_03:
                initFirstChcekbox();
                checkBox_03.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_04:
                initFirstChcekbox();
                checkBox_04.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_05:
                initFirstChcekbox();
                checkBox_05.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_06:
                initFirstChcekbox();
                checkBox_06.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_07:
                initSecondChcekbox();
                checkBox_07.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_08:
                initSecondChcekbox();
                checkBox_08.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_09:
                initSecondChcekbox();
                checkBox_09.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_10:
                initSecondChcekbox();
                checkBox_10.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_11:
                initThreadChcekbox();
                checkBox_11.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_12:
                initThreadChcekbox();
                checkBox_12.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_13:
                initThreadChcekbox();
                checkBox_13.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_14:
                initFourChcekbox();
                checkBox_14.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_layout_15:
                initFourChcekbox();
                checkBox_15.setChecked(true);
                break;



            case R.id.comment_manager_jurisdiction_fragment_checkbox_01:
                initFirstChcekbox();
                checkBox_01.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_02:
                initFirstChcekbox();
                checkBox_02.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_03:
                initFirstChcekbox();
                checkBox_03.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_04:
                initFirstChcekbox();
                checkBox_04.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_05:
                initFirstChcekbox();
                checkBox_05.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_06:
                initFirstChcekbox();
                checkBox_06.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_07:
                initSecondChcekbox();
                checkBox_07.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_08:
                initSecondChcekbox();
                checkBox_08.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_09:
                initSecondChcekbox();
                checkBox_09.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_10:
                initSecondChcekbox();
                checkBox_10.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_11:
                initThreadChcekbox();
                checkBox_11.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_12:
                initThreadChcekbox();
                checkBox_12.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_13:
                initThreadChcekbox();
                checkBox_13.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_14:
                initFourChcekbox();
                checkBox_14.setChecked(true);
                break;
            case R.id.comment_manager_jurisdiction_fragment_checkbox_15:
                initFourChcekbox();
                checkBox_15.setChecked(true);
                break;


        }
    }
}
