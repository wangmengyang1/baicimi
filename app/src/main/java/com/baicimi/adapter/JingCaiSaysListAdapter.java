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
 * 精彩评论list适配器
 */
public class JingCaiSaysListAdapter extends BaseAdapter{

    private Context mContext;
    private List<MiYouQuanBean> mList;
    private LayoutInflater mLayoutInflater;

    public JingCaiSaysListAdapter(Context context, List<MiYouQuanBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.fragment_jingcai_says_list_item, null);

            mViewHolder.message = (TextView) convertView.findViewById(R.id.jingcai_says_message);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.message.setSelected(true);
        mViewHolder.message.setText(mList.get(position).getZhuanfa_time());

        return convertView;
    }


    class ViewHolder {
        private TextView message;
    }

}
