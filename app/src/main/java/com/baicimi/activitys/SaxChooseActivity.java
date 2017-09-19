package com.baicimi.activitys;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.event.InfoSexEvent;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import org.xutils.view.annotation.Event;

import de.greenrobot.event.EventBus;

/**
 * Created by tan on 2016/8/16.
 */
@ContentView(R.layout.activity_choose_sax)
public class SaxChooseActivity extends BaseActivity {
    private static final int man = 1;
    private static final int famale = 2;



    //选择男
    @OnClick(R.id.boy)
    private void boyClick(View view) {
        Toast.makeText(getApplicationContext(), "选择了男", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().post(new InfoSexEvent(man));
        finish();
    }

    //选择女
    @OnClick(R.id.girl)
    private void girlClick(View view) {
        Toast.makeText(getApplicationContext(), "选择了女",
                Toast.LENGTH_SHORT).show();
        EventBus.getDefault().post(new InfoSexEvent(famale));
        finish();
    }

    @Override
    protected void initData() {

    }
}
