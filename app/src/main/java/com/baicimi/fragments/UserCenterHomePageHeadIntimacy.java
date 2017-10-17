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
 * Created by Administrator on 2017/10/16.
 * 个人中心亲密付首页
 */
public class UserCenterHomePageHeadIntimacy extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private TextView explain , request , myorderform;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_homepagehead_intimacy , container , false);

        back = (ImageView) view.findViewById(R.id.usercenter_homepagehead_intimacy_fragment_back);
        back.setOnClickListener(this);

        explain = (TextView) view.findViewById(R.id.usercenter_homepagehead_intimacy_fragment_explain);
        explain.setOnClickListener(this);

        request = (TextView) view.findViewById(R.id.usercenter_homepagehead_intimacy_fragment_request);
        request.setOnClickListener(this);

        myorderform = (TextView) view.findViewById(R.id.usercenter_homepagehead_intimacy_fragment_myorderform);
        myorderform.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_homepagehead_intimacy_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.usercenter_homepagehead_intimacy_fragment_explain:
                //亲密付说明
                startFragment(new UserCenterHomepageHeadIntimacyExplain());
                break;
            case R.id.usercenter_homepagehead_intimacy_fragment_request:
                //发起亲密付
                startFragment(new UserCenterHomepageHeadIntimacyRequest());
                break;
            case R.id.usercenter_homepagehead_intimacy_fragment_myorderform:
                //我的亲密付订单
                startFragment(new UserCenterHomepageHeadIntimacyMyorderform());
                break;
        }
    }
}
