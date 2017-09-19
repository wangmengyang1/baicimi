package com.baicimi.activitys;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.baicimi.Constants;
import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.event.InfoLoveNameEvent;
import com.baicimi.ui.SharedPreferencesUtil;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import de.greenrobot.event.EventBus;

/**
 * Created by tan on 2016/8/17.
 */
@ContentView(R.layout.activity_lovename_set)
public class LoveNameSetActivity extends BaseActivity {
    @ViewInject(R.id.et_set_lovenane)
    private EditText et_lovename;
    private String name;


    @OnClick({R.id.yes, R.id.login_back})
    private void nameClick(View view) {
        int id = view.getId();
        name = et_lovename.getText().toString();
        Log.d("昵称是",name);;
        SharedPreferencesUtil.putString(this, Constants.INFO_LOVENAME, name);
        EventBus.getDefault().post(new InfoLoveNameEvent(name));
        switch (id) {
            case R.id.yes:
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                }
                break;
            case R.id.login_back:
                finish();
                break;
        }
    }


    @Override
    protected void initData() {

    }
}
