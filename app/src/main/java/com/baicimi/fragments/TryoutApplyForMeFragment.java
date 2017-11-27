package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.TryoutApplyForMeAdapter;
import com.baicimi.adapter.UserIntegerInquireListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TryoutApplyForMeEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 * 试用申请 我的试用申请
 */
public class TryoutApplyForMeFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<TryoutApplyForMeEntry> list = new ArrayList<>();
    private TryoutApplyForMeAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tryout_apply_forme_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.tryout_apply_forme_fragment_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.tryout_apply_forme_fragment_listview);
        list.clear();
        list.add(new TryoutApplyForMeEntry(R.drawable.tryout_apply_forme_image_01 , "¥99.00" , "订单号 480000" , "魅族PRO 6 Plus 4GB + 64GB 公开版\\n月光银 移动联通4G手机 双卡双待" , "申请中" , "查看"));
        list.add(new TryoutApplyForMeEntry(R.drawable.tryout_apply_forme_image_01 , "¥99.00" , "订单号 480000" , "魅族PRO 6 Plus 4GB + 64GB 公开版\\n月光银 移动联通4G手机 双卡双待" , "申请成功" , "查看"));
        list.add(new TryoutApplyForMeEntry(R.drawable.tryout_apply_forme_image_01 , "¥99.00" , "订单号 480000" , "魅族PRO 6 Plus 4GB + 64GB 公开版\\n月光银 移动联通4G手机 双卡双待" , "申请失败" , "重新申请"));
        adapter = new TryoutApplyForMeAdapter(list , getContext() , this);
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        TryoutApplyForMeAdapter listAdapter = (TryoutApplyForMeAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 40;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1)+30);
        listView.setLayoutParams(params);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tryout_apply_forme_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
