package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.baicimi.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class LoveDonateFragmentSecondAdapter extends BaseAdapter{

    private List<Integer> list;
    private Context context;
    private LayoutInflater inflater;

    public LoveDonateFragmentSecondAdapter(List<Integer> list, Context context) {
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
        if (view == null){
            view = inflater.inflate(R.layout.love_donate_fragment_second_adpater , null);
        }
        return view;
    }

    public class LoveDonateFragmentSecondHolder{

    }

}
