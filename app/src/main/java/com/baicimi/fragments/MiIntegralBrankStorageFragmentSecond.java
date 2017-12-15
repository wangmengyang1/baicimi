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
 *  //了解存储利率
 */
public class MiIntegralBrankStorageFragmentSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_storage_fragmetn_second , container ,false);
        back = (ImageView) view.findViewById(R.id.mi_integral_brank_storage_fragmetn_second_back);
        back.setOnClickListener(this);
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_storage_fragmetn_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
