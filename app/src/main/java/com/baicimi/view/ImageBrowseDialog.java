package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.baicimi.R;
import com.baicimi.adapter.NoticeDialogPagerAdapterpa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ImageBrowseDialog extends Dialog {

    private Context context;
    private ViewPager viewPager;
    private List<View> list = new ArrayList<>();
    private NoticeDialogPagerAdapterpa adapterpa;

    public ImageBrowseDialog(Context context) {
        super(context);
        this.context = context;
    }

    public ImageBrowseDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected ImageBrowseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_browsedialog_fragment);

        //viewpager布局填充
        initViewPager();
    }

    //viewpager布局填充
    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.image_browsedialog_fragment_myviewpager);
        list.clear();
        for(int i = 0 ; i < 5 ; i++){
            list.add(getViews());
        }
        adapterpa = new  NoticeDialogPagerAdapterpa(list);
        viewPager.setAdapter(adapterpa);

    }

    private View getViews(){
        View v1 = LayoutInflater.from(getContext()).inflate(R.layout.image_browsedialog_fragment_viewpager_item , null);
        return v1;
    }

}
