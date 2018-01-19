package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;

import java.util.List;

/**
 * Created by Administrator on 2018/1/17.
 */
public class SpinnerDialogAdapter extends BaseAdapter{

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    private SpinnerDialogAdapterAdapters adapterAdapters;

    public SpinnerDialogAdapter(List<String> list, Context context) {
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
        SpinnerDialogAdapterHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.spinner_dialog_adapter , null);
            holder = new SpinnerDialogAdapterHolder();
            holder.lible = (ListView) view.findViewById(R.id.spinner_dialog_adapter_listview);
            view.setTag(holder);
        }else{
            holder = (SpinnerDialogAdapterHolder) view.getTag();
        }

        adapterAdapters = new SpinnerDialogAdapterAdapters(list , context);
        holder.lible.setAdapter(adapterAdapters);



        return view;
    }

    public class SpinnerDialogAdapterHolder{
        private ListView lible;
    }

}
