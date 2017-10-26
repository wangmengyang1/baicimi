package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

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
            view.setTag(holder);
        }else {
            holder = (ProductShardSdkHolder) view.getTag();
        }

        holder.imageurl.setImageResource(list.get(i));

        return view;
    }

    public class ProductShardSdkHolder{
        private ImageView imageurl;

    }

}
