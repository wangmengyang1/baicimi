package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.OrderGoodsNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class ShortcutOrderGoodsDistrict extends BaseFragment implements View.OnClickListener{

    private View view;

    private TableLayout tableLayout_01 , tableLayout_02 , tableLayout_03;
    private ImageView shrink_01 , shrink_02 , shrink_03;
    private boolean shrinkBoolean_01  = true, shrinkBoolean_02 = true ,shrinkBoolean_03  = true;
    private ImageView subtract_01 , subtract_02 ,subtract_03 ,subtract_04,subtract_05 ,subtract_06 ,subtract_07 ,subtract_08 ,
            subtract_09 ,subtract_10 ,subtract_11 ,subtract_12 ,subtract_13 ,subtract_14 ,subtract_15 ,subtract_16 ,
            subtract_17 ,subtract_18 ;
    private TextView number_01 , number_02 , number_03 , number_04 , number_05 , number_06 , number_07 , number_08 , number_09 ,
            number_10 , number_11 , number_12 , number_13 , number_14 , number_15 , number_16 , number_17 , number_18 ;
    private ImageView add_01 , add_02 ,add_03 ,add_04 ,add_05 ,add_06 ,add_07 ,add_08 ,add_09 ,add_10 ,add_11 ,add_12 ,
            add_13 ,add_14 ,add_15 ,add_16 ,add_17 ,add_18 ;

    private List<OrderGoodsNumber> list = new ArrayList<>();

    private TextView nameHome , name_01 , name_02 ,name_03 ,name_04 ,name_05 ,name_06 ,name_07 ,name_08 ,name_09,name_10 ,name_11 ,
            name_12 ,name_13 ,name_14 ,name_15 ,name_16 ,name_17 ,name_18 ;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.shortcut_order_goods_district , container , false);


        //伸缩
        initShrink();
        //添加订单数
        initNumber();


        return view;
    }

    //添加订单数
    private void initNumber() {
        list.clear();
        for (int i = 0 ; i < 18 ; i++){
            list.add(new OrderGoodsNumber(20));
        }
        subtract_01 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_01);
        number_01 = (TextView) view.findViewById(R.id.tablerow_number_image_01);
        add_01 = (ImageView) view.findViewById(R.id.tablerow_add_image_01);
        subtract_01.setOnClickListener(this);
        add_01.setOnClickListener(this);
        subtract_02 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_02);
        number_02 = (TextView) view.findViewById(R.id.tablerow_number_image_02);
        add_02 = (ImageView) view.findViewById(R.id.tablerow_add_image_02);
        subtract_02.setOnClickListener(this);
        add_02.setOnClickListener(this);
        subtract_03 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_03);
        number_03 = (TextView) view.findViewById(R.id.tablerow_number_image_03);
        add_03 = (ImageView) view.findViewById(R.id.tablerow_add_image_03);
        subtract_03.setOnClickListener(this);
        add_03.setOnClickListener(this);
        subtract_04= (ImageView) view.findViewById(R.id.tablerow_subtract_image_04);
        number_04= (TextView) view.findViewById(R.id.tablerow_number_image_04);
        add_04 = (ImageView) view.findViewById(R.id.tablerow_add_image_04);
        subtract_04.setOnClickListener(this);
        add_04.setOnClickListener(this);
        subtract_05 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_05);
        number_05 = (TextView) view.findViewById(R.id.tablerow_number_image_05);
        add_05 = (ImageView) view.findViewById(R.id.tablerow_add_image_05);
        subtract_05.setOnClickListener(this);
        add_05.setOnClickListener(this);
        subtract_06 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_06);
        number_06 = (TextView) view.findViewById(R.id.tablerow_number_image_06);
        add_06 = (ImageView) view.findViewById(R.id.tablerow_add_image_06);
        subtract_06.setOnClickListener(this);
        add_06.setOnClickListener(this);
        subtract_07 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_07);
        number_07 = (TextView) view.findViewById(R.id.tablerow_number_image_07);
        add_07 = (ImageView) view.findViewById(R.id.tablerow_add_image_07);
        subtract_07.setOnClickListener(this);
        add_07.setOnClickListener(this);
        subtract_08 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_08);
        number_08 = (TextView) view.findViewById(R.id.tablerow_number_image_08);
        add_08 = (ImageView) view.findViewById(R.id.tablerow_add_image_08);
        subtract_08.setOnClickListener(this);
        add_08.setOnClickListener(this);
        subtract_09 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_09);
        number_09 = (TextView) view.findViewById(R.id.tablerow_number_image_09);
        add_09 = (ImageView) view.findViewById(R.id.tablerow_add_image_09);
        subtract_09.setOnClickListener(this);
        add_09.setOnClickListener(this);
        subtract_10 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_10);
        number_10 = (TextView) view.findViewById(R.id.tablerow_number_image_10);
        add_10 = (ImageView) view.findViewById(R.id.tablerow_add_image_10);
        subtract_10.setOnClickListener(this);
        add_10.setOnClickListener(this);
        subtract_11 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_11);
        number_11 = (TextView) view.findViewById(R.id.tablerow_number_image_11);
        add_11 = (ImageView) view.findViewById(R.id.tablerow_add_image_11);
        subtract_11.setOnClickListener(this);
        add_11.setOnClickListener(this);
        subtract_12 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_12);
        number_12 = (TextView) view.findViewById(R.id.tablerow_number_image_12);
        add_12 = (ImageView) view.findViewById(R.id.tablerow_add_image_12);
        subtract_12.setOnClickListener(this);
        add_12.setOnClickListener(this);
        subtract_13 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_13);
        number_13 = (TextView) view.findViewById(R.id.tablerow_number_image_13);
        add_13 = (ImageView) view.findViewById(R.id.tablerow_add_image_13);
        subtract_13.setOnClickListener(this);
        add_13.setOnClickListener(this);
        subtract_14 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_14);
        number_14 = (TextView) view.findViewById(R.id.tablerow_number_image_14);
        add_14 = (ImageView) view.findViewById(R.id.tablerow_add_image_14);
        subtract_14.setOnClickListener(this);
        add_14.setOnClickListener(this);
        subtract_15 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_15);
        number_15 = (TextView) view.findViewById(R.id.tablerow_number_image_15);
        add_15 = (ImageView) view.findViewById(R.id.tablerow_add_image_15);
        subtract_15.setOnClickListener(this);
        add_15.setOnClickListener(this);
        subtract_16 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_16);
        number_16 = (TextView) view.findViewById(R.id.tablerow_number_image_16);
        add_16 = (ImageView) view.findViewById(R.id.tablerow_add_image_16);
        subtract_16.setOnClickListener(this);
        add_16.setOnClickListener(this);
        subtract_17 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_17);
        number_17 = (TextView) view.findViewById(R.id.tablerow_number_image_17);
        add_17 = (ImageView) view.findViewById(R.id.tablerow_add_image_17);
        subtract_17.setOnClickListener(this);
        add_17.setOnClickListener(this);
        subtract_18 = (ImageView) view.findViewById(R.id.tablerow_subtract_image_18);
        number_18 = (TextView) view.findViewById(R.id.tablerow_number_image_18);
        add_18 = (ImageView) view.findViewById(R.id.tablerow_add_image_18);
        subtract_18.setOnClickListener(this);
        add_18.setOnClickListener(this);


        nameHome = (TextView) view.findViewById(R.id.activity_product_name);
        name_01 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_02 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_03 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_04 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_05 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_06 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_07 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_08 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_09 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_10 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_11 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_12 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_13 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_14 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_15 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_16 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_17 = (TextView) view.findViewById(R.id.activity_product_name_01);
        name_18 = (TextView) view.findViewById(R.id.activity_product_name_01);
//        setWidthTV();

    }

    private void setWidthTV(){
        setLayoutParams(nameHome);
        setLayoutParams(name_01);
        setLayoutParams(name_02);
        setLayoutParams(name_03);
        setLayoutParams(name_04);
        setLayoutParams(name_05);
        setLayoutParams(name_06);
        setLayoutParams(name_07);
        setLayoutParams(name_08);
        setLayoutParams(name_09);
        setLayoutParams(name_10);
        setLayoutParams(name_11);
        setLayoutParams(name_12);
        setLayoutParams(name_13);
        setLayoutParams(name_14);
        setLayoutParams(name_15);
        setLayoutParams(name_16);
        setLayoutParams(name_17);
        setLayoutParams(name_18);


    };

    private void setLayoutParams(View view){
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = 15;

        view.setLayoutParams(layoutParams);
    }



    //伸缩
    private void initShrink() {
        tableLayout_03 = (TableLayout) view.findViewById(R.id.activity_main_tablelayout_03);
        tableLayout_02 = (TableLayout) view.findViewById(R.id.activity_main_tablelayout_02);
        tableLayout_01 = (TableLayout) view.findViewById(R.id.activity_main_tablelayout_01);
//        tableLayout.setColumnCollapsed(0 , false);//隐藏显示某一列
        shrink_01 = (ImageView) view.findViewById(R.id.activity_shrink_01);
        shrink_01.setOnClickListener(this);
        shrink_02 = (ImageView) view.findViewById(R.id.activity_shrink_02);
        shrink_02.setOnClickListener(this);
        shrink_03 = (ImageView) view.findViewById(R.id.activity_shrink_03);
        shrink_03.setOnClickListener(this);

    }


    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_shrink_01:
                if(shrinkBoolean_01){
                    shrink_01.setImageResource(R.drawable.toleft_image_blue_32);
                    tableLayout_01.setVisibility(View.VISIBLE);
                    tableLayout_03.setColumnCollapsed(1 , false);

                }else{
                    shrink_01.setImageResource(R.drawable.toright_image_blue_32);
                    tableLayout_01.setVisibility(View.GONE);
                    tableLayout_03.setColumnCollapsed(1 , true);
                }
                shrinkBoolean_01 = !shrinkBoolean_01;
                break;
            case R.id.activity_shrink_02:
                if(shrinkBoolean_02){
                    shrink_02.setImageResource(R.drawable.toleft_image_blue_32);
                    tableLayout_03.setColumnCollapsed(4 , false);
                    tableLayout_03.setColumnCollapsed(3 , false);
                }else{
                    shrink_02.setImageResource(R.drawable.toright_image_blue_32);
                    tableLayout_03.setColumnCollapsed(4 , true);
                    tableLayout_03.setColumnCollapsed(3 , true);
                }
                shrinkBoolean_02 = !shrinkBoolean_02;
                break;
            case R.id.activity_shrink_03:
                if(shrinkBoolean_03){
                    shrink_03.setImageResource(R.drawable.toleft_image_blue_32);
                    tableLayout_03.setColumnCollapsed(8 , false);
                }else{
                    shrink_03.setImageResource(R.drawable.toright_image_blue_32);
                    tableLayout_03.setColumnCollapsed(8 , true);
                }
                shrinkBoolean_03 = !shrinkBoolean_03;
                break;
            case R.id.tablerow_subtract_image_01:
                list.get(0).setNumber(list.get(0).getNumber()-1);
                number_01.setText(list.get(0).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_02:
                list.get(1).setNumber(list.get(1).getNumber()-1);
                number_02.setText(list.get(1).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_03:
                list.get(2).setNumber(list.get(2).getNumber()-1);
                number_03.setText(list.get(2).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_04:
                list.get(3).setNumber(list.get(3).getNumber()-1);
                number_04.setText(list.get(3).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_05:
                list.get(4).setNumber(list.get(4).getNumber()-1);
                number_05.setText(list.get(4).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_06:
                list.get(5).setNumber(list.get(5).getNumber()-1);
                number_06.setText(list.get(5).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_07:
                list.get(6).setNumber(list.get(6).getNumber()-1);
                number_07.setText(list.get(6).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_08:
                list.get(7).setNumber(list.get(7).getNumber()-1);
                number_08.setText(list.get(7).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_09:
                list.get(8).setNumber(list.get(8).getNumber()-1);
                number_09.setText(list.get(8).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_10:
                list.get(9).setNumber(list.get(9).getNumber()-1);
                number_10.setText(list.get(9).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_11:
                list.get(10).setNumber(list.get(10).getNumber()-1);
                number_11.setText(list.get(10).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_12:
                list.get(11).setNumber(list.get(11).getNumber()-1);
                number_12.setText(list.get(11).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_13:
                list.get(12).setNumber(list.get(12).getNumber()-1);
                number_13.setText(list.get(12).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_14:
                list.get(13).setNumber(list.get(13).getNumber()-1);
                number_14.setText(list.get(13).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_15:
                list.get(14).setNumber(list.get(14).getNumber()-1);
                number_15.setText(list.get(14).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_16:
                list.get(15).setNumber(list.get(15).getNumber()-1);
                number_16.setText(list.get(15).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_17:
                list.get(16).setNumber(list.get(16).getNumber()-1);
                number_17.setText(list.get(16).getNumber() + "");
                break;
            case R.id.tablerow_subtract_image_18:
                list.get(17).setNumber(list.get(17).getNumber()-1);
                number_18.setText(list.get(17).getNumber() + "");
                break;
            case R.id.tablerow_add_image_01:
                list.get(0).setNumber(list.get(0).getNumber()+1);
                number_01.setText(list.get(0).getNumber() + "");
                break;
            case R.id.tablerow_add_image_02:
                list.get(1).setNumber(list.get(1).getNumber()+1);
                number_02.setText(list.get(1).getNumber() + "");
                break;
            case R.id.tablerow_add_image_03:
                list.get(2).setNumber(list.get(2).getNumber()+1);
                number_03.setText(list.get(2).getNumber() + "");
                break;
            case R.id.tablerow_add_image_04:
                list.get(3).setNumber(list.get(3).getNumber()+1);
                number_04.setText(list.get(3).getNumber() + "");
                break;
            case R.id.tablerow_add_image_05:
                list.get(4).setNumber(list.get(4).getNumber()+1);
                number_05.setText(list.get(4).getNumber() + "");
                break;
            case R.id.tablerow_add_image_06:
                list.get(5).setNumber(list.get(5).getNumber()+1);
                number_06.setText(list.get(5).getNumber() + "");
                break;
            case R.id.tablerow_add_image_07:
                list.get(6).setNumber(list.get(6).getNumber()+1);
                number_07.setText(list.get(6).getNumber() + "");
                break;
            case R.id.tablerow_add_image_08:
                list.get(7).setNumber(list.get(7).getNumber()+1);
                number_08.setText(list.get(7).getNumber() + "");
                break;
            case R.id.tablerow_add_image_09:
                list.get(8).setNumber(list.get(8).getNumber()+1);
                number_09.setText(list.get(8).getNumber() + "");
                break;
            case R.id.tablerow_add_image_10:
                list.get(9).setNumber(list.get(9).getNumber()+1);
                number_10.setText(list.get(9).getNumber() + "");
                break;
            case R.id.tablerow_add_image_11:
                list.get(10).setNumber(list.get(10).getNumber()+1);
                number_11.setText(list.get(10).getNumber() + "");
                break;
            case R.id.tablerow_add_image_12:
                list.get(11).setNumber(list.get(11).getNumber()+1);
                number_12.setText(list.get(11).getNumber() + "");
                break;
            case R.id.tablerow_add_image_13:
                list.get(12).setNumber(list.get(12).getNumber()+1);
                number_13.setText(list.get(12).getNumber() + "");
                break;
            case R.id.tablerow_add_image_14:
                list.get(13).setNumber(list.get(13).getNumber()+1);
                number_14.setText(list.get(13).getNumber() + "");
                break;
            case R.id.tablerow_add_image_15:
                list.get(14).setNumber(list.get(14).getNumber()+1);
                number_15.setText(list.get(14).getNumber() + "");
                break;
            case R.id.tablerow_add_image_16:
                list.get(15).setNumber(list.get(15).getNumber()+1);
                number_16.setText(list.get(15).getNumber() + "");
                break;
            case R.id.tablerow_add_image_17:
                list.get(16).setNumber(list.get(16).getNumber()+1);
                number_17.setText(list.get(16).getNumber() + "");
                break;
            case R.id.tablerow_add_image_18:
                list.get(17).setNumber(list.get(17).getNumber()+1);
                number_18.setText(list.get(17).getNumber() + "");
                break;
        }
    }

}
