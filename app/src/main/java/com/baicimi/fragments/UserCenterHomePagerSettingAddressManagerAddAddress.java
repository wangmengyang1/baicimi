package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/19.
 * 个人中心设置界面 地址管理 添加收货地址
 */
public class UserCenterHomePagerSettingAddressManagerAddAddress extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private RelativeLayout saveAddress;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_homepager_setting_address_manager_addaddress , container , false);
        back = (ImageView) view.findViewById(R.id.user_center_homepager_setting_address_manager_addaddress_back);
        back.setOnClickListener(this);

        saveAddress = (RelativeLayout) view.findViewById(R.id.user_center_homepager_setting_address_manager_addaddress_saveaddress);
        saveAddress.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_homepager_setting_address_manager_addaddress_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_center_homepager_setting_address_manager_addaddress_saveaddress:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
