package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.ChildViewListViewEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public class ChildViewListViewAdapter extends BaseAdapter{

    private List<ChildViewListViewEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public ChildViewListViewAdapter(List<ChildViewListViewEntry> list, Context context) {
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
        ChildViewListViewHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.child_view_listview_adapter , null);
            holder = new ChildViewListViewHolder();
            holder.liber = (TextView) view.findViewById(R.id.child_view_listview_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.child_view_listview_adapter_content);
            holder.money = (TextView) view.findViewById(R.id.child_view_listview_adapter_money);
            view.setTag(holder);
        }else {
            holder = (ChildViewListViewHolder) view.getTag();
        }

        ChildViewListViewEntry init = (ChildViewListViewEntry) getItem(i);

        holder.liber.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.money.setText(init.getNumber());

        return view;
    }

    public class ChildViewListViewHolder{
        private TextView liber;
        private TextView content;
        private TextView money;

    }

}
