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

public class CoverSettingFirstDissmessDialog extends Dialog {
    public CoverSettingFirstDissmessDialog(Context context) {
        super(context);
    }

    public CoverSettingFirstDissmessDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess;
    private BaseFragment baseFragment;

    public CoverSettingFirstDissmessDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cover_setting_first_dissmess_dialog);

        dissmess = (TextView) findViewById(R.id.cover_setting_first_dissmess_dialog_dissmass);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();


                CoverSettingFirstReplaceDialog coverSettingFirstReplaceDialog = new CoverSettingFirstReplaceDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                coverSettingFirstReplaceDialog.show();

            }
        });

    }
}
