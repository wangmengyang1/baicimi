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
 * Created by Administrator on 2017/10/26.
 * 分享（分享到全球生活汇页面）
 */
public class UserCenterHomePageShardSDK extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private TextView publish;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_homepage_shardsdk , container , false);

        back = (ImageView) view.findViewById(R.id.usercenter_homepage_shardsdk_back);
        back.setOnClickListener(this);

        publish = (TextView) view.findViewById(R.id.usercenter_homepage_shardsdk_publish);
        publish.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_homepage_shardsdk_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.usercenter_homepage_shardsdk_publish:
                //发表成功
                startFragment(new UserCenterHomePageSucceed());
                break;
        }
    }
}
