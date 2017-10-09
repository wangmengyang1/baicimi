package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.FrequentlyQuestionEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/9.
 */
public class FrequentlyQuestionAdapter extends BaseAdapter{

    private List<FrequentlyQuestionEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public FrequentlyQuestionAdapter(List<FrequentlyQuestionEntry> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
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
        FrequentlyQuestionHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.frequently_quention_adapter , null);
            holder = new FrequentlyQuestionHolder();
            holder.lible = (TextView) view.findViewById(R.id.frequently_question_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.frequently_question_adapter_content);
            holder.image = (ImageView) view.findViewById(R.id.frequently_question_adapter_image);
            view.setTag(holder);
        }else{
            holder = (FrequentlyQuestionHolder) view.getTag();
        }

        FrequentlyQuestionEntry init = (FrequentlyQuestionEntry) getItem(i);

        if(i == 0){
            holder.image.setVisibility(View.VISIBLE);
        }else{
            holder.image.setVisibility(View.GONE);
        }

        holder.lible.setText(init.getLible());
        holder.content.setText(init.getConent());


        return view;
    }

    public class FrequentlyQuestionHolder{
        private TextView lible;
        private TextView content;
        private ImageView image;
    }

}
