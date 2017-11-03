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

public class PresentSaveFirstExamineAddressDialog extends Dialog {
    public PresentSaveFirstExamineAddressDialog(Context context) {
        super(context);
    }

    public PresentSaveFirstExamineAddressDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public PresentSaveFirstExamineAddressDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present_save_first_examine_address_dialog);
        deny = (TextView) findViewById(R.id.present_save_first_examine_address_dialog_false);//确定
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                
            }
        });

    }
}
