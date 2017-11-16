package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/15.
 * 个人中心，设置，人生重要时刻认证，发起认证界面  结婚认证界面
 */
public class GetMarriedAttestationFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.get_married_attestation_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.get_married_attestation_fragment_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get_married_attestation_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
