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

public class ExtractSecondEoarbDialog extends Dialog implements View.OnClickListener {
    public ExtractSecondEoarbDialog(Context context) {
        super(context);
    }

    public ExtractSecondEoarbDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView principal , interest , dissmess;
    private BaseFragment baseFragment;
    private boolean state = false;

    public ExtractSecondEoarbDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extract_second_eoarb_dialog);

        principal = (TextView) findViewById(R.id.extract_second_eoarb_dialog_principal);
        interest = (TextView) findViewById(R.id.extract_second_eoarb_dialog_interest);
        dissmess = (TextView) findViewById(R.id.extract_second_eoarb_dialog_false);

        principal.setOnClickListener(this);
        interest.setOnClickListener(this);
        dissmess.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.extract_second_eoarb_dialog_principal:

                //本金
                principal.setBackgroundResource(R.drawable.extract_second_eoarb_dialog_textview_shape);
                interest.setBackgroundResource(R.drawable.pryment_adency_fragment_government_edittext_shape);

                state = false;
                break;
            case R.id.extract_second_eoarb_dialog_interest:
                //利息
                principal.setBackgroundResource(R.drawable.pryment_adency_fragment_government_edittext_shape);
                interest.setBackgroundResource(R.drawable.extract_second_eoarb_dialog_textview_shape);

                state = true;
                break;
            case R.id.extract_second_eoarb_dialog_false:
                //确认
                if (state){
                    //利息
                }else {
                    dismiss();
                    //本金
                    ExtractSecondEoarbPrincipalDialog extractSecondEoarbPrincipalDialog =
                            new ExtractSecondEoarbPrincipalDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive  , baseFragment);
                    extractSecondEoarbPrincipalDialog.show();
                }
                break;
        }
    }
}
