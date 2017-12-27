package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/27.
 * 分享（分享到全球生活汇页面） 分享成功
 */
public class UserCenterHomePageSucceed extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_homepage_succeed , container ,  false);

        back = (ImageView) view.findViewById(R.id.user_center_homepage_succeed_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_homepage_succeed_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
