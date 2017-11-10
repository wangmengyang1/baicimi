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

public class ModificationPayPasswordDialog extends Dialog {
    public ModificationPayPasswordDialog(Context context) {
        super(context);
    }

    public ModificationPayPasswordDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public ModificationPayPasswordDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.midification_pay_pawwsord_dialog);

        dissmess = (TextView) findViewById(R.id.midification_pay_password_second_dialog_false);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                ModificationPayPasswordSecondDialog modificationPayPasswordSecondDialog = new ModificationPayPasswordSecondDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                modificationPayPasswordSecondDialog.show();
            }
        });


    }
}
