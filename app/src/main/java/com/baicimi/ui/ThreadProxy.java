package com.baicimi.ui;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lynne on 2016/1/21.
 */
public class ThreadProxy {
    private ThreadPoolExecutor pool;
    private int corePoolSize;
    private int maximunPoolSize;
    public ThreadProxy(int corePoolSize,int maximunPoolSize){
        this.corePoolSize =corePoolSize ;
        this.maximunPoolSize =maximunPoolSize ;
    }

    private void initExecutor(){
        if(pool==null){
            synchronized (ThreadProxy.class){
                if(pool==null){
                    BlockingQueue<Runnable> blockingQueue =new LinkedBlockingDeque<Runnable>(128) ;
                    ThreadFactory factory = Executors.defaultThreadFactory() ;
                    RejectedExecutionHandler handler =new ThreadPoolExecutor.AbortPolicy() ;
                    pool =new ThreadPoolExecutor(corePoolSize ,maximunPoolSize,10 , TimeUnit.SECONDS,blockingQueue,factory ,handler);
                }
            }
        }
    }

    public void execute(Runnable runnable){
        initExecutor();
        pool.execute(runnable);
    }
    public void remove(Runnable runnable){
        pool.remove(runnable);
    }
}
