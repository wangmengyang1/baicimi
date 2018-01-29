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
 * Created by Administrator on 2018/1/29.
 * 个人中心  我的生活助手  亲密付首页
 */
public class IntimacyPayHomeFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private TextView myIntimacyPay;
    private TextView explainIntimacyPay;
    private TextView IntimacyPay;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.intimacy_pay_home_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.intimacy_pay_home_fragment_back);
        back.setOnClickListener(this);

        myIntimacyPay = (TextView) view.findViewById(R.id.intimacy_pay_home_fragment_myorderform);
        explainIntimacyPay = (TextView) view.findViewById(R.id.intimacy_pay_home_fragment_paymentagency);
        IntimacyPay = (TextView) view.findViewById(R.id.intimacy_pay_home_fragment_readly);

        myIntimacyPay.setOnClickListener(this);
        explainIntimacyPay.setOnClickListener(this);
        IntimacyPay.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.intimacy_pay_home_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.intimacy_pay_home_fragment_myorderform:
                //我的亲密付
                startFragment(new MyIntimacyPayFragment());
                break;
            case R.id.intimacy_pay_home_fragment_paymentagency:
                //亲密付说明
                startFragment(new ExplainIntimacyPayFragment());
                break;
            case R.id.intimacy_pay_home_fragment_readly:
                //发起亲密付
                startFragment(new UserCenterHomepageHeadIntimacyRequest());
                break;
        }
    }
}
