package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.GreenfoodBoutiqueEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */
public class GreenfoodBoutiqueAdapter extends BaseAdapter{

    private List<GreenfoodBoutiqueEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public GreenfoodBoutiqueAdapter(List<GreenfoodBoutiqueEntry> list, Context context) {
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
        GreenfoodBoutiqueHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.green_food_boutique_adapter , null);
            holder = new GreenfoodBoutiqueHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.green_food_boutiqye_adapter_imageurl);
            holder.content = (TextView) view.findViewById(R.id.green_food_boutiqye_adapter_content);
            view.setTag(holder);
        }else{
            holder = (GreenfoodBoutiqueHolder) view.getTag();
        }

        GreenfoodBoutiqueEntry init = (GreenfoodBoutiqueEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.content.setText(init.getString());

        return view;
    }

    public class GreenfoodBoutiqueHolder{
        private ImageView imageUrl;
        private TextView content;
    }

}
