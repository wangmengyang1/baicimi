package com.baicimi.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.view.RingView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */

public class NoticeDialogPagerAdapterpa extends PagerAdapter {

    private List<View> date;
    private String[] title;
    private Context context;

    public NoticeDialogPagerAdapterpa(List<View> date) {
        this.date = date;
    }

    public NoticeDialogPagerAdapterpa(List<View> date, String[] title , Context context) {
        this.date = date;
        this.title = title;
        this.context = context;
    }

    @Override
    public int getCount() {
        return date.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //添加下一个item的方法
    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        View view = null;
        view =new RingView(context);//关键地方，动态生成页面。
        view.setId(position);

        container.addView(view);
        return view;
    }

    //删除上一个item的方法
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if(container != null)
        container.removeView(date.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
