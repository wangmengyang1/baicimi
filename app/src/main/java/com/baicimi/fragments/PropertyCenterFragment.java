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
 * 个人中心我的资产界面
 */

public class PropertyCenterFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView miWallet;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.property_center_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.property_center_fragment_back);
        back.setOnClickListener(this);

        miWallet = (TextView) view.findViewById(R.id.property_center_fragment_myorderform);
        miWallet.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.property_center_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.property_center_fragment_myorderform:
                //幂钱包界面
                startFragment(new PropertyCenterSecondMiWallet());
                break;
        }
    }
}
