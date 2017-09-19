package com.baicimi.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.ui.TimeButton;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by tan on 2016/8/12.
 */
@ContentView(R.layout.activity_test_messge)
public class VerifyFindPasswordActivity extends BaseActivity{
    @ViewInject(R.id.login_back)
    private ImageView imageView;
    @ViewInject(R.id.new_password_next)
    private Button btn_next;
    @ViewInject(R.id.tv_find_password)
    private TimeButton v;

    @Override
    protected void initData() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(VerifyFindPasswordActivity.this,NewPasswordSetActivity.class);
                startActivity(intent);
                finish();
            }
        });

        v = (TimeButton) findViewById(R.id.tv_find_password);
        v.setTextAfter("秒后重新获取").setTextBefore("点击获取验证码").setLenght(60 * 1000);

    }
}
