package com.baicimi.fragments;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.PassWordEditText;

/**
 * Created by Administrator on 2017/12/27.
 * 个人中心   资产中心  幂钱包   我的账户余额 充值
 */
public class MiWalletHomePageAccountBalanceRecharge extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView next;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_homepage_account_balance_recharge , container , false);

        back = (ImageView) view.findViewById(R.id.mi_wallet_homepage_account_balance_recharge_back);
        back.setOnClickListener(this);

        next = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_recharge_next);
        next.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_homepage_account_balance_recharge_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_wallet_homepage_account_balance_recharge_next:

                View viewWindow = LayoutInflater.from(getContext()).inflate(R.layout.mi_wallet_homepage_account_balance_recharge_window , null);
                final PopupWindow popupWindow = new PopupWindow(viewWindow , WindowManager.LayoutParams.MATCH_PARENT,500);
                changeWindowAlpha(getActivity(), 0.5f);
                // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);

                // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
                popupWindow.setBackgroundDrawable(new BitmapDrawable());

                // 实例化一个ColorDrawable颜色为半透明
                ColorDrawable dw = new ColorDrawable(0xFFffffff);
                popupWindow.setBackgroundDrawable(dw);

                // 设置popWindow的显示和消失动画
                popupWindow.setAnimationStyle(R.style.AnimBottom);
                //设置在底部显示
                popupWindow.showAtLocation(view , Gravity.BOTTOM, 0, 0);

                /**
                 * *popWindow消失监听方法
                 */
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        changeWindowAlpha(getActivity(), 1.0f);
                    }
                });

                ImageView backWindow = (ImageView) viewWindow.findViewById(R.id.mi_wallet_homepage_account_balance_recharge_window_back);
                LinearLayout backLayout = (LinearLayout) viewWindow.findViewById(R.id.mi_wallet_homepage_account_balance_recharge_window_checked);
                backWindow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                backLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        showSecondPopupWindow();
                    }
                });

                break;
        }
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


    private void showSecondPopupWindow(){
        View viewWindowSecond = LayoutInflater.from(getContext()).inflate(R.layout.mi_wallet_homepage_account_balance_recharge_window_second , null);
        final PopupWindow popupWindowSecond = new PopupWindow(viewWindowSecond , WindowManager.LayoutParams.MATCH_PARENT,500);
        changeWindowAlpha(getActivity(), 0.5f);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        popupWindowSecond.setFocusable(true);
        popupWindowSecond.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        popupWindowSecond.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        popupWindowSecond.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        popupWindowSecond.setAnimationStyle(R.style.AnimBottom);
        //设置在底部显示
        popupWindowSecond.showAtLocation(view , Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        popupWindowSecond.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });

        ImageView windowSecondBack = (ImageView) viewWindowSecond.findViewById(R.id.mi_wallet_homepage_account_balance_recharge_window_second_back);
        windowSecondBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindowSecond.dismiss();
            }
        });
        PassWordEditText passWordEditText = (PassWordEditText) viewWindowSecond.findViewById(R.id.mi_wallet_homepage_account_balance_recharge_window_second_pw_et);
        passWordEditText.setOnTextEndListener(new PassWordEditText.OnTextEndListener() {
            @Override
            public void onTextEndListener(boolean state) {
                if (state){
                    startFragment(new MiWalletHomePageAccountBalanceRechargeSucceed());
                }
            }
        });


    }

}
