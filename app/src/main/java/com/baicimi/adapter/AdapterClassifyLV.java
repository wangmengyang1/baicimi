package com.baicimi.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseMySingleLayoutAdapter;
import com.baicimi.bean.Categories;

import java.util.List;

//分类品种ListView名字类
public class AdapterClassifyLV extends BaseMySingleLayoutAdapter<Categories> {
    private int tag;

    public AdapterClassifyLV(Context context, int layoutId) {
        super(context, layoutId);
    }

    public void setFlag(int tag){
        this.tag = tag;
        notifyDataSetChanged();
    }
    @Override
    public void bindDatas(ViewHolder holder, List<Categories> datas2, int position) {
        ImageView ivClassify = (ImageView) holder.getView(R.id.iv_classify);
        TextView tvName = (TextView) holder.getView(R.id.tv_classify_name);
        if (position == tag) {
//			tvName.setTextColor(Color.GREEN);
            tvName.setTextColor(Color.RED);
            ivClassify.setVisibility(View.VISIBLE);
        }else {
            tvName.setTextColor(Color.BLACK);
            ivClassify.setVisibility(View.INVISIBLE);
        }
        tvName.setText(datas2.get(position).name);

    }

}