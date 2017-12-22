package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.ImmediatelyChangeEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */
public class ImmediatelyChangeAdapter extends BaseAdapter{

    private List<ImmediatelyChangeEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public ImmediatelyChangeAdapter(List<ImmediatelyChangeEntry> list, Context context) {
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
        ImmediatelyChangeHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.immediately_change_adapter , null);
            holder = new ImmediatelyChangeHolder();

            holder.imageUrl = (ImageView) view.findViewById(R.id.immediately_change_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.immediately_change_adapter_lible);
            holder.numberCode = (TextView) view.findViewById(R.id.immediately_change_adapter_numbercode);

            view.setTag(holder);
        }else{
            holder = (ImmediatelyChangeHolder) view.getTag();

        }

        ImmediatelyChangeEntry init = (ImmediatelyChangeEntry) getItem(i);


        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.numberCode.setText(init.getNumberCode());

        return view;
    }

    public class ImmediatelyChangeHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView numberCode;
    }

}
