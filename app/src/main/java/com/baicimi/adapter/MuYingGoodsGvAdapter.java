package com.baicimi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.MuYingYongPinGridViewBean;

import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class MuYingGoodsGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<MuYingYongPinGridViewBean> mList;
    private LayoutInflater mLayoutInflater;

    public MuYingGoodsGvAdapter(Context context, List<MuYingYongPinGridViewBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.muying_gridview, null);

            mViewHolder.tv_goods_name = (TextView) convertView.findViewById(R.id.tv_shaixuan_goods_name);
            mViewHolder.tv_now_price = (TextView) convertView.findViewById(R.id.tv_jifenjia);
            mViewHolder.tv_used_price = (TextView) convertView.findViewById(R.id.tv_jifenjia_num);
            mViewHolder.but_num = (TextView) convertView.findViewById(R.id.fukuan_num);
            mViewHolder.imageUrl = (ImageView) convertView.findViewById(R.id.img_goods);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_name.setSelected(true);
        mViewHolder.tv_goods_name.setText(mList.get(position).getTv_goods_message());
        mViewHolder.tv_now_price.setText(mList.get(position).getTv_now_price());
        mViewHolder.tv_used_price.setText(mList.get(position).getTv_used_price());
        mViewHolder.but_num.setText(mList.get(position).getTv_buy_um());
        if(position == 0){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_01);
        }else if (position == 1){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_02);
        }else if (position == 2){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_03);
        }else if (position == 3){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_04);
        }else if (position == 4){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_05);
        }else if (position == 5){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_06);
        }else if (position == 6){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_07);
        }else if (position == 7){
            mViewHolder.imageUrl.setImageResource(R.mipmap.muying_gridview_08);
        }
        return convertView;
    }

    class ViewHolder {
        private TextView tv_goods_name;
        private TextView tv_now_price;
        private TextView tv_used_price;
        private TextView but_num;
        private ImageView imageUrl;
    }

}
