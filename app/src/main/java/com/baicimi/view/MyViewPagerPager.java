package com.baicimi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by wjb on 2016/5/23.
 */
public class MyViewPagerPager extends ViewPager {

    private int mLastX = 0;
    private int mLastY = 0;

    private boolean scrollable = true;

    public MyViewPagerPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();


        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:

                if(!scrollable){
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                }
                int deltaX = x - mLastX;
                if( getCurrentItem()==0 && deltaX >0 ){
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

    public void setScrollable(boolean state){
        scrollable = state;
    }
}
