package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/19.
 * 上传回执单添加图片页面
 */

public class CoverSettingFirstDialog extends Dialog {
    public CoverSettingFirstDialog(Context context) {
        super(context);
    }

    public CoverSettingFirstDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , circle;
    private BaseFragment baseFragment;

    public CoverSettingFirstDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cover_setting_first_dialog);

        circle = (TextView) findViewById(R.id.cover_setting_first_dialog_circle);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取消
                dismiss();
                CoverSettingFirstCancelDialog coverSettingFirstCancelDialog = new CoverSettingFirstCancelDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                coverSettingFirstCancelDialog.show();
            }
        });

        dissmess = (TextView) findViewById(R.id.cover_setting_first_dialog_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //替换
                dismiss();

                CoverSettingFirstDissmessDialog coverSettingFirstDissmessDialog = new CoverSettingFirstDissmessDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                coverSettingFirstDissmessDialog.show();
            }
        });

    }
}
