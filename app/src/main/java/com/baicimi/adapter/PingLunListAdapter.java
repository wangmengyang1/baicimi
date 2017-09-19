package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.PingLunContentsBean;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 * 评论内容适配器
 */
public class PingLunListAdapter extends BaseAdapter{

    private Context mContext;
    private List<PingLunContentsBean> mList;
    private LayoutInflater mLayoutInflater;
    private int num = 0;

    public PingLunListAdapter(Context context, List<PingLunContentsBean> mList) {
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
        final ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.pinglun_listview, null);

            mViewHolder.tv_user_name = (TextView) convertView.findViewById(R.id.tv_user_name);
            mViewHolder.tv_pinglun_time = (TextView) convertView.findViewById(R.id.pinglun_time);
            mViewHolder.tv_pinglun_contents = (TextView) convertView.findViewById(R.id.tv_pinglun_contents);
            mViewHolder.tv_pinglun_goods_message = (TextView) convertView.findViewById(R.id.pinggu_goods_message);
            mViewHolder.tv_goods_buy_time = (TextView) convertView.findViewById(R.id.goods_buy_time);
            mViewHolder.tv_pinglun_nums = (TextView) convertView.findViewById(R.id.pinglun_contents_num);
            mViewHolder.tv_pinglun_zans_num = (TextView) convertView.findViewById(R.id.pinglun_zan_nums);
            mViewHolder.img_pinglun_zans_num = (ImageView) convertView.findViewById(R.id.img_pinglun_zans);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_user_name.setSelected(true);
        mViewHolder.tv_user_name.setText(mList.get(position).getTv_user_name());
        mViewHolder.tv_pinglun_time.setText(mList.get(position).getTv_pinglun_time());
        mViewHolder.tv_pinglun_contents.setText(mList.get(position).getTv_pinglun_contents());
        mViewHolder.tv_pinglun_goods_message.setText(mList.get(position).getTv_pinglun_goods_message());
        mViewHolder.tv_goods_buy_time.setText(mList.get(position).getTv_goods_buy_time());
        mViewHolder.tv_pinglun_nums.setText(mList.get(position).getTv_pinglun_nums());
        mViewHolder.tv_pinglun_zans_num.setText(mList.get(position).getTv_pinglun_zans_num());

        mViewHolder.img_pinglun_zans_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                String s=String.valueOf(num);
                mViewHolder.tv_pinglun_zans_num.setText(s);
            }
        });

        return convertView;
    }


    class ViewHolder {
        private TextView tv_user_name;
        private TextView tv_pinglun_time;
        private TextView tv_pinglun_contents;
        private TextView tv_pinglun_goods_message;
        private TextView tv_goods_buy_time;
        private TextView tv_pinglun_nums;
        private TextView tv_pinglun_zans_num;
        private ImageView img_pinglun_zans_num;
    }

}
