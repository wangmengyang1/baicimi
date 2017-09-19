package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.FenQiZhangDanDetailsBean;
import com.baicimi.bean.ZhangDanDetailsBean;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 */
public class FenQiZhangDanDetailListAdapter extends BaseAdapter{

    private Context mContext;
    private List<FenQiZhangDanDetailsBean> mList;
    private LayoutInflater mLayoutInflater;

    public FenQiZhangDanDetailListAdapter(Context context, List<FenQiZhangDanDetailsBean> mList) {
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }



    @Override
    public int getCount() {
        return 10;
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
            convertView = mLayoutInflater.inflate(R.layout.zhangdanfenqi_list_item, null);
            mViewHolder.time = (TextView) convertView.findViewById(R.id.time);
            mViewHolder.goods_name = (TextView) convertView.findViewById(R.id.goods_name);
            mViewHolder.mony_num = (TextView) convertView.findViewById(R.id.mony_num);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.time.setSelected(true);
        mViewHolder.time.setText(mList.get(position).getTime());
        mViewHolder.goods_name.setText(mList.get(position).getGoods_name());
        mViewHolder.mony_num.setText(mList.get(position).getMony_num());


        return convertView;
    }


    class ViewHolder {
        private TextView time;
        private TextView goods_name;
        private TextView mony_num;
    }

}
