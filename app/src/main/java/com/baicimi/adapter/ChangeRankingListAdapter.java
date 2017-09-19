package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.ChangeRankingLvBean;
import com.baicimi.bean.ShaiXuanListBean;
import com.baicimi.ui.RotateTextView;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 */
public class ChangeRankingListAdapter extends BaseAdapter{

    private Context mContext;
    private List<ChangeRankingLvBean> mList;
    private LayoutInflater mLayoutInflater;

    public ChangeRankingListAdapter(Context context, List<ChangeRankingLvBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.change_ranking_list_item, null);
            mViewHolder.tv_goods_name = (TextView) convertView.findViewById(R.id.goods_name);
            mViewHolder.tv_no= (RotateTextView) convertView.findViewById(R.id.tv_no);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_name.setSelected(true);
        mViewHolder.tv_goods_name.setText(mList.get(position).getName());
        mViewHolder.tv_no.setText(mList.get(position).getNo());
        mViewHolder.tv_no.setDegrees(318);

        return convertView;
    }


    class ViewHolder {
        private TextView tv_goods_name;
        private RotateTextView tv_no;
    }

}
