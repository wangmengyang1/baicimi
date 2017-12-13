package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.baicimi.R;
import com.baicimi.entity.MPFileMyMyPictureEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public class MPFileMyMyPictureSecondAdapter extends BaseAdapter{

    private List<MPFileMyMyPictureEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MPFileMyMyPictureSecondAdapter(List<MPFileMyMyPictureEntry> list, Context context) {
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
        MPFileMyMyPictureSecondHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mp_file_mymy_picture_second_adapter , null);
            holder = new MPFileMyMyPictureSecondHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.mp_file_mymy_picture_second_adapter_image);
            holder.imagePen = (ImageView) view.findViewById(R.id.mp_file_mymy_picture_second_adapter_pen);
            holder.imageTag = (ImageView) view.findViewById(R.id.mp_file_mymy_picture_second_adapter_tag);

            view.setTag(holder);
        }else{
            holder = (MPFileMyMyPictureSecondHolder) view.getTag();
        }

        MPFileMyMyPictureEntry init = (MPFileMyMyPictureEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());

        return view;
    }

    public class MPFileMyMyPictureSecondHolder{
        private ImageView imageUrl;
        private ImageView imagePen;
        private ImageView imageTag;
    }

}
