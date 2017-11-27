package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TryoutApplyForMeEntry;
import com.baicimi.fragments.TryoutApplyForMeEvaluateFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public class TryoutApplyForMeAdapter extends BaseAdapter{

    private List<TryoutApplyForMeEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private BaseFragment baseFragment;

    public TryoutApplyForMeAdapter(List<TryoutApplyForMeEntry> list, Context context , BaseFragment baseFragment) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.baseFragment = baseFragment;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        TryoutApplyForMeHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.tryout_apply_forme_adapter , null);
            holder = new TryoutApplyForMeHolder();
            holder.state = (TextView) view.findViewById(R.id.tryout_apply_forme_adapter_state);
            holder.applyFor = (TextView) view.findViewById(R.id.tryout_apply_forme_adapter_applyFor);
            view.setTag(holder);
        }else{
            holder = (TryoutApplyForMeHolder) view.getTag();
        }

        holder.state.setText(list.get(i).getState());
        holder.applyFor.setText(list.get(i).getApplyFor());
        holder.state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(i).getState().equals("申请成功")){
                    if (baseFragment != null){
                        //发表试用申请
                        baseFragment.startFragment(new TryoutApplyForMeEvaluateFragment());
                    }
                }
            }
        });


        return view;
    }

    public class TryoutApplyForMeHolder{
        private TextView state;
        private TextView applyFor;
    }

}
