package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baicimi.R;
import com.baicimi.bean.MyDingDanLvBean;
import java.util.List;

/**
 * Created by tan on 2016/9/5.
 * 我的订单ListView适配器
 */
public class MyDingDanListAdapter extends BaseAdapter{

    private Context mContext;
    private List<MyDingDanLvBean> mList;
    private LayoutInflater mLayoutInflater;

    public MyDingDanListAdapter(Context context, List<MyDingDanLvBean> mList) {
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
            convertView = mLayoutInflater.inflate(R.layout.fragment_my_dingdan_item, null);

            mViewHolder.tv_my_dingdan_goods_message = (TextView) convertView.findViewById(R.id.my_dingdan_goods_message);
            mViewHolder.tv_my_dingdan_goods_color = (TextView) convertView.findViewById(R.id.my_dingdan_goods_color);
            mViewHolder.tv_my_dingdan_goods_price = (TextView) convertView.findViewById(R.id.my_dingdan_goods_price);
            mViewHolder.tv_my_dingdan_goods_num = (TextView) convertView.findViewById(R.id.my_dingdan_goods_num);
            mViewHolder.tv_my_dingdan_goods_allprice = (TextView) convertView.findViewById(R.id.my_dingdan_goods_allprice);
            mViewHolder.tv_my_dingdan_goods_allnum = (TextView) convertView.findViewById(R.id.my_dingdan_goods_num_all);

            mViewHolder.btn_wuliu= (Button) convertView.findViewById(R.id.btn_chakanwuliu);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv_my_dingdan_goods_message.setSelected(true);
        mViewHolder.tv_my_dingdan_goods_message.setText(mList.get(position).getTv_my_dingdan_goods_message());
        mViewHolder.tv_my_dingdan_goods_color.setText(mList.get(position).getTv_my_dingdan_goods_color());
        mViewHolder.tv_my_dingdan_goods_price.setText(mList.get(position).getTv_my_dingdan_goods_price());
        mViewHolder.tv_my_dingdan_goods_num.setText(mList.get(position).getTv_my_dingdan_goods_num());
        mViewHolder.tv_my_dingdan_goods_allprice.setText(mList.get(position).getTv_my_dingdan_goods_allprice());
        mViewHolder.tv_my_dingdan_goods_allnum.setText(mList.get(position).getTv_my_dingdan_goods_allnum());

//            mViewHolder.btn_wuliu.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(mContext,WuLiuDetailsActivity.class);
//                    mContext.startActivity(intent);
//                }
//            });

        return convertView;
    }


    class ViewHolder {
        private TextView tv_my_dingdan_goods_message;
        private TextView tv_my_dingdan_goods_color;
        private TextView tv_my_dingdan_goods_price;
        private TextView tv_my_dingdan_goods_num;
        private TextView tv_my_dingdan_goods_allprice;
        private TextView tv_my_dingdan_goods_allnum;

        private Button btn_wuliu;
    }

}
