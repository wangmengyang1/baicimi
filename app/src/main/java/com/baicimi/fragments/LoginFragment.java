package com.baicimi.fragments;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.PhoneRegisterActivity;
import com.baicimi.activitys.SendMessageFindPasswordActivity;
import com.baicimi.base.BaseFragment;
import com.baicimi.conf.Constant;
import com.baicimi.qqsigin.JsonParserUtil;
import com.baicimi.qqsigin.QQLoadInfo;
import com.baicimi.qqsigin.QQUserInfo;
import com.baicimi.ui.SharedPreferencesUtil;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


/**
 * Created by tan on 2016/8/11.
 */
public class LoginFragment extends BaseFragment {
    @ViewInject(R.id.phone)
    private EditText phone_num;
    @ViewInject(R.id.et_password)
    private EditText password_num;

    /**
     * QQ
     */
    private Tencent mTencent;
    private String mAppId;

    private UserInfo mUserInfo;
    private ImageView qq_img;

    /**
     * 微信
     */
    public static IWXAPI WXapi;
    private String weixinCode;
    private final static int LOGIN_WHAT_INIT = 1;
    private static String get_access_token = "";


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        qq_img = (ImageView) view.findViewById(R.id.qq_sigin);
        qq_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登陆
                mTencent.login(getActivity(), "all", new QQListener());
            }
        });
        setConfig();

        return view;
    }

    private void setConfig() {
        mAppId = "222222";
        // 注册QQ
//		StatConfig.setAppKey(this, "Aqc" + mOpenKey);
        mTencent = Tencent.createInstance(mAppId, getActivity());
    }

    /**
     * 获得QQ登陆的基本信息
     **/
    class QQListener implements IUiListener {

        //登陆成功
        @Override
        public void onComplete(Object obj) {
            Log.i("", "======登陆成功=======" + obj.toString());

            QQLoadInfo qQLoadInfo = JsonParserUtil.getQQLoadInfo(obj.toString());

            //设置openid和token，否则获取不到下面的信息
            String openId = qQLoadInfo.getOpenid();
            String token = qQLoadInfo.getAccess_token();
            String expires = qQLoadInfo.getExpires_in();

            mTencent.setAccessToken(token, expires);
            mTencent.setOpenId(openId);

            mUserInfo = new UserInfo(getActivity(), mTencent.getQQToken());
            mUserInfo.getUserInfo(new UserInfoListener());
        }

        //QQ登陆取消
        @Override
        public void onCancel() {
            // TODO Auto-generated method stub

        }

        //QQ登陆失败
        @Override
        public void onError(UiError arg0) {
            // TODO Auto-generated method stub
        }
    }

    /**
     * 获得qq登陆用户信息
     **/
    class UserInfoListener implements IUiListener {

        @Override
        public void onComplete(Object obj) {
            // TODO Auto-generated method stub
            Log.i("", "======用户信息=======" + obj.toString());
             /**
             * figureurl_qq_2为用户图像的url
             * */
            QQUserInfo qQUserInfo = JsonParserUtil.getQQUserInfo(obj.toString());
            String user_header = qQUserInfo.getFigureurl_qq_2();//获取QQ头像信息
            String user_lovename = qQUserInfo.getNickname();//获取QQ昵称

            Log.i("", "===用户图像 url====" + qQUserInfo.getFigureurl_qq_2());
            Log.i("", "===用户昵称====" + qQUserInfo.getNickname());

            SharedPreferencesUtil.putString(getContext(), com.baicimi.Constants.INFO_HEADER, user_header);
            SharedPreferencesUtil.putString(getContext(), com.baicimi.Constants.INFO_LOVENAME, user_lovename);

        }

        @Override
        public void onCancel() {
            // TODO Auto-generated method stub
        }

        @Override
        public void onError(UiError arg0) {
            // TODO Auto-generated method stub
        }
    }

    @Override
    public void onDestroy() {
        //qq登出
        if (mTencent != null) {
            mTencent.logout(getActivity());
        }
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //在某些低端机上调用登录后，由于内存紧张导致 APP 被系统回收，登录成功后无法成功回传数据,需要重写onActivityResult
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, (IUiListener) new QQListener());
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_login, R.id.register, R.id.find_password})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.btn_login:
                startFragment(new UserCenterHomePageHeadFragment() , null );//个人中心界面(最新)
//                startFragment(new UserCenterHomePageFragment(), null);
//                startFragment(new PersonCenteredFragment(), null);//登录成功跳转到个人中心页面。（旧页面）
                String  head=SharedPreferencesUtil.getString(getContext(), com.baicimi.Constants.INFO_HEADER,"");
                String name=SharedPreferencesUtil.getString(getContext(), com.baicimi.Constants.INFO_LOVENAME,"");

                Log.d("获得的头像信息是....",head);
                Log.d("获得的头像信息是....",name);
//                InPortPassWord();
                break;
            case R.id.register:
                Intent registerintent = new Intent(getActivity(), PhoneRegisterActivity.class);
                startActivity(registerintent);
                break;
            case R.id.find_password:
//                Intent findintent = new Intent(getActivity(), SendMessageFindPasswordActivity.class);
//                startActivity(findintent);
                //密码找回
                startFragment(new UserPasswordFindFragment());
                break;
        }
    }


}


