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
 * 对公转账提示弹出对话框
 */

public class CommonalityTransferDialog extends Dialog {

    private TextView requestTv;

    public CommonalityTransferDialog(Context context) {
        super(context);
    }

    public CommonalityTransferDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private BaseFragment baseFragment;

    public CommonalityTransferDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commonality_transfer_dialog);
        requestTv = (TextView) findViewById(R.id.commonality_transfer_dialog_request_tv);
        requestTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
