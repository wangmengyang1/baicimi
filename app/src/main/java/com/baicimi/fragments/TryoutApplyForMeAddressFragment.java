package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.TryoutApplyForMeAddressDialog;

/**
 * Created by Administrator on 2017/11/27.
 * 试用申请 我的试用申请 申请成功提交申请评价  免费使用收货地址填写
 */
public class TryoutApplyForMeAddressFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmess;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tryout_apply_forme_address_frgment, container , false);

        back = (ImageView) view.findViewById(R.id.tryout_apply_forme_address_frgment_back);
        back.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.tryout_apply_forme_address_frgment_dissmess);
        dissmess.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tryout_apply_forme_address_frgment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.tryout_apply_forme_address_frgment_dissmess:
                //试用申请提交成功弹窗
                TryoutApplyForMeAddressDialog tryoutApplyForMeAddressDialog = new TryoutApplyForMeAddressDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                tryoutApplyForMeAddressDialog.show();
                break;
        }
    }
}
