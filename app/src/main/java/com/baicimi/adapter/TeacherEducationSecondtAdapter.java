package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.TeacherEducationEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */
public class TeacherEducationSecondtAdapter extends BaseAdapter{

    private List<TeacherEducationEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public TeacherEducationSecondtAdapter(List<TeacherEducationEntry> listSecond, Context context) {
        this.list = listSecond;
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
        TeacherEducationSeondHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.reacher_education_second_adapter , null);
            holder = new TeacherEducationSeondHolder();
            holder.lible = (TextView) view.findViewById(R.id.reacher_education_second_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.reacher_education_second_adapter_content);
            view.setTag(holder);
        }else{
            holder = (TeacherEducationSeondHolder) view.getTag();
        }

        holder.lible.setText(list.get(i).getLible());
        holder.content.setText(list.get(i).getContent());

        return view;
    }

    public class TeacherEducationSeondHolder{
        private TextView lible;
        private TextView content;
    }

}
