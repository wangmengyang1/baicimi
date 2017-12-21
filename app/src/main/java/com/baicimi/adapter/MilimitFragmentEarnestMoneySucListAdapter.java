package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.AuthenticationListEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
public class MilimitFragmentEarnestMoneySucListAdapter extends BaseAdapter{

    private List<AuthenticationListEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MilimitFragmentEarnestMoneySucListAdapter(List<AuthenticationListEntry> list, Context context) {
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
        MilimitFragmentEarnestMoneySucListHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_limit_fragment_earnest_money_suc_list_adapter , null);
            holder = new MilimitFragmentEarnestMoneySucListHolder();
            holder.lible = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_money_suc_list_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_money_suc_list_adapter_content);
            holder.tag = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_money_suc_list_adapter_tag);
            holder.imageUrl = (ImageView) view.findViewById(R.id.mi_limit_fragment_earnest_money_suc_list_adapter_imageurl);
            view.setTag(holder);
        }else {
            holder = (MilimitFragmentEarnestMoneySucListHolder) view.getTag();
        }

        AuthenticationListEntry init = (AuthenticationListEntry) getItem(i);

        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.tag.setText(init.getTag());
        holder.imageUrl.setImageResource(init.getImageUrl());
        if (init.isTagState()){
            holder.tag.setVisibility(View.VISIBLE);
        }else{
            holder.tag.setVisibility(View.GONE);
        }

        return view;
    }

    public class MilimitFragmentEarnestMoneySucListHolder{
        private TextView lible;
        private TextView content;
        private TextView tag;
        private ImageView imageUrl;

    }

}
