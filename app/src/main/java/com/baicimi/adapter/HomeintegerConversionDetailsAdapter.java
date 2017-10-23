package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.HomeintegerConversionDetailsEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */
public class HomeintegerConversionDetailsAdapter extends BaseAdapter{

    private List<HomeintegerConversionDetailsEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public HomeintegerConversionDetailsAdapter(List<HomeintegerConversionDetailsEntry> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
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
        HomeintegerConversionDetailsHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.home_integer_conversion_details_adapter , null);
            holder = new HomeintegerConversionDetailsHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.home_integer_conversion_details_adapter_imageurl);
            holder.number = (TextView) view.findViewById(R.id.home_integer_conversion_details_adapter_number);
            holder.conversionDate = (TextView) view.findViewById(R.id.home_integer_conversion_details_adapter_vonversiondate);
            view.setTag(holder);
        }else{
            holder = (HomeintegerConversionDetailsHolder) view.getTag();
        }
        HomeintegerConversionDetailsEntry init = (HomeintegerConversionDetailsEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.number.setText(init.getNumber());
        holder.conversionDate.setText(init.getConversionDate());
        return view;
    }

    public class HomeintegerConversionDetailsHolder{
        private ImageView imageUrl;
        private TextView number;
        private TextView conversionDate;
    }

}
