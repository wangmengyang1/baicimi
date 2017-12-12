package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MPSystemGcMyPictureEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 */
public class MPSystemGcMyPictureAdapter extends BaseAdapter{

    private List<MPSystemGcMyPictureEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public MPSystemGcMyPictureAdapter(List<MPSystemGcMyPictureEntry> list, Context context) {
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
        MPSystemGcMyPictureHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mp_systemgc_my_picture_adapter , null);
            holder = new MPSystemGcMyPictureHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.mp_systemgc_my_picture_adapter_lible);
            holder.date = (TextView) view.findViewById(R.id.mp_systemgc_my_picture_adapter_date);
            holder.manager = (ImageView) view.findViewById(R.id.mp_systemgc_my_picture_adapter_manager);

            view.setTag(holder);
        }else{
            holder = (MPSystemGcMyPictureHolder) view.getTag();
        }

        holder.imageUrl.setImageResource(list.get(i).getImageUrl());
        holder.date.setText(list.get(i).getDate());

        return view;
    }

    public class MPSystemGcMyPictureHolder{
        private ImageView imageUrl;
        private TextView date;
        private ImageView manager;
    }

}
