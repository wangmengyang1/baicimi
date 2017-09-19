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
import com.baicimi.bean.ShaiXuanListBean;
import com.baicimi.view.ShopingPackageDialog;

import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class ShaiXuanGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<ShaiXuanListBean> mList;
    private LayoutInflater mLayoutInflater;

    public ShaiXuanGvAdapter(Context context, List<ShaiXuanListBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.fragment_shaixuan_gv_item, null);

            mViewHolder.tv_goods_name = (TextView) convertView.findViewById(R.id.tv_shaixuan_goods_name);
            mViewHolder.tv_jifendikou_num = (TextView) convertView.findViewById(R.id.tv_jifen_num);
            mViewHolder.jifendikou_mony_num = (TextView) convertView.findViewById(R.id.tv_mony_num);
            mViewHolder.tv_now_price = (TextView) convertView.findViewById(R.id.tv_jifenjia_num);
            mViewHolder.tv_used_price = (TextView) convertView.findViewById(R.id.tv_shangchengjia_num);
            mViewHolder.tagNumber = (ImageView) convertView.findViewById(R.id.fragment_shaixuan_gv_item_shoping_image);
            mViewHolder.layout = (LinearLayout) convertView.findViewById(R.id.fragment_shaixuan_gv_item_layout_shop);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_name.setSelected(true);
        mViewHolder.tv_goods_name.setText(mList.get(position).getTv_goods_name());
        mViewHolder.tv_jifendikou_num.setText(mList.get(position).getTv_jifendikou_num());
        mViewHolder.jifendikou_mony_num.setText(mList.get(position).getJifendikou_mony_num());
        mViewHolder.tv_now_price.setText(mList.get(position).getTv_now_price());
        mViewHolder.tv_used_price.setText(mList.get(position).getTv_used_price());

        mViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopingPackageDialog shopingPackageDialog = new ShopingPackageDialog(mContext , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog.show();
            }
        });

        return convertView;
    }

    class ViewHolder {
        private TextView tv_goods_name;
        private TextView tv_jifendikou_num;
        private TextView jifendikou_mony_num;
        private TextView tv_now_price;
        private TextView tv_used_price;
        private ImageView tagNumber;
        private LinearLayout layout;
    }

}
