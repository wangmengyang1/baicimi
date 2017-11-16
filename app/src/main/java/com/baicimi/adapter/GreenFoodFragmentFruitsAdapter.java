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
 * Created by Administrator on 2017/11/15.
 */
public class GreenFoodFragmentFruitsAdapter extends BaseAdapter{

    private List<ShaiXuanListBean> list;
    private Context context;
    private LayoutInflater inflater;

    public GreenFoodFragmentFruitsAdapter(List<ShaiXuanListBean> list, Context context) {
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
        ViewHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.green_food_fragment_fruits_adapter , null);
            holder = new ViewHolder();
            holder.tv_goods_name = (TextView) view.findViewById(R.id.green_food_fragment_fruits_adapter_tv_shaixuan_goods_name);
            holder.tv_jifendikou_num = (TextView) view.findViewById(R.id.green_food_fragment_fruits_adapter_tv_jifen_num);
            holder.jifendikou_mony_num = (TextView) view.findViewById(R.id.green_food_fragment_fruits_adapter_tv_mony_num);
            holder.tv_now_price = (TextView) view.findViewById(R.id.green_food_fragment_fruits_adapter_tv_jifenjia_num);
            holder.tv_used_price = (TextView) view.findViewById(R.id.green_food_fragment_fruits_adapter_tv_shangchengjia_num);
            holder.shopPackage = (ImageView) view.findViewById(R.id.green_food_fragment_fruits_adapter_tv_baoyou);
            holder.layout = (LinearLayout) view.findViewById(R.id.green_food_fragment_fruits_adapter_fragment_shaixuan_list_item_layout);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_goods_name.setSelected(true);
        holder.tv_goods_name.setText(list.get(i).getTv_goods_name());
        holder.tv_jifendikou_num.setText(list.get(i).getTv_jifendikou_num());
        holder.jifendikou_mony_num.setText(list.get(i).getJifendikou_mony_num());
        holder.tv_now_price.setText(list.get(i).getTv_now_price());
        holder.tv_used_price.setText(list.get(i).getTv_used_price());

//        mViewHolder.shopPackage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopingPackageDialog shopingPackageDialog = new ShopingPackageDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive);
                shopingPackageDialog.show();
            }
        });

        return view;
    }

    class ViewHolder {
        private TextView tv_goods_name;
        private TextView tv_jifendikou_num;
        private TextView jifendikou_mony_num;
        private TextView tv_now_price;
        private TextView tv_used_price;
        private ImageView shopPackage;
        private LinearLayout layout;
    }



}
