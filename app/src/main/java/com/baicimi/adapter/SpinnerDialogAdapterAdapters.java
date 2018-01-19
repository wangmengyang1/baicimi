package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;

import java.util.List;

/**
 * Created by Administrator on 2018/1/17.
 */
public class SpinnerDialogAdapterAdapters extends BaseAdapter{

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public SpinnerDialogAdapterAdapters(List<String> list, Context context) {
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
        SpinnerDialogAdapterAdaptersHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.spinner_dialog_adapter_adapter , null);
            holder = new SpinnerDialogAdapterAdaptersHolder();
            holder.lible = (TextView) view.findViewById(R.id.spinner_dialog_adapter_adapater_textview);

            view.setTag(holder);
        }else{
            holder = (SpinnerDialogAdapterAdaptersHolder) view.getTag();
        }

        holder.lible.setText(list.get(i));

        return view;
    }


    public class SpinnerDialogAdapterAdaptersHolder{
        private TextView lible;
    }


}
