package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */
public class HomeIntegerFreeGiftAdapter extends BaseAdapter{

    private List<HomeIntegerFreeGiftEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public HomeIntegerFreeGiftAdapter(List<HomeIntegerFreeGiftEntry> list, Context context) {
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
        HomeIntegerFreeGiftHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.home_integer_free_gift_adapter , null);
            holder = new HomeIntegerFreeGiftHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.home_integer_free_gift_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_lible);
            holder.money = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_money);
            holder.integerNumber = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_integer);
            holder.number = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_number);
            holder.details = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_details);
            holder.rule = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_rule);
            holder.immediately = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_immediately);
            holder.layout_lible = (TextView) view.findViewById(R.id.home_integer_free_gift_adapter_layout_lible);
            view.setTag(holder);
        }else{
            holder = (HomeIntegerFreeGiftHolder) view.getTag();
        }

        HomeIntegerFreeGiftEntry init = (HomeIntegerFreeGiftEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.money.setText(init.getMoney());
        holder.integerNumber.setText(init.getIntegerNumber());
        holder.number.setText(init.getNumber());

//        holder.layout_lible.setText(init.getLible());

        if (!(init.getHeadLible().equals("ischeck"))){
            holder.layout_lible.setVisibility(View.VISIBLE);
            holder.layout_lible.setText(init.getHeadLible());
        }else {
            holder.layout_lible.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    public class HomeIntegerFreeGiftHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView money;
        private TextView integerNumber;
        private TextView number;
        private TextView details;
        private TextView rule;
        private TextView immediately;
        private TextView layout_lible;
    }

}
