package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.NewUserEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class NewUserListViewAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    private List<NewUserEntry> list = new ArrayList<>();


    public NewUserListViewAdapter(Context context, List<NewUserEntry> list) {
        this.context = context;
        this.list = list;
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
        NewUserHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.new_user_listview_adapter , null);
            holder = new NewUserHolder();
            holder.imageUri = (ImageView) view.findViewById(R.id.new_user_listview_adapter_image);
            holder.lible = (TextView) view.findViewById(R.id.new_user_listview_adapter_lible);
            holder.lible_content = (TextView) view.findViewById(R.id.new_user_listview_adapter_lible_content);
            holder.lible_state = (TextView) view.findViewById(R.id.new_user_listview_adapter_lible_state);
            holder.new_integral = (TextView) view.findViewById(R.id.new_user_listview_adapter_new_integral);
            holder.integral_number = (TextView) view.findViewById(R.id.new_user_listview_adapter_integral_number);
            holder.exchange_number = (TextView) view.findViewById(R.id.new_user_listview_adapter_exchange_number);
            holder.imageUri = (ImageView) view.findViewById(R.id.new_user_listview_shopping);
        }
        return view;
    }

    public class NewUserHolder{
        private ImageView imageUri;
        private TextView lible;
        private TextView lible_content;
        private TextView lible_state;
        private TextView new_integral;
        private TextView integral_number;
        private TextView exchange_number;
        private ImageView shopping;

    }
}
