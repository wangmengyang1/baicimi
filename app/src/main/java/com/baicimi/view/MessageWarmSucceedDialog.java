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

public class MessageWarmSucceedDialog extends Dialog {
    public MessageWarmSucceedDialog(Context context) {
        super(context);
    }

    public MessageWarmSucceedDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess;
    private BaseFragment baseFragment;

    public MessageWarmSucceedDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_warm_succeed_dialog);

        dissmess = (TextView) findViewById(R.id.message_warm_succeed_dialog_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                ConversionSucceedDialog conversionSucceedDialog = new ConversionSucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                conversionSucceedDialog.show();
            }
        });

    }
}
