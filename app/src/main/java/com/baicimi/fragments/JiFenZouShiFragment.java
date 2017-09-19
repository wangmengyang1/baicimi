package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.JiFenZouShiView;
import com.baicimi.view.LineChartView;

/**
 * Created by tan on 2016/10/10.
 * 积分走势界面
 */
public class JiFenZouShiFragment extends BaseFragment{
    JiFenZouShiView jiFenZouShiView;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_jifen_zoushi,container,false);
        jiFenZouShiView= (JiFenZouShiView) view.findViewById(R.id.chart_line);

        String[] xLables = new String[] { "11.02", "12.02", "13.02", "14.02",
                "15.02", "16.02" };
        String[] yLabels = new String[] {"    0", "200", "400", "600", "800", "1000"};
        String[] allData = new String[] { "200", "680", "580", "600", "400", "570","400"
        };
        String title = "今日兑换:1000积分=1元";
        jiFenZouShiView.SetInfo(xLables, yLabels, allData, title);
        return view;
    }

    @Override
    protected void initData() {

    }
}
