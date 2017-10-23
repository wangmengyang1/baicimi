package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.HomeintegerHotbrandEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */
public class HomeintegerHotbrandAdapter extends BaseAdapter{

    private List<HomeintegerHotbrandEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public HomeintegerHotbrandAdapter(List<HomeintegerHotbrandEntry> list, Context context) {
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
        HomeintegerHotbradnHolder holder;
        if (view == null){
            view = inflater.inflate(R.layout.home_integer_hotbrand_adapter , null);
            holder = new HomeintegerHotbradnHolder();
            holder.lible = (TextView) view.findViewById(R.id.home_integer_hotbrand_adapter_lible);
            holder.layout = (LinearLayout) view.findViewById(R.id.home_integer_hotbrand_adapter_layout);

            view.setTag(holder);
        }else{
            holder = (HomeintegerHotbradnHolder) view.getTag();
        }

        HomeintegerHotbrandEntry init = (HomeintegerHotbrandEntry) getItem(i);


        holder.lible.setText(init.getLible());
        for (int l = 0 ; l < init.getList().size() ; l++){
            View itmeView = LayoutInflater.from(context).inflate(R.layout.home_integer_hot_brand_adapter_item , null);
            ImageView imageView = (ImageView) itmeView.findViewById(R.id.home_integer_hot_brand_adapter_item_image);
            imageView.setImageResource(init.getList().get(l));
            holder.layout.addView(itmeView);
        }

        return view;
    }

    public class HomeintegerHotbradnHolder{
        private TextView lible;
        private LinearLayout layout;
    }

}
