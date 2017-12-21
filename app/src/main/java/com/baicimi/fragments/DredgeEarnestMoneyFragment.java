package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.PassWordEditText;

/**
 * Created by Administrator on 2017/12/21.
 * 个人中心首页 我的生活助手  幂额度首页 身份验证
 */
public class DredgeEarnestMoneyFragment extends BaseFragment implements View.OnClickListener  {

    private View view;

    private ImageView back;

    private PassWordEditText passWordEditText;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.dredge_earnest_money_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.dredge_earnest_money_fragment_back);
        back.setOnClickListener(this);

        passWordEditText = (PassWordEditText) view.findViewById(R.id.pw_et);
        passWordEditText.setOnTextEndListener(new PassWordEditText.OnTextEndListener() {
            @Override
            public void onTextEndListener(boolean state) {
                if (state){
                    startFragment(new SignContractSucceed());
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dredge_earnest_money_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }


}
