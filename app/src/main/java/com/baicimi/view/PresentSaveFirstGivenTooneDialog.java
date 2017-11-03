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

public class PresentSaveFirstGivenTooneDialog extends Dialog {
    public PresentSaveFirstGivenTooneDialog(Context context) {
        super(context);
    }

    public PresentSaveFirstGivenTooneDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public PresentSaveFirstGivenTooneDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present_save_first_given_toone_dialog);
        deny = (TextView) findViewById(R.id.present_save_first_given_toone_dialog_false);//确定
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                PresentSaveFirstgtoSucceedDialog presentSaveFirstgtoSucceedDialog = new PresentSaveFirstgtoSucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                presentSaveFirstgtoSucceedDialog.show();
            }
        });

    }
}
