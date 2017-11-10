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

public class TransFeraccountsSecondDialog extends Dialog {
    public TransFeraccountsSecondDialog(Context context) {
        super(context);
    }

    public TransFeraccountsSecondDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , back;
    private BaseFragment baseFragment;

    public TransFeraccountsSecondDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trans_feraccounts_second_dialog);

        dissmess = (TextView) findViewById(R.id.trans_feraccounts_second_dialog_false);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        back = (TextView) findViewById(R.id.trans_feraccounts_second_dialog_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });



    }
}
