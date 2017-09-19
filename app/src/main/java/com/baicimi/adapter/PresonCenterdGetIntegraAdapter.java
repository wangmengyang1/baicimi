package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.PresonCenterdeGetIntegralEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
public class PresonCenterdGetIntegraAdapter extends BaseAdapter{

    private Context context;
    private List<PresonCenterdeGetIntegralEntry> list;
    private LayoutInflater inflater;

    public PresonCenterdGetIntegraAdapter(Context context, List<PresonCenterdeGetIntegralEntry> list) {
        this.context = context;
        this.list = list;
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
        GetIntegralHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.preson_centerd_get_integral_adapter , null);
            holder = new GetIntegralHolder();
            holder.commodityImage = (ImageView) view.findViewById(R.id.preson_centerd_get_intergral_adapter_image);
            holder.lible = (TextView) view.findViewById(R.id.preson_centerd_get_intergral_adapter_lible);
            holder.newMoney = (TextView) view.findViewById(R.id.preson_centerd_get_intergral_adapter_newmoeny);
            holder.oldMoney = (TextView) view.findViewById(R.id.preson_centerd_get_intergral_adapter_oldmoney);
            holder.shoppingUser = (TextView) view.findViewById(R.id.preson_centerd_get_intergral_adapter_shopuser);

            view.setTag(holder);
        }else {
            holder = (GetIntegralHolder) view.getTag();
        }

        PresonCenterdeGetIntegralEntry init = (PresonCenterdeGetIntegralEntry) getItem(i);

        holder.commodityImage.setImageResource(init.getCommodityImage());
        holder.lible.setText(init.getLible());
        holder.newMoney.setText(init.getNewMoney());
        holder.oldMoney.setText(init.getOldMoney());
        holder.shoppingUser.setText(init.getShoppingUser());


        return view;
    }

    public class GetIntegralHolder{
        private ImageView commodityImage;
        private TextView lible;
        private TextView newMoney;
        private TextView oldMoney;
        private TextView shoppingUser;
    }

}
