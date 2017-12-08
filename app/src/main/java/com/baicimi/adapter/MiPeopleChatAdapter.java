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
 * Created by Administrator on 2017/12/8.
 */
public class MiPeopleChatAdapter extends BaseAdapter{

    private List<AuthenticationEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MiPeopleChatAdapter(List<AuthenticationEntry> list, Context context) {
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
        MiPeopleChatHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_people_chat_adapter , null);
            holder = new MiPeopleChatHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.mi_people_chat_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.mi_people_chat_adapter_lible);
            view.setTag(holder);
        }else {
            holder = (MiPeopleChatHolder) view.getTag();
        }

        holder.imageUrl.setImageResource(list.get(i).getImageUrl());
        holder.lible.setText(list.get(i).getLible());

        return view;
    }

    public class MiPeopleChatHolder{
        private ImageView imageUrl;
        private TextView lible;
    }

}
