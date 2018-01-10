package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.RosePerSonalFragmentPictureFanseEntry;

import java.util.List;

/**
 * Created by Administrator on 2018/1/10.
 */
public class RosePerSonalFragmentPictureFanseAdapter extends BaseAdapter{

    private List<RosePerSonalFragmentPictureFanseEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public RosePerSonalFragmentPictureFanseAdapter(List<RosePerSonalFragmentPictureFanseEntry> list, Context context) {
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
        RosePerSonalFragmentPictureFanseHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.rose_personal_fragment_picture_fanse_adapter , null);
            holder = new RosePerSonalFragmentPictureFanseHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.rose_personal_fragment_picture_fanse_adapter_userimage);
            holder.lible = (TextView) view.findViewById(R.id.rose_personal_fragment_picture_fanse_adapter_username);
            holder.content = (TextView) view.findViewById(R.id.rose_personal_fragment_picture_fanse_adapter_content);
            holder.add = (ImageView) view.findViewById(R.id.rose_personal_fragment_picture_fanse_adapter_add);
            holder.menu = (ImageView) view.findViewById(R.id.rose_personal_fragment_picture_fanse_adapter_meun);
            view.setTag(holder);
        }else{
            holder = (RosePerSonalFragmentPictureFanseHolder) view.getTag();
        }

        RosePerSonalFragmentPictureFanseEntry init = (RosePerSonalFragmentPictureFanseEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());

        return view;
    }

    public class RosePerSonalFragmentPictureFanseHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private ImageView add;
        private ImageView menu;

    }

}
