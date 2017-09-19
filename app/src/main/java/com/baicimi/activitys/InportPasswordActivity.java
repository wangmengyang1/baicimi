package com.baicimi.activitys;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.baicimi.Constants;
import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.conf.Constant;
import com.baicimi.ui.SharedPreferencesUtil;
import com.lidroid.xutils.util.LogUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by tan on 2016/8/12.
 */
@ContentView(R.layout.activity_password_set)
public class InportPasswordActivity extends BaseActivity{
    @ViewInject(R.id.login_back)
    private ImageView imageView;
    @ViewInject(R.id.btn_secc)
    private Button btn_secc;
    @ViewInject(R.id.et_phone_password)
    private EditText e;
    @Override
    protected void initData() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_secc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InPortPassWord();
                finish();
            }
        });
    }


    public void InPortPassWord() {
        String str = e.getText().toString();//获取输入的动态短信密码
        LogUtils.d("要输入的原始用户密码是>>>>"+str);
        String PhonedNum= SharedPreferencesUtil.getString(getApplicationContext(), Constants.INFO_PHONENUM,"");//拿到手机号码
        LogUtils.d("手机号码是>>>>"+PhonedNum);
        RequestParams params = new RequestParams(Constant.MyURL.INPortPassWord+PhonedNum+"&pass="+str+"&ip=%@");
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
