package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/12/20.
 * 了解分期
 */
public class KnowFenQiFragment extends BaseFragment{
    private Fragment[] mFragments;
    private int mIndex;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_know_fenqi,container,false);
        initFragment();
        return view;
    }


    @OnClick({R.id.login_back,R.id.btn_edu_fenqi,R.id.btn_kafenqi})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.btn_edu_fenqi:
                setIndexSelect(0);
                break;
            case R.id.btn_kafenqi:
                setIndexSelect(1);
                break;

        }
    }


    private void initFragment() {
        //幂额度分期
        KnowMiFenQiFragment knowMiFenQiFragment =new KnowMiFenQiFragment();
        //银行卡分期
        KaFenQiFragment kaFenQiFragment =new KaFenQiFragment();
        //添加到数组
        mFragments = new Fragment[]{knowMiFenQiFragment,kaFenQiFragment};
        //开启事务
        FragmentTransaction ft =
                getActivity().getSupportFragmentManager().beginTransaction();
        //添加首页
        ft.add(R.id.fenqi_content,knowMiFenQiFragment).commit();
        //默认设置为第0个
        setIndexSelect(0);
    }




    private void setIndexSelect(int index) {
        if(mIndex==index){
            return;
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if(!mFragments[index].isAdded()){
            ft.add(R.id.fenqi_content,mFragments[index]).show(mFragments[index]);
        }else {
            ft.show(mFragments[index]);
        }
        ft.commit();
        //再次赋值
        mIndex=index;
    }


    @Override
    protected void initData() {

    }
}
