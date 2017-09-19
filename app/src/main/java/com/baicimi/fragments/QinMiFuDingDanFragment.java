package com.baicimi.fragments;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
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

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/9/14.\
 * 亲密付订单界面
 */
public class QinMiFuDingDanFragment extends BaseFragment{
    private Button btn_qinmifu;
    private RelativeLayout relativeLayout;
    private PopupWindow window;
    private CheckBox checkBox1000;
    private CheckBox checkBox2000;
    private CheckBox checkBox5000;
    private Button button_yes;
    private ImageView imageView_cansul;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_qinmifu_dingdan,container,false);
        relativeLayout= (RelativeLayout) view.findViewById(R.id.re_use_code);
        btn_qinmifu= (Button) view.findViewById(R.id.btn_qinmifu_tijiao);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindow();
            }
        });
        btn_qinmifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new MyDingDanFragment(),null);
            }
        });
        return view;
    }



    /**
     * 显示popupWindow
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
        checkBox1000= (CheckBox) view_window.findViewById(R.id.use_jifen1);
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
        checkBox2000= (CheckBox) view_window.findViewById(R.id.use_jifen2);
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
        checkBox5000= (CheckBox) view_window.findViewById(R.id.use_jifen3);
        checkBox5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1000.setChecked(false);
                checkBox2000.setChecked(false);
                checkBox5000.setChecked(true);
            }
        });


        button_yes= (Button) view_window.findViewById(R.id.jifen_btn_yse);
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupWindow();
            }
        });


        imageView_cansul= (ImageView) view_window.findViewById(R.id.guanbi_img);
        imageView_cansul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupWindow();
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


    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }

            @Override
    protected void initData() {

    }
}
