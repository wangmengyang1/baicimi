package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/12.
 */

public class BrandFragmentSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout layout_tagnumber;
    private TextView tagNumber;
    private int count = 1234;

    private LinearLayout layout_attention;
    private TextView textview_attention;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.brand_fragment_second , container , false);
        back = (ImageView) view.findViewById(R.id.brand_fragment_second_back);
        back.setOnClickListener(this);

        //标价点击数据改变以及添加关注
        initTagNumber();
        return view;
    }

    //标价点击数据改变
    private void initTagNumber() {
        layout_tagnumber = (LinearLayout) view.findViewById(R.id.brand_fragment_second_layout_tagnumber);
        tagNumber = (TextView) view.findViewById(R.id.brand_fragment_second_textview_tagnumber);
        layout_tagnumber.setOnClickListener(this);
        layout_attention = (LinearLayout) view.findViewById(R.id.brang_frgment_second_layout_attention);
        textview_attention = (TextView) view.findViewById(R.id.brang_frgment_second_textview_attention);
        layout_attention.setOnClickListener(this);
        textview_attention.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.brand_fragment_second_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.brand_fragment_second_layout_tagnumber:
                tagNumber.setText((count++) + "");
                break;
            case R.id.brang_frgment_second_layout_attention:
                layout_attention.setVisibility(View.INVISIBLE);
                textview_attention.setVisibility(View.VISIBLE);
                break;
            case R.id.brang_frgment_second_textview_attention:
                layout_attention.setVisibility(View.VISIBLE);
                textview_attention.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
