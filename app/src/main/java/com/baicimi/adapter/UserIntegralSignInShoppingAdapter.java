package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UserIntegralSignInShoppingEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */
public class UserIntegralSignInShoppingAdapter extends BaseAdapter{

    private List<UserIntegralSignInShoppingEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public UserIntegralSignInShoppingAdapter(List<UserIntegralSignInShoppingEntry> list, Context context) {
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
        UserIntegralSignInShoppingHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.user_integral_sign_in_shoppint_adapter , null);
            holder = new UserIntegralSignInShoppingHolder();
            holder.date = (TextView) view.findViewById(R.id.user_integral_sign_in_shoppint_adapter_date);
            holder.state = (TextView) view.findViewById(R.id.user_integral_sign_in_shoppint_adapter_state);
            holder.imageUrl = (ImageView) view.findViewById(R.id.user_integral_sign_in_shoppint_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.user_integral_sign_in_shoppint_adapter_lible);
            holder.category = (TextView) view.findViewById(R.id.user_integral_sign_in_shoppint_adapter_category);
            view.setTag(holder);
        }else{
            holder = (UserIntegralSignInShoppingHolder) view.getTag();
        }

        UserIntegralSignInShoppingEntry init = (UserIntegralSignInShoppingEntry) getItem(i);

        holder.date.setText(init.getDate());
        holder.state.setText(init.getState());
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.category.setText(init.getCategory());


        return view;
    }

    public class UserIntegralSignInShoppingHolder{
        private TextView date;
        private TextView state;
        private ImageView imageUrl;
        private TextView lible;
        private TextView category;
    }

}
