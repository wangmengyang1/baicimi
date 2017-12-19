package com.baicimi.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.LoveDonateFragmentEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class LoveDonateFragmentGirdAdapter extends BaseAdapter{

    private List<LoveDonateFragmentEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public LoveDonateFragmentGirdAdapter(List<LoveDonateFragmentEntry> listSecond, Context context) {
        this.list = listSecond;
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
        LoveDonateFragmentGirdHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.love_donate_fragment_grid_adpater , null);
            holder = new LoveDonateFragmentGirdHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.love_donate_fragment_grid_adpater_imageurl);
            view.setTag(holder);
        }else{
            holder = (LoveDonateFragmentGirdHolder) view.getTag();
        }
        LoveDonateFragmentEntry init = (LoveDonateFragmentEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());

        return view;
    }

    public class LoveDonateFragmentGirdHolder{
        private TextView address;
        private ImageView imageUrl;
        private TextView lible;

    }
}
