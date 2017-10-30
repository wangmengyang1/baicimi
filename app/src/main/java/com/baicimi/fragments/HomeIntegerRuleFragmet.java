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
 * Created by Administrator on 2017/10/24.
 * 积分商城  积分规则
 */

public class HomeIntegerRuleFragmet extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView store_homepage , store_signin , integer;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_rule_fragment , container ,false);
        back = (ImageView) view.findViewById(R.id.home_integer_rule_fragment_back);
        back.setOnClickListener(this);

        store_homepage = (TextView) view.findViewById(R.id.home_integer_rule_fragment_store_homepage);
        store_signin = (TextView) view.findViewById(R.id.home_integer_rule_fragment_store_signin);
        integer = (TextView) view.findViewById(R.id.home_integer_rule_fragment_store_integer);
        store_homepage.setOnClickListener(this);
        store_signin.setOnClickListener(this);
        integer.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_integer_rule_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.home_integer_rule_fragment_store_homepage:
                //商城首页
                getActivity().getSupportFragmentManager().popBackStack(null , 1);
                startFragment(new MainFragment());
                break;
            case R.id.home_integer_rule_fragment_store_signin:
                //每日签到
                startFragment(new HomeIntegerEverydaySignin(), null);
                break;
            case R.id.home_integer_rule_fragment_store_integer:
                //积分兑换成功页面
                startFragment(new IntegralExchangeFragment());//跳转到第二页面
                break;
        }
    }
}
