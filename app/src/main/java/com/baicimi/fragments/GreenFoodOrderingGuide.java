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
 * 绿色食品，立即预定，订购指南
 */
public class GreenFoodOrderingGuide extends BaseFragment implements View.OnClickListener {

    private ImageView back;
    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.green_food_ordering_guide , container , false);

        back = (ImageView) view.findViewById(R.id.green_food_ordering_guide_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.green_food_ordering_guide_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
