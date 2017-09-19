package com.baicimi.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.fragments.MainFragment;

/**
 * Created by Administrator on 2017/8/21.
 */

public class EnterpriseUplogingDialog extends Dialog implements View.OnClickListener {


    private ImageView back;
    private TextView back_homePage;
    private BaseFragment fragment;

    public EnterpriseUplogingDialog(Context context) {
        super(context);
    }

    public EnterpriseUplogingDialog(Context context, int themeResId , BaseFragment fragment) {
        super(context, themeResId);
        this.fragment = fragment;
    }

    protected EnterpriseUplogingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterprise_eploging_dialog_item);

        back = (ImageView) findViewById(R.id.enterprise_eploging_dialog_dissmiss);
        back.setOnClickListener(this);
        back_homePage = (TextView) findViewById(R.id.enterprise_uploging_dialog_item_back_homepage);
        back_homePage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.enterprise_eploging_dialog_dissmiss:
                dismiss();
                break;
            case R.id.enterprise_uploging_dialog_item_back_homepage:
                dismiss();
                fragment.getActivity().getSupportFragmentManager().popBackStack(null , 1);
                fragment.startFragment(new MainFragment());
                break;
        }
    }
}
