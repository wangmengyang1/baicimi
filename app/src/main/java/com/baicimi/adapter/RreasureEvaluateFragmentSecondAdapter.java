package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.baicimi.R;
import com.baicimi.entity.RreasureEvaluateFragmentSecondEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class RreasureEvaluateFragmentSecondAdapter extends BaseAdapter{

    private List<RreasureEvaluateFragmentSecondEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public RreasureEvaluateFragmentSecondAdapter(List<RreasureEvaluateFragmentSecondEntry> list, Context context) {
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
        RreasureEvaluateFragmentSecondHolder holder = null;
        if (view == null){
            view  = inflater.inflate(R.layout.rreasure_evaluate_fragment_second_adapter , null);
            holder = new RreasureEvaluateFragmentSecondHolder();
            view.setTag(holder);
        }else{
            holder = (RreasureEvaluateFragmentSecondHolder) view.getTag();
        }
        return view;
    }

    public class RreasureEvaluateFragmentSecondHolder{

    }


}
