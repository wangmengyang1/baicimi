package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UserCenterHelpCenterConsultEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */
public class UserCenterHelpCenterConsultAdapter extends BaseAdapter{

    private List<UserCenterHelpCenterConsultEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public UserCenterHelpCenterConsultAdapter(List<UserCenterHelpCenterConsultEntry> list, Context context) {
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
        UserCenterHelpCenterConsultHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.user_center_help_center_sonsult_adapter , null);
            holder = new UserCenterHelpCenterConsultHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.user_center_help_center_sonsult_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.user_center_help_center_sonsult_adapter_lible);
            view.setTag(holder);
        }else{
            holder = (UserCenterHelpCenterConsultHolder) view.getTag();
        }
        UserCenterHelpCenterConsultEntry init = (UserCenterHelpCenterConsultEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());

        return view;
    }

    public class UserCenterHelpCenterConsultHolder{
        private ImageView imageUrl;
        private TextView lible;
    }

}
