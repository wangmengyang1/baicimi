package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.baicimi.R;
import com.baicimi.entity.TryoutApplyForFragmentSecondEntry;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/27.
 */
public class TryoutApplyForFragmentSecondAdapter extends BaseAdapter{

    private ArrayList<TryoutApplyForFragmentSecondEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public TryoutApplyForFragmentSecondAdapter(ArrayList<TryoutApplyForFragmentSecondEntry> list, Context context) {
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
        TryoutApplyForFragmentSecondHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.tryout_apply_for_fragment_second_adapter , null);
            holder = new TryoutApplyForFragmentSecondHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.tryout_apply_for_fragment_second_adapter_imageurl);
            holder.userImage = (ImageView) view.findViewById(R.id.tryout_apply_for_fragment_second_adapter_userimage);

            view.setTag(holder);
        }else{
            holder = (TryoutApplyForFragmentSecondHolder) view.getTag();
        }

        holder.imageUrl.setImageResource(list.get(i).getImageUrl());
        holder.userImage.setImageResource(list.get(i).getUserImage());

        return view;
    }

    public class TryoutApplyForFragmentSecondHolder{
        private ImageView imageUrl;
        private ImageView userImage;
    }

}
