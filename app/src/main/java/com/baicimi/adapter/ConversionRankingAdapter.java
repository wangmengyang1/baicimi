package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.ConversionRankingEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */
public class ConversionRankingAdapter extends BaseAdapter{
    private List<ConversionRankingEntry> listFirst;
    private Context context;
    private LayoutInflater inflater;
    private boolean isCheck;
    private ConversionRankingHolder holder;

    public ConversionRankingAdapter(List<ConversionRankingEntry> listFirst, Context context) {
        this.listFirst = listFirst;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public ConversionRankingAdapter(List<ConversionRankingEntry> listFirst, Context context, boolean isCheck) {
        this.listFirst = listFirst;
        this.context = context;
        this.isCheck = isCheck;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listFirst.size();
    }

    @Override
    public Object getItem(int i) {
        return listFirst.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.conversion_ranking_adapter , null);
            holder = new ConversionRankingHolder();
            holder.imagerUrl = (ImageView) view.findViewById(R.id.conversion_ranking_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.conversion_ranking_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.conversion_ranking_adapter_content);
            holder.addAttention = (TextView) view.findViewById(R.id.conversion_ranking_adapter_addattention);

            view.setTag(holder);
        }else{
            holder = (ConversionRankingHolder) view.getTag();
        }

        ConversionRankingEntry init = (ConversionRankingEntry) getItem(i);

        if (isCheck){
            holder.addAttention.setVisibility(View.VISIBLE);
        }else {
            holder.addAttention.setVisibility(View.GONE);
        }

        holder.imagerUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());


        if (listFirst.get(i).isState()){
            holder.addAttention.setText("已关注");
        }else {
            holder.addAttention.setText("+关注");
        }


        holder.addAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((ConversionRankingEntry) getItem(i)).isState() == true){
                    holder.addAttention.setText("已关注");
                    listFirst.get(i).setState(!listFirst.get(i).isState());
                    notifyDataSetChanged();
                }else {
                    holder.addAttention.setText("+关注");
                    listFirst.get(i).setState(!listFirst.get(i).isState());
                    notifyDataSetChanged();
                }
            }
        });


        return view;
    }

    public class ConversionRankingHolder{
        private ImageView imagerUrl;
        private TextView lible;
        private TextView content;
        private TextView addAttention;

    }

}
