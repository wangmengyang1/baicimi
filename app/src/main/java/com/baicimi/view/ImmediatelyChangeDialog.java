package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.fragments.ImmediatelyChangeSucceed;

/**
 * Created by Administrator on 2017/9/19.
 * 上传回执单添加图片页面
 */

public class ImmediatelyChangeDialog extends Dialog {
    public ImmediatelyChangeDialog(Context context) {
        super(context);
    }

    public ImmediatelyChangeDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public ImmediatelyChangeDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immediately_change_dialog);

        dissmess = (TextView) findViewById(R.id.immediately_change_dialog_true);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        deny = (TextView) findViewById(R.id.immediately_change_dialog_false);
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                if (baseFragment != null){
                    //兑换失败页面
                    baseFragment.startFragment(new ImmediatelyChangeSucceed());
                }
            }
        });

    }
}
