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
 * 个人中心，设置，人生重要时刻认证
 */
public class SettingSignificanceMoment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView sponsorMoment;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_significande_moment , container , false);
        back = (ImageView) view.findViewById(R.id.setting_significande_moment_fragment_back);
        back.setOnClickListener(this);

        sponsorMoment = (TextView) view.findViewById(R.id.setting_significande_moment_fragment_myorderform);
        sponsorMoment.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_significande_moment_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.setting_significande_moment_fragment_myorderform:
                //发起认证
                startFragment(new SettingSignificanceMonmentSecondSponsorMoment());
                break;

        }
    }
}
