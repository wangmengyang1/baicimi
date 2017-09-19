package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.TodayCosmeticsEntry;
import com.baicimi.interfaces.DistributionNumberOnitemClick;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class TodayCosmeticsAdapter extends BaseAdapter{

    private Context context;
    private List<TodayCosmeticsEntry> list_lv;
    private LayoutInflater inflater;
    private DistributionNumberOnitemClick distributionNumberOnitemClick;
    public TodayCosmeticsAdapter(Context context, List<TodayCosmeticsEntry> list_lv , DistributionNumberOnitemClick distributionNumberOnitemClick) {
        this.context = context;
        this.list_lv = list_lv;
        inflater = LayoutInflater.from(context);
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
    }

    @Override
    public int getCount() {
        return list_lv.size();
    }

    @Override
    public Object getItem(int i) {
        return list_lv.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        TodayCosmeticsHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.today_cosmetics_adapter , null);
            holder = new TodayCosmeticsHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.today_cosmetics_adapter_imageurl);
            holder.discountsPrice = (TextView) view.findViewById(R.id.today_cosmetics_adapter_discountsPrice);
            holder.marketPrice = (TextView) view.findViewById(R.id.today_cosmetics_adapter_marketPrice);
            holder.content = (TextView) view.findViewById(R.id.today_cosmetics_adapter_content);
            holder.evaluate = (TextView) view.findViewById(R.id.today_cosmetics_adapter_evaluate);
            holder.goodReputation = (TextView) view.findViewById(R.id.today_cosmetics_adapter_goodreputation);
            holder.salesVolume = (TextView) view.findViewById(R.id.today_cosmetics_adapter_salesVolume);
            holder.number = (TextView) view.findViewById(R.id.today_cosmetics_adapter_number);
            holder.subtract = (ImageView) view.findViewById(R.id.today_cosmetics_adapter_subtract);
            holder.number = (TextView) view.findViewById(R.id.today_cosmetics_adapter_number);
            holder.add = (ImageView) view.findViewById(R.id.today_cosmetics_adapter_add);
            holder.shopcup = (ImageView) view.findViewById(R.id.today_cosmetics_adapter_shopcup);
            holder.immediatelyshop = (TextView) view.findViewById(R.id.today_cosmetics_adapter_immediatelyshop);

            view.setTag(holder);
        }else{
            holder = (TodayCosmeticsHolder) view.getTag();
        }
        TodayCosmeticsEntry init = (TodayCosmeticsEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.discountsPrice.setText(init.getDiscountsPrice());
        holder.marketPrice.setText(init.getMarketPrice());
        holder.content.setText(init.getContent());
        holder.evaluate.setText(init.getEvaluate());
        holder.goodReputation.setText(init.getGoodReputation());
        holder.salesVolume.setText(init.getSalesVolume());
        holder.number.setText(init.getBuyNumber() + "");
        holder.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.today_cosmetics_adapter_subtract);
            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.today_cosmetics_adapter_add);
            }
        });

        holder.shopcup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.today_cosmetics_adapter_shopcup);
            }
        });
        holder.immediatelyshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.today_cosmetics_adapter_immediatelyshop);
            }
        });

        holder.imageUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.today_cosmetics_adapter_imageurl);
            }
        });

        return view;
    }

    public class TodayCosmeticsHolder{
        private ImageView imageUrl;
        private TextView discountsPrice;
        private TextView marketPrice;
        private TextView content;
        private TextView evaluate;
        private TextView goodReputation;
        private TextView salesVolume;
        private ImageView subtract;
        private TextView number;
        private ImageView add;
        private ImageView shopcup;
        private TextView immediatelyshop;

    }

}
