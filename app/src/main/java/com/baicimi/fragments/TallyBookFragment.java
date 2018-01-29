package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 * 个人中心  我的生活助手  记账本
 */
public class TallyBookFragment extends BaseFragment implements View.OnClickListener {


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 7;

    private TextView datail , statement , account;
    private ImageView back;

    private LinearLayout addCurtain;
    private View view;

    private TallyBookDetailFragment tallyBookDetailFragment;//明细
    private TallyBookStatementFragment tallyBookStatementFragment;//类别报表
    private TallyBookAccountFragment accountFragment;//账户

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tally_book_fragment , container , false);


        //fragment切换

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);


        back = (ImageView) view.findViewById(R.id.tally_book_fragment_back);
        back.setOnClickListener(this);

        datail = (TextView) view.findViewById(R.id.tally_book_fragment_datail);
        statement = (TextView) view.findViewById(R.id.tally_book_fragment_statement);
        account = (TextView) view.findViewById(R.id.tally_book_fragment_account);
        datail.setOnClickListener(this);
        statement.setOnClickListener(this);
        account.setOnClickListener(this);


        addCurtain = (LinearLayout) view.findViewById(R.id.tally_book_fragment_layout);
        addCurtain.setOnClickListener(this);

        return view;
    }


    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(tallyBookDetailFragment = new TallyBookDetailFragment());
        listFragment.add(tallyBookStatementFragment = new TallyBookStatementFragment());
        listFragment.add(accountFragment = new TallyBookAccountFragment());
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
                transaction.add(R.id.tally_book_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.tally_book_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }

    @Override
    protected void initData() {

    }



    private void showTextView(){
        datail.setTextColor(Color.WHITE);
        datail.setBackgroundColor(Color.parseColor("#5b626a"));

        statement.setTextColor(Color.WHITE);
        statement.setBackgroundColor(Color.parseColor("#5b626a"));

        account.setTextColor(Color.WHITE);
        account.setBackgroundColor(Color.parseColor("#5b626a"));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tally_book_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.tally_book_fragment_datail:
                //明细
                showTextView();
                datail.setTextColor(Color.parseColor("#535353"));
                datail.setBackgroundColor(Color.WHITE);
                initShowFragment(0);
                addCurtain.setVisibility(View.VISIBLE);
                break;
            case R.id.tally_book_fragment_statement:
                //类别报表
                showTextView();
                statement.setTextColor(Color.parseColor("#535353"));
                statement.setBackgroundColor(Color.WHITE);
                initShowFragment(1);
                addCurtain.setVisibility(View.GONE);
                break;
            case R.id.tally_book_fragment_account:
                //账户
                showTextView();
                account.setTextColor(Color.parseColor("#535353"));
                account.setBackgroundColor(Color.WHITE);
                initShowFragment(2);
                addCurtain.setVisibility(View.GONE);
                break;
            case R.id.tally_book_fragment_layout:
                //记一笔
                startFragment(new OneForTheBooksFragment());
                break;
        }
    }

}
