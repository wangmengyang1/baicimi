package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.fragments.TallyBookDetailEntry;

import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */
public class TallyBookDetailAdater extends BaseAdapter{
    private List<TallyBookDetailEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public TallyBookDetailAdater(List<TallyBookDetailEntry> list, Context context) {
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
        TallyBookDetailHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.tally_book_datail_adapter , null);
            holder = new TallyBookDetailHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.tally_book_datail_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.tally_book_datail_adapter_lible);
            holder.money = (TextView) view.findViewById(R.id.tally_book_datail_adapter_money);

            view.setTag(holder);
        }else{
            holder = (TallyBookDetailHolder) view.getTag();
        }

        TallyBookDetailEntry init = (TallyBookDetailEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.money.setText(init.getMoney());

        return view;
    }

    public class TallyBookDetailHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView money;
    }

}
