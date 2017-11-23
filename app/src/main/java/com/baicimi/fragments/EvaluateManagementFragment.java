package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/23.
 * 个人中心 我的订单首页  评价管理
 */
public class EvaluateManagementFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private LinearLayout evaluate , logistics;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.evaluate_management_fragment , container , false);

        evaluate = (LinearLayout) view.findViewById(R.id.evaluate_management_fragment_evaluate);
        evaluate.setOnClickListener(this);

        logistics = (LinearLayout) view.findViewById(R.id.evaluate_management_fragment_logistics);
        logistics.setOnClickListener(this);

        back = (ImageView) view.findViewById(R.id.evaluate_management_fragment_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.evaluate_management_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.evaluate_management_fragment_evaluate:
                //宝贝评价
                startFragment(new RreasureEvaluateFragment());
                break;
            case R.id.evaluate_management_fragment_logistics:
                //物流评价
                startFragment(new LogisticsEvaluateFragment());
                break;
        }
    }
}
