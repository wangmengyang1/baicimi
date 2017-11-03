package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UserCenterMessageCenterEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */
public class UserCenterMessageCenterAdapter extends BaseAdapter{

    private List<UserCenterMessageCenterEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public UserCenterMessageCenterAdapter(List<UserCenterMessageCenterEntry> list, Context context) {
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
        UserCenterMessageCenterHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.usercenter_message_center_adapter , null);
            holder = new UserCenterMessageCenterHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.usercenter_message_center_adapter_userimage);
            holder.ischecked = (ImageView) view.findViewById(R.id.usercenter_message_center_adapter_ischecked);
            holder.name = (TextView) view.findViewById(R.id.usercenter_message_center_adapter_name);
            holder.lible = (TextView) view.findViewById(R.id.usercenter_message_center_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.usercenter_message_center_adapter_conent_ischecktrue);
            holder.contentFalse = (TextView) view.findViewById(R.id.usercenter_message_center_adapter_conent_ischeckfalse);
            holder.date = (TextView) view.findViewById(R.id.usercenter_message_center_adapter_date);

            view.setTag(holder);
        }else {
            holder = (UserCenterMessageCenterHolder) view.getTag();
        }
        UserCenterMessageCenterEntry init = (UserCenterMessageCenterEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.name.setText(init.getName());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.date.setText(init.getDate());


        return view;
    }

    public class UserCenterMessageCenterHolder{
        private ImageView imageUrl;
        private ImageView ischecked;
        private TextView name;
        private TextView lible;
        private TextView content;
        private TextView contentFalse;
        private TextView date;
    }

}
