package com.baicimi.fragments;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.ShaiXuanActivity;
import com.baicimi.activitys.ShowFragmentActivity;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tan on 2016/9/2.
 * 商品筛选页面
 */
public class SerchGoodsFragment extends BaseFragment {
    private CheckBox checkBox_liebiao;
    private FragmentManager fManager;
    private FragmentTransaction ftTransaction;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private LinkedList<String> mFragments2 = new LinkedList<String>();
    private PopupWindow window;

    private TextView lible;
    private String libleString;

    public SerchGoodsFragment(String lible) {
        libleString = lible;
    }


    public SerchGoodsFragment() {
    }


    public String getLibleString() {
        return libleString;
    }

    public void setLibleString(String libleString) {
        this.libleString = libleString;
    }

    private ImageView scanning;//二维码


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_serch_goods, container, false);
        checkBox_liebiao = (CheckBox) view.findViewById(R.id.liebiao_checkbox);

        fragments.add(new ShaiXuanGoodsListFragment());
        fragments.add(new ShaiXuanGoodsGvFragment());
        fManager = getChildFragmentManager();
        ShaiXuanGoodsListFragment shaiXuanGoodsListFragment=new ShaiXuanGoodsListFragment();
        selectFragment(shaiXuanGoodsListFragment,"shaixuan_list");
        checkBox_liebiao.setSelected(true);

        checkBox_liebiao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    selectFragment(new ShaiXuanGoodsListFragment(),"shaixuan_list");
                }else {
                    selectFragment(new ShaiXuanGoodsGvFragment(),"shaoxuan_gv");
                }
            }
        });


        lible = (TextView) view.findViewById(R.id.fragment_serch_goods_lible);
        lible.setText(getLibleString());

        //二维码扫描
        initScanning();

        return view;
    }

    //二维码扫描
    private void initScanning() {
        scanning = (ImageView) view.findViewById(R.id.fragment_serch_goods_scanning);
        scanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),
                        ShowFragmentActivity.class));
            }
        });
    }

    @OnClick({R.id.brand_fragment_second_back,R.id.img_shaixuan})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.brand_fragment_second_back:
                ((MainActivity) getActivity()).goBack();
                break;
            case R.id.img_shaixuan:
               Intent intentshaixuan=new Intent(getActivity(), ShaiXuanActivity.class);
                startActivity(intentshaixuan);
//                showPopwindow(view);
                break;
        }
    }

    @Override
    protected void initData() {

    }


    public void selectFragment(Fragment f,String tag){
        ftTransaction = fManager.beginTransaction();
        if (mFragments2 != null) {
            if (mFragments2.contains(tag)) {
                for (String str : mFragments2) {
                    if (tag.equals(str)) {
                        ftTransaction.show(fManager.findFragmentByTag(tag));
                    }else {
                        ftTransaction.hide(fManager.findFragmentByTag(str));
                    }
                }
            }else {
                ftTransaction.add(R.id.shaixuan_list_fragment,f, tag);
                mFragments2.add(tag);
            }

        }else {
            ftTransaction.add(R.id.shaixuan_list_fragment,f, tag);
            mFragments2.add(tag);
        }
        ftTransaction.commit();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理扫描结果（在界面上显示）
        if (resultCode == -1) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
//            resultTextView.setText(scanResult);
            Toast.makeText(getContext() , scanResult , Toast.LENGTH_SHORT).show();
        }
    }


//    /**
//     * 显示popupWindow
//     */
//    private void showPopwindow(View view) {
//        // 利用layoutInflater获得View
//        LayoutInflater inflater = LayoutInflater.from(getActivity());
//        View view_window = inflater.inflate(R.layout.activity_goods_shaixuan, null);
//
//        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
//        window = new PopupWindow(view_window,
//                WindowManager.LayoutParams.MATCH_PARENT,
//                WindowManager.LayoutParams.WRAP_CONTENT);
//
//        //调用父亲变暗的方法
//        changeWindowAlpha(getActivity(), 0.5f);
//
//        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
//        window.setFocusable(true);
//        window.setTouchable(true);
//
//        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
//        window.setBackgroundDrawable(new BitmapDrawable());
//
////        // 实例化一个ColorDrawable颜色为半透明
////        ColorDrawable dw = new ColorDrawable(0xFFffffff);
////        window.setBackgroundDrawable(dw);
////        //在参照的View控件下方显示
////        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));
//
//        // 设置popWindow的显示和消失动画
//        window.setAnimationStyle(R.style.shaixuan_anim_style);
//        //设置在底部显示
//        window.showAtLocation(view,
//                Gravity.RIGHT, 0, 0);
//
//        /**
//         * *popWindow消失监听方法
//         */
//        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
//
//            @Override
//            public void onDismiss() {
//                changeWindowAlpha(getActivity(), 1.0f);
//            }
//        });
//
//
////        /**
////         *选择个人订单
////         */
////        dingdan_checbox = (CheckBox) view_window.findViewById(R.id.person_dingdan_check);
////        dingdan_checbox.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                dingdan_checbox.setChecked(true);
////                tuangou_checbox.setChecked(false);
////                fenqi_checbox.setChecked(false);
////                zhengfu_checbox.setChecked(false);
////                qingmifu_checbox.setChecked(false);
////                startFragment(new PersonDingDanFragment(), null);
////                closePopupWindow();
////            }
////        });
//
//
//    }
//
//
//    /**
//     * 改变popwindow背景的方法
//     *
//     * @param alpha
//     */
//    private static void changeWindowAlpha(FragmentActivity activity, float alpha) {
//        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
//        params.alpha = alpha;
//        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        activity.getWindow().setAttributes(params);
//    }
//
//    /**
//     * 关闭窗口
//     */
//    private void closePopupWindow() {
//        if (window != null && window.isShowing()) {
//            System.out.println("88888888888888888888");
//            window.dismiss();
//            window = null;
//            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
//            params.alpha = 1.0f;
//            getActivity().getWindow().setAttributes(params);
//            System.out.println("99999999999999999999");
//        }
//    }



}
