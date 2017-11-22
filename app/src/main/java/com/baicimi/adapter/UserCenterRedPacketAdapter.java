package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UserCenterRedPacketEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
public class UserCenterRedPacketAdapter extends BaseAdapter{

    private List<UserCenterRedPacketEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public UserCenterRedPacketAdapter(List<UserCenterRedPacketEntry> list, Context context) {
        this.list = list;
        this.context = context;
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
        UserCenterRedPacketHolder holder = null;

        if (view == null){
            view = inflater.inflate(R.layout.user_center_redpacket_adapter , null);
            holder = new UserCenterRedPacketHolder();
            holder.userName = (TextView) view.findViewById(R.id.user_center_redpacket_adapter_username);
            holder.date = (TextView) view.findViewById(R.id.user_center_redpacket_adapter_date);
            holder.money = (TextView) view.findViewById(R.id.user_center_redpacket_adapter_money);
            view.setTag(holder);
        }else {
            holder = (UserCenterRedPacketHolder) view.getTag();
        }

        UserCenterRedPacketEntry init = (UserCenterRedPacketEntry) getItem(i);


        holder.userName.setText(init.getUsername());
        holder.date.setText(init.getDate());
        holder.money.setText(init.getMoney());

        return view;
    }

    public class UserCenterRedPacketHolder{
        private TextView userName;
        private TextView date;
        private TextView money;
    }

}
