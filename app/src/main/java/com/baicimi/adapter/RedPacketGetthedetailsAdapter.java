package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.RedPacketGetthedetailsEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
public class RedPacketGetthedetailsAdapter extends BaseAdapter{

    private List<RedPacketGetthedetailsEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public RedPacketGetthedetailsAdapter(List<RedPacketGetthedetailsEntry> list, Context context) {
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
        RedPacketGetthedetailsHolder holder = null;

        if (view == null){
            view = inflater.inflate(R.layout.red_packet_getthe_details_adapter , null);
            holder = new RedPacketGetthedetailsHolder();
            holder.imageurl = (ImageView) view.findViewById(R.id.red_packet_getthe_details_imageurl);
            holder.numberimage = (ImageView) view.findViewById(R.id.red_packet_getthe_details_imagenumber);
            holder.username = (TextView) view.findViewById(R.id.red_packet_getthe_details_username);
            holder.lible = (TextView) view.findViewById(R.id.red_packet_getthe_details_lible);
            holder.date = (TextView) view.findViewById(R.id.red_packet_getthe_details_date);
            holder.number = (TextView) view.findViewById(R.id.red_packet_getthe_details_non);
            view.setTag(holder);
        }else {
            holder = (RedPacketGetthedetailsHolder) view.getTag();
        }

        RedPacketGetthedetailsEntry init = (RedPacketGetthedetailsEntry) getItem(i);

        holder.imageurl.setImageResource(init.getImageurl());
        holder.username.setText(init.getUsername());
        holder.lible.setText(init.getLible());
        holder.date.setText(init.getDate());
        if (i <= 2){
            holder.numberimage.setVisibility(View.VISIBLE);

        }else{
            holder.numberimage.setVisibility(View.INVISIBLE);
        }
        holder.number.setText(i + "");
        return view;
    }

    public class RedPacketGetthedetailsHolder{
        private ImageView imageurl;
        private TextView username;
        private TextView lible;
        private TextView date;
        private TextView number;
        private ImageView numberimage;

    }

}
