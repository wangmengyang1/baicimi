package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.AddAddressBean;
import com.baicimi.bean.PinPaiLvBean;

import java.util.List;

/**
 * Created by tan on 2017/1/4.
 */
public class AddAddressAdapter extends BaseAdapter {

    private Context mContext;
    private List<AddAddressBean> mList;
    private LayoutInflater mLayoutInflater;

    public AddAddressAdapter(Context context, List<AddAddressBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.add_address_item, null);

            mViewHolder.name = (TextView) convertView.findViewById(R.id.man_name);
            mViewHolder.phone_num = (TextView) convertView.findViewById(R.id.man_phone_num);
            mViewHolder.address = (TextView) convertView.findViewById(R.id.man_address);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.name.setSelected(true);
        mViewHolder.name.setText(mList.get(position).getName());
        mViewHolder.phone_num.setText(mList.get(position).getPhone_num());
        mViewHolder.address.setText(mList.get(position).getAddress());

        return convertView;
    }

    class ViewHolder {
        private TextView name;
        private TextView phone_num;
        private TextView address;

    }

}

