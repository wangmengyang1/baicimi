package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/15.
 * 了解幂银行储蓄
 */
public class MiIntegralBrankStorageFragmentThread extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_storage_fragmetn_thread , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_storage_fragmetn_thread_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_storage_fragmetn_thread_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
