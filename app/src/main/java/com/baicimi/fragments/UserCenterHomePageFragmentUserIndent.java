package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHomePageEntrySecond;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 * 我的订单模板页
 */

public class UserCenterHomePageFragmentUserIndent extends BaseFragment {

    private View view;
    private GridView gridview_03;
    private List<UserCenterHomePageEntrySecond> list_03 = new ArrayList<>();
    private UserCenterHomePageSecondAdapter adapter_03;

    private FragmentManager fragmentManager;
    private int showIndex;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> listFragment = new ArrayList<>();

    private OnMyIndentFragment onMyIndentFragment = new OnMyIndentFragment();
    private View view1;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_home_page_fragment_user_indent , container , false);

        //会员推荐
        initRecommend();
        //fragment切换
        initFragmentLayoutShow();




        return view;
    }



    //头部fragment布局切换
    private void initFragmentLayoutShow() {
        fragmentManager = getChildFragmentManager();
        listFragment.add(onMyIndentFragment);
        setShowFragment(0);
    }



    //显示fragment
    private void setShowFragment(int index){
        if (index > listFragment.size()){
            return;
        }else{
            if(listFragment.get(index) == null){
                return;
            }else{
                String tag = listFragment.get(index).getTag();
                fragmentTransaction = fragmentManager.beginTransaction();
                // 3 控制Fragment 的动画
                fragmentTransaction.setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit, R.anim.slide_right_enter,
                        R.anim.slide_left_exit);
                if(listFragment.get(index).isAdded()){
                    //如果已经添加了，则显示
                    fragmentTransaction.hide(listFragment.get(showIndex));
                    fragmentTransaction.show(listFragment.get(index));
                }else{
                    //如果没有添加，则添加之后显示
                    fragmentTransaction.add(R.id.user_center_home_page_fragment_user_indent_framelayout , listFragment.get(index) , tag).show(listFragment.get(index));
                }
                showIndex = index;
                fragmentTransaction.commit();
            }

        }
    }




    //会员推荐GridView布局填充
    private void initRecommend() {
        gridview_03 = (GridView) view.findViewById(R.id.user_center_home_page_fragmet_gridview_03_user_indent);
        list_03.clear();
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_image_home_page_adapter_second_01 , new String("") , new String("")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_image_home_page_adapter_second_02 , new String("") , new String("")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_image_home_page_adapter_second_03 , new String("") , new String("")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_image_home_page_adapter_second_04 , new String("") , new String("")));
        adapter_03 = new UserCenterHomePageSecondAdapter(getContext() , list_03);
        gridview_03.setAdapter(adapter_03);
        fixGrdiViewHeight03(gridview_03);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageSecondAdapter listAdapter = (UserCenterHomePageSecondAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/2); index++) {
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



    @Override
    protected void initData() {

    }
}
