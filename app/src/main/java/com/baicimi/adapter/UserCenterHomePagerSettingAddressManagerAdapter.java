package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHomePagerSettingAddressManagerEntry;
import com.baicimi.fragments.UserCenterHomePagerSettingAddressManagerAddAddress;
import com.baicimi.fragments.UserCenterHomePagerSettingAddressManagerCompileAddress;

import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 */
public class UserCenterHomePagerSettingAddressManagerAdapter extends BaseAdapter{

    private List<UserCenterHomePagerSettingAddressManagerEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private BaseFragment baseFragment;


    public UserCenterHomePagerSettingAddressManagerAdapter(List<UserCenterHomePagerSettingAddressManagerEntry> list, Context context, BaseFragment baseFragment) {
        this.list = list;
        this.context = context;
        this.baseFragment = baseFragment;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        UserCenterHomePagerSettingAddressManagerHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.user_center_home_page_setting_address_manager_adapter , null);
            holder = new UserCenterHomePagerSettingAddressManagerHolder();
            holder.name = (TextView) view.findViewById(R.id.user_center_home_page_setting_address_manager_adapter_name);
            holder.number = (TextView) view.findViewById(R.id.user_center_home_page_setting_address_manager_adapter_number);
            holder.address = (TextView) view.findViewById(R.id.user_center_home_page_setting_address_manager_adapter_address);
            holder.defaultCB = (CheckBox) view.findViewById(R.id.user_center_home_page_setting_address_manager_adapter_checkbox);
            holder.compile = (LinearLayout) view.findViewById(R.id.user_center_home_page_setting_address_manager_adapter_compile);
            holder.delete = (LinearLayout) view.findViewById(R.id.user_center_home_page_setting_address_manager_adapter_delete);

            view.setTag(holder);

        }else{
            holder = (UserCenterHomePagerSettingAddressManagerHolder) view.getTag();
        }

        UserCenterHomePagerSettingAddressManagerEntry init = (UserCenterHomePagerSettingAddressManagerEntry) getItem(i);


        holder.name.setText(init.getName());
        holder.number.setText(init.getNumber());
        holder.address.setText(init.getAddress());


        if (init.ischeck()){
            holder.defaultCB.setChecked(true);
        }else{
            holder.defaultCB.setChecked(false);
        }

        //编辑收货地址
        holder.compile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baseFragment != null){

                    baseFragment.startFragment(new UserCenterHomePagerSettingAddressManagerCompileAddress());
                }
            }
        });


        return view;
    }

    public class UserCenterHomePagerSettingAddressManagerHolder{
        private TextView name;
        private TextView number;
        private TextView address;
        private CheckBox defaultCB;
        private LinearLayout compile;
        private LinearLayout delete;
    }

}
