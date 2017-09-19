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
import com.baicimi.bean.MuYingYongPinGridViewBean;
import com.baicimi.fragments.GoodsDetailsFragment;
import com.baicimi.view.ShopingPackageDialog;

import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class NanShiGoodsGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<MuYingYongPinGridViewBean> mList;
    private LayoutInflater mLayoutInflater;
    private BaseFragment fragment;

    public NanShiGoodsGvAdapter(Context context, List<MuYingYongPinGridViewBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public NanShiGoodsGvAdapter(Context mContext, List<MuYingYongPinGridViewBean> mList, BaseFragment fragment) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.fragment = fragment;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.qiyueju_gv_item, null);
            mViewHolder.tv_message = (TextView) convertView.findViewById(R.id.tv_message);
            mViewHolder.buy_num = (TextView) convertView.findViewById(R.id.tv_buy_num);
            mViewHolder.imageUrl = (ImageView) convertView.findViewById(R.id.img_goods);
            mViewHolder.shopImage = (ImageView) convertView.findViewById(R.id.tv_baoyou);
            mViewHolder.layout_shop = (LinearLayout) convertView.findViewById(R.id.qiyueju_gv_item_layout_shop);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_message.setSelected(true);
        mViewHolder.tv_message.setText(mList.get(position).getTv_goods_message());
        mViewHolder.buy_num.setText(mList.get(position).getTv_buy_um());

        mViewHolder.tv_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment != null){
                    fragment.startFragment(new GoodsDetailsFragment(),null);
                }
            }
        });

        mViewHolder.imageUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment != null){
                    fragment.startFragment(new GoodsDetailsFragment(),null);
                }
            }
        });



        mViewHolder.layout_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopingPackageDialog shopingPackageDialog = new ShopingPackageDialog(mContext , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog.show();
            }
        });


        return convertView;
    }

    class ViewHolder {
        private TextView tv_message;
        private TextView buy_num;
        private ImageView imageUrl;
        private ImageView shopImage;
        private LinearLayout layout_shop;
    }

}
