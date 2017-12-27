package com.baicimi.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.RreasureEvaluateFragmentSecondEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class LogisticsEvaluateFragmentThreadAdapter extends BaseAdapter{

    private List<RreasureEvaluateFragmentSecondEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private BaseFragment baseFragment;

    public LogisticsEvaluateFragmentThreadAdapter(List<RreasureEvaluateFragmentSecondEntry> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public LogisticsEvaluateFragmentThreadAdapter(List<RreasureEvaluateFragmentSecondEntry> list, Context context, BaseFragment baseFragment) {
        this.list = list;
        this.context = context;
        this.baseFragment = baseFragment;
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
        LogisticsEvaluateFragmentThreadHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.logistics_evaluate_fragment_thread_adapter , null);
            holder = new LogisticsEvaluateFragmentThreadHolder();
            holder.evaluate = (TextView) view.findViewById(R.id.logistics_evaluate_fragment_thread_adapter_evaluate);
            view.setTag(holder);
        }else{
            holder = (LogisticsEvaluateFragmentThreadHolder) view.getTag();
        }

        holder.evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baseFragment != null){
                    //评价管理   物流评价 写评价
                    baseFragment.startFragment(new EvaluateManagementFragmentWirte());
                }
            }
        });

        return view;
    }

    public class LogisticsEvaluateFragmentThreadHolder{
        private TextView evaluate;
    }

}
