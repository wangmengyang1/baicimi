package com.baicimi.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.FootPaintEveryTaskEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 */
public class FootPaintEveryTaskAdapter extends BaseAdapter{

    private List<FootPaintEveryTaskEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public FootPaintEveryTaskAdapter(List<FootPaintEveryTaskEntry> list, Context context) {
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
        FootPaintEveryTaskHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.footpaint_every_task_adapter , null);
            holder = new FootPaintEveryTaskHolder();
            holder.lible = (TextView) view.findViewById(R.id.footpaint_every_task_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.footpaint_every_task_adapter_content);
            holder.state = (TextView) view.findViewById(R.id.footpaint_every_task_adapter_state);

            view.setTag(holder);
        }else{
            holder = (FootPaintEveryTaskHolder) view.getTag();
        }
        FootPaintEveryTaskEntry init = (FootPaintEveryTaskEntry) getItem(i);
        if (i == 0){
            holder.content.setTextColor(Color.parseColor("#737373"));
        }else{
            holder.content.setTextColor(Color.parseColor("#ff0000"));
        }


        if (init.isState()){
            holder.state.setText("已完成");
            holder.state.setBackgroundColor(Color.parseColor("#efefef"));
        }else{
            holder.state.setText("去完成");
            holder.state.setBackgroundColor(Color.parseColor("#737373"));
        }


        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());

        return view;
    }

    public class FootPaintEveryTaskHolder{
        private TextView lible;
        private TextView content;
        private TextView state;
    }

}
