package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/8/16.
 */

public class IntimacyPaymentDredgeSucceedFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private TextView succeed;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.intimacy_payment_dredge_succeed_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.back_intimacy_payment_dredge_succeed);
        back.setOnClickListener(this);

        succeed = (TextView) view.findViewById(R.id.intimacy_payment_dedge_succeed_textivew);
        succeed.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_intimacy_payment_dredge_succeed:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.intimacy_payment_dedge_succeed_textivew:
//                getActivity().getSupportFragmentManager().popBackStack(null , 1);
                startFragment(new IntimacyPaymentUserMessageFragment());
//                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;

        }
    }
}
