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

public class AutomaticSelectionDialog extends Dialog {
    public AutomaticSelectionDialog(Context context) {
        super(context);
    }

    public AutomaticSelectionDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , circle;
    private BaseFragment baseFragment;
    private TextView setting;

    public AutomaticSelectionDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.automatic_selection_dialog);


        setting = (TextView) findViewById(R.id.automatic_selection_dialog_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                AutomaticSelectionSettingDialog automaticSelectionSettingDialog = new AutomaticSelectionSettingDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                automaticSelectionSettingDialog.show();
            }
        });

        dissmess = (TextView) findViewById(R.id.automatic_selection_diessmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //替换
                dismiss();
            }
        });

    }
}
