package com.baicimi.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by tan on 2016/8/12.
 */
@ContentView(R.layout.activity_newpassword_set)
public class NewPasswordSetActivity extends BaseActivity{
    @ViewInject(R.id.login_back)
    private ImageView imageView;
    @ViewInject(R.id.btn_newpass_next)
    private Button newpassw_next;

    @Override
    protected void initData() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        newpassw_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //跳到个人中心
                    finish();
            }
        });
    }
}
