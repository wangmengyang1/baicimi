package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.BackMonyListAdapter;
import com.baicimi.adapter.BackedListAdapter;
import com.baicimi.adapter.OpenFenQiListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.BackMonyBean;
import com.baicimi.bean.BackedMonyBean;
import com.baicimi.bean.OpenFenQiBean;
import com.baicimi.ui.MyListView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;

/**
 * Created by tan on 2016/12/20.
 * 我的分期页面
 */
public class FenQiFragment extends BaseFragment{
    private MyListView myListView;
    private ArrayList<OpenFenQiBean> arrayList;
    private OpenFenQiListAdapter eduListAdapter;
    final OpenFenQiBean eduBean=new OpenFenQiBean();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_openfenqi,container,false);
        myListView= (MyListView) view.findViewById(R.id.know_fenqi_list);

        arrayList=new ArrayList<>();
        for (int i=0;i<10;i++){
            eduBean.setTv_know("了解详情");
            arrayList.add(eduBean);
        }
        eduListAdapter=new OpenFenQiListAdapter(getActivity(),arrayList);
        myListView.setAdapter(eduListAdapter);

        return view;
    }


    @OnClick({R.id.login_back,R.id.btn_know_fenqi})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.btn_know_fenqi:
                startFragment(new KnowFenQiFragment(),null);
                break;
        }
    }

    public void starEduFenqiFragment(){
        startFragment(new EduFenQiDetailsFragment(),null);
    }


    @Override
    protected void initData() {

    }
}
