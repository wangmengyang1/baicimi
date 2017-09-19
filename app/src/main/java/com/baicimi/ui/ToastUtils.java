package com.baicimi.ui;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by tan on 2016/9/21.
 */
public class ToastUtils {
    private static Toast toast ;
    public static void showOnUIThread(String text , Context context){
        if(toast==null){
            toast = Toast.makeText(context ,text,Toast.LENGTH_LONG);
        }
        toast.setText(text);
        toast.show();
    }
    public static void showOnWorkThread(final String text , final Context context){
        ThreadUtils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                showOnUIThread(text , context);
            }
        });
    }
}
