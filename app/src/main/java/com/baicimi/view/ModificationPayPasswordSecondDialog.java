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

public class ModificationPayPasswordSecondDialog extends Dialog {
    public ModificationPayPasswordSecondDialog(Context context) {
        super(context);
    }

    public ModificationPayPasswordSecondDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public ModificationPayPasswordSecondDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_password_second_dialog);

        dissmess = (TextView) findViewById(R.id.pay_password_second_dialog_false);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                ModificationSucceedDialog modificationSucceedDialog = new ModificationSucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                modificationSucceedDialog.show();
            }
        });


    }
}
