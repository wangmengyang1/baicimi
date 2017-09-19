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
import com.baicimi.entity.TryoutApplyForEntry;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */
public class TryoutApplyForAdapter extends BaseAdapter{

    private Context context;
    private List<TryoutApplyForEntry> list;
    private LayoutInflater inflater;
    private DistributionNumberOnitemClick distributionNumberOnitemClick;

    public TryoutApplyForAdapter(Context context, List<TryoutApplyForEntry> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public TryoutApplyForAdapter(Context context, List<TryoutApplyForEntry> list,  DistributionNumberOnitemClick distributionNumberOnitemClick) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
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
        TryoutApplyForHolder holder;
        if(view == null){
            view = inflater.inflate(R.layout.tryoutapply_for_adapter_fragment , null);
            holder = new TryoutApplyForHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.horizontallayout_item_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.horizontallayout_item_adapter_lible);
            holder.newMoney = (TextView) view.findViewById(R.id.horizontallayout_item_adapter_newmoney);
            holder.content = (TextView) view.findViewById(R.id.horizontallayout_item_adapter_number);
            holder.linearLayout = (LinearLayout) view.findViewById(R.id.tryoutapply_for_adapter_fragment_layout);
            holder.tagNumber = (TextView) view.findViewById(R.id.tryoutapply_for_adapter_fragment_tagnumber_tv);
            view.setTag(holder);
        }else{
            holder = (TryoutApplyForHolder) view.getTag();
        }

        TryoutApplyForEntry init = (TryoutApplyForEntry) getItem(i);
        Glide.with(context)
                .load(R.drawable.tyrout_applyfor_fragment_image_09)
                .into(holder.imageUrl);

//        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.newMoney.setText(init.getNewMoney());
        holder.content.setText(init.getNumber());
        holder.tagNumber.setText(init.getTagNumber() + "");
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(distributionNumberOnitemClick != null){
                    distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.tryoutapply_for_adapter_fragment_layout);
                }
            }
        });

        return view;
    }

    public class TryoutApplyForHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView newMoney;
        private TextView content;
        private LinearLayout linearLayout;
        private TextView tagNumber;

    }

}
