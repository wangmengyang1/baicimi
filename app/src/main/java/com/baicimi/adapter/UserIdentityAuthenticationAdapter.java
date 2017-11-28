package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UserIdentityAuthenticationEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public class UserIdentityAuthenticationAdapter extends BaseAdapter{

    private List<UserIdentityAuthenticationEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public UserIdentityAuthenticationAdapter(List<UserIdentityAuthenticationEntry> list, Context context) {
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
        UserIdentityAuthenticationHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.user_identity_authentication_adapter , null);
            holder = new UserIdentityAuthenticationHolder();
            holder.lible = (TextView) view.findViewById(R.id.user_identity_authentication_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.user_identity_authentication_adapter_content);
            view.setTag(holder);
        }else{
            holder = (UserIdentityAuthenticationHolder) view.getTag();
        }

        holder.lible.setText(list.get(i).getLible());
        holder.content.setText(list.get(i).getContent());

        return view;
    }

    public class UserIdentityAuthenticationHolder{
        private TextView lible;
        private TextView content;
    }
}
