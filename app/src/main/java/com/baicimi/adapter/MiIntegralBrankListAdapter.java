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
 * Created by Administrator on 2017/12/13.
 */
public class MiIntegralBrankListAdapter extends BaseAdapter{

    private List<AuthenticationEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MiIntegralBrankListAdapter(List<AuthenticationEntry> list, Context context) {
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
        MiIntegralBrankListHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_integral_brand_list_adapter , null);
            holder = new MiIntegralBrankListHolder();
            holder.lible = (TextView) view.findViewById(R.id.mi_integral_brand_list_adapter_lible);
            holder.imageUrl = (ImageView) view.findViewById(R.id.mi_integral_brand_list_adapter_imageurl);
            view.setTag(holder);
        }else{
            holder = (MiIntegralBrankListHolder) view.getTag();
        }

        holder.lible.setText(list.get(i).getLible());
        holder.imageUrl.setImageResource(list.get(i).getImageUrl());

        return view;
    }

    public class MiIntegralBrankListHolder{
        private TextView lible;
        private ImageView imageUrl;
    }

}
