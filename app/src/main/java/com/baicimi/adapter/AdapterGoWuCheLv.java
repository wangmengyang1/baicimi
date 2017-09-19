package com.baicimi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.bean.GouWuCheListBean;

import java.util.List;


//购物车列表ListView
public class AdapterGoWuCheLv extends BaseAdapter {

    private Context mContext;
    private List<GouWuCheListBean> mList;
    private LayoutInflater mLayoutInflater;
    private int num = 1;


    public AdapterGoWuCheLv(Context context, List<GouWuCheListBean> mList) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.fragment_gouwuche_item, null);

            mViewHolder.tv_goods_message = (TextView) convertView.findViewById(R.id.gouwuche_goods_message);
            mViewHolder.tv_bianhao = (TextView) convertView.findViewById(R.id.gouwuche_goods_yanse_num);

            //加减
            mViewHolder.tv_add = (TextView) convertView.findViewById(R.id.gouwuche_goods_add);
            mViewHolder.tv_jian = (TextView) convertView.findViewById(R.id.gouwuche_goods_jian);
            mViewHolder.tv_gouwuche_goods_num = (TextView) convertView.findViewById(R.id.gouwuche_goods_num);
            //根据id获取对象
            mViewHolder.spinner1 = (Spinner) convertView.findViewById(R.id.btn_kuanshi);
            mViewHolder.spinner2 = (Spinner) convertView.findViewById(R.id.btn_jifendikou);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.tv_goods_message.setSelected(true);
        mViewHolder.tv_goods_message.setText(mList.get(position).getGoods_message());
        mViewHolder.tv_bianhao.setText(mList.get(position).getYanse_num());


        num = Integer.parseInt(mViewHolder.tv_gouwuche_goods_num.getText().toString());
        mViewHolder.tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                String s = String.valueOf(num);
                mViewHolder.tv_gouwuche_goods_num.setText(s);
            }
        });
        mViewHolder.tv_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num > 0) {
                    num--;
                }
                String s = String.valueOf(num);
                mViewHolder.tv_gouwuche_goods_num.setText(s);
            }
        });

        //显示的数组
        final String arr1[] = new String[]{
                "XS",
                "S",
                "M",
                "L",
                "XL",
                "XXL",
                "XXXL"};
        //显示的数组
        final String arr2[] = new String[]{
                "1000积分抵扣10元",
                "1500积分抵扣15元",
                "3000积分抵扣30元",
                "不使用积分",
               };


        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(convertView.getContext(),android.R.layout.simple_spinner_item, arr1);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(convertView.getContext(),android.R.layout.simple_spinner_item, arr2);
        //设置显示的数据
        mViewHolder.spinner1.setAdapter(arrayAdapter1);
        mViewHolder.spinner2.setAdapter(arrayAdapter2);
        return convertView;
    }


    class ViewHolder {
        private TextView tv_goods_message;
        private TextView tv_bianhao;

        private TextView tv_add;
        private TextView tv_jian;
        private TextView tv_gouwuche_goods_num;

        //声明spinner对象
        private Spinner spinner1, spinner2;
    }

}
