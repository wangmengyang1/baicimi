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
 * 积分兑换成功界面
 */
public class IntegralExchangeFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;//返回
    private Button exchange_btn;//完成
//    private Button exchange_particulars_btn;//积分详情

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.cela_integral_exchange_fragment , container , false);
        initUI();
        return view;
    }

    private void initUI() {
        back = (ImageView) view.findViewById(R.id.cela_interal_exchange_back);
        exchange_btn = (Button) view.findViewById(R.id.cela_imtegral_exchange_button);
//        exchange_particulars_btn = (Button) view.findViewById(R.id.cela_imtegral_exchange_details);

        back.setOnClickListener(this);
        exchange_btn.setOnClickListener(this);
//        exchange_particulars_btn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cela_interal_exchange_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
//                startFragment(new MyCodeFragment());
                break;
            case R.id.cela_imtegral_exchange_button:
                getActivity().getSupportFragmentManager().popBackStack(null , 1);
                startFragment(new MainFragment());
                break;
//            case R.id.cela_imtegral_exchange_details:
//                ((MainActivity) getActivity()).goBack();//返回上一层页面
//                startFragment(new MyCodeFragment());
//                break;
        }
    }
}
