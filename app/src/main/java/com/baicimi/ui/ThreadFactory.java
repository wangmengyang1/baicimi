package com.baicimi.ui;

/**
 * Created by tan on 2016/9/21.
 */
public class ThreadFactory {
    private static ThreadProxy commonProxy;
    private static int corePoolSize = 5;
    private static int maximunPoolSize = 9;
    private ThreadFactory(){}
    public static ThreadProxy getCommonProxy(){
        if (commonProxy==null){
            synchronized (ThreadFactory.class){
                if (commonProxy==null){
                    commonProxy = new ThreadProxy(corePoolSize,maximunPoolSize);
                }
            }
        }
        return commonProxy;
    }
}
