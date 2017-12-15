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
 * //活期储蓄，查看详情 二级页面
 */
public class MiintegralbrankMyTFCdFirstSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_my_tf_cd_first_second , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_my_tf_cd_first_second_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_my_tf_cd_first_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
