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
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ShoppingBagEntry;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */
public class ShoppingBagAdapter extends BaseAdapter{

    private List<ShoppingBagEntry> list;
    private Context context;
    private BaseFragment baseFragment;
    private LayoutInflater inflater;

    public ShoppingBagAdapter(List<ShoppingBagEntry> list, Context context, BaseFragment baseFragment) {
        this.list = list;
        this.context = context;
        this.baseFragment = baseFragment;
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
        ShoppingBagHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.shoppint_bag_adapter , null);
            holder = new ShoppingBagHolder();
            holder.checkBox = (CheckBox) view.findViewById(R.id.shoppint_bag_adapter_checkbox);
            holder.imageUrl = (ImageView) view.findViewById(R.id.shoppint_bag_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.shoppint_bag_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.shoppint_bag_adapter_content);
            holder.capacity = (TextView) view.findViewById(R.id.shoppint_bag_adapter_capacity);
            holder.inventory = (TextView) view.findViewById(R.id.shoppint_bag_adapter_inventory);
            holder.money = (TextView) view.findViewById(R.id.shoppint_bag_adapter_money);
            holder.count = (TextView) view.findViewById(R.id.shoppint_bag_adapter_count);
            holder.add = (ImageView) view.findViewById(R.id.shoppint_bag_adapter_add);
            holder.subtract = (ImageView) view.findViewById(R.id.shoppint_bag_adapter_subtract);

            view.setTag(holder);
        }else{
            holder = (ShoppingBagHolder) view.getTag();
        }

        ShoppingBagEntry init = (ShoppingBagEntry) getItem(i);


        holder.checkBox.setChecked(init.isStateDelte());
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.capacity.setText(init.getCapacity());
        holder.inventory.setText(init.getInventory());
        holder.money.setText(init.getMoney());
        holder.count.setText(init.getCount() + "");


        return view;
    }

    public class ShoppingBagHolder{
        private CheckBox checkBox;
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private TextView capacity;
        private TextView inventory;
        private TextView money;
        private TextView count;
        private ImageView add;
        private ImageView subtract;
    }

}
