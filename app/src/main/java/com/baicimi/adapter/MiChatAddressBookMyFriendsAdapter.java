package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.fragments.MiChatAddressBookMyFriendsEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class MiChatAddressBookMyFriendsAdapter extends BaseAdapter{

    private List<MiChatAddressBookMyFriendsEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public MiChatAddressBookMyFriendsAdapter(List<MiChatAddressBookMyFriendsEntry> list, Context context) {
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
        MiChatAddressBookMyFriendsHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.michat_address_book_my_friends_adapter , null);
            holder = new MiChatAddressBookMyFriendsHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.michat_address_book_my_friends_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.michat_address_book_my_friends_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.michat_address_book_my_friends_adapter_content);
            holder.state = (ImageView) view.findViewById(R.id.michat_address_book_my_friends_adapter_state);
            holder.maneger = (ImageView) view.findViewById(R.id.michat_address_book_my_friends_adapter_manager);

            view.setTag(holder);
        }else{
            holder = (MiChatAddressBookMyFriendsHolder) view.getTag();
        }

        MiChatAddressBookMyFriendsEntry init = (MiChatAddressBookMyFriendsEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.state.setImageResource(init.getState());

        holder.maneger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //管理
            }
        });

        return view;
    }

    public class MiChatAddressBookMyFriendsHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private ImageView state;
        private ImageView maneger;
    }

}
