package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/8.
 */

public class IntegralCeLaFragment extends BaseFragment implements View.OnClickListener {

    private ImageView back;
    private Button exchange_btn;
    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.cela_integral_fragment , container , false);

        //找控件
        initUI();
        return view;
    }

    private void initUI() {
        back = (ImageView) view.findViewById(R.id.cela_interal_back);
        exchange_btn = (Button) view.findViewById(R.id.cela_imtegral_button);

        //设置监听事件
        back.setOnClickListener(this);
        exchange_btn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cela_interal_back:
                getActivity().getSupportFragmentManager().popBackStack(null , 1);
                startFragment(new MainFragment());
                break;
            case R.id.cela_imtegral_button:
                startFragment(new IntegralExchangeFragment());//跳转到第二页面
                break;
        }
    }
}
