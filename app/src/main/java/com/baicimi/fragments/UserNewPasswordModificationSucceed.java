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
 * Created by Administrator on 2017/11/28.
 *    //个人中心  密码找回 验证身份手机号验证+证件验证 新密码修改完成
 */
public class UserNewPasswordModificationSucceed extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView anewlogin;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_new_password_moditication_succeed , container , false);

        back = (ImageView) view.findViewById(R.id.user_new_password_moditication_succeed_back);
        back.setOnClickListener(this);

        anewlogin = (TextView) view.findViewById(R.id.user_new_password_moditication_succeed_anewlogin);
        anewlogin.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_new_password_moditication_succeed_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_new_password_moditication_succeed_anewlogin:
//                getActivity().getSupportFragmentManager().popBackStack(null , 1);
//                MainFragment mainFragment = new MainFragment();
////                mainFragment.selectFragment(new MainFragment().getFragments().get(3) , new MainFragment().getTags()[3]);
//                startFragment(mainFragment);

                break;
        }
    }
}
