package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.PopularityViewGridView;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public class PopularityViewAdapter extends BaseAdapter{

    private List<PopularityViewGridView> list;
    private Context context;
    private LayoutInflater inflater;

    public PopularityViewAdapter(List<PopularityViewGridView> list, Context context) {
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
        PopularityHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.popularity_view_adapter , null);
            holder = new PopularityHolder();
            holder.image = (ImageView) view.findViewById(R.id.popularity_view_adapter_image);
            holder.lible = (TextView) view.findViewById(R.id.popularity_view_adapter_lible);
            holder.newmoney = (TextView) view.findViewById(R.id.popularity_view_adapter_newmoney);
            holder.oldmoney = (TextView) view.findViewById(R.id.popularity_view_adapter_oldmoney);
            holder.usershopping = (TextView) view.findViewById(R.id.popularity_view_adapter_usershopping);
            holder.shopping = (ImageView) view.findViewById(R.id.popularity_view_adapter_shopping);
            view.setTag(holder);
        }else{
            holder = (PopularityHolder) view.getTag();
        }
        PopularityViewGridView init = list.get(i);
        holder.image.setImageResource(init.getImageUri());
        holder.lible.setText(init.getLible());
        holder.newmoney.setText(init.getNewmoney());
        holder.oldmoney.setText(init.getOldmoney());
        holder.usershopping.setText(init.getUsershoping());


        return view;
    }

    public class PopularityHolder{
        private ImageView image;
        private TextView lible;
        private TextView newmoney;
        private TextView oldmoney;
        private TextView usershopping;
        private ImageView shopping;
    }
}
