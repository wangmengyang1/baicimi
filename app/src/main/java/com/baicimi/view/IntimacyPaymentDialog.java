package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.fragments.IntimacyPaymentDredgeSucceedFragment;
import com.baicimi.fragments.IntimacyPaymentHomePageFragment;
import com.baicimi.fragments.IntimacyPaymentUserMessageFragment;

/**
 * Created by Administrator on 2017/8/16.
 * 亲密付自定义弹出对话框
 */

public class IntimacyPaymentDialog extends Dialog implements View.OnClickListener {

    private Context context;

    private TextView consent;
    private TextView more;
    private IntimacyPaymentHomePageFragment intimacyPaymentHomePageFragment;

    public IntimacyPaymentDialog(Context context) {
        super(context);
        this.context = context;
    }

    public IntimacyPaymentDialog(Context context, int themeResId , BaseFragment baseFragment) {
        super(context, themeResId);
        this.context = context;
//        this.intimacyPaymentHomePageFragment = intimacyPaymentHomePageFragment;
        intimacyPaymentHomePageFragment = (IntimacyPaymentHomePageFragment) baseFragment;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intimacy_payment_dialog_view_fragment);
        consent = (TextView) findViewById(R.id.intimacy_payment_dialog_view_fragment_consent);
        more = (TextView) findViewById(R.id.intimacy_payment_dialog_view_fragment_more);

        consent.setOnClickListener(this);
        more.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.intimacy_payment_dialog_view_fragment_consent:
                dismiss();
                break;
            case R.id.intimacy_payment_dialog_view_fragment_more:

                if(intimacyPaymentHomePageFragment != null){
                    intimacyPaymentHomePageFragment.startFragment(new IntimacyPaymentUserMessageFragment());
                }
                dismiss();
                break;
        }
    }
}
