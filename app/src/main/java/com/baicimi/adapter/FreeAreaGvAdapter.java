package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.ChangeRankingLvBean;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 */
public class FreeAreaGvAdapter extends BaseAdapter{

    private Context mContext;
    private List<ChangeRankingLvBean> mList;
    private LayoutInflater mLayoutInflater;

    public FreeAreaGvAdapter(Context context, List<ChangeRankingLvBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.free_area_list_item, null);

            mViewHolder.tv_goods_name = (TextView) convertView.findViewById(R.id.goods_name);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_goods_name.setSelected(true);
        mViewHolder.tv_goods_name.setText(mList.get(position).getName());

        return convertView;
    }


    class ViewHolder {
        private TextView tv_goods_name;
    }

}
