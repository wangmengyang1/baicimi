package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.DistributionOrderGoodsEntry;
import com.baicimi.interfaces.DistributionNumberOnitemClick;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
public class DistributionOrderGoodsAdapter extends BaseAdapter{

    private Context context;
    private List<DistributionOrderGoodsEntry> list;
    private LayoutInflater inflater;
    private DistributionOrderGoodsHolder holder;

    private DistributionNumberOnitemClick distributionNOC;


    public DistributionOrderGoodsAdapter(Context context, List<DistributionOrderGoodsEntry> list  , DistributionNumberOnitemClick distributionNOC) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.distributionNOC = distributionNOC;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.distribution_order_good_adapter , null);
            holder = new DistributionOrderGoodsHolder();
            holder.lible = (TextView) view.findViewById(R.id.distribution_order_good_adapter_lible);
            holder.specification = (TextView) view.findViewById(R.id.distribution_order_good_adapter_specification);
            holder.imageUrl = (ImageView) view.findViewById(R.id.distribution_order_good_adapter_imageurl);
            holder.money = (TextView) view.findViewById(R.id.distribution_order_good_adapter_money);
            holder.number = (TextView) view.findViewById(R.id.distribution_order_good_adapter_number);
            holder.subtract = (ImageView) view.findViewById(R.id.distribution_order_good_adapter_subtract_image);
            holder.addNumber = (ImageView) view.findViewById(R.id.distribution_order_good_adapter_add_image);
            holder.linearLayout = (LinearLayout) view.findViewById(R.id.distribution_order_good_adapter_layout);


            view.setTag(holder);
        }else{
            holder = (DistributionOrderGoodsHolder) view.getTag();
        }

        DistributionOrderGoodsEntry init = (DistributionOrderGoodsEntry) getItem(i);


        if(i == 0){
            holder.linearLayout.setVisibility(View.VISIBLE);
        }else{
            holder.linearLayout.setVisibility(View.GONE);
        }

        holder.lible.setText(init.getLible());
        holder.specification.setText(init.getSpecification());
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.money.setText(init.getMoney());
        holder.number.setText(init.getNumber() + "");
        holder.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNOC.setNumberOnitemClick(view , i , R.id.distribution_order_good_adapter_subtract_image);
            }
        });
        holder.addNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNOC.setNumberOnitemClick(view , i ,R.id.distribution_order_good_adapter_add_image);
            }
        });


        holder.imageUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNOC.setNumberOnitemClick(view , i ,R.id.distribution_order_good_adapter_imageurl);
            }
        });


        return view;
    }



    public class DistributionOrderGoodsHolder{
        private TextView lible;
        private TextView specification;
        private ImageView imageUrl;
        private TextView money;
        private TextView number;
        private ImageView subtract;
        private ImageView addNumber;
        private LinearLayout linearLayout;


    }

}
