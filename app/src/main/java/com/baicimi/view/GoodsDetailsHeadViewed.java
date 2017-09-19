package com.baicimi.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.fragments.PersonDingDanFragment;
import com.baicimi.fragments.QinMiFuDingDanFragment;
import com.baicimi.fragments.TuanGouDingDanFragment;

/**
 * Created by tan on 2016/9/19.
 * 商品详情ListView上方布局2
 */
public class GoodsDetailsHeadViewed extends BaseView{
    private LinearLayout ll_fuwu;
    private PopupWindow window;
    private Button button;

    public GoodsDetailsHeadViewed(Context context) {
        super(context);
    }

    @Override
    public void initEvent() {
    }

    @Override
    protected void initData() {
    }

    @Override
    public void initView() {
        view= LayoutInflater.from(mcontext).inflate( R.layout.view_goods_details_headed,this);
        ll_fuwu= (LinearLayout) view.findViewById(R.id.fuwu_ll);
        ll_fuwu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindow();
            }
        });

    }



    /**
     * 显示popupWindow
     */
    private void showPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view_window = inflater.inflate(R.layout.view_fuwu, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha( ((MainActivity)mcontext), 0.5f);

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
        window.showAtLocation(view.findViewById(R.id.fuwu_ll),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha( ((MainActivity)mcontext), 1.0f);
            }
        });

        button= (Button) view_window.findViewById(R.id.btn_wancheng);
        button.setOnClickListener(new OnClickListener() {
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
            window.dismiss();
            window = null;
            WindowManager.LayoutParams params = ((MainActivity)mcontext).getWindow().getAttributes();
            params.alpha = 1.0f;
            ((MainActivity)mcontext).getWindow().setAttributes(params);
        }
    }


}
