package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MiChatAddFriendsEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class MiChatAddFriendsAdapter extends BaseAdapter{

    private List<MiChatAddFriendsEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MiChatAddFriendsAdapter(List<MiChatAddFriendsEntry> list, Context context) {
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
        MiChatAddFriendsHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_chat_add_friends_adapter , null);
            holder = new MiChatAddFriendsHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.mi_chat_add_friends_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.mi_chat_add_friends_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.mi_chat_add_friends_adapter_content);
            holder.state = (ImageView) view.findViewById(R.id.mi_chat_add_friends_adapter_state);
            view.setTag(holder);
        }else{
            holder = (MiChatAddFriendsHolder) view.getTag();
        }

        MiChatAddFriendsEntry init = (MiChatAddFriendsEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.state.setImageResource(init.getState());
        return view;
    }

    public class MiChatAddFriendsHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private ImageView state;
    }

}
