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

public class IntegerParticularsDialog extends Dialog {
    public IntegerParticularsDialog(Context context) {
        super(context);
    }

    public IntegerParticularsDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , circle;
    private BaseFragment baseFragment;

    public IntegerParticularsDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integer_particulars_dialog);

        dissmess = (TextView) findViewById(R.id.integer_particulars_diessmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //替换
                dismiss();
            }
        });

    }
}
