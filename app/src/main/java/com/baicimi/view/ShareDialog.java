package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.baicimi.R;

/**
 * Created by tan on 2016/9/24.
 * 分享对话框
 */
public class ShareDialog extends Dialog{
    private onClickback callback;

    public ShareDialog(Context context, onClickback callback) {
        this(context, R.layout.share_view, R.style.mypopwindow_anim_style,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.callback = callback;
    }

    public ShareDialog(final Context context, int layout, int style, int width,
                       int height) {
        super(context, style);
        setContentView(layout);
        setCanceledOnTouchOutside(true);
        // 设置属性值
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = width;
        lp.height = height;
        getWindow().setAttributes(lp);

        setListener();
    }

    // 设置点击事件
    private void setListener() {
        findViewById(R.id.tv_wx).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(1);
                        dismiss();
                    }
                });
        findViewById(R.id.tv_wxp).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(2);
                        dismiss();
                    }
                });
        findViewById(R.id.tv_wb).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(3);
                        dismiss();
                    }
                });
        findViewById(R.id.tv_qq).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(4);
                        dismiss();
                    }
                });
        findViewById(R.id.tv_qqz).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(5);
                        dismiss();
                    }
                });
        findViewById(R.id.btn_cansul_share).setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
    }

    @Override
    public void show() {
        super.show();
       // 设置dialog显示动画
        getWindow().setWindowAnimations(R.style.mypopwindow_anim_style);
        // 设置显示位置为底部
        getWindow().setGravity(Gravity.BOTTOM);
    }

    public interface onClickback {
        abstract void onShare(int id);
    }
}

