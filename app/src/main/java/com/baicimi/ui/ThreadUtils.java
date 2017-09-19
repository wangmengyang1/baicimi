package com.baicimi.ui;

import android.os.Handler;

/**
 * Created by tan on 2016/9/21.
 */
public class ThreadUtils {

    private static Handler handler = new Handler();

    public static void runOnUIThread(Runnable runnable) {
        handler.post(runnable);
    }

    public static void runOnUIThreadDelay(Runnable runnable, long delay) {
        handler.postDelayed(runnable, delay);
    }

    public static void runOnWorkThread(Runnable runnable) {
        //线程池策略
        ThreadFactory.getCommonProxy().execute(runnable);
    }
}
