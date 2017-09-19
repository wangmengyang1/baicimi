package com.baicimi.adapter;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.GrouBuyMeiZhuangGvBean;
import com.bumptech.glide.Glide;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;


/**
 * Created by tan on 2016/9/5.
 */
public class GrouBuyPersonGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<GrouBuyMeiZhuangGvBean> mList;
    private LayoutInflater mLayoutInflater;

    public GrouBuyPersonGvAdapter(Context context, List<GrouBuyMeiZhuangGvBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderGrouBuy mViewHolder;
        if (view == null) {
            mViewHolder = new ViewHolderGrouBuy();
            view = mLayoutInflater.inflate(R.layout.groubuy_person_gv_item, null);
            mViewHolder.tv_goods_name = (TextView) view.findViewById(R.id.groubuy_goods_name_lible);
            mViewHolder.use_price = (TextView) view.findViewById(R.id.old_money);
            mViewHolder.persaon_groubuy_price = (TextView) view.findViewById(R.id.new_money);
            mViewHolder.groubuy_price = (TextView) view.findViewById(R.id.group_purchase);
            mViewHolder.imageUrl = (ImageView) view.findViewById(R.id.groubuy_goods_imgurl);
            view.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolderGrouBuy) view.getTag();
        }

        GrouBuyMeiZhuangGvBean init  = (GrouBuyMeiZhuangGvBean) getItem(i);

//        mViewHolder.tv_goods_name.setSelected(true);
        mViewHolder.tv_goods_name.setText(init.getName());
        mViewHolder.use_price.setText(init.getUsed_price());
        mViewHolder.persaon_groubuy_price.setText(init.getPerson_groubuy_price());
        mViewHolder.groubuy_price.setText(init.getGroubuy_price());

        //加载图片，会造成内存的过度消耗，通过测试得知，如果通过压缩将图片的质量降低无意义（BOSS想看到高清图）
//        Picasso.with(mContext).load(init.getImageUrl()).into(mViewHolder.imageUrl);
//        mViewHolder.imageUrl.setImageResource(init.getImageUrl());
        Glide.with(mContext)
                .load(R.drawable.image_tuangou_21)
                .into(mViewHolder.imageUrl);
        return view;
    }

    public class ViewHolderGrouBuy {
        private TextView tv_goods_name;
        private TextView use_price;
        private TextView persaon_groubuy_price;
        private TextView groubuy_price;
        private ImageView imageUrl;
    }
}
