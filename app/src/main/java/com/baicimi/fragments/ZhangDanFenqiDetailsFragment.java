package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ZhangDanDetailListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ZhangDanDetailsBean;
import com.baicimi.ui.MyListView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;

/**
 * Created by tan on 2016/12/22.
 * 账单分期明细
 */
public class ZhangDanFenqiDetailsFragment extends BaseFragment {
    private MyListView myListView;
    private ArrayList<ZhangDanDetailsBean> arrayList;
    private ZhangDanDetailListAdapter eduListAdapter;
    final ZhangDanDetailsBean eduBean = new ZhangDanDetailsBean();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_zhangdan_detail, container, false);

        myListView = (MyListView) view.findViewById(R.id.check_fenqi_list);

        arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            eduBean.setTime("01/03期");
            eduBean.setBack_time("还款日期:2016-06-10");
            eduBean.setMony_num("1350.00(含手续费0.00)");
            eduBean.setYes_back("已还清");
            arrayList.add(eduBean);
        }
        eduListAdapter = new ZhangDanDetailListAdapter(getActivity(), arrayList);
        myListView.setAdapter(eduListAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startFragment(new FenqiZhangDanDetailsFragment(), null);
            }
        });

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
    protected void initData() {

    }
}
