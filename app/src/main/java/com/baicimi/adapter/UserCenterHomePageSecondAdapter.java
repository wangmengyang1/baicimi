package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UserCenterHomePageEntrySecond;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */
public class UserCenterHomePageSecondAdapter extends BaseAdapter{

    private Context context;
    private List<UserCenterHomePageEntrySecond> list;
    private LayoutInflater inflater;


    public UserCenterHomePageSecondAdapter(Context context, List<UserCenterHomePageEntrySecond> list) {
        this.context = context;
        this.list = list;
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
        UserCenterHomePageSecondHolder holder = null;

        if (view == null){
            view = inflater.inflate(R.layout.user_center_home_page_second_adapter , null);
            holder = new UserCenterHomePageSecondHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.user_center_home_page_second_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.user_center_home_page_second_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.user_center_home_page_second_adapter_content);
            holder.newMoney = (TextView) view.findViewById(R.id.user_center_home_page_second_adapter_newmoney);
            holder.oldMoney = (TextView) view.findViewById(R.id.user_center_home_page_second_adapter_oldmoney);

            view.setTag(holder);
        }else{
            holder = (UserCenterHomePageSecondHolder) view.getTag();
        }

        UserCenterHomePageEntrySecond init = (UserCenterHomePageEntrySecond) getItem(i);

        Glide.with(context)
                .load(init.getImageUrl())
                .into( holder.imageUrl);

//        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.newMoney.setText(init.getNewMoney());
        holder.oldMoney.setText(init.getOldMoney());

        return view;
    }

    public class UserCenterHomePageSecondHolder{
        private TextView lible;
        private TextView content;
        private ImageView imageUrl;
        private TextView newMoney;
        private TextView oldMoney;
    }

}
