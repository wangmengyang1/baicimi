package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baicimi.R;
import com.baicimi.entity.AuthenticationEntry;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */
public class OneForTheBooksAdapter extends BaseAdapter{

    private List<AuthenticationEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public OneForTheBooksAdapter(List<AuthenticationEntry> list, Context context) {
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
        OneForTheBooksHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.one_for_the_book_adapter , null);
            holder = new OneForTheBooksHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.one_for_the_book_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.one_for_the_book_adapter_lible);
            view.setTag(holder);
        }else{
            holder = (OneForTheBooksHolder) view.getTag();
        }
        AuthenticationEntry init = (AuthenticationEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        return view;
    }

    public class OneForTheBooksHolder{
        private ImageView imageUrl;
        private TextView lible;
    }

}
