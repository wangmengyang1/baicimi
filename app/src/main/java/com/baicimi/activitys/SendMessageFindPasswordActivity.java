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
 * Created by tan on 2016/8/11.
 */
@ContentView(R.layout.activity_send_messege_find_password)
public class SendMessageFindPasswordActivity extends BaseActivity {

    @ViewInject(R.id.login_back)
    private ImageView imageView;
    @ViewInject(R.id.new_password_next)
    private Button btn_next;

    @Override
    protected void initData() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent findintent=new Intent();
                findintent.setClass(SendMessageFindPasswordActivity.this,VerifyFindPasswordActivity.class);
                startActivity(findintent);
                finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
