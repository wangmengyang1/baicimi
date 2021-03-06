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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.HistoryAdapter;
import com.baicimi.adapter.MyViewPagerFragmetAdapterSecond;
import com.baicimi.adapter.VerticalPagerAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ShopingPackageMessage;
import com.baicimi.view.VerticalViewPagerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/5.
 * 商品详情界面
 */
public class GoodsDetailsGrouBuyFragment extends BaseFragment implements View.OnClickListener {
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private Button btn_choose,btn_buynow;

    private ImageView btn_buying_car;
    private ViewPager viewPager;
    private PopupWindow window_choose;
    private CheckBox checkBox_xxl, checkBox_xl, checkBox_l, checkBox_m, checkBox_s,
            checkBox_xs, checkBox_yellow, checkBox_red, checkBox_black, checkBox_huase,
            checkBox_blacked, checkBox_danyellow;

    private LinearLayout layout_tagnumber;
    private TextView tagNumber;
    private int count = 1234;

    private List<Fragment> listFragments = new ArrayList<>();


    @Override
    protected View initView(final LayoutInflater inflater, final ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_details_grou_buy, container, false);
        checkBox1 = (CheckBox) view.findViewById(R.id.che1_grou_buy);
        checkBox2 = (CheckBox) view.findViewById(R.id.che2_grou_buy);
        checkBox3 = (CheckBox) view.findViewById(R.id.che3_grou_buy);
        checkBox4 = (CheckBox) view.findViewById(R.id.btn_three_grou_buy);
        checkBox5 = (CheckBox) view.findViewById(R.id.btn_six_grou_buy);
        checkBox6 = (CheckBox) view.findViewById(R.id.btn_shier_grou_buy);
        viewPager = (ViewPager) view.findViewById(R.id.check_list_grou_buy);

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

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox4.setChecked(true);
                checkBox5.setChecked(false);
                checkBox6.setChecked(false);
            }
        });

        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox4.setChecked(false);
                checkBox5.setChecked(true);
                checkBox6.setChecked(false);
            }
        });

        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
                checkBox6.setChecked(true);
            }
        });



        listFragments.clear();
        listFragments.add(new CheckOneFragment());
        listFragments.add(new CheckTwoFragment());
        listFragments.add(new CheckThreeFragment());

        MyViewPagerFragmetAdapterSecond myViewPagerFragmetAdapterSecond = new MyViewPagerFragmetAdapterSecond(getChildFragmentManager() , listFragments);

        viewPager.setAdapter(myViewPagerFragmetAdapterSecond);



        btn_buying_car= (ImageView) view.findViewById(R.id.btn_buynow_grou_buy);
        btn_buying_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startFragment(new ShopingCarFragment(),null);
                showPopwindowChoose(0);
            }
        });

        /**
         * 立即购买，跳转到订单界面，实际情况要判断是哪一种订单
         * */
        btn_buynow= (Button) view.findViewById(R.id.btn_gouwuche_grou_buy);
        btn_buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startFragment(new PersonDingDanFragment(),null);
                showPopwindowChoose(1);
            }
        });


        //关注度布局填充
        initTagNumber();

        return view;
    }

    //关注度布局填充
    private void initTagNumber() {
        layout_tagnumber = (LinearLayout) view.findViewById(R.id.fragment_details_grou_buy_layout_tagnumber);
        tagNumber = (TextView) view.findViewById(R.id.fragment_details_grou_buy_textview_tagnumber);
        layout_tagnumber.setOnClickListener(this);
    }

    /**
     * 显示服务窗口
     */
    private void showPopwindowChoose(final int index) {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view_window = inflater.inflate(R.layout.goods_details_choose_dialog, null);
        TextView textView = (TextView) view_window.findViewById(R.id.goods_details_choose_dialog_confirm);
        LinearLayout linearLayout = (LinearLayout) view_window.findViewById(R.id.goods_details_choose_dialog_layout);
        linearLayout.setVisibility(View.VISIBLE);

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
        window_choose.showAtLocation(view.findViewById(R.id.re_buy_grou_buy),
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


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index == 0){

                    //购物车的跳转
                    EventBus.getDefault().post(new ShopingPackageMessage(1));
//                    //购物车的跳转
//                    startFragment(new ShopingCarFragment(),null);
                }else if (index == 1){
                    //立即购买的跳转
                    startFragment(new PersonDingDanFragment(),null);
                }
                closePopupFuwuWindow();
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
            window_choose.dismiss();
            window_choose = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_details_grou_buy_layout_tagnumber:
                tagNumber.setText((count++) + "");
                break;
        }
    }
}
