package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/29.
 * 个人中心  我的生活助手  亲密付首页 亲密付说明
 */
public class ExplainIntimacyPayFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.explain_intimacy_pay_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.explain_intimacy_pay_fragment_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.explain_intimacy_pay_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
