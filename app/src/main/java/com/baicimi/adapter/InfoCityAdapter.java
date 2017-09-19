package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.CityEneity;

import java.util.ArrayList;


/**
 * 文件名：InfoCityAdapter
 * 描    述：城市列表适配器
 * 时    间：2016-03-01
 * 版    权：
 */
public class InfoCityAdapter extends BaseAdapter {
    Context context;
    ArrayList<CityEneity> list;

    public InfoCityAdapter(Context cont, ArrayList<CityEneity> list) {
        context = cont;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_list_info_place, null);
            holder.province = (TextView) convertView.findViewById(R.id.place_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.province.setText(list.get(position).getName());
        return convertView;
    }

    class ViewHolder {
        private TextView province;
    }
}
