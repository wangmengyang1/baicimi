package com.baicimi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.GouWuCheGvBean;
import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class GouWuCheGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<GouWuCheGvBean> mList;
    private LayoutInflater mLayoutInflater;

    public GouWuCheGvAdapter(Context context, List<GouWuCheGvBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.fragment_gouwuche_gvgoods_item, null);

            mViewHolder.tv_goods_message = (TextView) convertView.findViewById(R.id.gouwuche_tv_gv_message);
            mViewHolder.gouwuche_goods_mony_num = (TextView) convertView.findViewById(R.id.gouwuche_tv_gv_price);
            mViewHolder.gouwuche_goods_pay_num = (TextView) convertView.findViewById(R.id.gouwuche_tv_gv_paynum);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_message.setSelected(true);
        mViewHolder.tv_goods_message.setText(mList.get(position).getTv_gouwuche_gv_goods_message());
        mViewHolder.gouwuche_goods_mony_num.setText(mList.get(position).getTv_gouwuche_gv_goods_price());
        mViewHolder.gouwuche_goods_pay_num.setText(mList.get(position).getTv_gouwuche_gv_goods_paynum());

        return convertView;
    }

    class ViewHolder {
        private TextView tv_goods_message;
        private TextView gouwuche_goods_mony_num;
        private TextView gouwuche_goods_pay_num;
    }
}
