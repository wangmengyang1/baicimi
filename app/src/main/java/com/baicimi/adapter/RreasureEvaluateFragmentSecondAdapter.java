package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.RreasureEvaluateFragmentSecondEntry;
import com.baicimi.fragments.LogisticsEvaluateFragmentSecondParticulars;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class RreasureEvaluateFragmentSecondAdapter extends BaseAdapter{

    private List<RreasureEvaluateFragmentSecondEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private BaseFragment baseFragment;


    public RreasureEvaluateFragmentSecondAdapter(List<RreasureEvaluateFragmentSecondEntry> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public RreasureEvaluateFragmentSecondAdapter(List<RreasureEvaluateFragmentSecondEntry> list, Context context, BaseFragment baseFragment) {
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
        RreasureEvaluateFragmentSecondHolder holder = null;
        if (view == null){
            view  = inflater.inflate(R.layout.rreasure_evaluate_fragment_second_adapter , null);
            holder = new RreasureEvaluateFragmentSecondHolder();
            holder.more = (TextView) view.findViewById(R.id.rreasure_evaluate_fragment_second_adapter_more);
            view.setTag(holder);
        }else{
            holder = (RreasureEvaluateFragmentSecondHolder) view.getTag();
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (baseFragment != null){
                        //评价管理   物流评价   分销点/店详情
                        baseFragment.startFragment(new LogisticsEvaluateFragmentSecondParticulars());
                    }
                }
            });
        }
        return view;
    }

    public class RreasureEvaluateFragmentSecondHolder{
        private TextView more;
    }


}
