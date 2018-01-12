package com.baicimi.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 * 个人中心首页 我的全球生活汇
 */
public class RosePerSonalMyFragment extends com.baicimi.base.BaseFragment implements View.OnClickListener {

    private View view;


    private CheckBox all,picture,article,photo,video,myfriends , attention , setting;


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 4;

    private RosePersonalMyPicture rosePersonalMyPicture;//我的图片
    private RosePersonalMyArticle rosePersonalMyArticle;//我的文章


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rose_personal_my_fragment , container , false);

        //fragment初始化。切换
        fm = getChildFragmentManager();
        init();
        initShowFragment(0);
        //checkbox初始化
        initCheckBox();
        return view;
    }



    //checkbox初始化
    private void initCheckBox() {
        all = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_all);
        picture = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_picture);
        article = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_article);
        photo = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_photo);
        video = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_video);
        attention = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_attention);
        myfriends = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_myfriends);
        setting = (CheckBox) view.findViewById(R.id.rose_personal_my_fragment_setting);
        all.setOnClickListener(this);
        picture.setOnClickListener(this);
        article.setOnClickListener(this);
        photo.setOnClickListener(this);
        video.setOnClickListener(this);
        attention.setOnClickListener(this);
        myfriends.setOnClickListener(this);
        setting.setOnClickListener(this);
    }


    private void showCheckBox(){
        all.setChecked(false);
        picture.setChecked(false);
        article.setChecked(false);
        photo.setChecked(false);
        video.setChecked(false);
        attention.setChecked(false);
        myfriends.setChecked(false);
        setting.setChecked(false);
    }

    //数据填充
    private void init() {
        listFragment.clear();

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
                transaction.add(R.id.rose_personal_my_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.rose_personal_my_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rose_personal_my_fragment_all:
                showCheckBox();
                all.setChecked(true);
                break;
            case R.id.rose_personal_my_fragment_picture:
                showCheckBox();
                picture.setChecked(true);
                break;
            case R.id.rose_personal_my_fragment_article:
                showCheckBox();
                article.setChecked(true);
                break;
            case R.id.rose_personal_my_fragment_photo:
                showCheckBox();
                photo.setChecked(true);
                break;
            case R.id.rose_personal_my_fragment_video:
                showCheckBox();
                video.setChecked(true);
                break;
            case R.id.rose_personal_my_fragment_attention:
                showCheckBox();
                attention.setChecked(true);
                break;
            case R.id.rose_personal_my_fragment_myfriends:
                showCheckBox();
                myfriends.setChecked(true);
                break;
            case R.id.rose_personal_my_fragment_setting:
                showCheckBox();
                setting.setChecked(true);
                break;
        }
    }
}
