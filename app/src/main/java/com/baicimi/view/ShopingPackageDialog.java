package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.ShopingPackageMessage;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/9/14.
 */

public class ShopingPackageDialog extends Dialog implements View.OnClickListener {

    private TextView confirm;
    private LinearLayout layout_01 , layout_02 ,layout_03 ,layout_04 ,layout_05 ,layout_06 ;
    private CheckBox select_01 , select_02 ,select_03 ,select_04 ,select_05 ,select_06 ;
    private CheckBox yellow , red , black , huase , blacked , danyellow;

    private ShopingPackageMessage shopingPackageMessage;


    public ShopingPackageDialog(Context context) {
        super(context);
    }

    public ShopingPackageDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_details_choose_dialog);
        confirm = (TextView) findViewById(R.id.goods_details_choose_dialog_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new ShopingPackageMessage(1));
                dismiss();
            }
        });

        //款式大小选择
        initCheckBodSelect();
    }
    //款式大小选择
    private void initCheckBodSelect() {
        layout_01 = (LinearLayout) findViewById(R.id.goods_details_choose_dialog_layout_01);
        layout_02 = (LinearLayout) findViewById(R.id.goods_details_choose_dialog_layout_02);
        layout_03 = (LinearLayout) findViewById(R.id.goods_details_choose_dialog_layout_03);
        layout_04 = (LinearLayout) findViewById(R.id.goods_details_choose_dialog_layout_04);
        layout_05 = (LinearLayout) findViewById(R.id.goods_details_choose_dialog_layout_05);
        layout_06 = (LinearLayout) findViewById(R.id.goods_details_choose_dialog_layout_06);

        select_01 = (CheckBox) findViewById(R.id.goods_xxl);
        select_02 = (CheckBox) findViewById(R.id.goods_xl);
        select_03 = (CheckBox) findViewById(R.id.goods_l);
        select_04 = (CheckBox) findViewById(R.id.goods_m);
        select_05 = (CheckBox) findViewById(R.id.goods_s);
        select_06 = (CheckBox) findViewById(R.id.goods_xs);

        select_01.setOnClickListener(this);
        select_02.setOnClickListener(this);
        select_03.setOnClickListener(this);
        select_04.setOnClickListener(this);
        select_05.setOnClickListener(this);
        select_06.setOnClickListener(this);

        layout_01.setOnClickListener(this);
        layout_02.setOnClickListener(this);
        layout_03.setOnClickListener(this);
        layout_04.setOnClickListener(this);
        layout_05.setOnClickListener(this);
        layout_06.setOnClickListener(this);

        yellow = (CheckBox) findViewById(R.id.goods_yellow);
        red = (CheckBox) findViewById(R.id.goods_red);
        black = (CheckBox) findViewById(R.id.goods_black);
        huase = (CheckBox) findViewById(R.id.goods_huase);
        blacked = (CheckBox) findViewById(R.id.goods_blacked);
        danyellow = (CheckBox) findViewById(R.id.goods_danyellow);
        yellow.setOnClickListener(this);
        red.setOnClickListener(this);
        black.setOnClickListener(this);
        huase.setOnClickListener(this);
        blacked.setOnClickListener(this);
        danyellow.setOnClickListener(this);

    }

    //初始化所有checkbox(规格)
    private void initCheckBox(){
        select_01.setChecked(false);
        select_02.setChecked(false);
        select_03.setChecked(false);
        select_04.setChecked(false);
        select_05.setChecked(false);
        select_06.setChecked(false);
    }
    //初始化所有checkbox(颜色)
    private void initCheckBoxColor(){
        yellow.setChecked(false);
        red.setChecked(false);
        black.setChecked(false);
        huase.setChecked(false);
        blacked.setChecked(false);
        danyellow.setChecked(false);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.goods_details_choose_dialog_layout_01:
                initCheckBox();
                select_01.setChecked(true);
                break;
            case R.id.goods_details_choose_dialog_layout_02:
                initCheckBox();
                select_02.setChecked(true);
                break;
            case R.id.goods_details_choose_dialog_layout_03:
                initCheckBox();
                select_03.setChecked(true);
                break;
            case R.id.goods_details_choose_dialog_layout_04:
                initCheckBox();
                select_04.setChecked(true);
                break;
            case R.id.goods_details_choose_dialog_layout_05:
                initCheckBox();
                select_05.setChecked(true);
                break;
            case R.id.goods_details_choose_dialog_layout_06:
                initCheckBox();
                select_06.setChecked(true);
                break;
            case R.id.goods_xxl:
                initCheckBox();
                select_01.setChecked(true);
                break;
            case R.id.goods_xl:
                initCheckBox();
                select_02.setChecked(true);
                break;
            case R.id.goods_l:
                initCheckBox();
                select_03.setChecked(true);
                break;
            case R.id.goods_m:
                initCheckBox();
                select_04.setChecked(true);
                break;
            case R.id.goods_s:
                initCheckBox();
                select_05.setChecked(true);
                break;
            case R.id.goods_xs:
                initCheckBox();
                select_06.setChecked(true);
                break;
            case R.id.goods_yellow:
                initCheckBoxColor();
                yellow.setChecked(true);
                break;
            case R.id.goods_red:
                initCheckBoxColor();
                red.setChecked(true);
                break;
            case R.id.goods_black:
                initCheckBoxColor();
                black.setChecked(true);
                break;
            case R.id.goods_huase:
                initCheckBoxColor();
                huase.setChecked(true);
                break;
            case R.id.goods_blacked:
                initCheckBoxColor();
                blacked.setChecked(true);
                break;
            case R.id.goods_danyellow:
                initCheckBoxColor();
                danyellow.setChecked(true);
                break;
        }
    }
}
