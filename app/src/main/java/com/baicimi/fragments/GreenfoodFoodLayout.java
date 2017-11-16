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
 * 绿色食品首页布局 绿色食品
 */
public class GreenfoodFoodLayout extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.green_food_food_layout , container  , false);

        back = (ImageView) view.findViewById(R.id.green_food_food_layout_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.green_food_food_layout_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
