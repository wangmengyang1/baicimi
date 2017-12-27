package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.LogisticsEvaluateFragmentSecondParticularsEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/27.
 */
public class LogisticsEvaluateFragmentSecondParticularsAdapter extends BaseAdapter{

    private List<LogisticsEvaluateFragmentSecondParticularsEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private BaseFragment baseFragment;

    public LogisticsEvaluateFragmentSecondParticularsAdapter(List<LogisticsEvaluateFragmentSecondParticularsEntry> list,
                                                             Context context , BaseFragment baseFragment) {
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
        LogisticsEvaluateFragmentSecondParticularsHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.logistics_evaluate_fragment_second_par_adapter , null);
            holder = new LogisticsEvaluateFragmentSecondParticularsHolder();
            holder.content = (TextView) view.findViewById(R.id.logistics_evaluate_fragment_second_par_adapter_content);
            holder.imageFirst = (ImageView) view.findViewById(R.id.logistics_evaluate_fragment_second_par_adapter_imagefirst);
            holder.imageSecond = (ImageView) view.findViewById(R.id.logistics_evaluate_fragment_second_par_adapter_imagesecond);

            view.setTag(holder);
        }else{
            holder = (LogisticsEvaluateFragmentSecondParticularsHolder) view.getTag();
        }
        LogisticsEvaluateFragmentSecondParticularsEntry init = (LogisticsEvaluateFragmentSecondParticularsEntry) getItem(i);

        holder.content.setText(init.getContent());
        holder.imageFirst.setImageResource(init.getImageFirst());
        holder.imageSecond.setImageResource(init.getImageSecond());
        holder.userName.setText(init.getUserName());

        if (init.isImageState()){
            holder.imageFirst.setVisibility(View.GONE);
            holder.imageSecond.setVisibility(View.GONE);
        }else{
            holder.imageFirst.setVisibility(View.VISIBLE);
            holder.imageSecond.setVisibility(View.VISIBLE);
        }

        if (init.isReplyState()){
            holder.reply.setVisibility(View.GONE);
        }else{
            holder.reply.setVisibility(View.VISIBLE);
        }

        return view;
    }

    public class LogisticsEvaluateFragmentSecondParticularsHolder{
        private TextView content;
        private ImageView imageFirst;
        private ImageView imageSecond;
        private TextView userName;
        private TextView reply;
    }

}
