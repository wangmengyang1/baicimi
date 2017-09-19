package com.baicimi.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.MyPagerSlidingTabStrip;
import com.baicimi.ui.PagerSlidingTabStrip;
import com.baicimi.view.MyViewPager;
import com.baicimi.view.MyViewPagerGovernment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/20.
 * 政府采购页面
 */
public class ZhengFuBuyFragment extends BaseFragment{
    private Button btn_zhengfu_tijiao;
    private ViewPager viewPager;
    private PagerSlidingTabStrip tabs;
    private Class[] fragmentClass = {ShenQingCaiGouFragment.class,GovernmentDingDanFragment.class};
    private String[] data = new String[]{"申请采购", "采购订单"};
    private List<Fragment> list = new ArrayList<Fragment>();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_zhengfu_buy,container,false);
        ViewUtils.inject(this, view);
        viewPager = (ViewPager) view.findViewById(R.id.vp_zhengfu_dingdan);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.zhengfu_dingdan_p);
        btn_zhengfu_tijiao= (Button) view.findViewById(R.id.btn_zhengfu_tijiao);
        init();
        viewPager.setAdapter(new MyFPA(getFragmentManager()));
        tabs.setViewPager(viewPager);

        btn_zhengfu_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new MyDingDanFragment(),null);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1){
                    btn_zhengfu_tijiao.setVisibility(View.GONE);
                }else{
                    btn_zhengfu_tijiao.setVisibility(View.VISIBLE);
//                    viewPager.requestDisallowInterceptTouchEvent(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


//
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

//        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        layoutParams.height = height - 90-110-2-100;
        viewPager.setLayoutParams(layoutParams);
        viewPager.getParent().requestDisallowInterceptTouchEvent(false);

        return view;
    }

    private void init() {
        for (int i = 0; i < fragmentClass.length; i++) {
            try {
                list.add((BaseFragment) fragmentClass[i].newInstance());
            } catch (java.lang.InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    class MyFPA extends FragmentStatePagerAdapter {

        public MyFPA(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (list != null) {
                return list.get(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }

    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }

    @Override
    protected void initData() {

    }

//    //动态设置viewpager高度
//    private void setViewPagerHeight(final ViewPager viewPager){
//        if(viewPager!=null){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println( viewPager.getMeasuredHeight() + "********************" + viewPager.getWidth());
//                }
//            }).start();
//
//
//
//        }
//    }

}
