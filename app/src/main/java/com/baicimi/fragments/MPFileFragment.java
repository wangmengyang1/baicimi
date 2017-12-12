package com.baicimi.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 文件
 */
public class MPFileFragment extends BaseFragment{

    private View view;

    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 6;


    private MPFileMyMyArticle mpFileMyMyArticle;//我的文章
    private MPFileMyMyPicture mpFileMyMyPicture;//我的图片

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mp_file_fragment , container , false);

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);
        return view;
    }


    //数据填充
    private void init() {
        listFragment.clear();
//        listFragment.add(mpSystemGcMyArticle = new MPSystemGcMyArticle());
//        listFragment.add(mpSystemGcMyPicture = new MPSystemGcMyPicture());
    }


    //fragment切换
    private void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag();
        FragmentTransaction transaction =  fm.beginTransaction();
        if (fragmentTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));
            index = i;
        }else {
            if (fragmentTag.isEmpty()){
                fragmentTag.add(tag);
                transaction.add(R.id.mp_file_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.mp_file_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }



    @Override
    protected void initData() {

    }
}
