package com.baicimi.fragments;

import android.graphics.Color;
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
 * Created by Administrator on 2018/1/8.
 * 个人中心首页 手机充值
 */
public class PhoneTopUpFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 7;

    private PhoneTopUpFragmentPhone phoneTopUpFragmentPhone;//充话费
    private PhoneTopUpFragmentFlow phoneTopUpFragmentFlow;//充流量


    private TextView phoneTv;
    private TextView flowTv;
    private View phoneView , flowView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.phone_top_up_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.phone_top_up_fragment_back);
        back.setOnClickListener(this);


        //fragment切换

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);

        phoneTv = (TextView) view.findViewById(R.id.phone_top_up_fragment_phone_textview);
        flowTv = (TextView) view.findViewById(R.id.phone_top_up_fragment_flow_textview);
        phoneView = view.findViewById(R.id.phone_top_up_fragment_phone_view);
        flowView = view.findViewById(R.id.phone_top_up_fragment_flow_view);
        phoneTv.setOnClickListener(this);
        flowTv.setOnClickListener(this);

        return view;
    }


    private void initShowView(){
        phoneTv.setTextColor(Color.parseColor("#010101"));
        flowTv.setTextColor(Color.parseColor("#010101"));
        phoneView.setBackgroundColor(Color.parseColor("#ffffff"));
        flowView.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(phoneTopUpFragmentPhone = new PhoneTopUpFragmentPhone());
        listFragment.add(phoneTopUpFragmentFlow = new PhoneTopUpFragmentFlow());
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
                transaction.add(R.id.phone_top_up_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.phone_top_up_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phone_top_up_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.phone_top_up_fragment_phone_textview:
                initShowView();
                phoneTv.setTextColor(Color.parseColor("#ff0000"));
                phoneView.setBackgroundColor(Color.parseColor("#ff0000"));
                initShowFragment(0);
                break;
            case R.id.phone_top_up_fragment_flow_textview:
                initShowView();
                flowTv.setTextColor(Color.parseColor("#ff0000"));
                flowView.setBackgroundColor(Color.parseColor("#ff0000"));
                initShowFragment(1);
                break;
        }
    }
}
