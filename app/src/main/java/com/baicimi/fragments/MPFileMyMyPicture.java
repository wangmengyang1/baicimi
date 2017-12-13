package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MPFileMyMyArticleAdapter;
import com.baicimi.adapter.MPFileMyMyPictureAdapter;
import com.baicimi.adapter.MPFileMyMyPictureSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MPFileMyMyPictureEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 文件 我的图片
 */
public class MPFileMyMyPicture extends BaseFragment{

    private View view;

    private GridView gridViewFirst , gridViewSecond , gridViewThread;
    private List<MPFileMyMyPictureEntry> listFirst = new ArrayList<>();
    private List<MPFileMyMyPictureEntry> listSecond = new ArrayList<>();
    private List<MPFileMyMyPictureEntry> listThread = new ArrayList<>();

    private MPFileMyMyPictureAdapter adapterFirst;
    private MPFileMyMyPictureAdapter adapterSecond;
    private MPFileMyMyPictureSecondAdapter adapterThread;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mp_file_mymy_picture , container , false);

        //gridview布局填充
        initGridView();
        initGridViewSecond();
        initGridViewThread();

        return view;
    }

    private void initGridViewThread() {
        gridViewThread = (GridView) view.findViewById(R.id.mp_file_mymy_picture_listviewthread);
        listThread.add(new MPFileMyMyPictureEntry("" , R.drawable.mp_new_book_image_08 , ""));
        listThread.add(new MPFileMyMyPictureEntry("" , R.drawable.mp_new_book_image_08 , ""));
        listThread.add(new MPFileMyMyPictureEntry("" , R.drawable.mp_new_book_image_08 , ""));
        listThread.add(new MPFileMyMyPictureEntry("" , R.drawable.mp_new_book_image_08 , ""));
        adapterThread = new MPFileMyMyPictureSecondAdapter(listThread , getContext());
        gridViewThread.setAdapter(adapterThread);
        fixGridViewHeight(gridViewThread);

    }

    private void initGridViewSecond() {
        gridViewSecond = (GridView) view.findViewById(R.id.mp_file_mymy_picture_listviewsecond);
        listSecond.clear();
        listSecond.add(new MPFileMyMyPictureEntry("" ,R.drawable.mp_new_book_image_07, "今天"));
        adapterSecond = new MPFileMyMyPictureAdapter(listSecond , getContext());
        gridViewSecond.setAdapter(adapterSecond);
    }

    //gridview布局填充
    private void initGridView() {
        gridViewFirst = (GridView) view.findViewById(R.id.mp_file_mymy_picture_listviewfirst);
        listFirst.clear();
        listFirst.add(new MPFileMyMyPictureEntry("" ,R.drawable.mp_new_book_image_07, "今天"));
        adapterFirst = new MPFileMyMyPictureAdapter(listFirst , getContext());
        gridViewFirst.setAdapter(adapterFirst);
    }


    //动态计算listview的高度
    public void fixGridViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MPFileMyMyPictureSecondAdapter listAdapter = (MPFileMyMyPictureSecondAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/2; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 24;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
//        System.out.println(girdViewHeight + "_______________________________");
    }



    @Override
    protected void initData() {

    }
}
