package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/21.
 * 个人中心，帮助中心首页 点此咨询提问跳转页面 详细咨询页面
 */
@SuppressLint("ValidFragment")
public class UserCenterHelpIndentConvertion extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView lible , fillinaform;
    private ImageView back;
    private String lible_Str;
    private LinearLayout layout;


    public UserCenterHelpIndentConvertion(String lible_Str) {
        this.lible_Str = lible_Str;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_help_indent_converstion , container ,false);

        back = (ImageView) view.findViewById(R.id.user_center_help_indent_converstion_back);
        back.setOnClickListener(this);

        lible = (TextView) view.findViewById(R.id.user_center_help_indent_converstion_libles);
        lible.setText(lible_Str);

        if (lible_Str.equals("分销点/店")){
            layout = (LinearLayout) view.findViewById(R.id.user_center_help_indent_converstion_layout);
            fillinaform = (TextView) view.findViewById(R.id.user_center_help_indent_converstion_fillinaform);
            layout.setVisibility(View.VISIBLE);
            fillinaform.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //百次幂分销点/店申请表
                    startFragment(new DistributionPpplicationFrom());
                }
            });
        }

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_help_indent_converstion_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
