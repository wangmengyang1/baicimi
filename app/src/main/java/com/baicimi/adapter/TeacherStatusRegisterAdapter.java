package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.TeacherStatusRegisterEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public class TeacherStatusRegisterAdapter extends BaseAdapter{

    private List<TeacherStatusRegisterEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public TeacherStatusRegisterAdapter(List<TeacherStatusRegisterEntry> list, Context context) {
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
        TeacherStatusHolder holder = null;
        if(view == null){

            if(i == 4){
                view = inflater.inflate(R.layout.teacher_status_register_adapter , null);
            }else{
                view = inflater.inflate(R.layout.teacher_status_register_adapter_02 , null);
                holder = new TeacherStatusHolder();
                holder.imageUrl = (ImageView) view.findViewById(R.id.teacher_status_register_adapter_image);
                holder.lible = (TextView) view.findViewById(R.id.teacher_status_register_adapter_lible);
            }
            view.setTag(holder);
        }else{
            holder = (TeacherStatusHolder) view.getTag();
        }

        if(i == 4){

        }else{
            TeacherStatusRegisterEntry init = (TeacherStatusRegisterEntry) getItem(i);
            holder.imageUrl.setImageResource(init.getImageUrl());
            holder.lible.setText(init.getLible());
        }
        return view;
    }

    public class TeacherStatusHolder{
        private ImageView imageUrl;
        private TextView lible;
    }

}
