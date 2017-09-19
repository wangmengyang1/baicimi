package com.baicimi.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/8/31.
 */

public class MyViewPagerMeasure extends ViewPager {

    private int height;

    public MyViewPagerMeasure(Context context) {
        super(context);
    }

    public MyViewPagerMeasure(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int index = getCurrentItem();

//        BaseFragment fragment = (BaseFragment) ((FragmentPagerAdapter)getAdapter()).getItem(index);
        View view1 = (View) getAdapter().instantiateItem(this , index);
        if(view1 != null){
            view1.measure(widthMeasureSpec , MeasureSpec.makeMeasureSpec(0 , MeasureSpec.UNSPECIFIED));
            height = view1.getMeasuredHeight();
        }
        height = MeasureSpec.makeMeasureSpec(height , MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, height);


    }
}
