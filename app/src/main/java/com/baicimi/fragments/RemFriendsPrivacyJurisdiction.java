package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/27.
 * 个人中心  设置  隐私设置  推荐好友权限
 */
public class RemFriendsPrivacyJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rem_friends_privacy_jurisdiction , container , false);

        back = (ImageView) view.findViewById(R.id.rem_friends_privacy_jurisdiction_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rem_friends_privacy_jurisdiction_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
