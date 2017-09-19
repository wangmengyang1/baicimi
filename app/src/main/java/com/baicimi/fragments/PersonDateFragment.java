package com.baicimi.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.Constants;
import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.AdressGuanliActivity;
import com.baicimi.activitys.LoveNameSetActivity;
import com.baicimi.activitys.NameSetActivity;
import com.baicimi.activitys.SaxChooseActivity;
import com.baicimi.base.BaseFragment;
import com.baicimi.event.InfoLoveNameEvent;
import com.baicimi.event.InfoSexEvent;
import com.baicimi.event.UserNameEvent;
import com.baicimi.ui.FileUtils;
import com.baicimi.ui.SharedPreferencesUtil;
import com.baicimi.view.CircleImg;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


import java.io.File;

import de.greenrobot.event.EventBus;


/**
 * Created by tan on 2016/8/16.
 */
public class PersonDateFragment extends BaseFragment {
    private int i;
    private FragmentManager fm;
    @ViewInject(R.id.login_back)
    private ImageView imageView;
    @ViewInject(R.id.sax_choose)
    private RelativeLayout saxre;
    @ViewInject(R.id.user_sex)
    private TextView tv_sex;
    @ViewInject(R.id.user_id)
    private TextView tv_id;
    @ViewInject(R.id.user_love_name)
    private TextView tv_love_id;
    @ViewInject(R.id.info_header)
    private CircleImg info_head;

    private RelativeLayout mainLayout;

    private PopupWindow window_choose;
    private static final String IMAGE_FILE_NAME = "head.jpg";// 头像文件名称
    private String urlpath;            // 图片本地路径
    private static final int REQUESTCODE_PICK = 0;        // 相册选图标记
    private static final int REQUESTCODE_TAKE = 1;        // 相机拍照标记
    private static final int REQUESTCODE_CUTTING = 2;    // 图片裁切标记


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_person_data, container, false);
        tv_id= (TextView) view.findViewById(R.id.user_id);
        tv_love_id= (TextView) view.findViewById(R.id.love_name);

        String user_name = SharedPreferencesUtil.getString(getContext(), Constants.INFO_NAME, "");
        String user_lovename = SharedPreferencesUtil.getString(getContext(), Constants.INFO_LOVENAME, "");
        tv_id.setText(user_name);
        tv_love_id.setText(user_lovename);


        //更换头像
        info_head = (CircleImg) view.findViewById(R.id.info_header);
        info_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindowChoose(v);
            }
        });

        return view;
    }

    /**
     * 显示服务窗口
     */
    private void showPopwindowChoose(View v) {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.layout_dialog_pic, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_choose = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_choose.setFocusable(true);
        window_choose.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_choose.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        window_choose.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window_choose.setAnimationStyle(R.style.AnimBottom);
        //设置在底部显示
        window_choose.showAtLocation(v,
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window_choose.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });


        Button button_takePhotoBtn= (Button) view_window.findViewById(R.id.takePhotoBtn);
        button_takePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupFuwuWindow();
                Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //下面这句指定调用相机拍照后的照片存储的路径
                takeIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME)));
                startActivityForResult(takeIntent, REQUESTCODE_TAKE);
            }
        });

        Button button_pickPhotoBtn= (Button) view_window.findViewById(R.id.pickPhotoBtn);
        button_pickPhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupFuwuWindow();
                Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
                // 如果朋友们要限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型"
                pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(pickIntent, REQUESTCODE_PICK);
            }
        });

        Button button_cancelBtn= (Button) view_window.findViewById(R.id.cancelBtn);
        button_cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupFuwuWindow();
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
    private void closePopupFuwuWindow() {
        if (window_choose != null && window_choose.isShowing()) {
            System.out.println("88888888888888888888");
            window_choose.dismiss();
            window_choose = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
            System.out.println("99999999999999999999");
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQUESTCODE_PICK:// 直接从相册获取
                    try {
                    startPhotoZoom(data.getData());
                } catch (NullPointerException e) {
                    e.printStackTrace();// 用户点击取消操作
                }
                break;
            case REQUESTCODE_TAKE:// 调用相机拍照
                File temp = new File(Environment.getExternalStorageDirectory() + "/" + IMAGE_FILE_NAME);
                startPhotoZoom(Uri.fromFile(temp));
                break;
            case REQUESTCODE_CUTTING:// 取得裁剪后的图片
                if (data != null) {
                    setPicToView(data);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, REQUESTCODE_CUTTING);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param picdata
     */
    private void setPicToView(Intent picdata) {
        Bundle extras = picdata.getExtras();
        if (extras != null) {
            // 取得SDCard图片路径做显示
            Bitmap photo = extras.getParcelable("data");
            Drawable drawable = new BitmapDrawable(null, photo);
            urlpath = FileUtils.saveFile(getActivity(), "head.jpg", photo);
            info_head.setImageDrawable(drawable);
//            SharedPreferencesUtil.putString(getActivity(), Constants.INFO_PHOTOPATH, urlpath);
//            imgPost(machine_code, fid, urlpath);
        }
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.login_back, R.id.sax_choose, R.id.name_set_re, R.id.love_name_re, R.id.address_guanli_re})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
            case R.id.sax_choose:
                Intent saxintent = new Intent(getActivity(), SaxChooseActivity.class);
                startActivity(saxintent);
                break;
            case R.id.name_set_re:
                Intent nameintent = new Intent(getActivity(), NameSetActivity.class);
                startActivity(nameintent);
                break;
            case R.id.love_name_re:
                Intent lovenameintent = new Intent(getActivity(), LoveNameSetActivity.class);
                startActivity(lovenameintent);
                break;
            case R.id.address_guanli_re:
                Intent addressintent = new Intent(getActivity(), AdressGuanliActivity.class);
                startActivity(addressintent);
                break;
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        //注册EventBus
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        //取消注册EventBus
        EventBus.getDefault().unregister(this);
    }


    /**
     * EventBus得到性别
     */
    public void onEventMainThread(InfoSexEvent sex) {
        i = sex.getSex();
        if (i == 1) {
            tv_sex.setText("男");
        } else if (i == 2) {
            tv_sex.setText("女");
        }
    }

    /**
     * EventBus得到用户名
     */
    public void onEventMainThread(UserNameEvent name) {
        tv_id.setText(name.getName());
    }

    /**
     * EventBus得到昵称
     */
    public void onEventMainThread(InfoLoveNameEvent name) {
        tv_love_id.setText(name.getName());
    }
}
