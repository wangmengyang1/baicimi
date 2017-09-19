package com.baicimi.fragments;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.OnDrawingException;
import com.baicimi.view.RingView;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/24.
 */
public class MyCodeFragment extends BaseFragment {
    //圆环颜色分布
    public static final int gouwusuode=0xFFf05a4b;
    public static final int denglusuode=0xFF86BC5B;
    public static final int qita=0xFFF49902;
    public static final int shureget=0xFF7259F4;
    public static final int tuijiansuode=0xFFFFF001;
    public static final int gameget=0xFFEF4A89;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_my_jifen, container, false);
        RingView ringView = (RingView) view.findViewById(R.id.ring_huanxing);
        ringView.setColors(new int[]{gameget,tuijiansuode, shureget, qita,denglusuode,gouwusuode});
        ringView.setValues(new int[]{33, 27, 18, 10, 7,5});

        try {
            ringView.startDraw();
        } catch (OnDrawingException e) {
            e.printStackTrace();
        }
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
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
