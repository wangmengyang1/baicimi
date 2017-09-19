package com.baicimi.activitys;


import android.content.Intent;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.Constants;
import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.conf.Constant;
import com.baicimi.ui.SharedPreferencesUtil;
import com.baicimi.ui.TimeButton;
import com.lidroid.xutils.util.LogUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


/**
 * Created by tan on 2016/8/11.
 */
@ContentView(R.layout.activity_import_code)
public class CodeInportActivity extends BaseActivity {
    @ViewInject(R.id.btn_next)
    private Button btn_next;
    @ViewInject(R.id.login_back)
    private ImageView imageView;
    @ViewInject(R.id.button1)
    private TimeButton v;
    @ViewInject(R.id.et_password_num)
    private EditText e;
    @ViewInject(R.id.phone_num)
    private TextView phone_num;


    @Override
    protected void initData() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CodeInportActivity.this, InportPasswordActivity.class);
                startActivity(intent);
                InPortPassWordNum();
                finish();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        v = (TimeButton) findViewById(R.id.button1);
        v.setTextAfter("秒后重新获取").setTextBefore("点击获取验证码").setLenght(115 * 1000);

        String phone = SharedPreferencesUtil.getString(getApplicationContext(), Constants.INFO_PHONENUM, "");
        phone_num.setText(String.valueOf(phone));

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        v.onDestroy();
        super.onDestroy();
    }


    public void InPortPassWordNum() {
        String str = e.getText().toString();//获取输入的动态短信密码
        LogUtils.d("要输入的动态密码是>>>>"+str);
        String sPassWordNum= SharedPreferencesUtil.getString(getApplicationContext(), Constants.INFO_PHONENUM,"");
        LogUtils.d("手机号码是>>>>"+sPassWordNum);
        RequestParams params = new RequestParams(Constant.MyURL.INPortPassWordNum+sPassWordNum+"&code="+str);
        LogUtils.d("请求的数据是>>>>"+params);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String o) {
                LogUtils.d("返回的数据是>>>>"+o.toString());
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                LogUtils.d("-----onError没有返回数据"+throwable);
            }

            @Override
            public void onCancelled(CancelledException e) {
                LogUtils.d("-----onCancelled");
            }

            @Override
            public void onFinished() {
                LogUtils.d("-----onFinished");
            }
        });
    }



}
