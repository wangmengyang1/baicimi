package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.baicimi.R;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
public class CustomViewCoverAdapter extends BaseAdapter{

    private List<Integer> list;
    private Context context;
    private LayoutInflater inflater;

    public CustomViewCoverAdapter(List<Integer> list, Context context) {
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
        CustomViewCoverHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.custom_view_cover_adapter , null);
            holder = new CustomViewCoverHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.custom_view_cover_imageurl);
            view.setTag(holder);
        }else{
            holder = (CustomViewCoverHolder) view.getTag();
        }

        holder.imageUrl.setImageResource(list.get(i));

        return view;
    }

    public class CustomViewCoverHolder{
        private ImageView imageUrl;
    }

}
