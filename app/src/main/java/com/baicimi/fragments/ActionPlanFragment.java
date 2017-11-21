package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/21.
 * 个人中心，帮助中心首页 点此咨询提问跳转页面  百万行动计划
 */
public class ActionPlanFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.action_plan_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.action_plan_fragment_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.action_plan_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
