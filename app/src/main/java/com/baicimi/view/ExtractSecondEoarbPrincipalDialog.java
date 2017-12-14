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

public class ExtractSecondEoarbPrincipalDialog extends Dialog {
    public ExtractSecondEoarbPrincipalDialog(Context context) {
        super(context);
    }

    public ExtractSecondEoarbPrincipalDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public ExtractSecondEoarbPrincipalDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extract_second_eoarb_principal_dialog);

        dissmess = (TextView) findViewById(R.id.extract_second_eoarb_principal_dialog_true);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                ExtractSecondEoarbPrincipalSecondDialog extractSecondEoarbPrincipalSecondDialog =
                        new ExtractSecondEoarbPrincipalSecondDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , baseFragment);
                extractSecondEoarbPrincipalSecondDialog.show();
            }
        });

        deny = (TextView) findViewById(R.id.extract_second_eoarb_principal_dialog_false);
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取消
                dismiss();
            }
        });
    }
}
