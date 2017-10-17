package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.HomepageHeadIntimacyEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
public class HomepageHeadIntimacyAdapter extends BaseAdapter{

    private List<HomepageHeadIntimacyEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public HomepageHeadIntimacyAdapter(List<HomepageHeadIntimacyEntry> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
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
        HomepageHeadIntemacyAdapterHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.homepage_head_intimacy_adapter , null);
            holder = new HomepageHeadIntemacyAdapterHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.homepage_head_intimacy_adapter_imageurl);
            holder.userName = (TextView) view.findViewById(R.id.homepage_head_intimacy_adapter_username);
            view.setTag(holder);
        }else {
            holder = (HomepageHeadIntemacyAdapterHolder) view.getTag();
        }

        HomepageHeadIntimacyEntry  init = (HomepageHeadIntimacyEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.userName.setText(init.getName());

        return view;
    }

    public class HomepageHeadIntemacyAdapterHolder{
        private ImageView imageUrl;
        private TextView userName;

    }

}
