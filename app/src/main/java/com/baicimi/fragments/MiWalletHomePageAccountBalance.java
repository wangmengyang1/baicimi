package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.MiWalletRecordAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MiWalletRecordEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 * 个人中心   资产中心  幂钱包   我的账户余额
 */
public class MiWalletHomePageAccountBalance extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<MiWalletRecordEntry> list = new ArrayList<>();
    private MiWalletRecordAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_homepage_account_balance , container , false);

        back = (ImageView) view.findViewById(R.id.mi_wallet_homepage_account_balance_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();


        return view;
    }

    @Override
    protected void initData() {

    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.mi_wallet_homepage_account_balance_liatview);
        list.clear();
        list.add(new MiWalletRecordEntry("2017.03.06", "13965468432 广东移动30元手机话费充值，自动充值" , "政府采购" , "+100.00"));
        list.add(new MiWalletRecordEntry("2017.03.06", "13965468432 广东移动30元手机话费充值，自动充值" , "政府采购" , "+100.00"));
        list.add(new MiWalletRecordEntry("2017.03.06", "13965468432 广东移动30元手机话费充值，自动充值" , "政府采购" , "+100.00"));
        list.add(new MiWalletRecordEntry("2017.03.06", "13965468432 广东移动30元手机话费充值，自动充值" , "政府采购" , "+100.00"));
        list.add(new MiWalletRecordEntry("2017.03.06", "13965468432 广东移动30元手机话费充值，自动充值" , "政府采购" , "+100.00"));
        list.add(new MiWalletRecordEntry("2017.03.06", "13965468432 广东移动30元手机话费充值，自动充值" , "政府采购" , "+100.00"));
        adapter = new MiWalletRecordAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MiWalletRecordAdapter listAdapter = (MiWalletRecordAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 12;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+40);
        listView.setLayoutParams(params);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_homepage_account_balance_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
