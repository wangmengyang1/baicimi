package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.ChoosePayWayActivity;
import com.baicimi.adapter.BackMonyListAdapter;
import com.baicimi.adapter.BackedListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.BackMonyBean;
import com.baicimi.bean.BackedMonyBean;
import com.baicimi.ui.MyListView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;

/**
 * Created by tan on 2016/12/20.
 * 我的分期页面
 */
public class FenQiFragmented extends BaseFragment{
    private MyListView myListView,myListView_backed;
    private ArrayList<BackMonyBean> arrayList;
    private ArrayList<BackedMonyBean> arrayList_backed;
    private BackMonyListAdapter eduListAdapter;
    private BackedListAdapter backedListAdapter;
    final BackMonyBean eduBean=new BackMonyBean();
    final BackedMonyBean backedMonyBean=new BackedMonyBean();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_fenqi,container,false);
        myListView= (MyListView) view.findViewById(R.id.fenqi_list);
        myListView_backed= (MyListView) view.findViewById(R.id.fenqi_list_yihuan);

        arrayList=new ArrayList<>();
        for (int i=0;i<3;i++){
            eduBean.setMony("500");
            arrayList.add(eduBean);
        }
        eduListAdapter=new BackMonyListAdapter(this,getActivity(),arrayList);
        myListView.setAdapter(eduListAdapter);


        arrayList_backed=new ArrayList<>();
        for (int i=0;i<3;i++){
            backedMonyBean.setMony("1350");
            arrayList_backed.add(backedMonyBean);
        }
        backedListAdapter=new BackedListAdapter(getActivity(),arrayList_backed);
        myListView_backed.setAdapter(backedListAdapter);

        return view;
    }


    @OnClick({R.id.login_back,R.id.know_fenqi})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.know_fenqi:
                startFragment(new KnowFenQiFragment(),null);
                break;
        }
    }

    public void starEduFenqiFragment(){
        startFragment(new EduFenQiDetailsFragment(),null);
    }



    public void starSeceesePayFragment(){
        startFragment(new SeccesePayMonyFragment(),null);
    }


    @Override
    protected void initData() {

    }
}
