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
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.HomePageBrandButtonViewPager;
import com.baicimi.fragments.BrandFragmentSecond;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.interfaces.DistributionNumberOnitemClickVP;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
public class HomePageViewButtonAdapte extends BaseAdapter{

    private Context context;
    private List<HomePageBrandButtonViewPager> list;
    private LayoutInflater inflater;
    private DistributionNumberOnitemClickVP distributionNumberOnitemClick;
    private BaseFragment baseFragment;

    public HomePageViewButtonAdapte(Context context, List<HomePageBrandButtonViewPager> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public HomePageViewButtonAdapte(Context context, List<HomePageBrandButtonViewPager> list, DistributionNumberOnitemClickVP distributionNumberOnitemClick) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
    }

    public HomePageViewButtonAdapte(Context context, List<HomePageBrandButtonViewPager> list, DistributionNumberOnitemClickVP distributionNumberOnitemClick, BaseFragment baseFragment) {
        this.context = context;
        this.list = list;
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        HomePageViewButtonHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.home_page_view_button_adapter , null);
            holder = new HomePageViewButtonHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.home_page_view_button_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.home_page_view_button_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.home_page_view_button_adapter_content);
            holder.attention = (TextView) view.findViewById(R.id.home_page_view_button_adapter_attention);
            holder.imageLible = (ImageView) view.findViewById(R.id.home_page_view_button_adapter_imagelabel);
            holder.linearLayout = (LinearLayout) view.findViewById(R.id.home_page_view_button_adapter_layout_tag);
            holder.button_layout = (LinearLayout) view.findViewById(R.id.home_page_view_button_layout);
            holder.eylt_attention = (TextView) view.findViewById(R.id.home_page_view_button_adapter_eylt_attention_tv);
            view.setTag(holder);
        }else{
            holder = (HomePageViewButtonHolder) view.getTag();
        }

        HomePageBrandButtonViewPager init = (HomePageBrandButtonViewPager) getItem(i);
//        holder.imageUrl.setImageResource(init.getImageUrl());
      Glide.with(context)
              .load(init.getImageUrl())
              .into(holder.imageUrl);
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.attention.setText(init.getAttention() + "");
//        holder.imageLible.setImageResource(init.getLibleImager());
//        Glide.with(context)
//                .load(init.getLibleImager())
//                .into(holder.imageLible);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(distributionNumberOnitemClick != null){
                   distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.home_page_view_button_adapter_layout_tag , HomePageViewButtonAdapte.this);
                }
            }
        });
        holder.button_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.home_page_view_button_layout , HomePageViewButtonAdapte.this);
            }
        });
        holder.eylt_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , i , R.id.home_page_view_button_adapter_eylt_attention_tv , HomePageViewButtonAdapte.this);
            }
        });

        holder.imageLible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(baseFragment != null){
                    baseFragment.startFragment(new BrandFragmentSecond());
                }
            }
        });

        return view;
    }

    public class HomePageViewButtonHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private TextView attention;
        private ImageView imageLible;
        private LinearLayout linearLayout;
        private LinearLayout button_layout;
        private TextView eylt_attention;

    }

}
