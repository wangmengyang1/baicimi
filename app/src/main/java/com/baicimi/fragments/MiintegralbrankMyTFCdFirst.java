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
 * Created by Administrator on 2017/12/15.
 *   //活期储蓄，查看详情
 */
public class MiintegralbrankMyTFCdFirst extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView cdfirst;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_my_tf_cd_first , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_my_tf_cd_first_back);
        back.setOnClickListener(this);

        cdfirst = (TextView) view.findViewById(R.id.mi_integral_brank_my_tf_cd_first_cdfirst);
        cdfirst.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_my_tf_cd_first_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_my_tf_cd_first_cdfirst:
                //查看详情
                startFragment(new MiintegralbrankMyTFCdFirstSecond());
                break;
        }
    }
}
