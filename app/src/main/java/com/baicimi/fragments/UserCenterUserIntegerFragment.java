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
 * Created by Administrator on 2017/10/26.
 * 个人中心，会员积分页面
 */
public class UserCenterUserIntegerFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private UserIntegerFragmetInquire inquireFragment;//积分查询
    private UserIntegerFragmentUse userFragment;//使用积分
    private UserIntegerFragmentGather gatherFragment;//收集积分
    private UserIntegerFragmentEarn earnFragment;//赚取积分

    private TextView inquire , user , gather , earn;

    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> listFragmentTag = new ArrayList<>();
    private int index = 5;

    private ImageView back;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_userinteger_fragment , container , false);


        fm = getChildFragmentManager();
        //fragment数据源
        initListAddFragment();
        initShowFragment(0);

        inquire = (TextView) view.findViewById(R.id.usercenter_userinteger_fragment_inquire);
        user = (TextView) view.findViewById(R.id.usercenter_userinteger_fragment_use);
        gather = (TextView) view.findViewById(R.id.usercenter_userinteger_fragment_gather);
        earn = (TextView) view.findViewById(R.id.usercenter_userinteger_fragment_earn);

        inquire.setOnClickListener(this);
        user.setOnClickListener(this);
        gather.setOnClickListener(this);
        earn.setOnClickListener(this);
        back = (ImageView) view.findViewById(R.id.usercenter_userintger_fragment_back);
        back.setOnClickListener(this);

        return view;
    }


    private void initShowTablebar(){
        inquire.setBackgroundColor(Color.WHITE);
        user.setBackgroundColor(Color.WHITE);
        gather.setBackgroundColor(Color.WHITE);
        earn.setBackgroundColor(Color.WHITE);
    }

    //fragment数据源
    private void initListAddFragment() {
        listFragment.clear();
        listFragment.add(inquireFragment = new UserIntegerFragmetInquire());
        listFragment.add(userFragment = new UserIntegerFragmentUse());
        listFragment.add(gatherFragment = new UserIntegerFragmentGather());
        listFragment.add(earnFragment = new UserIntegerFragmentEarn());
    }


    //fragment切换
    private void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag();
        FragmentTransaction transaction =  fm.beginTransaction();
        if (listFragmentTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));
            index = i;
        }else {
            listFragmentTag.add(tag);
            transaction.add(R.id.usercenter_userinteger_fragment_framelayout , listFragment.get(i) , tag);
            index = i;
        }
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_userinteger_fragment_inquire:
                initShowTablebar();
                inquire.setBackgroundColor(Color.parseColor("#eeeeee"));
                initShowFragment(0);
                break;
            case R.id.usercenter_userinteger_fragment_use:
                initShowTablebar();
                initShowFragment(1);
                inquire.setBackgroundColor(Color.parseColor("#eeeeee"));
                break;
            case R.id.usercenter_userinteger_fragment_gather:
                initShowTablebar();
                initShowFragment(2);
                inquire.setBackgroundColor(Color.parseColor("#eeeeee"));
                break;
            case R.id.usercenter_userinteger_fragment_earn:
                initShowTablebar();
                initShowFragment(3);
                inquire.setBackgroundColor(Color.parseColor("#eeeeee"));
                break;
            case R.id.usercenter_userintger_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
