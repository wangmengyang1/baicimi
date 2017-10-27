package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.BolckManagementDialog;

/**
 * Created by Administrator on 2017/10/27.
 * 个人中心  设置  隐私设置  屏蔽管理
 */
public class BlockManagementJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView firstAdd , secondAdd;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.block_manamgement_jurisdiction , container , false);

        back = (ImageView) view.findViewById(R.id.block_manamgement_jurisdiction_back);
        back.setOnClickListener(this);

        firstAdd = (TextView) view.findViewById(R.id.block_namegement_jurisdiction_add_first);
        firstAdd.setOnClickListener(this);

        secondAdd = (TextView) view.findViewById(R.id.block_namegement_jurisdiction_add_second);
        secondAdd.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.block_manamgement_jurisdiction_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.block_namegement_jurisdiction_add_first:
                BolckManagementDialog bolckManagementDialog = new BolckManagementDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                bolckManagementDialog.show();
                break;
            case R.id.block_namegement_jurisdiction_add_second:
                BolckManagementDialog bolckManagementDialogsecond = new BolckManagementDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                bolckManagementDialogsecond.show();
                break;
        }
    }
}
