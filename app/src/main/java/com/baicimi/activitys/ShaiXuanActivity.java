package com.baicimi.activitys;

import android.view.View;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/9/7.
 * 筛选activity
 */
@ContentView(R.layout.activity_goods_shaixuan)
public class ShaiXuanActivity extends BaseActivity{


    @OnClick({R.id.btn_shaixuan_yes})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_shaixuan_yes:
                finish();
                break;
        }
        }


    @Override
    protected void initData() {

    }
}
