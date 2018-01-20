package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.UserCenterHomePagerSettingAddressManagerAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHomePagerSettingAddressManagerEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/20.
 * 个人中心，设置，个人信息界面 基本资料 管理收货地址
 */
public class SettingUserMessageBasicDateManagerAddress extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listView;
    private List<UserCenterHomePagerSettingAddressManagerEntry> list = new ArrayList<>();
    private UserCenterHomePagerSettingAddressManagerAdapter adapter;


    private TextView addAddress;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.settting_user_message_basic_date_manager_address , container , false);

        back = (ImageView) view.findViewById(R.id.settting_user_message_basic_date_manager_address_back);
        back.setOnClickListener(this);


        //listview布局填充
        initListView();

        addAddress = (TextView) view.findViewById(R.id.settting_user_message_basic_date_manager_address_addaddress);
        addAddress.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }



    private void initListView() {
        listView = (ListView) view.findViewById(R.id.settting_user_message_basic_date_manager_address_listview);
        list.clear();
        list.add(new UserCenterHomePagerSettingAddressManagerEntry("张三" , "1380000000"
                ,"中国广东省广州市广州市详细地址详细地址A大厦18F1808室     1380000000" , true ));
        list.add(new UserCenterHomePagerSettingAddressManagerEntry("张三" , "1380000000"
                ,"中国广东省广州市广州市详细地址详细地址A大厦18F1808室     1380000000" , false ));

        adapter = new UserCenterHomePagerSettingAddressManagerAdapter(list , getContext() , this);
        listView.setAdapter(adapter);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settting_user_message_basic_date_manager_address_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.settting_user_message_basic_date_manager_address_addaddress:
                //添加新地址
                startFragment(new UserCenterHomePagerSettingAddressManagerAddAddress());
                break;
        }
    }
}
