package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MPSystemGcMyArticleEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 */
public class MPSystemGcMyArticleAdapter extends BaseAdapter{

    private List<MPSystemGcMyArticleEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MPSystemGcMyArticleAdapter(List<MPSystemGcMyArticleEntry> list, Context context) {
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
        MPSystemGcMyArticleHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mp_system_gv_my_article_adapter , null);
            holder = new MPSystemGcMyArticleHolder();
            holder.date = (TextView) view.findViewById(R.id.mp_system_gv_my_article_adapter_date);
            holder.lible = (TextView) view.findViewById(R.id.mp_system_gv_my_article_adapter_lible);
            holder.manager = (ImageView) view.findViewById(R.id.mp_system_gv_my_article_adapter_manager);

            view.setTag(holder);
        }else{
            holder = (MPSystemGcMyArticleHolder) view.getTag();
        }

        holder.date.setText(list.get(i).getDate());
        holder.lible.setText(list.get(i).getLible());

        return view;
    }

    public class MPSystemGcMyArticleHolder{
        private TextView date;
        private TextView lible;
        private ImageView manager;
    }

}
