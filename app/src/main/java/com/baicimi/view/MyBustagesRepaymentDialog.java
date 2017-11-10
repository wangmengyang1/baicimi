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

public class MyBustagesRepaymentDialog extends Dialog {
    public MyBustagesRepaymentDialog(Context context) {
        super(context);
    }

    public MyBustagesRepaymentDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , back;
    private BaseFragment baseFragment;

    public MyBustagesRepaymentDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_bustages_repayment_dialog);

        dissmess = (TextView) findViewById(R.id.my_bustages_repayment_dialog_false);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                MyBustagesRepaymentSecondDialog myBustagesRepaymentSecondDialog = new MyBustagesRepaymentSecondDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                myBustagesRepaymentSecondDialog.show();
            }
        });
        back = (TextView) findViewById(R.id.my_bustages_repayment_dialog_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
