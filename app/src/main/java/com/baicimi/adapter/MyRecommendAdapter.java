package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MyRecommendEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */
public class MyRecommendAdapter extends BaseAdapter{

    private List<MyRecommendEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MyRecommendAdapter(List<MyRecommendEntry> list, Context context) {
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
        MyRecommendHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.my_recommend_adapter , null);
            holder = new MyRecommendHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.my_recommend_adapter_imagurl);
            holder.lible = (TextView) view.findViewById(R.id.my_recommend_adapter_lible);
            holder.money = (TextView) view.findViewById(R.id.my_recommend_adapter_money);
            holder.code = (TextView) view.findViewById(R.id.my_recommend_adapter_code);
            holder.userNumber = (TextView) view.findViewById(R.id.my_recommend_adapter_usernumber);
            holder.conversion = (TextView) view.findViewById(R.id.my_recommend_adapter_conversion);

            view.setTag(holder);
        }else {
            holder = (MyRecommendHolder) view.getTag();
        }

        MyRecommendEntry init = (MyRecommendEntry) getItem(i);


        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.money.setText(init.getMoney());
        holder.code.setText(init.getCode());
        holder.userNumber.setText(init.getUserNumber());


        return view;
    }

    public class MyRecommendHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView money;
        private TextView code;
        private TextView userNumber;
        private TextView conversion;//兑换
    }

}
