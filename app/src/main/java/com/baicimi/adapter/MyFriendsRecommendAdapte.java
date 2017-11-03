package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MyFriendsRecommendFragmentEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */
public class MyFriendsRecommendAdapte extends BaseAdapter{

    private List<MyFriendsRecommendFragmentEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MyFriendsRecommendAdapte(List<MyFriendsRecommendFragmentEntry> list, Context context) {
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
        MyFriendsRecommendHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.my_friends_recommend_adapter , null);
            holder = new MyFriendsRecommendHolder();
            holder.name = (TextView) view.findViewById(R.id.my_friends_recommend_adapter_name);
            holder.phoneNumber = (TextView) view.findViewById(R.id.my_friends_recommend_adapter_phonenumber);
            holder.email = (TextView) view.findViewById(R.id.my_friends_recommend_adapter_email);
            holder.weichect = (TextView) view.findViewById(R.id.my_friends_recommend_adapter_weichect);
            holder.state = (TextView) view.findViewById(R.id.my_friends_recommend_adapter_state);
            holder.layout = (LinearLayout) view.findViewById(R.id.my_friends_recommend_adapter_layout);
            holder.deblocking = (ImageView) view.findViewById(R.id.my_friends_recommend_adapter_deblocking);
            holder.add = (ImageView) view.findViewById(R.id.my_friends_recommend_adapter_add);
            view.setTag(holder);
        }else{
            holder = (MyFriendsRecommendHolder) view.getTag();
        }

        MyFriendsRecommendFragmentEntry init = (MyFriendsRecommendFragmentEntry) getItem(i);

        holder.name.setText(init.getName());
        holder.phoneNumber.setText(init.getPhoneNumber());
        holder.email.setText(init.getEmail());
        holder.weichect.setText(init.getWeichect());
        holder.state.setText(init.getState());

        if (!init.isCheck() && (i+1 != getCount())){
            holder.layout.setVisibility(View.INVISIBLE);
            holder.add.setVisibility(View.GONE);
            holder.deblocking.setVisibility(View.VISIBLE);
        }else if (i+1 == getCount()){
            holder.layout.setVisibility(View.INVISIBLE);
            holder.add.setVisibility(View.VISIBLE);
            holder.deblocking.setVisibility(View.GONE);
        }else {
            holder.layout.setVisibility(View.VISIBLE);
            holder.add.setVisibility(View.GONE);
            holder.deblocking.setVisibility(View.GONE);
        }


        return view;
    }

    public class MyFriendsRecommendHolder{
        private TextView name;
        private TextView phoneNumber;
        private TextView email;
        private TextView weichect;
        private TextView state;
        private LinearLayout layout;
        private ImageView deblocking;//锁
        private ImageView add;//添加
    }

}
