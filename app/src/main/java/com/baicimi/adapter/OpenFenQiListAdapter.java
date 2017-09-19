package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baicimi.R;
import com.baicimi.bean.OpenFenQiBean;
import java.util.List;

/**
 * Created by tan on 2016/9/5.
 */
public class OpenFenQiListAdapter extends BaseAdapter{

    private Context mContext;
    private List<OpenFenQiBean> mList;
    private LayoutInflater mLayoutInflater;

    public OpenFenQiListAdapter(Context context, List<OpenFenQiBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.fragment_fenqi_know_listitem, null);
            mViewHolder.tv = (TextView) convertView.findViewById(R.id.tv_know);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv.setSelected(true);
        mViewHolder.tv.setText(mList.get(position).getTv_know());

        return convertView;
    }


    class ViewHolder {
        private TextView tv;
    }

}
