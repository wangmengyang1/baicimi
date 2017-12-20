package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/19.
 * 上传回执单添加图片页面
 */

public class LoveDonateSecondDialog extends Dialog {
    public LoveDonateSecondDialog(Context context) {
        super(context);
    }

    public LoveDonateSecondDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess;

    private BaseFragment baseFragment;

    public LoveDonateSecondDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.love_donate_second_popupwindow);

        dissmess = (TextView) findViewById(R.id.love_donate_second_popupwindow_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
//        deny = (TextView) findViewById(R.id.love_donate_popupwindow_dissmess);
//        deny.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });

    }
}
