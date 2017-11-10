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

public class MyBustagesRepaymentSecondDialog extends Dialog {
    public MyBustagesRepaymentSecondDialog(Context context) {
        super(context);
    }

    public MyBustagesRepaymentSecondDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , back;
    private BaseFragment baseFragment;

    public MyBustagesRepaymentSecondDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_bustages_repayment_second_dialog);

        dissmess = (TextView) findViewById(R.id.my_bustages_repayment_second_dialog_false);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                //确认还款
                PaySucceedDialog paySucceedDialog = new PaySucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                paySucceedDialog.show();
            }
        });
        back = (TextView) findViewById(R.id.my_bustages_repayment_second_dialog_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
