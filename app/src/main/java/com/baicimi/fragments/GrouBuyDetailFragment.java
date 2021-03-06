package com.baicimi.fragments;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.HistoryAdapter;
import com.baicimi.adapter.VerticalPagerAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.VerticalViewPagerView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/12/12.
 * 团购详情页面
 */
public class GrouBuyDetailFragment extends BaseFragment{
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private Button btn_choose,btn_buying_car,btn_buynow;

    private List<View> baseList;
    private LayoutInflater inflater;
    private View view1, view2, view3;
    private ViewPager viewPager;
    private VerticalViewPagerView checkOne, checkTwo, checkThree;
    private List<Fragment> oneListFragments, twoListFragments,
            threeListFragments;

    private PopupWindow window_choose;
    private CheckBox checkBox_xxl, checkBox_xl, checkBox_l, checkBox_m, checkBox_s,
            checkBox_xs, checkBox_yellow, checkBox_red, checkBox_black, checkBox_huase,
            checkBox_blacked, checkBox_danyellow;


    @Override
    protected View initView(final LayoutInflater inflater, final ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_groubuy, container, false);
        checkBox1 = (CheckBox) view.findViewById(R.id.che1);
        checkBox2 = (CheckBox) view.findViewById(R.id.che2);
        checkBox3 = (CheckBox) view.findViewById(R.id.che3);
        viewPager = (ViewPager) view.findViewById(R.id.check_list);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(true);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(true);
                checkBox3.setChecked(false);
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(true);
            }
        });



        baseList = getList();
        oneListFragments = getFragmentList();
        twoListFragments = getTwoFragments();
        threeListFragments = getThreeFragments();

        VerticalPagerAdapter fragmentAdapter = new VerticalPagerAdapter(
                getChildFragmentManager(), oneListFragments);
        VerticalPagerAdapter fragmentAdapter1 = new VerticalPagerAdapter(
                getChildFragmentManager(), twoListFragments);
        VerticalPagerAdapter fragmentAdapter2 = new VerticalPagerAdapter(
                getChildFragmentManager(), threeListFragments);

        HistoryAdapter adapter = new HistoryAdapter(baseList);

        checkOne.setAdapter(fragmentAdapter);
        checkTwo.setAdapter(fragmentAdapter1);
        checkThree.setAdapter(fragmentAdapter2);
        viewPager.setAdapter(adapter);


        btn_choose = (Button) view.findViewById(R.id.btn_choose);
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindowChoose();
            }
        });

        btn_buying_car= (Button) view.findViewById(R.id.btn_gouwuche);
        btn_buying_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new ShopingCarFragment(),null);
            }
        });

        /**
         * 立即购买，跳转到订单界面，实际情况要判断是哪一种订单
         * */
        btn_buynow= (Button) view.findViewById(R.id.btn_buynow);
        btn_buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new PersonDingDanFragment(),null);
            }
        });

        return view;
    }


    public List<View> getList() {
        List<View> mList;
        inflater = LayoutInflater.from(getContext());
        view1 = inflater.inflate(R.layout.check_one, null);
        checkOne = (VerticalViewPagerView) view1.findViewById(R.id.check_one);
        imageView1 = (ImageView) view1.findViewById(R.id.img_gouwuche2);

        imageView4 = (ImageView) view1.findViewById(R.id.login_back1);
        //跳转到购物车界面
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new ShopingCarFragment(), null);
            }
        });
        //返回上一层
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goBack();//返回上一层页面
            }
        });
        view2 = inflater.inflate(R.layout.check_two, null);
        checkTwo = (VerticalViewPagerView) view2.findViewById(R.id.check_two);
        imageView2 = (ImageView) view2.findViewById(R.id.img_gouwuche2);
        imageView5 = (ImageView) view2.findViewById(R.id.login_back2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new ShopingCarFragment(), null);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goBack();//返回上一层页面
            }
        });
        view3 = inflater.inflate(R.layout.check_three, null);
        checkThree = (VerticalViewPagerView) view3.findViewById(R.id.check_Three);
        imageView3 = (ImageView) view3.findViewById(R.id.img_gouwuche3);
        imageView6 = (ImageView) view3.findViewById(R.id.login_back3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new ShopingCarFragment(), null);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goBack();//返回上一层页面
            }
        });
        mList = new ArrayList<View>();
        mList.add(view1);
        mList.add(view2);
        mList.add(view3);
        return mList;
    }

    public List<Fragment> getFragmentList() {
        List<Fragment> listFragments = new ArrayList<Fragment>();

        for (int i = 0; i < 10; i++) {
            CheckOneFragment oneFragment = new CheckOneFragment();
            listFragments.add(oneFragment);
        }
        return listFragments;
    }

    public List<Fragment> getTwoFragments() {
        List<Fragment> listFragments = new ArrayList<Fragment>();

        for (int i = 0; i < 10; i++) {
            CheckTwoFragment twoFragment = new CheckTwoFragment();
            listFragments.add(twoFragment);
        }
        return listFragments;
    }


    public List<Fragment> getThreeFragments() {
        List<Fragment> listFragments = new ArrayList<Fragment>();

        for (int i = 0; i < 10; i++) {
            CheckThreeFragment threeFragment = new CheckThreeFragment();
            listFragments.add(threeFragment);

        }
        return listFragments;

    }


    /**
     * 显示服务窗口
     */
    private void showPopwindowChoose() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.goods_details_choose_dialog, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_choose = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

//        //调用父亲变暗的方法
//        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_choose.setFocusable(true);
        window_choose.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_choose.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        window_choose.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window_choose.setAnimationStyle(R.style.AnimBottom);
        //设置在底部显示
        window_choose.showAtLocation(view.findViewById(R.id.re_buy),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window_choose.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });

        /**
         * 商品码数选择
         * */
        checkBox_xxl= (CheckBox) view_window.findViewById(R.id.goods_xxl);
        checkBox_xxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_xxl.setChecked(true);
                checkBox_xl.setChecked(false);
                checkBox_l.setChecked(false);
                checkBox_m.setChecked(false);
                checkBox_s.setChecked(false);
                checkBox_xs.setChecked(false);
            }
        });
        checkBox_xl= (CheckBox) view_window.findViewById(R.id.goods_xl);
        checkBox_xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_xxl.setChecked(false);
                checkBox_xl.setChecked(true);
                checkBox_l.setChecked(false);
                checkBox_m.setChecked(false);
                checkBox_s.setChecked(false);
                checkBox_xs.setChecked(false);
            }
        });
        checkBox_l= (CheckBox) view_window.findViewById(R.id.goods_l);
        checkBox_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_xxl.setChecked(false);
                checkBox_xl.setChecked(false);
                checkBox_l.setChecked(true);
                checkBox_m.setChecked(false);
                checkBox_s.setChecked(false);
                checkBox_xs.setChecked(false);
            }
        });
        checkBox_m= (CheckBox) view_window.findViewById(R.id.goods_m);
        checkBox_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_xxl.setChecked(false);
                checkBox_xl.setChecked(false);
                checkBox_l.setChecked(false);
                checkBox_m.setChecked(true);
                checkBox_s.setChecked(false);
                checkBox_xs.setChecked(false);
            }
        });
        checkBox_s= (CheckBox) view_window.findViewById(R.id.goods_s);
        checkBox_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_xxl.setChecked(false);
                checkBox_xl.setChecked(false);
                checkBox_l.setChecked(false);
                checkBox_m.setChecked(false);
                checkBox_s.setChecked(true);
                checkBox_xs.setChecked(false);
            }
        });
        checkBox_xs= (CheckBox) view_window.findViewById(R.id.goods_xs);
        checkBox_xs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_xxl.setChecked(false);
                checkBox_xl.setChecked(false);
                checkBox_l.setChecked(false);
                checkBox_m.setChecked(false);
                checkBox_s.setChecked(false);
                checkBox_xs.setChecked(true);
            }
        });


        /**
         * 商品颜色选择
         * */
        checkBox_yellow= (CheckBox) view_window.findViewById(R.id.goods_yellow);
        checkBox_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_yellow.setChecked(true);
                checkBox_red.setChecked(false);
                checkBox_black.setChecked(false);
                checkBox_huase.setChecked(false);
                checkBox_blacked.setChecked(false);
                checkBox_danyellow.setChecked(false);
            }
        });
        checkBox_red= (CheckBox) view_window.findViewById(R.id.goods_red);
        checkBox_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_yellow.setChecked(false);
                checkBox_red.setChecked(true);
                checkBox_black.setChecked(false);
                checkBox_huase.setChecked(false);
                checkBox_blacked.setChecked(false);
                checkBox_danyellow.setChecked(false);
            }
        });

        checkBox_black= (CheckBox) view_window.findViewById(R.id.goods_black);
        checkBox_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_yellow.setChecked(false);
                checkBox_red.setChecked(false);
                checkBox_black.setChecked(true);
                checkBox_huase.setChecked(false);
                checkBox_blacked.setChecked(false);
                checkBox_danyellow.setChecked(false);
            }
        });

        checkBox_huase= (CheckBox) view_window.findViewById(R.id.goods_huase);
        checkBox_huase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_yellow.setChecked(false);
                checkBox_red.setChecked(false);
                checkBox_black.setChecked(false);
                checkBox_huase.setChecked(true);
                checkBox_blacked.setChecked(false);
                checkBox_danyellow.setChecked(false);
            }
        });

        checkBox_blacked= (CheckBox) view_window.findViewById(R.id.goods_blacked);
        checkBox_blacked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_yellow.setChecked(false);
                checkBox_red.setChecked(false);
                checkBox_black.setChecked(false);
                checkBox_huase.setChecked(false);
                checkBox_blacked.setChecked(true);
                checkBox_danyellow.setChecked(false);
            }
        });

        checkBox_danyellow= (CheckBox) view_window.findViewById(R.id.goods_danyellow);
        checkBox_danyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_yellow.setChecked(false);
                checkBox_red.setChecked(false);
                checkBox_black.setChecked(false);
                checkBox_huase.setChecked(false);
                checkBox_blacked.setChecked(false);
                checkBox_danyellow.setChecked(true);
            }
        });



    }

    /**
     * 改变popwindow背景的方法
     *
     * @param alpha
     */
    private static void changeWindowAlpha(FragmentActivity activity, float alpha) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = alpha;
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        activity.getWindow().setAttributes(params);
    }

    /**
     * 关闭服务窗口
     */
    private void closePopupFuwuWindow() {
        if (window_choose != null && window_choose.isShowing()) {
            System.out.println("88888888888888888888");
            window_choose.dismiss();
            window_choose = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
            System.out.println("99999999999999999999");
        }
    }



    @OnClick({R.id.login_back,R.id.to_groubuy})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层
                break;
            case R.id.to_groubuy:
               startFragment(new TuanGouDingDanFragment(),null);
                break;
        }
    }


    @Override
    protected void initData() {

    }

}

