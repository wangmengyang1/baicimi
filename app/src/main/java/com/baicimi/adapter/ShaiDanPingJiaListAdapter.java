package com.baicimi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.activitys.ShaiDanPingJiaActivity;
import com.baicimi.bean.ShaiDnaPingJiaListBean;

import java.util.List;

/**
 * Created by tan on 2016/9/29.
 * 晒单评价listview适配器
 */
public class ShaiDanPingJiaListAdapter extends BaseAdapter {
    private Context mContext;
    private List<ShaiDnaPingJiaListBean> mList;
    private LayoutInflater mLayoutInflater;

    public ShaiDanPingJiaListAdapter(Context context, List<ShaiDnaPingJiaListBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.pingjia_goods_list_item, null);

            mViewHolder.tv_pinglun_goods_message = (TextView) convertView.findViewById(R.id.tv_pingjia_goods);
            mViewHolder.re_shaidan= (RelativeLayout) convertView.findViewById(R.id.re_shaidan);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_pinglun_goods_message.setSelected(true);
        mViewHolder.tv_pinglun_goods_message.setText(mList.get(position).getTv_shaidan_goods_message());

        mViewHolder.re_shaidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,ShaiDanPingJiaActivity.class);
                mContext.startActivity(intent);
            }
        });


        return convertView;
    }


    class ViewHolder {
        private TextView tv_pinglun_goods_message;
        private RelativeLayout re_shaidan;
    }
}
