package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.TryoutApplyForFragmentSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TryoutApplyForFragmentSecondEntry;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/27.
 * 试用申请 试用报告
 */
public class TryoutApplyForFragmentSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listview;
    private ArrayList<TryoutApplyForFragmentSecondEntry> list = new ArrayList<>();
    private TryoutApplyForFragmentSecondAdapter adapter;

    private TextView morereport;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tryout_appply_for_fragment_second , container , false);

        //listview布局填充
        initListView();

        morereport = (TextView) view.findViewById(R.id.tryout_appply_for_fragment_second_morereport);
        morereport.setOnClickListener(this);

        back = (ImageView) view.findViewById(R.id.tryout_appply_for_fragment_second_back);
        back.setOnClickListener(this);
        return view;
    }

    //listview布局填充
    private void initListView() {
        listview = (ListView) view.findViewById(R.id.tryout_appply_for_fragment_second_listview);
        list.clear();
        list.add(new TryoutApplyForFragmentSecondEntry(R.drawable.tryout_apply_forme_image_04 , R.drawable.tryout_apply_forme_image_07));
        list.add(new TryoutApplyForFragmentSecondEntry(R.drawable.tryout_apply_forme_image_05 , R.drawable.tryout_apply_forme_image_08));
        list.add(new TryoutApplyForFragmentSecondEntry(R.drawable.tryout_apply_forme_image_06 , R.drawable.tryout_apply_forme_image_07));
        list.add(new TryoutApplyForFragmentSecondEntry(R.drawable.tryout_apply_forme_image_04 , R.drawable.tryout_apply_forme_image_08));
        adapter = new TryoutApplyForFragmentSecondAdapter(list , getContext());
        listview.setAdapter(adapter);
        fixGrdiViewHeight03(listview);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        TryoutApplyForFragmentSecondAdapter listAdapter = (TryoutApplyForFragmentSecondAdapter) listView.getAdapter();
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
            case R.id.tryout_appply_for_fragment_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.tryout_appply_for_fragment_second_morereport:
                //查看全部试用报告页面
                startFragment(new TryoutApplyForSecondMoreReport());
                break;
        }
    }
}
