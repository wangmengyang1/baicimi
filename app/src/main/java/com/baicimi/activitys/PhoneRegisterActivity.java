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
import com.lidroid.xutils.util.LogUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by tan on 2016/8/12.
 */
@ContentView(R.layout.activity_register_phone)
public class PhoneRegisterActivity extends BaseActivity {
    @ViewInject(R.id.login_back)
    private ImageView imageView;
    @ViewInject(R.id.btn_next)
    private Button btn_next;
    @ViewInject(R.id.et_phone)
    private EditText e;
    @ViewInject(R.id.zhanghao)
    private TextView tvCountry;


    @Override
    protected void initData() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PhoneRegisterActivity.this, SendMessageActivity.class);
                getPhoneNum();
                startActivity(intent);
                finish();
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         *跳转到获取地区手机前缀号界面
         * */
        tvCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneRegisterActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });


        String item0 = this.getResources().getStringArray(R.array.cities_data)[0];
        CharSequence[] items = this.getResources().getStringArray(R.array.cities_data);


    }

    @Override
    protected void onResume() {
        tvCountry.setText(SharedPreferencesUtil.getCountry(this));
        super.onResume();
    }

    public void getPhoneNum() {
        String str = e.getText().toString();//获取手机号码

        //保存输入的电话号码
        SharedPreferencesUtil.putString(getApplicationContext(), Constants.INFO_PHONENUM,str);

//        params.addHeader("Content-Type", "application/json");
        String strBase64 = new String(Base64.encode(str.getBytes(), Base64.DEFAULT));
        LogUtils.d("返回的数据是>>>>"+strBase64);
        RequestParams params = new RequestParams(Constant.MyURL.REGISTER+strBase64);
        LogUtils.d("请求的数据是>>>>"+params);
//        params.addBodyParameter("token", strBase64);//把url和参数进行拼接
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
