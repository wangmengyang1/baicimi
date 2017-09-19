package com.baicimi.activitys;

import android.view.View;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;


/**
 * Created by tan on 2016/9/29.
 */
@ContentView(R.layout.fragment_shaidan_pingjia)
public class ShaiDanPingJiaActivity extends BaseActivity {

    @OnClick({R.id.login_back,R.id.tv_tijiao_pingjia})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                finish();
                break;
            case R.id.tv_tijiao_pingjia:
                finish();
                break;
        }
    }

    @Override
    protected void initData() {

    }
}
