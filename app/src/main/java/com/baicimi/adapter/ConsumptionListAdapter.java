package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.ConsumptionListEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */
public class ConsumptionListAdapter extends BaseAdapter{

    private List<ConsumptionListEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public ConsumptionListAdapter(List<ConsumptionListEntry> list, Context context) {
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
        ConsumptionListHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.consumption_list_adapter , null);
            holder = new ConsumptionListHolder();
            holder.date = (TextView) view.findViewById(R.id.consumption_list_adapter_date);
            holder.state = (TextView) view.findViewById(R.id.consumption_list_adapter_state);
            holder.stateButton = (TextView) view.findViewById(R.id.consumption_list_adapter_statebutton);
            holder.lible = (TextView) view.findViewById(R.id.consumption_list_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.consumption_list_adapter_content);
            holder.button = (TextView) view.findViewById(R.id.consumption_list_adapter_button);

            view.setTag(holder);
        }else{
            holder = (ConsumptionListHolder) view.getTag();
        }
        ConsumptionListEntry init = (ConsumptionListEntry) getItem(i);


        holder.date.setText(init.getDate());
        holder.state.setText(init.getState());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.button.setText(init.getButton());


        if (init.getState().equals("等待确认收货")){
            holder.stateButton.setVisibility(View.VISIBLE);
        }else{
            holder.stateButton.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    public class ConsumptionListHolder{
        private TextView date;
        private TextView state;
        private TextView stateButton;
        private TextView lible;
        private TextView content;
        private TextView button;
    }

}
