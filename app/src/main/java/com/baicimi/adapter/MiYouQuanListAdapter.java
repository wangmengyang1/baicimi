package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.MiYouQuanBean;
import java.util.List;

/**
 * Created by tan on 2016/9/5.
 * 幂友圈list适配器
 */
public class MiYouQuanListAdapter extends BaseAdapter{

    private Context mContext;
    private List<MiYouQuanBean> mList;
    private LayoutInflater mLayoutInflater;

    public MiYouQuanListAdapter(Context context, List<MiYouQuanBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.fragment_miyouquan_list_item, null);

            mViewHolder.zhuanfa_time = (TextView) convertView.findViewById(R.id.zhuanfa_time);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.zhuanfa_time.setSelected(true);
        mViewHolder.zhuanfa_time.setText(mList.get(position).getZhuanfa_time());

        return convertView;
    }


    class ViewHolder {
        private TextView zhuanfa_time;
    }

}
