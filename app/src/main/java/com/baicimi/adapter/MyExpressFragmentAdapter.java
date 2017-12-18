package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MyExpressFragmentEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */
public class MyExpressFragmentAdapter extends BaseAdapter{

    private List<MyExpressFragmentEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public MyExpressFragmentAdapter(List<MyExpressFragmentEntry> list, Context context) {
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
        MyExpressFragmentHolder holder =  null;
        if (view == null){
            view = inflater.inflate(R.layout.my_express_fragment_adapter , null);
            holder = new MyExpressFragmentHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.my_express_fragment_adapter_imageurl);
            holder.state = (TextView) view.findViewById(R.id.my_express_fragment_adapter_state);
            holder.date = (TextView) view.findViewById(R.id.my_express_fragment_adapter_date);
            holder.content = (TextView) view.findViewById(R.id.my_express_fragment_adapter_content);
            holder.expressage = (TextView) view.findViewById(R.id.my_express_fragment_adapter_expressage);

            view.setTag(holder);
        }else{
            holder = (MyExpressFragmentHolder) view.getTag();
        }

        MyExpressFragmentEntry init = (MyExpressFragmentEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.state.setText(init.getState());
        holder.date.setText(init.getDate());
        holder.content.setText(init.getLible());
        holder.expressage.setText(init.getExpressage());

        return view;
    }

    public class MyExpressFragmentHolder{
        private ImageView imageUrl;
        private TextView state;
        private TextView date;
        private TextView content;
        private TextView expressage;
    }

}
