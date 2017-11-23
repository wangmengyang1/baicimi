package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.fragments.RreasureEvaluateFragmentEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class RreasureEvaluateFragmentAdapte extends BaseAdapter{

    private List<RreasureEvaluateFragmentEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public RreasureEvaluateFragmentAdapte(List<RreasureEvaluateFragmentEntry> list, Context context) {
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
        RreasureEvaluateFragmentHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.rreasure_evaluate_fragment_adapter , null);
            holder = new RreasureEvaluateFragmentHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.rreasure_evaluate_fragment_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.rreasure_evaluate_fragment_adapter_lible);
            holder.date = (TextView) view.findViewById(R.id.rreasure_evaluate_fragment_adapter_date);

            view.setTag(holder);
        }else {
            holder = (RreasureEvaluateFragmentHolder) view.getTag();
        }

        holder.imageUrl.setImageResource(list.get(i).getImageUrl());
        holder.lible.setText(list.get(i).getLible());
        holder.date.setText(list.get(i).getDate());

        return view;
    }

    public class RreasureEvaluateFragmentHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView date;
    }

}
