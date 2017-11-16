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
 * 个人中心，设置，人生重要时刻认证，发起认证界面  宝爸宝妈认证界面
 */
public class TreasuretreasuremomdadFragment extends BaseFragment implements View.OnClickListener {

    private ImageView back;
    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.treasure_treasure_mom_dad_fagment , container , false);
        back = (ImageView) view.findViewById(R.id.treasure_treasure_mom_dad_fagment_back);
        back.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.treasure_treasure_mom_dad_fagment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
