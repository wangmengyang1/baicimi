package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.RoseZanListBean;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 * 玫瑰社区奢侈list适配器
 */
public class RosePersonalZanListAdapter extends BaseAdapter{

    private Context mContext;
    private List<RoseZanListBean> mList;
    private LayoutInflater mLayoutInflater;

    public RosePersonalZanListAdapter(Context context, List<RoseZanListBean> mList) {
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
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.fragment_rosezan_list_item, null);

            mViewHolder.name = (TextView) convertView.findViewById(R.id.tv3);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.name.setSelected(true);
        mViewHolder.name.setText(mList.get(position).getName());

        return convertView;
    }


    class ViewHolder {
        private TextView name;
    }

}
