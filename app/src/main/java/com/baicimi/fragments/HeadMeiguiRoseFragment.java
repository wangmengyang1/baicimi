package com.baicimi.fragments;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/22.
 * 玫瑰社区
 */

public class HeadMeiguiRoseFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView rose_tv;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.head_meigui_rose_fragment , container , false);

        rose_tv = (TextView) view.findViewById(R.id.head_meigui_rose_fragment_textview_rose);
        rose_tv.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.head_meigui_rose_fragment_textview_rose:
//                Intent intent = new Intent();
//                PackageManager packageManager = getContext().getPackageManager();
//                intent = packageManager.getLaunchIntentForPackage(new String("com.baici"));
//                ComponentName comp = new ComponentName("com.baicimi", getRunningActivityName());
//                    intent.setAction("android.intent.action.VIEW");
//                intent.setComponent(comp);
//                startActivity(intent);


                Intent intent = new Intent();
                PackageManager packageManager = getContext().getPackageManager();
                intent = packageManager.getLaunchIntentForPackage(new String("com.baici"));
                if (intent == null){
                    Toast.makeText(getContext() , "请安装最新的玫瑰社区项目" , Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.setAction("android.intent.action.VIEW");
                startActivity(intent);

                break;
        }
    }


    private String getRunningActivityName(){
        ActivityManager activityManager= (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        String runningActivity=activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
        return runningActivity;
    }


}
