package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.fragments.AfterSaleServerApplyforFragment;

/**
 * Created by Administrator on 2017/9/19.
 * 退款退货弹出对话框
 */

public class AfterSaleServerDialog extends Dialog {
    public AfterSaleServerDialog(Context context) {
        super(context);
    }

    public AfterSaleServerDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView true_tv;
    private BaseFragment baseFragment;

    public AfterSaleServerDialog(Context context, int themeResId ,BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_sale_server_dialog);
        true_tv = (TextView) findViewById(R.id.after_sale_server_dialog_true);
        true_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                if (baseFragment != null){
                    baseFragment.startFragment(new AfterSaleServerApplyforFragment());
                }
            }
        });
    }
}
