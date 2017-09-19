package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

public class AdapterClassifyGV extends BaseAdapter{
	private Context context;
	private List<Map<String, Object>> listitem;

	public AdapterClassifyGV(Context context,List<Map<String, Object>> listitem) {
		this.context = context;
		this.listitem = listitem;
	}

	@Override
	public int getCount() {
		return listitem.size();
	}

	@Override
	public Object getItem(int position) {
		return listitem.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.fragment_classify_rv_item, null);
		}

		ImageView imageView = (ImageView) convertView.findViewById(R.id.gv_pic);
		TextView textView = (TextView) convertView.findViewById(R.id.gv_name);

		Map<String, Object> map = listitem.get(position);
		Glide.with(context)
				.load((Integer) map.get("image"))
				.into(imageView);
//		imageView.setImageResource((Integer) map.get("image"));
		textView.setText(map.get("gv_title") + "");
		return convertView;
	}
}
