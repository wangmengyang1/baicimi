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
 * Created by Administrator on 2017/10/11.
 */
public class UserCenterHomePageSecondHeadadapter extends BaseAdapter{

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public UserCenterHomePageSecondHeadadapter(List<String> secondListview, Context context) {
        this.list = secondListview;
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
        UserCenterHomdPageSecondHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.user_center_homepage_second_headadapter , null);
            holder = new UserCenterHomdPageSecondHolder();
            holder.textView = (TextView) view.findViewById(R.id.user_center_homepage_second_headadapter_lible);
            view.setTag(holder);
        }else{
            holder = (UserCenterHomdPageSecondHolder) view.getTag();
        }

        holder.textView.setText(list.get(i));


        return view;
    }

    public class UserCenterHomdPageSecondHolder{
        private TextView textView;
    }

}
