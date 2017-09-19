package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.ZhangDanDetailsBean;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 */
public class ZhangDanDetailListAdapter extends BaseAdapter{

    private Context mContext;
    private List<ZhangDanDetailsBean> mList;
    private LayoutInflater mLayoutInflater;

    public ZhangDanDetailListAdapter(Context context, List<ZhangDanDetailsBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }



    @Override
    public int getCount() {
        return 3;
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
            convertView = mLayoutInflater.inflate(R.layout.zhangdan_details_item, null);
            mViewHolder.time = (TextView) convertView.findViewById(R.id.time);
            mViewHolder.back_time = (TextView) convertView.findViewById(R.id.back_mony_time);
            mViewHolder.mony_num = (TextView) convertView.findViewById(R.id.back_mony_num);
            mViewHolder.yes_back = (TextView) convertView.findViewById(R.id.yes_back);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.time.setSelected(true);
        mViewHolder.time.setText(mList.get(position).getTime());
        mViewHolder.back_time.setText(mList.get(position).getBack_time());
        mViewHolder.mony_num.setText(mList.get(position).getMony_num());
        mViewHolder.yes_back.setText(mList.get(position).getYes_back());


        return convertView;
    }


    class ViewHolder {
        private TextView time;
        private TextView back_time;
        private TextView mony_num;
        private TextView yes_back;
    }

}
