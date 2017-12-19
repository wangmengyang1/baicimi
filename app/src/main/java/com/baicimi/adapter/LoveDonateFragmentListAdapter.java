package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.LoveDonateFragmentEntry;
import com.baicimi.view.CircleImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class LoveDonateFragmentListAdapter extends BaseAdapter{

    private List<LoveDonateFragmentEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public LoveDonateFragmentListAdapter(List<LoveDonateFragmentEntry> list, Context context) {
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
        LoveDonateFragmentListHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.love_donate_fragment_list_adapter , null);
            holder = new LoveDonateFragmentListHolder();
            holder.lible = (TextView) view.findViewById(R.id.love_donate_fragment_list_adapter_lible);
            holder.imageUrl = (ImageView) view.findViewById(R.id.love_donate_fragment_list_adapter_imageurl);
            holder.content = (TextView) view.findViewById(R.id.love_donate_fragment_list_adapter_content);
            holder.userImage = (CircleImageView) view.findViewById(R.id.love_donate_fragment_list_adapter_userimage);
            holder.userName = (TextView) view.findViewById(R.id.love_donate_fragment_list_adapter_username);
            holder.userAddress = (TextView) view.findViewById(R.id.love_donate_fragment_list_adapter_address);

            view.setTag(holder);
        }else{
            holder = (LoveDonateFragmentListHolder) view.getTag();
        }

        LoveDonateFragmentEntry init = (LoveDonateFragmentEntry) getItem(i);

        holder.lible.setText(init.getLible());
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.content.setText(init.getContent());
        holder.userImage.setImageResource(init.getUserImage());
        holder.userName.setText(init.getName());
        holder.userAddress.setText(init.getAddress());
        return view;
    }

    public class LoveDonateFragmentListHolder{
        private TextView lible;
        private ImageView imageUrl;
        private TextView content;
        private CircleImageView userImage;
        private TextView userName;
        private TextView userAddress;
    }
}
