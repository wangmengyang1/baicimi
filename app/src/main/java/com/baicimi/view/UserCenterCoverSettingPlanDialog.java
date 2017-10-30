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

public class UserCenterCoverSettingPlanDialog extends Dialog {
    public UserCenterCoverSettingPlanDialog(Context context) {
        super(context);
    }

    public UserCenterCoverSettingPlanDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess;
    private BaseFragment baseFragment;

    public UserCenterCoverSettingPlanDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_center_cover_setting_plan_dialog);

        dissmess = (TextView) findViewById(R.id.user_center_cover_setting_plan_dialog_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                CoverSettingFirstReplaceDialog coverSettingFirstReplaceDialog = new CoverSettingFirstReplaceDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                coverSettingFirstReplaceDialog.show();

            }
        });

    }
}
