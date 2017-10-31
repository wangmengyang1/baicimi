package com.baicimi.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MybustagesEntry;
import com.baicimi.fragments.MiWalletFragmentMybustages;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public class MyustagesAdapter extends BaseAdapter{

    private List<MybustagesEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private BaseFragment fragment;

    public MyustagesAdapter(List<MybustagesEntry> list, Context context , BaseFragment fragment) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.fragment = fragment;
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
        MyBustagesHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.my_bustages_adapter , null);
            holder = new MyBustagesHolder();
            holder.lible = (TextView) view.findViewById(R.id.my_bustages_adapter_lible);
            holder.consumption = (TextView) view.findViewById(R.id.my_bustages_adapter_consumption);
            holder.date = (TextView) view.findViewById(R.id.my_bustages_adapter_date);
            holder.money = (TextView) view.findViewById(R.id.my_bustages_adapter_money);
            holder.consumptionNumber = (TextView) view.findViewById(R.id.my_bustages_adapter_consumptionnumber);
            holder.state = (TextView) view.findViewById(R.id.my_bustages_adapter_state);
            holder.result = (TextView) view.findViewById(R.id.my_bustages_adapter_result);

            view.setTag(holder);
        }else{
            holder = (MyBustagesHolder) view.getTag();
        }

        final MybustagesEntry init = (MybustagesEntry) getItem(i);

        holder.lible.setText(init.getLible());
        holder.consumption.setText(init.getConsumption());
        holder.date.setText(init.getDate());
        holder.money.setText(init.getMoney());
        holder.consumptionNumber.setText(init.getConsumptionNumber());
        holder.state.setText(init.getState());
        holder.result.setText(init.getResult());

        if (init.getState().equals("已通过")){
            holder.state.setTextColor(Color.parseColor("#66c05e"));
        }else if (init.getState().equals("审核中")){
            holder.state.setTextColor(Color.parseColor("#ff0000"));
        }


        holder.result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (init.getResult().equals("查看")){
                    if (fragment != null){
                        //查看分期
                        fragment.startFragment(new MiWalletFragmentMybustages());
                    }
                }
            }
        });



        return view;
    }

    public class MyBustagesHolder{
        private TextView lible;
        private TextView consumption;
        private TextView date;
        private TextView money;
        private TextView consumptionNumber;
        private TextView state;
        private TextView result;
    }


}
