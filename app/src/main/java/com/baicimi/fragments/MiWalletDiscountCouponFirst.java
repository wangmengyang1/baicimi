package com.baicimi.fragments;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 * 个人中心  首页  资产中心  幂钱包  我的卡券  首页
 */
@SuppressLint("ValidFragment")
public class MiWalletDiscountCouponFirst extends BaseFragment implements View.OnClickListener {

    private View view;
    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 3;


    private MiWalletDiscountCouponFirstItemFirst miwalldtDisFirst;//团购
    private MiWalletDiscountCouponFirstItemSecond miwalldtDisSecond;//限量优惠券
    private MiWalletDiscountCouponFirstItemThread miwalldtDisThread;//政府采购
    private MiWalletDiscountCouponFirstItemFour miwalldtDisFour;//已过期

    private TextView use , pastdue , lible;

    private String libleString = "";

    @SuppressLint("ValidFragment")
    public MiWalletDiscountCouponFirst(String libleString) {
        this.libleString = libleString;
    }

    private ImageView back;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_walldt_discunt_cunpon_first , container , false);

        fm = getChildFragmentManager();

        lible = (TextView) view.findViewById(R.id.mi_wallet_discunt_cunpon_first_lible);
        lible.setText(libleString);
        if (libleString.equals("团购优惠券")){
            init(0);
        }else if (libleString.equals("限量优惠券")){
            init(1);
        }else if (libleString.equals("政府采购优惠券")){
            init(2);
        }


        initShowFragment(0);

        use = (TextView) view.findViewById(R.id.mi_wallde_discunt_cunpon_first_use);
        pastdue = (TextView) view.findViewById(R.id.mi_wallde_discunt_cunpon_first_pastdue);
        use.setOnClickListener(this);
        pastdue.setOnClickListener(this);

        back = (ImageView) view.findViewById(R.id.mi_wallet_discunt_cunpon_first_back);
        back.setOnClickListener(this);

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
                transaction.add(R.id.mi_wallde_discunt_cunpon_first_framglayout , listFragment.get(i) , tag);
                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.mi_wallde_discunt_cunpon_first_framglayout , listFragment.get(i) , tag);
                index = i;
            }

        }
        transaction.commit();
    }

    //数据填充
    private void init(int count) {
        listFragment.clear();
        if (count == 0){
            listFragment.add(miwalldtDisFirst = new MiWalletDiscountCouponFirstItemFirst());
            listFragment.add(miwalldtDisFour = new MiWalletDiscountCouponFirstItemFour());
        }else if (count == 1){
            listFragment.add(miwalldtDisSecond = new MiWalletDiscountCouponFirstItemSecond());
            listFragment.add(miwalldtDisFour = new MiWalletDiscountCouponFirstItemFour());
        }else if (count == 2){
            listFragment.add(miwalldtDisThread = new MiWalletDiscountCouponFirstItemThread());
            listFragment.add(miwalldtDisFour = new MiWalletDiscountCouponFirstItemFour());
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallde_discunt_cunpon_first_use:
                initShowFragment(0);
                break;
            case R.id.mi_wallde_discunt_cunpon_first_pastdue:
                initShowFragment(1);
                break;
            case R.id.mi_wallet_discunt_cunpon_first_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
