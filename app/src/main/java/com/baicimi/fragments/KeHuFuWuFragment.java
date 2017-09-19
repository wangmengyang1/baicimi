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
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;


/**
 * Created by tan on 2016/9/30.
 * 客户服务界面
 */
public class KeHuFuWuFragment extends BaseFragment{
    private Fragment[] mFragments;
    private int mIndex;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_kehufuwu,container,false);
        ViewUtils.inject(this, view);
        initFragment();


        return view;
    }


    @OnClick({R.id.login_back,R.id.gouwu,R.id.dingdan,R.id.qita})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.dingdan:
                setIndexSelect(0);
                break;
            case R.id.gouwu:
                setIndexSelect(1);
                break;
            case R.id.qita:
                setIndexSelect(2);
                break;
        }
    }

    private void initFragment() {
        //订单问题
        DingDanWenTiFragment dingDanWenTiFragment =new DingDanWenTiFragment();
        //购物问题
        GouWuWenTiFragment gouWuWenTiFragment =new GouWuWenTiFragment();
        //其他问题
        QiTaWenTiFragment qiTaWenTiFragment =new QiTaWenTiFragment();
        //添加到数组
        mFragments = new Fragment[]{dingDanWenTiFragment,gouWuWenTiFragment,qiTaWenTiFragment};
        //开启事务
        FragmentTransaction ft =
                getActivity().getSupportFragmentManager().beginTransaction();
        //添加首页
        ft.add(R.id.id_content_fuwu,dingDanWenTiFragment).commit();
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
            ft.add(R.id.id_content_fuwu,mFragments[index]).show(mFragments[index]);
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
