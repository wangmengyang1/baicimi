package com.baicimi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.FridayNightGvBean;
import com.baicimi.interfaces.DistributionNumberOnitemClickSecond;
import com.baicimi.view.ShopingPackageDialog;
import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by tan on 2016/9/5.
 */
public class FridayNightGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<FridayNightGvBean> mList;
    private LayoutInflater mLayoutInflater;
    private DistributionNumberOnitemClickSecond distributionNumberOnitemClick;
    private int indexView;

    private BaseFragment baseFragment;

    public FridayNightGvAdapter(Context context, List<FridayNightGvBean> mList , DistributionNumberOnitemClickSecond distributionNumberOnitemClick , int indexView) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
        this.indexView = indexView;
    }


    public FridayNightGvAdapter(Context mContext, List<FridayNightGvBean> mList, DistributionNumberOnitemClickSecond distributionNumberOnitemClick, int indexView, BaseFragment baseFragment) {
        this.mContext = mContext;
        this.mList = mList;
        this.distributionNumberOnitemClick = distributionNumberOnitemClick;
        this.indexView = indexView;
        this.baseFragment = baseFragment;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.fridaynight_buying_gv_item, null);

            mViewHolder.tv_goods_name = (TextView) convertView.findViewById(R.id.tv_buying_goods_name);
            mViewHolder.use_price = (TextView) convertView.findViewById(R.id.use_price);
            mViewHolder.now_price = (TextView) convertView.findViewById(R.id.now_price);
            mViewHolder.imageUrl = (ImageView) convertView.findViewById(R.id.fridaynight_buying_gv_item_image);
            mViewHolder.number = (TextView) convertView.findViewById(R.id.fridaynight_buying_gv_item_number_textview);
            mViewHolder.subtractTextView = (ImageView) convertView.findViewById(R.id.fridaynight_buying_gv_item_subtract);
            mViewHolder.addTextView = (ImageView) convertView.findViewById(R.id.fridaynight_buying_gv_item_add);
            mViewHolder.rushtopurchase = (Button) convertView.findViewById(R.id.fridaynight_buying_gv_item_rushtopurchase);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        FridayNightGvBean init = (FridayNightGvBean) getItem(position);

        mViewHolder.tv_goods_name.setText(init.getName());
        mViewHolder.use_price.setText(init.getUsed_price());
        mViewHolder.now_price.setText(init.getNow_price());


//        mViewHolder.imageUrl.setImageResource(init.getImageUrl());


        //通过图片加载框架进行加载图片
        Glide.with(mContext)
                .load(init.getImageUrl())
                .into(mViewHolder.imageUrl);

        mViewHolder.number.setText(init.getNumber() + "");
        mViewHolder.subtractTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , position , R.id.fridaynight_buying_gv_item_subtract , indexView);
            }
        });
        mViewHolder.addTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distributionNumberOnitemClick.setNumberOnitemClick(view , position , R.id.fridaynight_buying_gv_item_add , indexView);
            }
        });

        mViewHolder.rushtopurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopingPackageDialog shopingPackageDialog = new ShopingPackageDialog(mContext , R.style.MeiGuiMeiShiSecondMyorderFive , 2 , baseFragment);
                shopingPackageDialog.show();
            }
        });

        return convertView;
    }

    class ViewHolder {
        private TextView tv_goods_name;
        private TextView use_price;
        private TextView now_price;
        private ImageView imageUrl;
        private TextView number;
        private ImageView subtractTextView;
        private ImageView addTextView;

        private Button rushtopurchase;

    }
    

}
