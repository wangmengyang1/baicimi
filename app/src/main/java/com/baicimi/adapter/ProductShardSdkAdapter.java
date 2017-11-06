package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class ProductShardSdkAdapter extends BaseAdapter{

    private List<Integer> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public ProductShardSdkAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ProductShardSdkHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.product_shard_sdk_adapter , null);
            holder = new ProductShardSdkHolder();
            holder.imageurl = (ImageView) view.findViewById(R.id.product_shard_sdk_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.product_shard_sdk_adapter_lible);
            view.setTag(holder);
        }else {
            holder = (ProductShardSdkHolder) view.getTag();
        }

        holder.imageurl.setImageResource(list.get(i));
        if (i == 0){
            holder.lible.setText("微信好友");
        }else if (i == 1){
            holder.lible.setText("朋友圈");
        }else if (i == 2){
            holder.lible.setText("新浪微博");
        }else if (i == 3){
            holder.lible.setText("QQ好友");
        }else if (i == 4){
            holder.lible.setText("复制链接");
        }else if (i == 5){
            holder.lible.setText("面对面分享");
        }else if (i == 5){
            holder.lible.setText("QQ空间");
        }

        return view;
    }

    public class ProductShardSdkHolder{
        private ImageView imageurl;
        private TextView lible;

    }

}
