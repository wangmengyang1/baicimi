package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.TuanGouDingDanLvBean;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 * 团购订单ListView
 */
public class TuanGouDingDanLvtAdapter extends BaseAdapter{

    private Context mContext;
    private List<TuanGouDingDanLvBean> mList;
    private LayoutInflater mLayoutInflater;

    public TuanGouDingDanLvtAdapter(Context context, List<TuanGouDingDanLvBean> mList) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.tuangou_dingdan_list_item, null);

            mViewHolder.tv_goods_message = (TextView) convertView.findViewById(R.id.tv_dingdan_message);
            mViewHolder.tv_goods_yanse_num = (TextView) convertView.findViewById(R.id.tv_dingdan_yanse_num);
            mViewHolder.tv_sendgoods_time = (TextView) convertView.findViewById(R.id.tv_dingdan_sand_time);
            mViewHolder.tv_goods_price = (TextView) convertView.findViewById(R.id.tv_dingdan_all_price);
            mViewHolder.tv_goods_receive_man = (TextView) convertView.findViewById(R.id.tv_dingdan_shouhuoren);
            mViewHolder.tv_goods_receive_address = (TextView) convertView.findViewById(R.id.tv_dingdan_address);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_message.setSelected(true);
        mViewHolder.tv_goods_message.setText(mList.get(position).getTv_tuangoods_message());
        mViewHolder.tv_goods_yanse_num.setText(mList.get(position).getTv_tuangoods_yanse_num());
        mViewHolder.tv_sendgoods_time.setText(mList.get(position).getTv_tuang_sendgoods_time());
        mViewHolder.tv_goods_price.setText(mList.get(position).getTv_tuanggoods_price());
        mViewHolder.tv_goods_receive_man.setText(mList.get(position).getTv_tuanggoods_receive_man());
        mViewHolder.tv_goods_receive_address.setText(mList.get(position).getTv_tuanggoods_receive_address());
        return convertView;
    }


    class ViewHolder {
        private TextView tv_goods_message;
        private TextView tv_goods_yanse_num;
        private TextView tv_sendgoods_time;
        private TextView tv_goods_price;
        private TextView tv_goods_receive_man;
        private TextView tv_goods_receive_address;
    }

}
