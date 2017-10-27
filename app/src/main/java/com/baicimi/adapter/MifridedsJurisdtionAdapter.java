package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MifridedsJurisdtionEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public class MifridedsJurisdtionAdapter extends BaseAdapter{

    private List<MifridedsJurisdtionEntry> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public MifridedsJurisdtionAdapter(List<MifridedsJurisdtionEntry> list, Context context) {
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
        MifridedsJurisdtionHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_friends_jurisdition_adapter , null);
            holder = new MifridedsJurisdtionHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.mi_fridends_jurisdiction_adapter_imageurl);
            holder.name = (TextView) view.findViewById(R.id.mi_fridends_jurisdiction_adapter_name);
            holder.checkBox = (CheckBox) view.findViewById(R.id.mi_fridends_jurisdiction_adapter_checkbox);
            view.setTag(holder);
        }else{
            holder = (MifridedsJurisdtionHolder) view.getTag();
        }
        MifridedsJurisdtionEntry init = (MifridedsJurisdtionEntry) getItem(i);


        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.name.setText(init.getName());
        holder.checkBox.setChecked(init.ischeck());

        return view;
    }

    public class MifridedsJurisdtionHolder{
        private ImageView imageUrl;
        private TextView name;
        private CheckBox checkBox;
    }

}
