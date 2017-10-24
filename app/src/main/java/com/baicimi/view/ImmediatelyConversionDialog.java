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
 *
 */

public class ImmediatelyConversionDialog extends Dialog {
    public ImmediatelyConversionDialog(Context context) {
        super(context);
    }

    public ImmediatelyConversionDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public ImmediatelyConversionDialog(Context context, int themeResId , boolean ischeck) {
        super(context, themeResId);
        this.ischeck = ischeck;
    }
    private TextView dissmess;
    private BaseFragment baseFragment;
    private boolean ischeck;
    private TextView remind;

    public ImmediatelyConversionDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immediately_conversion_dialog);
        remind = (TextView) findViewById(R.id.immediately_conversion_dialog_ps);
        if (ischeck){
            remind.setVisibility(View.VISIBLE);
        }else {
            remind.setVisibility(View.GONE);
        }
        dissmess = (TextView) findViewById(R.id.immediately_conversion_dialog_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                MessageWarmSucceedDialog messageWarmSucceedDialog = new MessageWarmSucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                messageWarmSucceedDialog.show();
            }
        });



    }
}
