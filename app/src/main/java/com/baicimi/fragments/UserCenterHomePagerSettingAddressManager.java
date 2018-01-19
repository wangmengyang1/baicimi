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
 * Created by Administrator on 2018/1/18.
 * 个人中心设置界面 地址管理
 */
public class UserCenterHomePagerSettingAddressManager extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<UserCenterHomePagerSettingAddressManagerEntry> list = new ArrayList<>();
    private UserCenterHomePagerSettingAddressManagerAdapter adapter;

    private ImageView back;
    private TextView addaddress;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_homepager_setting_address_manager , container , false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.user_center_homepager_setting_address_manager_back);
        back.setOnClickListener(this);


        addaddress = (TextView) view.findViewById(R.id.user_center_homepager_setting_address_manager_addaddress);
        addaddress.setOnClickListener(this);
        return view;
    }

    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_center_homepager_setting_address_manager_listview);
        list.clear();
        list.add(new UserCenterHomePagerSettingAddressManagerEntry("张三" , "1380000000"
                ,"中国广东省广州市广州市详细地址详细地址A大厦18F1808室     1380000000" , true ));
        list.add(new UserCenterHomePagerSettingAddressManagerEntry("张三" , "1380000000"
                ,"中国广东省广州市广州市详细地址详细地址A大厦18F1808室     1380000000" , false ));
        list.add(new UserCenterHomePagerSettingAddressManagerEntry("张三" , "1380000000"
                ,"中国广东省广州市广州市详细地址详细地址A大厦18F1808室     1380000000" , false ));
        list.add(new UserCenterHomePagerSettingAddressManagerEntry("张三" , "1380000000"
                ,"中国广东省广州市广州市详细地址详细地址A大厦18F1808室     1380000000" , false ));
        list.add(new UserCenterHomePagerSettingAddressManagerEntry("张三" , "1380000000"
                ,"中国广东省广州市广州市详细地址详细地址A大厦18F1808室     1380000000" , false ));


        adapter = new UserCenterHomePagerSettingAddressManagerAdapter(list , getContext() , this);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_homepager_setting_address_manager_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_center_homepager_setting_address_manager_addaddress:
                //添加收货地址
                startFragment(new UserCenterHomePagerSettingAddressManagerAddAddress());
                break;
        }
    }
}
