package com.baicimi.datetime;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/12.
 */

public class MyCountDownTimer extends CountDownTimer {

    private TextView textView;


    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     *                          表示以毫秒为单位 倒计时的总数
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     *                           表示 间隔 多少微秒 调用一次 onTick 方法
     */
    public MyCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public MyCountDownTimer(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        textView.setText("仅剩 ：" + getDateTimes(millisUntilFinished));
    }

    @Override
    public void onFinish() {
        textView.setText("00:00:00");
    }

    private String getDateTimes(long dateTeimer){
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date(dateTeimer);
        String times = format.format(date);
        return times;
    }

}
