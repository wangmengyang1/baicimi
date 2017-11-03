package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ComplaintSuggestSecondAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ComplaintSuggestSecondEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 * 个人中心  客户服务  投诉与建议二级页面
 */
public class ComplaintSuggestSecondFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<ComplaintSuggestSecondEntry> list = new ArrayList<>();
    private ComplaintSuggestSecondAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.complaint_suggest_second_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.complain_suggest_second_fragment_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.complaint_suggest_second_fragment_listview);
        list.clear();
        list.add(new ComplaintSuggestSecondEntry("排名" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("Top1" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("2" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("3" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("4" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("5" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("6" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("7" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("8" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("9" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));
        list.add(new ComplaintSuggestSecondEntry("10" , R.drawable.image_convertion_06 , "云淡风轻" , "36 " , "20积分"));

        adapter = new ComplaintSuggestSecondAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ComplaintSuggestSecondAdapter listAdapter = (ComplaintSuggestSecondAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 16;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.complain_suggest_second_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
