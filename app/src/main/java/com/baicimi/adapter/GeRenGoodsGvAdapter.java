package com.baicimi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.GeRenYongPinGridViewBean;
import com.baicimi.bean.ShaiXuanListBean;

import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class GeRenGoodsGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<GeRenYongPinGridViewBean> mList1;
    private LayoutInflater mLayoutInflater;

    public GeRenGoodsGvAdapter(Context context, List<GeRenYongPinGridViewBean> mList) {
        this.mContext = context;
        this.mList1 = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return mList1.get(position);
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
            convertView = mLayoutInflater.inflate(R.layout.persan_use_gv, null);

            mViewHolder.tv_goods_name = (TextView) convertView.findViewById(R.id.tv_goods_message);
            mViewHolder.tv_now_price = (TextView) convertView.findViewById(R.id.tv_goods_name);
            mViewHolder.imageUrl = (ImageView) convertView.findViewById(R.id.img_goods);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_name.setSelected(true);
        mViewHolder.tv_goods_name.setText(mList1.get(position).getTv_goods_message());
        mViewHolder.tv_now_price.setText(mList1.get(position).getTv_now_price());
        if(position == 0){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_01);
        }else if (position ==1){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_02);
        }else if (position ==2){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_03);
        }else if (position ==3){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_04);
        }else if (position ==4){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_05);
        }else if (position ==5){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_06);
        }else if (position ==6){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_07);
        }else if (position ==7){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_08);
        }else if (position ==8){
            mViewHolder.imageUrl.setImageResource(R.mipmap.user_gridview_08);
        }
        return convertView;
    }

    class ViewHolder {
        private TextView tv_goods_name;
        private TextView tv_now_price;
        private ImageView imageUrl;
    }

}
