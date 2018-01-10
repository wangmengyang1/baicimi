package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.RosePerSonalFragmentPictureFanseAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.RosePerSonalFragmentPictureFanseEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/10.
 * 全球生活汇  首页 他的图片 他的粉丝
 */
public class RosePerSonalFragmentPictureFanse extends BaseFragment {

    private View view;
    private ListView listView;
    private List<RosePerSonalFragmentPictureFanseEntry> list = new ArrayList<>();
    private RosePerSonalFragmentPictureFanseAdapter adapter;

    private String lible;
    private TextView libleTv;


    public RosePerSonalFragmentPictureFanse() {
    }


    @SuppressLint("ValidFragment")
    public RosePerSonalFragmentPictureFanse(String lible) {
        this.lible = lible;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rose_personal_fragment_picture_fanse , container , false);

        //listview布局填充
        initListView();

        libleTv = (TextView) view.findViewById(R.id.rose_personal_fragment_picture_fanse_lible);
        libleTv.setText(lible);

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.rose_personal_fragment_picture_fanse_listview);
        list.clear();
        list.add(new RosePerSonalFragmentPictureFanseEntry(R.drawable.rose_personal_fragment_picture_image_21 , "baby" , "今天百次幂商城又搞活动了！快点去和我......."));
        list.add(new RosePerSonalFragmentPictureFanseEntry(R.drawable.rose_personal_fragment_picture_image_10 , "ben" , "今天百次幂商城又搞活动了！快点去和我......."));
        list.add(new RosePerSonalFragmentPictureFanseEntry(R.drawable.rose_personal_fragment_picture_image_21 , "bnn" , "今天百次幂商城又搞活动了！快点去和我......."));
        list.add(new RosePerSonalFragmentPictureFanseEntry(R.drawable.rose_personal_fragment_picture_image_10 , "baby" , "今天百次幂商城又搞活动了！快点去和我......."));
        list.add(new RosePerSonalFragmentPictureFanseEntry(R.drawable.rose_personal_fragment_picture_image_21 , "ben" , "今天百次幂商城又搞活动了！快点去和我......."));
        list.add(new RosePerSonalFragmentPictureFanseEntry(R.drawable.rose_personal_fragment_picture_image_10 , "bnn" , "今天百次幂商城又搞活动了！快点去和我......."));
        adapter = new RosePerSonalFragmentPictureFanseAdapter(list , getContext());
        listView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }
}
