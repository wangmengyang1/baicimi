package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/17.
 * 个人中心  政府采购详情支付页面 提交订单（自取货）
 */
public class SelfHelpClaimGoods extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.self_help_claim_goods , container , false);

        back = (ImageView) view.findViewById(R.id.self_help_claim_goods_back);
        back.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.self_help_claim_goods_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面

                break;
        }
    }
}
