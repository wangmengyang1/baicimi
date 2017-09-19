package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.LineChartView;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/25.
 */
public class XinYongJieDuFragment extends BaseFragment{
    LineChartView lineChartView;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_xinyong_jiedu,container,false);
        lineChartView= (LineChartView) view.findViewById(R.id.chart_line);

        String[] xLables = new String[] { "1月", "2月", "3月", "4月", "5月", "6月",
                "7月" };
        String[] yLabels = new String[] { "", "200", "400", "600", "650", "700"};
        String[] allData = new String[] { "600", "610", "620", "630", "640",
                "660", "665" };
        String title = "近六个月信用分趋势";
        lineChartView.SetInfo(xLables, yLabels, allData, title);
        return view;
    }


    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
