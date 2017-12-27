package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/27.
 * 个人中心-会员中心-会员积分-去看看
 */
public class UserInregralInquireListAdapterLook extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_integral_inquire_list_adapter, container, false);

        back = (ImageView) view.findViewById(R.id.user_integral_inquire_list_adapter_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_integral_inquire_list_adapter_back:
                ((MainActivity) getActivity()).goBack();
                break;
        }
    }
}
