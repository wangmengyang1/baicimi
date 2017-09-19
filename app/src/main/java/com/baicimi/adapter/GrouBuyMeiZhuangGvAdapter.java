package com.baicimi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.GrouBuyMeiZhuangGvBean;

import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class GrouBuyMeiZhuangGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<GrouBuyMeiZhuangGvBean> mList;
    private LayoutInflater mLayoutInflater;

    public GrouBuyMeiZhuangGvAdapter(Context context, List<GrouBuyMeiZhuangGvBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.groubuy_meizhuang_gv_item, null);

            mViewHolder.tv_goods_name = (TextView) convertView.findViewById(R.id.groubuy_goods_name);
            mViewHolder.use_price = (TextView) convertView.findViewById(R.id.use_price);
            mViewHolder.persaon_groubuy_price = (TextView) convertView.findViewById(R.id.persaon_groubuy_price);
            mViewHolder.groubuy_price = (TextView) convertView.findViewById(R.id.groubuy_price);
            mViewHolder.imageUrl = (ImageView) convertView.findViewById(R.id.groubuy_goods_img);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_name.setSelected(true);
        mViewHolder.tv_goods_name.setText(mList.get(position).getName());
        mViewHolder.use_price.setText(mList.get(position).getUsed_price());
        mViewHolder.persaon_groubuy_price.setText(mList.get(position).getPerson_groubuy_price());
        mViewHolder.groubuy_price.setText(mList.get(position).getGroubuy_price());
        mViewHolder.imageUrl.setImageResource(mList.get(position).getImageUrl());
        return convertView;
    }

    class ViewHolder {
        private TextView tv_goods_name;
        private TextView use_price;
        private TextView persaon_groubuy_price;
        private TextView groubuy_price;
        private ImageView imageUrl;
    }
}
