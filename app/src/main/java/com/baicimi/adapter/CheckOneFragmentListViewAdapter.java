package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.CheckOneFragmentEntry;
import com.baicimi.entity.CheckOneFragmentGridViewEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */
public class CheckOneFragmentListViewAdapter extends BaseAdapter{

    private Context context;
    private List<CheckOneFragmentEntry> list;
    private LayoutInflater inflater;

    private List<CheckOneFragmentGridViewEntry> list_gv = new ArrayList<>();
    private CheckOneFragmentGridViewAdapter adapter;


    public CheckOneFragmentListViewAdapter(Context context, List<CheckOneFragmentEntry> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckOneFragmentListViewHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.check_one_fragment_listview_adapter , null);
            holder = new CheckOneFragmentListViewHolder();
            holder.userImage = (ImageView) view.findViewById(R.id.check_one_fragment_listview_adapter_userimage);
            holder.userName = (TextView) view.findViewById(R.id.check_one_fragment_listview_adapter_username);
            holder.date = (TextView) view.findViewById(R.id.check_one_fragment_listview_adapter_date);
            holder.content = (TextView) view.findViewById(R.id.check_one_fragment_listview_adapter_content);
            holder.comment = (TextView) view.findViewById(R.id.check_one_fragment_listview_adapter_comment);
            holder.shareNumber = (TextView) view.findViewById(R.id.check_one_fragment_listview_adapter_sharknumber);
            holder.liekNumber = (TextView) view.findViewById(R.id.check_one_fragment_listview_adapter_likenumber);
            holder.gridView = (GridView) view.findViewById(R.id.check_one_fragment_listview_adapter_gridview);
            view.setTag(holder);
        }else{
            holder = (CheckOneFragmentListViewHolder) view.getTag();
        }

        CheckOneFragmentEntry init = (CheckOneFragmentEntry) getItem(i);
        holder.userName.setText(init.getUserName());
        holder.date.setText(init.getDate());
        holder.content.setText(init.getContent());
        holder.comment.setText(init.getComment());
        holder.shareNumber.setText(init.getShareNumber());
        holder.liekNumber.setText(init.getLiekNumber());
        holder.userImage.setImageResource(init.getUserImage());


        list_gv.clear();
        for(int l = 0 ; l < 9 ; l++){
            list_gv.add(new CheckOneFragmentGridViewEntry(init.getCheckOneFragmentGridviewEntry()));
        }
        adapter = new CheckOneFragmentGridViewAdapter(context , list_gv);
        holder.gridView.setAdapter(adapter);
        fixGridViewHeight(holder.gridView);
        return view;
    }

    public class CheckOneFragmentListViewHolder{
        private ImageView userImage;
        private TextView userName;
        private TextView date;
        private TextView content;
        private GridView gridView;
        private TextView comment;
        private TextView shareNumber;
        private TextView liekNumber;
    }

    //动态计算listview的高度
    public void fixGridViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        CheckOneFragmentGridViewAdapter listAdapter = (CheckOneFragmentGridViewAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/3; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
    }




}
