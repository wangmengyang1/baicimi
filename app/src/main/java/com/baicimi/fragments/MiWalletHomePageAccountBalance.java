package com.baicimi.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
    private TextView lible_01 ,lible_02 ,lible_03 ,lible_04 ;

    private TextView withdrawdeposit;//提现
    private TextView recharge;//充值

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_homepage_account_balance , container , false);

        back = (ImageView) view.findViewById(R.id.mi_wallet_homepage_account_balance_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        lible_01 = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_text_01);
        lible_02 = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_text_02);
        lible_03 = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_text_03);
        lible_04 = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_text_04);

        lible_01.setOnClickListener(this);
        lible_02.setOnClickListener(this);
        lible_03.setOnClickListener(this);
        lible_04.setOnClickListener(this);

        withdrawdeposit = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_withdrawdeposit);
        recharge = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_recharge);

        withdrawdeposit.setOnClickListener(this);
        recharge.setOnClickListener(this);
        return view;
    }


    private void showTitleLible(){
        lible_01.setBackgroundColor(Color.parseColor("#737373"));
        lible_01.setTextColor(Color.WHITE);
        lible_02.setBackgroundColor(Color.parseColor("#737373"));
        lible_02.setTextColor(Color.WHITE);
        lible_03.setBackgroundColor(Color.parseColor("#737373"));
        lible_03.setTextColor(Color.WHITE);
        lible_04.setBackgroundColor(Color.parseColor("#737373"));
        lible_04.setTextColor(Color.WHITE);
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
            case R.id.mi_wallet_homepage_account_balance_text_01:
                showTitleLible();
                lible_01.setBackgroundResource(R.drawable.background_null);
                lible_01.setTextColor(Color.parseColor("#737373"));
                break;
            case R.id.mi_wallet_homepage_account_balance_text_02:
                showTitleLible();
                lible_02.setBackgroundResource(R.drawable.background_null);
                lible_02.setTextColor(Color.parseColor("#737373"));
                break;
            case R.id.mi_wallet_homepage_account_balance_text_03:
                showTitleLible();
                lible_03.setBackgroundResource(R.drawable.background_null);
                lible_03.setTextColor(Color.parseColor("#737373"));
                break;
            case R.id.mi_wallet_homepage_account_balance_text_04:
                showTitleLible();
                lible_04.setBackgroundResource(R.drawable.background_null);
                lible_04.setTextColor(Color.parseColor("#737373"));
                break;
            case R.id.mi_wallet_homepage_account_balance_withdrawdeposit:
                //提现
                startFragment(new MiWalletHomePageAccountBalanceWithdrawdeposit());
                break;
            case R.id.mi_wallet_homepage_account_balance_recharge:
                //充值
                startFragment(new MiWalletHomePageAccountBalanceRecharge());
                break;
        }
    }
}
