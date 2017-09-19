package com.baicimi.activitys;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.baicimi.Constants;
import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.event.UserNameEvent;
import com.baicimi.ui.SharedPreferencesUtil;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


import de.greenrobot.event.EventBus;

/**
 * Created by tan on 2016/8/17.
 */
@ContentView(R.layout.activity_name_set)
public class NameSetActivity extends BaseActivity {
    @ViewInject(R.id.et_set_nane)
    private EditText et_name;
    private String name;


    @Override
    protected void initData() {

    }


    @OnClick({R.id.save_name, R.id.login_back})
    private void nameClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.save_name:
                name = et_name.getText().toString();
                Log.d("名字是",name);
                SharedPreferencesUtil.putString(this, Constants.INFO_NAME, name);
                EventBus.getDefault().post(new UserNameEvent(name));
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(this, "请输入你的名字", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                }
                break;

            case R.id.login_back:
                finish();
                break;
        }
    }
}
