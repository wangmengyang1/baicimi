package com.baicimi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.PinPaiGvBean;

import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class PinPaiGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<PinPaiGvBean> mList;
    private LayoutInflater mLayoutInflater;

    public PinPaiGvAdapter(Context context, List<PinPaiGvBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return 10;
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
            convertView = mLayoutInflater.inflate(R.layout.fragment_pinpai_gv_item, null);

            mViewHolder.name = (TextView) convertView.findViewById(R.id.goods_name);
            mViewHolder.price = (TextView) convertView.findViewById(R.id.goods_price);
            mViewHolder.buy_num = (TextView) convertView.findViewById(R.id.goods_buy_num);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.name.setSelected(true);
        mViewHolder.name.setText(mList.get(position).getName());
        mViewHolder.price.setText(mList.get(position).getPrice());
        mViewHolder.buy_num.setText(mList.get(position).getBuy_num());

        return convertView;
    }

    class ViewHolder {
        private TextView name;
        private TextView price;
        private TextView buy_num;

    }

}
