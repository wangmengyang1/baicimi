package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.NewPeoplePrefectureEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class NewPeoplePrefectureAdapter extends BaseAdapter{

    private List<NewPeoplePrefectureEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public NewPeoplePrefectureAdapter(List<NewPeoplePrefectureEntry> list, Context context) {
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
        NewPeoplePrefectureHolder holder = null;
        if (view ==null){
            view = inflater.inflate(R.layout.new_people_prefecture_adapter , null);
            holder = new NewPeoplePrefectureHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.new_people_prefecture_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.new_people_prefecture_adapter_lible);
            holder.number = (TextView) view.findViewById(R.id.new_people_prefecture_adapter_number);
            holder.integer = (TextView) view.findViewById(R.id.new_people_prefecture_adapter_integer);

            view.setTag(holder);
        }else{
            holder = (NewPeoplePrefectureHolder) view.getTag();
        }
        NewPeoplePrefectureEntry init = (NewPeoplePrefectureEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.number.setText(init.getNumber());
        holder.integer.setText(init.getInteger());

        return view;
    }

    public class NewPeoplePrefectureHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView number;
        private TextView integer;

    }

}
