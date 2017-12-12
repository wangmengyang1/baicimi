package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MPNewBookEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 */
public class MPNewBookAdapter extends BaseAdapter{

    private List<MPNewBookEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MPNewBookAdapter(List<MPNewBookEntry> list, Context context) {
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
        MPNewBookHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mp_new_book_adapter , null);
            holder = new MPNewBookHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.mp_new_book_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.mp_new_book_adapter_newbook);
            view.setTag(holder);
        }else{
            holder = (MPNewBookHolder) view.getTag();
        }

        holder.imageUrl.setImageResource(list.get(i).getImageUrl());
        holder.lible.setText(list.get(i).getLible());

        return view;
    }

    public class MPNewBookHolder{
        private ImageView imageUrl;
        private TextView lible;
    }

}
