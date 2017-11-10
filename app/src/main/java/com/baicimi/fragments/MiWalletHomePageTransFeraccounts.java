package com.baicimi.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.TransFeraccountsFirstDialog;
import com.baicimi.view.TransFeraccountsSecondDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 * 个人中心首页  资产中心  幂钱包 转账付款
 */
public class MiWalletHomePageTransFeraccounts extends BaseFragment implements View.OnClickListener {

    private View view;
    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 3;

    private TransFeraccountsFirst transFeraccountsFirst;
    private TransFeraccountsSecond transFeraccountsSecond;

    private TextView account , bannkcard;
    private ImageView back;
    private TextView next;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.miwallet_homepage_trans_feraccounts , container , false);

        fm = getChildFragmentManager();
        init();

        initShowFragment(0);

        account = (TextView) view.findViewById(R.id.miwallet_homepage_trans_feracounts_account);
        bannkcard = (TextView) view.findViewById(R.id.miwallet_homepage_trans_feracounts_bannkcard);
        account.setOnClickListener(this);
        bannkcard.setOnClickListener(this);

        back = (ImageView) view.findViewById(R.id.miwallet_homepage_trand_feraccounts_back);
        back.setOnClickListener(this);

        next = (TextView) view.findViewById(R.id.miwallet_homepage_trans_feraccounts_next);
        next.setOnClickListener(this);
        return view;
    }


    //fragment切换
    private void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag();
        FragmentTransaction transaction =  fm.beginTransaction();
        if (fragmentTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));
            index = i;
        }else {
            if (fragmentTag.isEmpty()){
                fragmentTag.add(tag);
                transaction.add(R.id.miwallet_homepage_trans_feraccounts_framelayout , listFragment.get(i) , tag);
                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.miwallet_homepage_trans_feraccounts_framelayout , listFragment.get(i) , tag);
                index = i;
            }

        }
        transaction.commit();
    }

    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(transFeraccountsFirst = new TransFeraccountsFirst());
        listFragment.add(transFeraccountsSecond = new TransFeraccountsSecond());
    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.miwallet_homepage_trand_feraccounts_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.miwallet_homepage_trans_feracounts_account:
                initShowFragment(0);
                break;
            case R.id.miwallet_homepage_trans_feracounts_bannkcard:
                initShowFragment(1);
                break;
            case R.id.miwallet_homepage_trans_feraccounts_next:
                if (index == 0){
                    TransFeraccountsSecondDialog transFeraccountsSecondDialog = new TransFeraccountsSecondDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    transFeraccountsSecondDialog.show();
                }else{
                    TransFeraccountsFirstDialog transFeraccountsFirstDialog = new TransFeraccountsFirstDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    transFeraccountsFirstDialog.show();
                }
                break;
        }
    }
}
