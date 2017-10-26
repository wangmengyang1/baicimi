package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.FragmentInquireListEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class UserIntegerInquireListAdapter extends BaseAdapter{
    private List<FragmentInquireListEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public UserIntegerInquireListAdapter(List<FragmentInquireListEntry> list, Context context) {
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
        UserIntegerInquireHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.userinteger_inquire_list_adapter, null);
            holder = new UserIntegerInquireHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.userinteger_inquire_list_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.userinteger_inquire_list_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.userinteger_inquire_list_adapter_content);

            view.setTag(holder);
        }else {
            holder = (UserIntegerInquireHolder) view.getTag();
        }
        FragmentInquireListEntry init = (FragmentInquireListEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        return view;
    }

    public class UserIntegerInquireHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
    }

}
