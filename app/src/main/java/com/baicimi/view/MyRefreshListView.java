package com.baicimi.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;


import com.baicimi.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by tan on 2017/1/12.
 */

public class MyRefreshListView extends ListView implements AbsListView.OnScrollListener {
    private final int STATE_PULL = 0;//下拉
    private final int STATE_LOADING = 1;//加载
    private final int STATE_LOADED = 2;//加载完成
    private boolean isShowFill = false;
    private boolean isMove = false;
    private int currentState = STATE_PULL;//当前的状态
    private float firstDownY;//第一次按下的y轴位置
    private View head;
    private int headHeight;//头部高度
    private int firstVisibleItem;
    private Handler handler = new Handler();;
    private TextView tvChange;
    private ViewGroup.LayoutParams lp;


    public MyRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //添加头部刷新的view
        addRefreshHead(context);
        setOnScrollListener(this);
    }


    private void addRefreshHead(Context context) {
        head = View.inflate(context, R.layout.ly_refresh_head, null);
        tvChange  = (TextView) head.findViewById(R.id.tv_change);
        lp = tvChange.getLayoutParams();
        head.measure(0, 0);
        headHeight = head.getMeasuredHeight();
        setPadding(0, -headHeight, 0, 0);
        addHeaderView(head);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN://按下
                firstDownY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE://移动
                float moveY = ev.getY();
                float distanceY = (moveY - firstDownY) / 3;
                if (distanceY > 10)
                    isMove = true;
                float paddingTop = -headHeight + distanceY;
                Log.d("test", "headHeight = " + headHeight + "moveY = " + moveY + " paddingTop = " + paddingTop);
                if (firstVisibleItem == 0 && -headHeight < paddingTop) {
                    if (currentState == STATE_PULL && paddingTop < 0) {//还没完全显示出来（下拉）
//                        currentState = STATE_PULL;//正在下拉
                        isShowFill = false;

                    } else if (currentState == STATE_PULL && paddingTop > 0) {//完全显示出来了
//                        currentState = STATE_LOADING;//刷新
                        isShowFill = true;
                    }
                    setHeight((int)distanceY);
                    //head.setPadding(0, (int) paddingTop, 0, 0);
                }
                break;
            case MotionEvent.ACTION_UP://松开 -- 松开才执行刷新
                if (isMove){
                    if (isShowFill) {//完全显示
//                        head.setPadding(0,0, 0, 0);
                        setHeight(headHeight);
                        //执行刷新

                        //状态变为正在刷新
                        currentState = STATE_LOADING;
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
//                                        head.setPadding(0, -headHeight, 0, 0);
                                        hideHeadAnim(headHeight);
                                        currentState = STATE_PULL;
                                    }
                                });
                            }
                        },1000);
                    } else {
//                        head.setPadding(0, -headHeight, 0, 0);
                        Log.d("test", "tvChange.getHeight() = " + tvChange.getHeight());
                        hideHeadAnim(tvChange.getHeight());
                        //setHeight(0);
                    }
                }
                isMove = false;
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void setHeight(int heght){
        lp.height = heght;
        tvChange.setLayoutParams(lp);
    }

    private void hideHeadAnim(int height){
        ValueAnimator anim = ValueAnimator.ofFloat(height,0);
        anim.setDuration(300);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d("TAG", "cuurent value is " + currentValue);
                setHeight((int) currentValue);
            }
        });
        anim.start();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
    }
}
