package com.baicimi.fragments;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.format.Time;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.MyViewPagerFragmetAdapterSecond;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.ui.PersonUserPagerSlidingTabStrip;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tan on 2016/10/14.
 * 首页积分商品页面
 */
public class JiFenGoodsFragment extends BaseFragment implements DistributionNumberOnitemClick{
    private ViewPager viewPager;
    private PersonUserPagerSlidingTabStrip tabs;
    private String[] titles = { "日化" , "绿色食品" , "美妆",  "母婴" , "个人用品","男士"};




    private PopupWindow window,window_point1,window_point2,window_point3;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;
    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,
            textView8,textView9,textView10,textView11,textView12,textView13,textView14;

    public static final int checked_color = 0xFFFEE8A1;
    public static final int check_color = 0xFFCE2F4B;



    private View head;

    private LinearLayout timelimit , new_conversion , goods_big;

    private View new_recommend_01 , new_recommend_02 , new_recommend_03 , popularity_01 , popularity_02 , popularity_03;


    private MyViewPagerFragmetAdapterSecond myViewPagerFragmetAdapterSecond;
    private List<Fragment> listFragment = new ArrayList<>();

    private ImageView everyday , brand , festival , newconversion;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_jifen_goods, container, false);
        initFragment();


        viewPager = (ViewPager) view.findViewById(R.id.vp_jifenshangcheng);
        tabs = (PersonUserPagerSlidingTabStrip) view.findViewById(R.id.my_head_jifen);
        viewPager.setAdapter(new MyViewPagerFragmetAdapterSecond(getChildFragmentManager() , listFragment , titles));
        tabs.setViewPager(viewPager);

        //头部
        head = view.findViewById(R.id.fragment_jifen_goods_head);

        //限时兑换
        timelimit = (LinearLayout) view.findViewById(R.id.fragment_jifen_goods_timelimit);
        new_conversion = (LinearLayout) view.findViewById(R.id.fragment_jifen_goods_new_conversion);
        goods_big = (LinearLayout) view.findViewById(R.id.fragment_jifen_goods_big);

        everyday = (ImageView) view.findViewById(R.id.fragment_jifen_goods_everyday);
        brand = (ImageView) view.findViewById(R.id.fragment_jifen_goods_brand);
        festival = (ImageView) view.findViewById(R.id.fragment_jifen_goods_festival);
        newconversion = (ImageView) view.findViewById(R.id.fragment_jifen_goods_newconversion);


        //新品推荐
        new_recommend_01 = view.findViewById(R.id.fragment_jifen_goods_new_recommend_01);
        new_recommend_02 = view.findViewById(R.id.fragment_jifen_goods_new_recommend_02);
        new_recommend_03 = view.findViewById(R.id.fragment_jifen_goods_new_recommend_03);

        //人气商品
        return view;
    }

    private void initFragment() {
        listFragment.clear();
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));

    }

    @Override
    public void setNumberOnitemClick(View view, int i, long l) {
        if(this.view != null){
            ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
            layoutParams.height = 1865;
            viewPager.setLayoutParams(layoutParams);
        }
    }




    @OnClick({R.id.change_ranking, R.id.news_things, R.id.free_area,
            R.id.jifen_rule, R.id.sigin_btn, R.id.float_btn , R.id.jifen_goods_brand_01 ,
            R.id.jifen_goods_brand_02 , R.id.jifen_goods_brand_03 , R.id.jifen_goods_brand_04 ,
            R.id.jifen_goods_brand_05 , R.id.jifen_goods_brand_06 , R.id.jifen_goods_brand_07 ,
            R.id.jifen_goods_brand_08 , R.id.jifen_goods_brand_09 , R.id.jifen_goods_brand_10 ,
            R.id.jifen_goods_brand_11 , R.id.jifen_goods_brand_12 , R.id.fragment_jifen_goods_head , R.id.fragment_jifen_goods_timelimit ,
            R.id.fragment_jifen_goods_new_conversion , R.id.fragment_jifen_goods_big , R.id.fragment_jifen_goods_new_recommend_01 ,
            R.id.fragment_jifen_goods_new_recommend_02 , R.id.fragment_jifen_goods_new_recommend_03 ,R.id.fragment_jifen_goods_everyday,
            R.id.fragment_jifen_goods_brand,R.id.fragment_jifen_goods_festival , R.id.fragment_jifen_goods_newconversion

    })
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.change_ranking:
                //兑换排行
//                startFragment(new ChangeRankingFragment(), null);
                startFragment(new HomeIntegerGoodsConversionRanking(), null);
                break;
            case R.id.news_things:
                //新人专区
//                startFragment(new NewUserStoreFragment(), null);
                startFragment(new HomeIntegerNewPeoplePrefecture(), null);
                break;
            case R.id.free_area:
                //免费礼品
//                startFragment(new FreeAreaFragment(), null);
                startFragment(new HomeIntegerFreeGiftFragment(), null);
                break;
            case R.id.jifen_rule:
                //积分规则
//                startFragment(new PointsRuleFragment(), null);
                startFragment(new HomeIntegerRuleFragmet(), null);
                break;
            case R.id.sigin_btn:
//                showPopwindowSigin();
                //每日签到
                startFragment(new HomeIntegerEverydaySignin(), null);
                break;
            case R.id.float_btn:
                showPopwindowPointOne();
                break;
            case R.id.jifen_goods_brand_01:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_02:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_03:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_04:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_05:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_06:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_07:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_08:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_09:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_10:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_11:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.jifen_goods_brand_12:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.fragment_jifen_goods_head:
                startFragment(new PopularityBrandFragment(), null);
                break;
            case R.id.fragment_jifen_goods_timelimit:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_jifen_goods_new_conversion:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_jifen_goods_big:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_jifen_goods_new_recommend_01:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_jifen_goods_new_recommend_02:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_jifen_goods_new_recommend_03:
                startFragment(new GoodsDetailsFragment(),null);
                break;
            case R.id.fragment_jifen_goods_everyday:
                startFragment(new HomeIntegerTimelimitConversion());
                break;
            case R.id.fragment_jifen_goods_brand:
                startFragment(new HomeIntegerTimelimitConversion(1));
                break;
            case R.id.fragment_jifen_goods_festival:
                startFragment(new HomeIntegerTimelimitConversion(2));
                break;
            case R.id.fragment_jifen_goods_newconversion:
                startFragment(new HomeIntegerTimelimitConversion(3));
                break;

        }
    }


    /**
     * 显示服务窗口
     */
    private void showPopwindowSigin() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.sigin_dialog, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        window.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.SiginAnimi);
//        int[] location = new int[2];
//        v.getLocationOnScreen(location);

        //设置在底部显示
//        window.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1] - window.getHeight());
        //设置在顶部显示
        window.showAtLocation(view.findViewById(R.id.jifen),Gravity.TOP,0,0);

        /**
         * *popWindow消失监听方法
         */
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });


        //月日
        textView1= (TextView) view_window.findViewById(R.id.one_date);
        textView2= (TextView) view_window.findViewById(R.id.two_date);
        textView3= (TextView) view_window.findViewById(R.id.three_date);
        textView4= (TextView) view_window.findViewById(R.id.four_date);
        textView5= (TextView) view_window.findViewById(R.id.five_date);
        textView6= (TextView) view_window.findViewById(R.id.six_date);
        textView7= (TextView) view_window.findViewById(R.id.seven_date);

        //签到奖励积分数量
        textView8= (TextView) view_window.findViewById(R.id.tv_one);
        textView9= (TextView) view_window.findViewById(R.id.tv_two);
        textView10= (TextView) view_window.findViewById(R.id.tv_three);
        textView11= (TextView) view_window.findViewById(R.id.tv_four);
        textView12= (TextView) view_window.findViewById(R.id.tv_five);
        textView13= (TextView) view_window.findViewById(R.id.tv_six);
        textView14= (TextView) view_window.findViewById(R.id.tv_seven);

        //签到按钮
        checkBox1= (CheckBox) view_window.findViewById(R.id.one_day);
        checkBox2= (CheckBox) view_window.findViewById(R.id.two_day);
        checkBox3= (CheckBox) view_window.findViewById(R.id.three_day);
        checkBox4= (CheckBox) view_window.findViewById(R.id.four_day);
        checkBox5= (CheckBox) view_window.findViewById(R.id.five_day);
        checkBox6= (CheckBox) view_window.findViewById(R.id.six_day);
        checkBox7= (CheckBox) view_window.findViewById(R.id.seven_day);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox1.isChecked()){
                    textView8.setTextColor(checked_color);
                }else {
                    textView8.setTextColor(check_color);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox2.isChecked()){
                    textView9.setTextColor(checked_color);
                }else {
                    textView9.setTextColor(check_color);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox3.isChecked()){
                    textView10.setTextColor(checked_color);
                }else {
                    textView10.setTextColor(check_color);
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox4.isChecked()){
                    textView11.setTextColor(checked_color);
                }else {
                    textView11.setTextColor(check_color);
                }
            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox5.isChecked()){
                    textView12.setTextColor(checked_color);
                }else {
                    textView12.setTextColor(check_color);
                }
            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox6.isChecked()){
                    textView13.setTextColor(checked_color);
                }else {
                    textView13.setTextColor(check_color);
                }
            }
        });
        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox7.isChecked()){
                    textView14.setTextColor(checked_color);
                }else {
                    textView14.setTextColor(check_color);
                }
            }
        });

        //获取月日
        Time time = new Time("GMT+8");
        time.setToNow();
        int month = time.month;
        int day = time.monthDay;
        textView1.setText((month+1)+"."+day);
        textView2.setText((month+1)+"."+(day+1));
        textView3.setText((month+1)+"."+(day+2));
        textView4.setText((month+1)+"."+(day+3));
        textView5.setText((month+1)+"."+(day+4));
        textView6.setText((month+1)+"."+(day+5));
        textView7.setText((month+1)+"."+(day+6));


    }


    /**
     * 显示窗口
     */
    private void showPopwindowPointOne() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.point_explain_dialog_one, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_point1 = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

//        //调用父亲变暗的方法
//        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_point1.setFocusable(true);
        window_point1.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_point1.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        window_point1.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window_point1.setAnimationStyle(R.style.SiginAnimi);
//        int[] location = new int[2];
//        v.getLocationOnScreen(location);

        //设置在底部显示
        window_point1.showAtLocation(view.findViewById(R.id.float_btn),Gravity.CENTER,0,0);

        /**
         * *popWindow消失监听方法
         */
        window_point1.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });

        Button button_close= (Button) view_window.findViewById(R.id.close_btn);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupPointWindow();
            }
        });

        Button button_moer= (Button) view_window.findViewById(R.id.btn_know_more1);
        button_moer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupPointWindow();
                showPopwindowPointTwo();
            }
        });
    }

    /**
     * 显示服务窗口
     */
    private void showPopwindowPointTwo() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.point_explain_dialog_two, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_point2 = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

//        //调用父亲变暗的方法
//        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_point2.setFocusable(true);
        window_point2.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_point2.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        window_point2.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window_point2.setAnimationStyle(R.style.SiginAnimi);
//        int[] location = new int[2];
//        v.getLocationOnScreen(location);

        //设置在底部显示
        window_point2.showAtLocation(view.findViewById(R.id.float_btn),Gravity.CENTER,0,0);

        /**
         * *popWindow消失监听方法
         */
        window_point2.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });

        Button button_close= (Button) view_window.findViewById(R.id.close_btn);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupPointtWindow();
            }
        });
        Button button_moer1= (Button) view_window.findViewById(R.id.btn_know_more2);
        button_moer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupPointtWindow();
                showPopwindowPointThree();
            }
        });

    }


    /**
     * 显示窗口
     */
    private void showPopwindowPointThree() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.point_explain_dialog_three, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window_point3 = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

//        //调用父亲变暗的方法
//        changeWindowAlpha(getActivity(), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window_point3.setFocusable(true);
        window_point3.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window_point3.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        window_point3.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window_point3.setAnimationStyle(R.style.SiginAnimi);
//        int[] location = new int[2];
//        v.getLocationOnScreen(location);

        //设置在底部显示
        window_point3.showAtLocation(view.findViewById(R.id.float_btn),Gravity.CENTER,0,0);
        /**
         * *popWindow消失监听方法
         */
        window_point3.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });

        Button button_close= (Button) view_window.findViewById(R.id.btn_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupPointttWindow();
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
     * 关闭窗口
     */
    private void closePopupPointWindow() {
        if ( window_point1!= null && window_point1.isShowing()) {

            window_point1.dismiss();
            window_point1 = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);

        }
    }

    /**
     * 关闭窗口
     */
    private void closePopupPointtWindow() {
        if ( window_point2!= null && window_point2.isShowing()) {

            window_point2.dismiss();
            window_point2 = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);

        }
    }

    /**
     * 关闭窗口
     */
    private void closePopupPointttWindow() {
        if ( window_point3!= null && window_point3.isShowing()) {

            window_point3.dismiss();
            window_point3 = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);

        }
    }


    @Override
    protected void initData() {

    }
}
