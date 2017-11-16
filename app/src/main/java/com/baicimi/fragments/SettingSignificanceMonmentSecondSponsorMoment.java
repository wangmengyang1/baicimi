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
 * 个人中心，设置，人生重要时刻认证，发起认证界面
 */
public class SettingSignificanceMonmentSecondSponsorMoment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView bachelordom , love_bachelordom , getmarried_bachelordom , myorderform ,pregnancy , old_married_couple , treasuretreasuremomdad;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_significance_monment_second_sponsor_monent , container , false);
        back = (ImageView) view.findViewById(R.id.setting_significande_moment_second_fragment_back);
        back.setOnClickListener(this);

        bachelordom = (TextView) view.findViewById(R.id.setting_significance_monment_second_sponsor_monent_bachelordom);
        bachelordom.setOnClickListener(this);

        love_bachelordom = (TextView) view.findViewById(R.id.setting_significance_monment_second_sponsor_love_bachelordom);
        love_bachelordom.setOnClickListener(this);
        getmarried_bachelordom = (TextView) view.findViewById(R.id.setting_significance_monment_second_sponsor_getmarried_bachelordom);
        getmarried_bachelordom.setOnClickListener(this);
        myorderform = (TextView) view.findViewById(R.id.setting_significande_moment_second_fragment_myorderform);
        myorderform.setOnClickListener(this);

        pregnancy = (TextView) view.findViewById(R.id.setting_significande_moment_second_fragment_pregnancy);
        pregnancy.setOnClickListener(this);

        old_married_couple = (TextView) view.findViewById(R.id.setting_significande_moment_second_fragment_old_married_couple);
        old_married_couple.setOnClickListener(this);


        treasuretreasuremomdad = (TextView) view.findViewById(R.id.setting_significande_moment_second_fragment_treasuretreasuremomdad);
        treasuretreasuremomdad.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_significande_moment_second_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.setting_significance_monment_second_sponsor_monent_bachelordom:
                //单身认证
                startFragment(new BachelordomAttestationFragment());
                break;
            case R.id.setting_significance_monment_second_sponsor_love_bachelordom:
                //恋爱认证
                startFragment(new LoveAttestationFragment());
                break;
            case R.id.setting_significance_monment_second_sponsor_getmarried_bachelordom:
                //结婚认证
                startFragment(new GetMarriedAttestationFragment());
                break;
            case R.id.setting_significande_moment_second_fragment_myorderform:
                //备孕认证
                startFragment(new BeiYunMumFragment());
                break;
            case R.id.setting_significande_moment_second_fragment_pregnancy:
                //怀孕认证
                startFragment(new PregnancyFragment());
                break;
            case R.id.setting_significande_moment_second_fragment_old_married_couple:
                //老夫老妻认证
                startFragment(new OldMarriedCoupleFragment());
                break;
            case R.id.setting_significande_moment_second_fragment_treasuretreasuremomdad:
                //宝爸宝妈认证
                startFragment(new TreasuretreasuremomdadFragment());
                break;
        }
    }
}
