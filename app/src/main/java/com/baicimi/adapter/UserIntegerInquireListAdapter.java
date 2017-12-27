package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.FragmentInquireListEntry;
import com.baicimi.fragments.UserInregralInquireListAdapterLook;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class UserIntegerInquireListAdapter extends BaseAdapter{
    private List<FragmentInquireListEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private BaseFragment fragment;

    public UserIntegerInquireListAdapter(List<FragmentInquireListEntry> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    public UserIntegerInquireListAdapter(List<FragmentInquireListEntry> list, Context context, BaseFragment fragment) {
        this.list = list;
        this.context = context;
        this.fragment = fragment;
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
        UserIntegerInquireHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.userinteger_inquire_list_adapter, null);
            holder = new UserIntegerInquireHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.userinteger_inquire_list_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.userinteger_inquire_list_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.userinteger_inquire_list_adapter_content);
            holder.look = (TextView) view.findViewById(R.id.userinteger_inquire_list_adapter_look);
            view.setTag(holder);
        }else {
            holder = (UserIntegerInquireHolder) view.getTag();
        }
        FragmentInquireListEntry init = (FragmentInquireListEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());

        holder.look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragment != null){
                    //个人中心-会员中心-会员积分-去看看
                    fragment.startFragment(new UserInregralInquireListAdapterLook());
                }
            }
        });
        return view;
    }

    public class UserIntegerInquireHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private TextView look;
    }

}
