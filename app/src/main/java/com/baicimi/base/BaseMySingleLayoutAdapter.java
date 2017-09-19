package com.baicimi.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseMySingleLayoutAdapter<T> extends BaseAdapter {
	private Context context;
	private List<T> datas;
	private int layoutId;
	private LayoutInflater inflater;

	public BaseMySingleLayoutAdapter(Context context, int layoutId) {
		super();
		this.context = context;
		this.layoutId = layoutId;
		datas = new ArrayList<T>();
		inflater = LayoutInflater.from(context);
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
		notifyDataSetChanged();
	}

	public void addDatas(List<T> datas) {
		this.datas.addAll(datas);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView != null) {
			holder = (ViewHolder) convertView.getTag();
		} else {			
			convertView = inflater.inflate(layoutId, parent, false);
//			convertView = View.inflate(context, layoutId, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		}

		bindDatas(holder, datas,position);

		return convertView;
	}

	public abstract void bindDatas(ViewHolder holder, List<T> datas2,int position);

	public class ViewHolder {
		private Map<Integer, View> layoutMap = new HashMap<Integer, View>();
		private View layout;// ���ֶ���

		public ViewHolder(View layout) {
			this.layout = layout;
		}

		public View getView(int id) {
			if (layoutMap.containsKey(id)) {
				return layoutMap.get(id);
			} else {
				View v = layout.findViewById(id);
				layoutMap.put(id, v);
				return v;
			}

		}

	}
}
