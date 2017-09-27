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
 * 个人中心，帮助中心，热点问题
 */
public class HelpCenterSecondHotQuestion extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView millionPlan;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.help_center_second_hot_question , container , false);
        back = (ImageView) view.findViewById(R.id.hot_question_fragment_back);
        back.setOnClickListener(this);
        millionPlan = (TextView) view.findViewById(R.id.hot_question_fragment_myorderform);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (back.getId()){
            case R.id.hot_question_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.hot_question_fragment_myorderform:
                //百万行动计划
                startFragment(new HelpCenterSecondHotQuestionMillionPlan());
                break;
        }
    }
}
