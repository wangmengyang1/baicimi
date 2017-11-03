package com.baicimi.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.ComplaintSuggestSecondEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */
public class ComplaintSuggestSecondAdapter extends BaseAdapter{
    private List<ComplaintSuggestSecondEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public ComplaintSuggestSecondAdapter(List<ComplaintSuggestSecondEntry> list, Context context) {
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
        ComplaintSuggestSecondHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.complain_suggest_second_adapter , null);
            holder = new ComplaintSuggestSecondHolder();
            holder.topNumber = (TextView) view.findViewById(R.id.complain_suggest_second_adapter_head_lible);
            holder.name = (TextView) view.findViewById(R.id.complain_suggest_second_adapter_head_name);
            holder.addeptNumber = (TextView) view.findViewById(R.id.complain_suggest_second_adapter_head_addeptNumber);
            holder.codeNumber = (TextView) view.findViewById(R.id.complain_suggest_second_adapter_head_codenumber);
            holder.imageUrl = (ImageView) view.findViewById(R.id.complain_suggest_second_adapter_head_image);
            view.setTag(holder);
        }else{
            holder = (ComplaintSuggestSecondHolder) view.getTag();
        }

        ComplaintSuggestSecondEntry init = (ComplaintSuggestSecondEntry) getItem(i);


        holder.topNumber.setText(init.getTopNumber());
        holder.name.setText(init.getName());
        holder.addeptNumber.setText(init.getAddeptNumber());
        holder.codeNumber.setText(init.getCodeNumber());
        holder.imageUrl.setImageResource(init.getImageUrl());

        if (i == 0){
            holder.imageUrl.setVisibility(View.INVISIBLE);
        }else{
            holder.imageUrl.setVisibility(View.VISIBLE);
        }

        if (i > 0 && i <= 3){
            holder.topNumber.setTextColor(Color.parseColor("#ff0000"));
        }

        return view;
    }

    public class ComplaintSuggestSecondHolder{
        private TextView topNumber;
        private ImageView imageUrl;
        private TextView name;
        private TextView addeptNumber;
        private TextView codeNumber;
        private LinearLayout layout;
    }

}
