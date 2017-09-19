package com.baicimi.activitys;

import android.view.View;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/12/24.
 */
@ContentView(R.layout.fragment_choose_payway)
public class ChoosePayWayActivity extends BaseActivity {


    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                finish();
                break;
        }
    }

    @Override
    protected void initData() {

    }
}
