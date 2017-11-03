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

public class PresentSaveFirstgtoSucceedDialog extends Dialog {
    public PresentSaveFirstgtoSucceedDialog(Context context) {
        super(context);
    }

    public PresentSaveFirstgtoSucceedDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public PresentSaveFirstgtoSucceedDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present_save_first_gro_succeed_dialog);

        dissmess = (TextView) findViewById(R.id.present_save_first_gro_succeed_dialog_false);//知道了
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
//                PresentSaveFirstExaminePostponeDialog presentSaveFirstExaminePostponeDialog = new PresentSaveFirstExaminePostponeDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
//                presentSaveFirstExaminePostponeDialog.show();
            }
        });


    }
}
