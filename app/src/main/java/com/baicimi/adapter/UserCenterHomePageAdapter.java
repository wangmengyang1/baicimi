package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UserCenterHomePageEntryFirst;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */
public class UserCenterHomePageAdapter extends BaseAdapter{

    private Context context;
    private List<UserCenterHomePageEntryFirst> list;
    private LayoutInflater inflater;

    public UserCenterHomePageAdapter(Context context, List<UserCenterHomePageEntryFirst> list) {
        this.context = context;
        this.list = list;
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
        UserCenterHomePageHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.user_center_home_page_adapter , null);
            holder = new UserCenterHomePageHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.user_center_home_page_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.user_center_home_page_adapter_lbile);
            view.setTag(holder);
        }else{
            holder = (UserCenterHomePageHolder) view.getTag();
        }

        UserCenterHomePageEntryFirst init = (UserCenterHomePageEntryFirst) getItem(i);

        Glide.with(context)
                .load(init.getImageUrl())
                .into(holder.imageUrl);

//        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());

        return view;
    }

    public class UserCenterHomePageHolder{
        private ImageView imageUrl;
        private TextView lible;
    }
}
