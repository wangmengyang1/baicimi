package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.fragments.ExtractSecondEoarbPrincipalEntrySlipg;

/**
 * Created by Administrator on 2017/9/19.
 * 上传回执单添加图片页面
 */

public class ExtractSecondEoarbPrincipalSecondDialog extends Dialog {
    public ExtractSecondEoarbPrincipalSecondDialog(Context context) {
        super(context);
    }

    public ExtractSecondEoarbPrincipalSecondDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public ExtractSecondEoarbPrincipalSecondDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extract_second_eoarb_principal_second_dialog);

        dissmess = (TextView) findViewById(R.id.extract_second_eoarb_principal_second_dialog_false);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baseFragment != null){
                    dismiss();
                    //提取凭条
                    baseFragment.startFragment(new ExtractSecondEoarbPrincipalEntrySlipg());
                }
            }
        });

    }
}
