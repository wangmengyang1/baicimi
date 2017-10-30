package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/19.
 *
 */

public class EveryDayConversionDialog extends Dialog {
    public EveryDayConversionDialog(Context context) {
        super(context);
    }

    public EveryDayConversionDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess;
    private BaseFragment baseFragment;

    private NumberPicker numberPickerMonth;

    public EveryDayConversionDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.every_day_conversion_dialog);
        dissmess = (TextView) findViewById(R.id.every_day_conversion_dialog_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
//        numberPickerMonth = (NumberPicker) findViewById(R.id.date_time_fragment_month);
//        numberPickerMonth.setMaxValue(12);
//        numberPickerMonth.setMinValue(1);
//        numberPickerMonth.setValue(10);
    }
}
