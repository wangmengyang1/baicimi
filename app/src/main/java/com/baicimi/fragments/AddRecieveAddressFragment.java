package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/12/22.
 * 添加收货地址
 */
public class AddRecieveAddressFragment extends BaseFragment {
    @ViewInject(R.id.ed_receive_man)
    private EditText editText_receive;
    @ViewInject(R.id.ed_receive_phone_num)
    private EditText editText_phone;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_add_address, container, false);
        return view;
    }

    @OnClick({R.id.login_back, R.id.save_address})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
            case R.id.save_address:
                if (editText_receive.getText().length() == 0) {
                    Toast.makeText(getContext(), "请输入收货人", Toast.LENGTH_SHORT).show();
                } else if (editText_phone.getText().length() == 0) {
                    Toast.makeText(getContext(), "请输入电话号码", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "地址保存成功", Toast.LENGTH_SHORT).show();
                    ((MainActivity) getActivity()).goBack();//返回上一层页面
                }
                break;
        }
    }

    @Override
    protected void initData() {

    }
}
