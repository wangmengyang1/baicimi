package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tan on 2017/2/13.
 * 玫瑰社区个人中心
 */
public class RosePerSonalFragment extends BaseFragment {
    private CheckBox checkBox_all,checkBox_picture,checkBox_essay,checkBox_xiangce,checkBox_zan,checkBox_shezhi;

    private FragmentManager fManager;
    private FragmentTransaction ftTransaction;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private List<String> mFragments2 = new ArrayList<>();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_personal_ss,container,false);
        checkBox_all= (CheckBox) view.findViewById(R.id.all_check);
        checkBox_picture= (CheckBox) view.findViewById(R.id.picture_check);
        checkBox_essay= (CheckBox) view.findViewById(R.id.essay_check);
        checkBox_xiangce= (CheckBox) view.findViewById(R.id.xiangce_check);
        checkBox_zan= (CheckBox) view.findViewById(R.id.zan_check);
        checkBox_shezhi= (CheckBox) view.findViewById(R.id.shezhi_check);

        fragments.add(new RosePersonalAllFragment());
        fragments.add(new RosePersonalPictureFragment());
        fragments.add(new RosePersonalEssayFragment());
        fragments.add(new MyPhotoFragment());
        fragments.add(new RosePersonalZanFragment());
        fragments.add(new RosePersonalSetFragment());
        fManager = getChildFragmentManager();
        RosePersonalAllFragment personalAllFragment=new RosePersonalAllFragment();
        selectFragment(personalAllFragment,"all");
        checkBox_all.setSelected(true);


        /**
         * 全部内容
         * */
        checkBox_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_all.setChecked(true);
                checkBox_picture.setChecked(false);
                checkBox_essay.setChecked(false);
                checkBox_xiangce.setChecked(false);
                checkBox_zan.setChecked(false);
                checkBox_shezhi.setChecked(false);
                selectFragment(new RosePersonalAllFragment(),"all");
            }
        });

        /**
         * 我的图片
         * */
        checkBox_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_all.setChecked(false);
                checkBox_picture.setChecked(true);
                checkBox_essay.setChecked(false);
                checkBox_xiangce.setChecked(false);
                checkBox_zan.setChecked(false);
                checkBox_shezhi.setChecked(false);
                selectFragment(new RosePersonalPictureFragment(),"picture");
            }
        });

        /**
         * 我的文章
         * */
        checkBox_essay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_all.setChecked(false);
                checkBox_picture.setChecked(false);
                checkBox_essay.setChecked(true);
                checkBox_xiangce.setChecked(false);
                checkBox_zan.setChecked(false);
                checkBox_shezhi.setChecked(false);
                selectFragment(new RosePersonalEssayFragment(),"essay");
            }
        });

        /**
         * 我的相册
         * */
        checkBox_xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_all.setChecked(false);
                checkBox_picture.setChecked(false);
                checkBox_essay.setChecked(false);
                checkBox_xiangce.setChecked(true);
                checkBox_zan.setChecked(false);
                checkBox_shezhi.setChecked(false);
                selectFragment(new MyPhotoFragment(),"xiangce");
            }
        });

        /**
         * 赞
         * */
        checkBox_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_all.setChecked(false);
                checkBox_picture.setChecked(false);
                checkBox_essay.setChecked(false);
                checkBox_xiangce.setChecked(false);
                checkBox_zan.setChecked(true);
                checkBox_shezhi.setChecked(false);
                selectFragment(new RosePersonalZanFragment(),"zan");
            }
        });

        /**
         * 设置
         * */
        checkBox_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_all.setChecked(false);
                checkBox_picture.setChecked(false);
                checkBox_essay.setChecked(false);
                checkBox_xiangce.setChecked(false);
                checkBox_zan.setChecked(false);
                checkBox_shezhi.setChecked(true);
                selectFragment(new RosePersonalSetFragment(),"shezhi");
            }
        });

        return view;
    }


//    @OnClick({R.id.login_back})
//    public void OnBackClick(View view) {
//        int id = view.getId();
//        switch (id) {
//            case R.id.login_back:
//                ((MainActivity) getActivity()).goBack();//返回上一层页面
//                break;
//        }
//    }

    @Override
    protected void initData() {

    }


    public void selectFragment(Fragment f, String tag){
        ftTransaction = fManager.beginTransaction();
        if (mFragments2 != null) {
            if (mFragments2.contains(tag)) {
                for (String str : mFragments2) {
                    if (tag.equals(str)) {
                        ftTransaction.show(fManager.findFragmentByTag(tag));
                    }else {
                        ftTransaction.hide(fManager.findFragmentByTag(str));
                    }
                }
            }else {
                ftTransaction.add(R.id.personal_vp,f, tag);
                mFragments2.add(tag);
            }

        }else {
            ftTransaction.add(R.id.personal_vp,f, tag);
            mFragments2.add(tag);
        }
        ftTransaction.commit();
    }

//    @OnClick({R.id.login_back,R.id.guanzhu})
//    public void onClick(View view) {
//        int id = view.getId();
//        switch (id) {
//            case R.id.guanzhu:
////               startFragment(new RoseAttentionFragment(),null);
//                break;
//            case R.id.login_back:
//                ((MainActivity) getActivity()).goBack();//返回上一层页面
//                break;
//        }
//    }



}
