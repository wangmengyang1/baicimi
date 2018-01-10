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
 * Created by tan on 2017/2/13.
 * 全球生活汇  首页
 */
public class RosePerSonalFragment extends BaseFragment implements View.OnClickListener {
    private CheckBox all,picture,article,photo,video,praise , share , attention;


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 4;


    private RosePerSonalFragmentAll herAll;//所有
    private RosePerSonalFragmentPicture herPicture;//他的图片
    private RosePerSonalFragmentArticle herArticle;//他的文章
    private RosePerSonalFragmentPhoto herPhoto;//他的相册
    private RosePerSonalFragmentVideo herVideo;//他的视频
    private RosePerSonalFragmentPraise herPraise;//他的赞
    private RosePerSonalFragmentShare herShare;//他的分享
    private RosePerSonalFragmentAttention herAttention;//他的钉

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_personal_ss,container,false);
        fm = getChildFragmentManager();
        init();
        initShowFragment(0);

        //checkbox初始化
        initCheckBox();

        return view;
    }

    //checkbox初始化
    private void initCheckBox() {
        all = (CheckBox) view.findViewById(R.id.fragment_personal_ss_all);
        picture = (CheckBox) view.findViewById(R.id.fragment_personal_ss_picture);
        article = (CheckBox) view.findViewById(R.id.fragment_personal_ss_article);
        photo = (CheckBox) view.findViewById(R.id.fragment_personal_ss_photo);
        video = (CheckBox) view.findViewById(R.id.fragment_personal_ss_video);
        praise = (CheckBox) view.findViewById(R.id.fragment_personal_ss_praise);
        share = (CheckBox) view.findViewById(R.id.fragment_personal_ss_share);
        attention = (CheckBox) view.findViewById(R.id.fragment_personal_ss_attention);
        all.setOnClickListener(this);
        picture.setOnClickListener(this);
        article.setOnClickListener(this);
        photo.setOnClickListener(this);
        video.setOnClickListener(this);
        praise.setOnClickListener(this);
        share.setOnClickListener(this);
        attention.setOnClickListener(this);
    }


    private void showCheckBox(){
        all.setChecked(false);
        picture.setChecked(false);
        article.setChecked(false);
        photo.setChecked(false);
        video.setChecked(false);
        praise.setChecked(false);
        share.setChecked(false);
        attention.setChecked(false);
    }


    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(herAll = new RosePerSonalFragmentAll());
        listFragment.add(herPicture = new RosePerSonalFragmentPicture());
        listFragment.add(herArticle = new RosePerSonalFragmentArticle());
        listFragment.add(herPhoto = new RosePerSonalFragmentPhoto());
        listFragment.add(herVideo = new RosePerSonalFragmentVideo());
        listFragment.add(herPraise = new RosePerSonalFragmentPraise());
        listFragment.add(herShare = new RosePerSonalFragmentShare());
        listFragment.add(herAttention = new RosePerSonalFragmentAttention());
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
                transaction.add(R.id.fragment_personal_ss_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.fragment_personal_ss_framelayout , listFragment.get(i) , tag);

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
            case R.id.fragment_personal_ss_all:
                showCheckBox();
                initShowFragment(0);
                all.setChecked(true);
                break;
            case R.id.fragment_personal_ss_picture:
                showCheckBox();
                initShowFragment(1);
                picture.setChecked(true);
                break;
            case R.id.fragment_personal_ss_article:
                showCheckBox();
                initShowFragment(2);
                article.setChecked(true);
                break;
            case R.id.fragment_personal_ss_photo:
                showCheckBox();
                initShowFragment(3);
                photo.setChecked(true);
                break;
            case R.id.fragment_personal_ss_video:
                showCheckBox();
                initShowFragment(4);
                video.setChecked(true);
                break;
            case R.id.fragment_personal_ss_praise:
                showCheckBox();
                initShowFragment(5);
                praise.setChecked(true);
                break;
            case R.id.fragment_personal_ss_share:
                showCheckBox();
                initShowFragment(6);
                share.setChecked(true);
                break;
            case R.id.fragment_personal_ss_attention:
                showCheckBox();
                initShowFragment(7);
                attention.setChecked(true);
                break;
        }
    }
}
