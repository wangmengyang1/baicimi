package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.AuthenticationEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ActuenticationAdapter extends BaseAdapter{

    private Context context;
    private List<AuthenticationEntry> list;
    private LayoutInflater inflater;


    public ActuenticationAdapter(Context context, List<AuthenticationEntry> list) {
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
        ActuenticationHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.actuentication_adapter , null);
            holder = new ActuenticationHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.actuentication_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.actuentication_adapter_lible);
            view.setTag(holder);
        }else{
            holder = (ActuenticationHolder) view.getTag();
        }

        AuthenticationEntry init = (AuthenticationEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());

        return view;
    }

    public class ActuenticationHolder{
        private ImageView imageUrl;
        private TextView lible;
    }

}
