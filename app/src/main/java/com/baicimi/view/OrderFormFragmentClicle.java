package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;

/**
 * Created by Administrator on 2017/9/18.
 */

public class OrderFormFragmentClicle extends Dialog implements View.OnClickListener {
    public OrderFormFragmentClicle(Context context) {
        super(context);
    }

    public OrderFormFragmentClicle(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView false_tv , true_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_form_fragment_clicle);

        false_tv = (TextView) findViewById(R.id.order_form_fragment_clicle_false);
        true_tv = (TextView) findViewById(R.id.order_form_fragment_clicle_true);

        false_tv.setOnClickListener(this);
        false_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.order_form_fragment_clicle_false:
                dismiss();
                break;
            case R.id.order_form_fragment_clicle_true:
                dismiss();
                break;
        }
    }
}
