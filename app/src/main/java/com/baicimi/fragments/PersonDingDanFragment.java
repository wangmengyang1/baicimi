package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.alipays.AuthResult;
import com.baicimi.alipays.OrderInfoUtil2_0;
import com.baicimi.alipays.PayResult;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.Map;

/**
 * Created by tan on 2016/9/14.\
 * 个人订单界面
 */
public class PersonDingDanFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout relativeLayout,relativeLayout_sendways,relativeLayout_payway,relativeLayout_fenqipay,relativeLayout_youhuiquan;
    private PopupWindow window,window_sendway,window_payway;
    private CheckBox checkBox1000;
    private CheckBox checkBox2000;
    private CheckBox checkBox5000;
    private CheckBox kuaidi1,kuaidi2;
    private Button button_yes;
    private ImageView imageView_cansul,imageView_cansul2;
    private Button btn_tijiao,btn_closesend;
    private CheckBox checkBox_one,checkBox_tow,checkBox_three,checkBox_one2,checkBox_tow2,checkBox_three2;


    private View view_window;//支付宝点击事件布局

    //支付宝支付
    private RelativeLayout paymony_alipay;


    //支付宝相关业务引入
    /** 支付宝支付业务：入参app_id */
    public static final String APPID = "2017041406710078";

    /** 支付宝账户登录授权业务：入参pid值 */
    public static final String PID = "2088011704608463";
    /** 支付宝账户登录授权业务：入参target_id值 */
    public static final String TARGET_ID = "";

    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /** 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1 */
    public static final String RSA2_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCINKMrbLCYx/xqIa+VEowKpoPymMpEmdset7B3dRRzYU6hlintm+O9O4zPUmZ5/YmKfH4kJjq9ReXlHuiTn+LTM0CfsmoHomQ3znmiM0ICwvUGRq/rOVEn3/JA1SdT2GXDtW3FCU0l2fA4wl7UGYAReJmx3wIOtI/2WTvig51y2pfI1BIUMBMbI3LV3xqFTsbioqqRmigdB2BtM8dV+rIm2ob1gqviikVsLtuxpmqhTizebvWjV6tuuYL7hLoZDEY3wXlVhFaBidK/SpC/r634tUkumcKy2lkepEBzVhK7g+iz1RuOet7CcwEvNDjG4+VQKmpl1TRV0srJFWi6Xp/XAgMBAAECggEAKEI+tHgk3pPF9OzOBCb+Q6uiNpOYvZwoWzT6MOTnTY9GeZZ0ACpiry0p2qHFbmtVOxy/ABpYpFdDs2xmXDQXDEwK3ukSU/1Y1/Hsm9fAvCY53EgKeWFwrnOQHD+kpzDAK4+1yVaNehGn4m75LoH3C7L04tFCv2v5XVxUyggTAr5PCM8x6AAA0JPX1Ca0zcxkatasVKcUeGL4IzJHmuTVRNKCV3rFQ8LJ+80Ta/dPtOu564hhynXiAFxfKhYZ43p5Ef0iL8ia/vcmTJH+wb8XdVKktZAHCFWiDvEAeIaaDq8JMd0JtOdWmx9cZP3/cJFymQBrWrkh9KCHMpvitL1J8QKBgQDlGfVPSNPPXLFWBXS3sFc0LuAxyazQ9Ramyw5AvFWmiaqC3aHYul3HzBC/32LkiMr3+2zBAyj0tQxmqYsg3h+HuOqyzYh2BmtofjXf4Jah3Z0DSxLNQjq+ydZs8QfdQZaV2T6RGSaBUUTzRqRHTTi/3zPeG2HisrdZRhswKtQqrwKBgQCYMojSy8IRLFn5tqa3TK9VZE5bZfepBUvdzWi3eCMlkvYrQ7nofj8aCbJOSpG2OVj/ep1GBQJDdJEWJ9pvubX1RKXZUy1OZqi58rwTZb2ebIBzjyzfhgzndpvaOpHxy5XPtAj0SjTTZhRG6n/yVwuJ9BM8BGazxDFYEdm7ld8HWQKBgQCNtR24Gcrx01rZY2yLhiaaX3hLM3ySj1ageq7pOdUcusBeS+qlHLmPMNkXZXxM8ZPiCYF+bY7ytd3iznIBNYN5NtbtHBaRMm1TZ+W5AbkKjAJnnBMYJSQjCMN6BSihIcWcEJETvOPFT1h/xa0tcUVt4Qi7FGLaj0K7lJKSm5s6fwKBgBuANhzw2HZF71Qh3uoMHzpsz4PQXvnZjSXc8ekE+kTV00lqCXOrLDfGPMPM0Zt9rUksnLKEQS5zJ6w7M0sw4WIaL2Wfk/Ywspg29ikDH0o7DNLUsiUJkddZJTw/jROF1+IaA+wwZG82aL+Pq+LcO6eHxNn5aZ1d/BSP1SoCILSxAoGAXt2jSRyUHnllDBJSBOZXQQkwG2Yq1igh/bzIvteJpL/gsIukN4V6rhF4bPAYy/jlX6At8QORBrWJUD/NfBkisyYdF9G0qXMM62XeAth9KLSEyycuEKJvncWTtNra+6HE9h1hGLFHAWB9wFGo0xVjoGSXFvT32YvHaCcDZXU9EEI=";
    public static final String RSA_PRIVATE = "";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(getContext(), "支付成功", Toast.LENGTH_SHORT).show();

                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(getContext(), "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(getContext(),
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(getContext(),
                                "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_person_dingdan, container, false);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.re_use_code);
        relativeLayout_sendways = (RelativeLayout) view.findViewById(R.id.send_ways_choose);
        relativeLayout_payway= (RelativeLayout) view.findViewById(R.id.pay_ways_choose);
        relativeLayout_fenqipay= (RelativeLayout) view.findViewById(R.id.re_fenqipay);
        relativeLayout_youhuiquan= (RelativeLayout) view.findViewById(R.id.re_youhuijuan);
        btn_tijiao = (Button) view.findViewById(R.id.btn_tijiao_dingdan);

        /**
         * 使用积分选择
         * */
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindow();
            }
        });

        /**
         * 配送方式选择
         * */
        relativeLayout_sendways.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSendWaysPopwindow();
            }
        });

        /**
         * 支付方式选择
         * */
        relativeLayout_payway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPayWaysPopwindow();
            }
        });

        /**
         * 分期支付选择
         * */
        relativeLayout_fenqipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFenqiPopwindow();
            }
        });


        /**
         * 选择
         * */
        relativeLayout_youhuiquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showyouhuiquanPopwindow();
            }
        });


        btn_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new MyDingDanFragment(), null);
            }
        });

        return view;
    }


    /**
     * 显示使用积分popupWindow
     */
    private void showPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.view_use_code, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        window.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window.setBackgroundDrawable(new BitmapDrawable());

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window.setBackgroundDrawable(dw);
//        //在参照的View控件下方显示
//        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        //设置在底部显示
        window.showAtLocation(view.findViewById(R.id.re_use_code),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });


        /**
         * 使用1000积分
         * */
        checkBox1000 = (CheckBox) view_window.findViewById(R.id.use_jifen1);
        checkBox1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1000.setChecked(true);
                checkBox2000.setChecked(false);
                checkBox5000.setChecked(false);
            }
        });

        /**
         * 使用2000积分
         * */
        checkBox2000 = (CheckBox) view_window.findViewById(R.id.use_jifen2);
        checkBox2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1000.setChecked(false);
                checkBox2000.setChecked(true);
                checkBox5000.setChecked(false);
            }
        });

        /**
         * 使用5000积分
         * */
        checkBox5000 = (CheckBox) view_window.findViewById(R.id.use_jifen3);
        checkBox5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1000.setChecked(false);
                checkBox2000.setChecked(false);
                checkBox5000.setChecked(true);
            }
        });


        button_yes = (Button) view_window.findViewById(R.id.jifen_btn_yse);
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupWindow();
            }
        });


        imageView_cansul = (ImageView) view_window.findViewById(R.id.guanbi_img);
        imageView_cansul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupWindow();
            }
        });

    }


    /**
     * 显示配送方式popupWindow
     */
    private void showSendWaysPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.sendway_dialog, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_sendway = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_sendway.setFocusable(true);
        window_sendway.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_sendway.setBackgroundDrawable(new BitmapDrawable());

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window.setBackgroundDrawable(dw);
//        //在参照的View控件下方显示
//        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));

        // 设置popWindow的显示和消失动画
        window_sendway.setAnimationStyle(R.style.mypopwindow_anim_style);
        //设置在底部显示
        window_sendway.showAtLocation(view.findViewById(R.id.re_use_code),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window_sendway.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });


        /**
         * 使用普通快递
         * */
        kuaidi1 = (CheckBox) view_window.findViewById(R.id.kuaidi1);
        kuaidi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuaidi1.setChecked(true);
                kuaidi2.setChecked(false);
            }
        });

        /**
         * 使用EMS快递
         * */
        kuaidi2 = (CheckBox) view_window.findViewById(R.id.kuaidi2);
        kuaidi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuaidi1.setChecked(false);
                kuaidi2.setChecked(true);
            }
        });


        imageView_cansul2 = (ImageView) view_window.findViewById(R.id.close_img);
        imageView_cansul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSendWayPopupWindow();
            }
        });

        btn_closesend = (Button) view_window.findViewById(R.id.btn_close);
        btn_closesend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSendWayPopupWindow();
            }
        });
    }


    /**
     * 显示支付方式popupWindow
     */
    private void showPayWaysPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        view_window = inflater.inflate(R.layout.paymony_dialog, null);
        paymony_alipay = (RelativeLayout) view_window.findViewById(R.id.paymony_alipay);
        paymony_alipay.setOnClickListener(this);


        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_payway = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_payway.setFocusable(true);
        window_payway.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_payway.setBackgroundDrawable(new BitmapDrawable());

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window.setBackgroundDrawable(dw);
//        //在参照的View控件下方显示
//        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));

        // 设置popWindow的显示和消失动画
        window_payway.setAnimationStyle(R.style.mypopwindow_anim_style);
        //设置在底部显示
        window_payway.showAtLocation(view.findViewById(R.id.re_use_code),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window_payway.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });
    }


    /**
     * 显示分期支付popupWindow
     */
    private void showFenqiPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.choose_fenqipay_dialog, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_payway = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_payway.setFocusable(true);
        window_payway.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_payway.setBackgroundDrawable(new BitmapDrawable());

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window.setBackgroundDrawable(dw);
//        //在参照的View控件下方显示
//        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));

        // 设置popWindow的显示和消失动画
        window_payway.setAnimationStyle(R.style.mypopwindow_anim_style);
        //设置在底部显示
        window_payway.showAtLocation(view.findViewById(R.id.re_fenqipay),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window_payway.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });

        ImageView imageView= (ImageView) view_window.findViewById(R.id.clouse_fenqi);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePayWayPopupWindow();
            }
        });
        Button button= (Button) view_window.findViewById(R.id.btn_do_fenqi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePayWayPopupWindow();
            }
        });

        checkBox_one= (CheckBox) view_window.findViewById(R.id.che_1);
        checkBox_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_one.setChecked(true);
                checkBox_tow.setChecked(false);
                checkBox_three.setChecked(false);
            }
        });

        checkBox_tow= (CheckBox) view_window.findViewById(R.id.che_2);
        checkBox_tow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_one.setChecked(false);
                checkBox_tow.setChecked(true);
                checkBox_three.setChecked(false);
            }
        });

        checkBox_three= (CheckBox) view_window.findViewById(R.id.che_3);
        checkBox_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_one.setChecked(false);
                checkBox_tow.setChecked(false);
                checkBox_three.setChecked(true);
            }
        });

    }


    /**
     * 显示优惠券popupWindow
     */
    private void showyouhuiquanPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.choose_youhuiquan_dialog, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_payway = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_payway.setFocusable(true);
        window_payway.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_payway.setBackgroundDrawable(new BitmapDrawable());

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window.setBackgroundDrawable(dw);
//        //在参照的View控件下方显示
//        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));

        // 设置popWindow的显示和消失动画
        window_payway.setAnimationStyle(R.style.mypopwindow_anim_style);
        //设置在底部显示
        window_payway.showAtLocation(view.findViewById(R.id.re_youhuijuan),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window_payway.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });



        ImageView imageView= (ImageView) view_window.findViewById(R.id.clouse_fenqi);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePayWayPopupWindow();
            }
        });

        Button button= (Button) view_window.findViewById(R.id.btn_do_fenqi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePayWayPopupWindow();
            }
        });

        checkBox_one2= (CheckBox) view_window.findViewById(R.id.che1);
        checkBox_one2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_one2.setChecked(true);
                checkBox_tow2.setChecked(false);
                checkBox_three2.setChecked(false);
            }
        });

        checkBox_tow2= (CheckBox) view_window.findViewById(R.id.che2);
        checkBox_tow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_one2.setChecked(false);
                checkBox_tow2.setChecked(true);
                checkBox_three2.setChecked(false);
            }
        });

        checkBox_three2= (CheckBox) view_window.findViewById(R.id.che3);
        checkBox_three2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_one2.setChecked(false);
                checkBox_tow2.setChecked(false);
                checkBox_three2.setChecked(true);
            }
        });


    }






    /**
     * 改变popwindow背景的方法
     *
     * @param alpha
     */
    private static void changeWindowAlpha(FragmentActivity activity, float alpha) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = alpha;
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        activity.getWindow().setAttributes(params);
    }


    /**
     * 关闭窗口
     */
    private void closePopupWindow() {
        if (window != null && window.isShowing()) {
            System.out.println("88888888888888888888");
            window.dismiss();
            window = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
            System.out.println("99999999999999999999");
        }
    }

    /**
     * 关闭窗口
     */
    private void closeSendWayPopupWindow() {
        if (window_sendway != null && window_sendway.isShowing()) {
            System.out.println("88888888888888888888");
            window_sendway.dismiss();
            window_sendway = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
            System.out.println("99999999999999999999");
        }
    }

    /**
     * 关闭窗口
     */
    private void closePayWayPopupWindow() {
        if (window_payway != null && window_payway.isShowing()) {
            System.out.println("88888888888888888888");
            window_payway.dismiss();
            window_payway = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
            System.out.println("99999999999999999999");
        }
    }

    @OnClick({R.id.login_back, R.id.re_address , R.id.paymony_alipay})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
            case R.id.re_address:
                startFragment(new AddRecieveAddressFragment(), null);
                break;
            case R.id.paymony_alipay:
                //进行支付宝支付
                payV2(view_window);
                break;
        }
    }

    @Override
    protected void initData() {

    }


    /**
     * 支付宝支付业务
     *
     * @param v
     */
    public void payV2(View v) {
        if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
            new AlertDialog.Builder(getContext()).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }

        /**
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * orderInfo的获取必须来自服务端；
         */
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(getActivity());
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


}
