package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.HeadScrollView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.zql.android.springview.SpringView;


/**
 * Created by tan on 2016/8/10.
 * 搜索界面
 */
public class SearchFragment extends BaseFragment {
    private HeadScrollView hsv;
    private LinearLayout llSearch;

    private SpringView springView;
    private LinearLayout linearLayout;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_search_title, container, false);

        //上拉布局内容填充
        initSpringView();

        return view;
    }

    //上拉布局内容填充
    private void initSpringView() {
        springView = (SpringView) view.findViewById(R.id.fragment_search_title_sousuo_springview);
        linearLayout = (LinearLayout) view.findViewById(R.id.fragment_secrch_title_sousuo_linearlayout);
    }

    @OnClick(R.id.sousuo_img)
    public void OnClicks(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.sousuo_img:
              startFragment(new FragmentClassifySearch(),null);
                break;
        }
    }


    @Override
    protected void initData() {

    }
}