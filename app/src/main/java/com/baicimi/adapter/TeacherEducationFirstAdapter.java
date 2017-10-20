package com.baicimi.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.TeacherEducationEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */
public class TeacherEducationFirstAdapter extends BaseAdapter{

    private List<TeacherEducationEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public TeacherEducationFirstAdapter(List<TeacherEducationEntry> list, Context context) {
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
        TeacherEducationHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.teacher_education_first_adapter , null);
            holder = new TeacherEducationHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.reacher_education_first_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.reacher_education_first_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.reacher_education_first_adapter_content);

            view.setTag(holder);
        }else{
            holder = (TeacherEducationHolder) view.getTag();
        }
        TeacherEducationEntry init = (TeacherEducationEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());

        return view;
    }

    public class TeacherEducationHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
    }

}
