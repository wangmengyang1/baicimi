package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baicimi.R;
import com.baicimi.bean.MiEduBean;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 */
public class MiEduListAdapter extends BaseAdapter{

    private Context mContext;
    private List<MiEduBean> mList;
    private LayoutInflater mLayoutInflater;

    public MiEduListAdapter(Context context, List<MiEduBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.mifenqi_diandian_item, null);
            mViewHolder.dian_img = (ImageView) convertView.findViewById(R.id.diandian);
            mViewHolder.tv = (TextView) convertView.findViewById(R.id.tv_know);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.dian_img.setSelected(true);
        mViewHolder.dian_img.setImageResource(R.mipmap.kaitongdianed);
        mViewHolder.tv.setText(mList.get(position).getTv());

        return convertView;
    }


    class ViewHolder {
        private ImageView dian_img;
        private TextView tv;
    }

}
