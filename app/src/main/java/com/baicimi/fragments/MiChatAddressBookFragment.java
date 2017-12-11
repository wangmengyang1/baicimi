package com.baicimi.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 通讯录
 */
public class MiChatAddressBookFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView myFriends , myFans;


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 6;

    private MiChatAddressBookMyFriends miChatAddressBookMyFriends;//我的粉丝
    private MiChatAddressBookMyFans miChatAddressBookMyFans;//我的朋友


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_chat_address_book_fragment , container , false);

        myFriends = (TextView) view.findViewById(R.id.michat_address_book_fragment_myfriends);
        myFans = (TextView) view.findViewById(R.id.michat_address_book_fragment_myfans);

        myFriends.setOnClickListener(this);
        myFans.setOnClickListener(this);

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);


        return view;
    }


    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(miChatAddressBookMyFriends = new MiChatAddressBookMyFriends());
        listFragment.add(miChatAddressBookMyFans = new MiChatAddressBookMyFans());
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
                transaction.add(R.id.mi_chat_address_book_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.mi_chat_address_book_fragment_framelayout , listFragment.get(i) , tag);

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
            case R.id.michat_address_book_fragment_myfriends:
                initShowFragment(0);
                break;
            case R.id.michat_address_book_fragment_myfans:
                initShowFragment(1);
                break;
        }
    }
}
