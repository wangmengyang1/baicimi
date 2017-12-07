package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页 赛事活动 7天习惯养成
 */
public class FootPaintActivitySevenFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.foot_paint_activity_seven_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.foot_paint_fragment_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.foot_paint_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
