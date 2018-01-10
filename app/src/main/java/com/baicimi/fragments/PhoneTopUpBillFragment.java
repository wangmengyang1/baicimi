package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.PhoneTopUpBillAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PhoneTopUpBillEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 *  个人中心首页 手机充值 充话费 手机充值账单、
 *
 */
public class PhoneTopUpBillFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listViewFirst , listViewSecond , listViewThread;
    private List<PhoneTopUpBillEntry> listFirst , listSecond , listThread;
    private PhoneTopUpBillAdapter adapterFirst , adapterSecond , adapterThread;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.phone_topup_bill_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.phone_topup_bill_fragment_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListViewFirst();
        initListViewSecond();
        initListViewThread();

        return view;
    }

    private void initListViewThread() {
        listViewThread = (ListView) view.findViewById(R.id.phone_topup_bill_fragment_listview_thread);
        listThread = new ArrayList<>();
        listThread.add(new PhoneTopUpBillEntry("周四" + "\n" + "07-25" , R.drawable.phone_topup_image_09 , "-49.90",
                "充值50元-13682273001"));
        adapterThread = new PhoneTopUpBillAdapter(listThread , getContext());
        listViewThread.setAdapter(adapterThread);
    }

    private void initListViewSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.phone_topup_bill_fragment_listview_second);
        listSecond = new ArrayList<>();
        listSecond.add(new PhoneTopUpBillEntry("周日" + "\n" + "07-25" , R.drawable.phone_topup_image_08 , "-3.75",
                "广东移动流量充值30M全国流量包  移动-13682273001"));
        listSecond.add(new PhoneTopUpBillEntry("周二" + "\n" + "07-25" , R.drawable.phone_topup_image_08 , "-9.50",
                "广东移动流量充值30M全国流量包  移动-13682273001"));
        listSecond.add(new PhoneTopUpBillEntry("周er" + "\n" + "07-25" , R.drawable.phone_topup_image_09 , "-10.00",
                "充值10元-13682273001"));
        adapterSecond = new PhoneTopUpBillAdapter(listSecond , getContext());
        listViewSecond.setAdapter(adapterSecond);
        fixGrdiViewHeight03(listViewSecond);
    }

    //listview布局填充
    private void initListViewFirst() {
        listViewFirst = (ListView) view.findViewById(R.id.phone_topup_bill_fragment_listview_first);
        listFirst = new ArrayList<>();
        listFirst.add(new PhoneTopUpBillEntry("周一" + "\n" + "07-25" , R.drawable.phone_topup_image_09 , "-49.90",
                "充值50元-13682273001"));
        adapterFirst = new PhoneTopUpBillAdapter(listFirst , getContext());
        listViewFirst.setAdapter(adapterFirst);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        PhoneTopUpBillAdapter listAdapter = (PhoneTopUpBillAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount() ); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
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
            case R.id.phone_topup_bill_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
