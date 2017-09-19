package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */

public class CelaCategoryAdapter extends BaseAdapter {
    private List<String> list  = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public CelaCategoryAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolders holders = null;
        if(view == null){
            view = inflater.inflate(R.layout.cela_category_listview_adapter , null);
            holders = new ViewHolders();
            holders.textView = (TextView) view.findViewById(R.id.cela_category_listview_textview);
            view.setTag(holders);
        }else{
            holders = (ViewHolders) view.getTag();
        }
        holders.textView.setText(list.get(i));
        return view;
    }

    public class ViewHolders{
        private TextView textView;
    }
}
