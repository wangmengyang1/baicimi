package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.PhoneTopUpFragmentPhoneAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PhoneTopUpFragmentPhoneEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/8.
 *  个人中心首页 手机充值 充话费
 */
public class PhoneTopUpFragmentPhone extends BaseFragment implements View.OnClickListener {

    private View view;
    private GridView gridView;
    private List<PhoneTopUpFragmentPhoneEntry> list = new ArrayList<>();
    private PhoneTopUpFragmentPhoneAdapter adapter;

    private TextView record;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.phone_topup_fragment_phone , container , false);

        //GridView布局填充
        initGridView();

        record = (TextView) view.findViewById(R.id.phone_tupup_fragment_phone_mytupuprecord);
        record.setOnClickListener(this);
        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.phone_topup_fragment_phone_gridview);
        list.clear();
        list.add(new PhoneTopUpFragmentPhoneEntry("10元" , "售价：9.98元" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("20元" , "售价：16.96元" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("30元" , "售价：29.94元" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("50元" , "售价：49.90元" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("100元" , "售价：99.80元" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("200元" , "售价：199.60元" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("300元" , "售价：299.40元" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("500元" , "售价：499.00元" , true));
        adapter = new PhoneTopUpFragmentPhoneAdapter(list , getContext());
        gridView.setAdapter(adapter);
        fixGrdiViewHeight03(gridView);

    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        PhoneTopUpFragmentPhoneAdapter listAdapter = (PhoneTopUpFragmentPhoneAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount() / 3)+1; index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 16;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phone_tupup_fragment_phone_mytupuprecord:
                //手机充值账单
                startFragment(new PhoneTopUpBillFragment());
                break;
        }
    }
}
