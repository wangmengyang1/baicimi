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
import com.baicimi.view.MiChatInviteFriendsDialog;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class MiChatInviteFriendsAdapter extends BaseAdapter{
    private List<MiChatAddFriendsEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MiChatInviteFriendsAdapter(List<MiChatAddFriendsEntry> list, Context context) {
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
        MiChatInviteFriendsHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_chat_invite_friends_adapter , null);
            holder = new MiChatInviteFriendsHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.mi_chat_invite_friends_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.mi_chat_invite_friends_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.mi_chat_invite_friends_adapter_content);
            holder.steteB = (TextView) view.findViewById(R.id.mi_chat_invite_friends_adapter_invite);
            view.setTag(holder);
        }else{
            holder = (MiChatInviteFriendsHolder) view.getTag();
        }

        MiChatAddFriendsEntry init = (MiChatAddFriendsEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        if (init.getContent().equals("邀请失败")){
            holder.content.setVisibility(View.VISIBLE);
            holder.steteB.setText("再次邀请");
        }else {
            holder.content.setVisibility(View.INVISIBLE);
            holder.steteB.setText("邀请");

        }

        holder.steteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MiChatInviteFriendsDialog miChatInviteFriendsDialog = new MiChatInviteFriendsDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive);
                miChatInviteFriendsDialog.show();
            }
        });
        return view;
    }

    public class MiChatInviteFriendsHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private ImageView state;
        private TextView steteB;
    }
}
