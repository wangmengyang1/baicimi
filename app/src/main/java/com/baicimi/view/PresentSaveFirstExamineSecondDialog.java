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

public class PresentSaveFirstExamineSecondDialog extends Dialog {
    public PresentSaveFirstExamineSecondDialog(Context context) {
        super(context);
    }

    public PresentSaveFirstExamineSecondDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public PresentSaveFirstExamineSecondDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present_save_first_examine_second_dialog);

        dissmess = (TextView) findViewById(R.id.present_save_first_examine_second_dialog_true);//延长存期
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                PresentSaveFirstExaminePostponeDialog presentSaveFirstExaminePostponeDialog = new PresentSaveFirstExaminePostponeDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                presentSaveFirstExaminePostponeDialog.show();
            }
        });
        deny = (TextView) findViewById(R.id.present_save_first_examine_second_dialog_false);//领取
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                PresentSaveFirstExamineAddressDialog presentSaveFirstExamineAddressDialog = new PresentSaveFirstExamineAddressDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                presentSaveFirstExamineAddressDialog.show();
            }
        });

    }
}
