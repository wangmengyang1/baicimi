package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MiChatFriendsCircleEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class MiChatFriendsCircleAdapter extends BaseAdapter{

    private List<MiChatFriendsCircleEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public MiChatFriendsCircleAdapter(List<MiChatFriendsCircleEntry> list, Context context) {
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
        MiChatFriendsCircleHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_chat_friends_circle_adapter , null);
            holder = new MiChatFriendsCircleHolder();
            holder.imageFirst = (ImageView) view.findViewById(R.id.mi_chat_friends_circle_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.mi_chat_friends_circle_adapter_content);
            holder.dateAddress = (TextView) view.findViewById(R.id.mi_chat_friends_circle_adapter_dateaddress);
            holder.userImage = (ImageView) view.findViewById(R.id.mi_chat_friends_circle_adapter_userimage);
            holder.userName = (TextView) view.findViewById(R.id.mi_chat_friends_circle_adapter_username);
            holder.userAddress = (TextView) view.findViewById(R.id.mi_chat_friends_circle_adapter_useraddress);
            holder.attention = (TextView) view.findViewById(R.id.mi_chat_friends_circle_adapter_attention);

            view.setTag(holder);
        }else{
            holder = (MiChatFriendsCircleHolder) view.getTag();
        }

        MiChatFriendsCircleEntry init = (MiChatFriendsCircleEntry) getItem(i);

        holder.imageFirst.setImageResource(init.getImageFirst());
        holder.lible.setText(init.getLible());
        holder.dateAddress.setText(init.getDateAddress());
        holder.userImage.setImageResource(init.getUserImage());
        holder.userName.setText(init.getUsername());
        holder.userAddress.setText(init.getUserAddress());

        return view;
    }

    public class MiChatFriendsCircleHolder{
        private ImageView imageFirst;
        private ImageView imageSecond;
        private TextView lible;
        private TextView dateAddress;
        private ImageView userImage;
        private TextView userName;
        private TextView userAddress;
        private TextView attention;//关注


    }

}
