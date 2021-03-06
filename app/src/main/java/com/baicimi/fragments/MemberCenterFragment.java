package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/27.
 * 个人中心会员中心界面
 */
public class MemberCenterFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView memberInteger;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.member_center_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.member_center_fragment_back);
        back.setOnClickListener(this);

        memberInteger = (TextView) view.findViewById(R.id.member_center_fragment_myorderform);
        memberInteger.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.member_center_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.member_center_fragment_myorderform:
                //会员积分
                startFragment(new MemberCenterSecondInteger());
                break;
        }
    }
}
