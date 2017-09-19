package com.baicimi.activitys;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baicimi.Constants;
import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.conf.Constant;
import com.baicimi.ui.SharedPreferencesUtil;
import com.baicimi.ui.ToastUtils;
import com.lidroid.xutils.util.LogUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by tan on 2016/8/11.
 */
@ContentView(R.layout.activity_sendmessege)
public class SendMessageActivity extends BaseActivity {
    @ViewInject(R.id.send_message_quxiao)
    private Button bt_quxiao;
    @ViewInject(R.id.send_message_queren)
    private Button bt_queren;
    @ViewInject(R.id.send_messege_to_phone)
    private TextView phone_num;

    @Override
    protected void initData() {
        bt_queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SendMessageActivity.this, CodeInportActivity.class);
                startActivity(intent);
                getPasswordNum();
                finish();
            }
        });

        bt_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String phone = SharedPreferencesUtil.getString(getApplicationContext(), Constants.INFO_PHONENUM, "");
        phone_num.setText(String.valueOf(phone));


    }

    public void getPasswordNum() {
        String sPassWordNum = SharedPreferencesUtil.getString(getApplicationContext(), Constants.INFO_PHONENUM, "");
        LogUtils.d("手机号码是>>>>" + sPassWordNum);
        RequestParams params = new RequestParams(Constant.MyURL.PassWordNum + sPassWordNum);
        LogUtils.d("请求的数据（动态密码）是>>>>" + params);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String o) {
                LogUtils.d("返回的数据是>>>>" + o.toString());
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                LogUtils.d("-----onError没有返回数据" + throwable);
//                ToastUtils.showOnUIThread("用户注册失败，请检查网络" , getApplicationContext());
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
