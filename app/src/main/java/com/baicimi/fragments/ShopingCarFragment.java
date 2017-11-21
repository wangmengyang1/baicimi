package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.FenQiDingDanDialogActivity;
import com.baicimi.adapter.AdapterGoWuCheLv;
import com.baicimi.adapter.GouWuCheGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.GouWuCheGvBean;
import com.baicimi.bean.GouWuCheListBean;
import com.baicimi.entity.CommodityNumberEntry;
import com.baicimi.entity.ShopingPackageMessage;
import com.baicimi.ui.MyGridView;
import com.baicimi.ui.MyListView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/6.
 * 购物车界面
 */
public class ShopingCarFragment extends BaseFragment {
    private CheckBox dingdan_checbox;
    private CheckBox tuangou_checbox;
    private CheckBox fenqi_checbox;
    private CheckBox zhengfu_checbox;
    private CheckBox qingmifu_checbox;

    private LinearLayout ll;
    private MyListView mList;

    private Button btn_jiesuan;
    private PopupWindow window,window_point;
    private ArrayList<GouWuCheListBean> gouwuche_arrayList;
    private List<GouWuCheGvBean> gvBeanArrayList;
    private AdapterGoWuCheLv adapterGoWuCheLv;
    final GouWuCheListBean gouWuCheListBean = new GouWuCheListBean();

    public ShopingCarFragment() {
    }

    private int commodityNumber = 0;

    @SuppressLint("ValidFragment")
    public ShopingCarFragment(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_gouwuche_jiesuan, container, false);
        mList = (MyListView) view.findViewById(R.id.gouwuche_list);
        btn_jiesuan = (Button) view.findViewById(R.id.btn_jiesuan);
        ll = (LinearLayout) view.findViewById(R.id.fuqin);


        /**
         * 购物车列表ListView
         */
        gouwuche_arrayList = new ArrayList<>();
        commodityNumber = CommodityNumberEntry.commodityNumberEntryIntereal().getCount();
        for (int i = 0; i < commodityNumber; i++) {
            gouWuCheListBean.setGoods_message("补水美白洁面乳");
            gouWuCheListBean.setYanse_num("编号 4373/206");
            gouwuche_arrayList.add(gouWuCheListBean);
        }
        adapterGoWuCheLv = new AdapterGoWuCheLv(getActivity(), gouwuche_arrayList);
        mList.setAdapter(adapterGoWuCheLv);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startFragment(new GoodsDetailsFragment(), null);
            }
        });

        /**
         * 点击按钮显示订单popupWindow
         */
        btn_jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindow();
            }
        });

        return view;
    }


    @OnClick({R.id.login_back})
    public void OnBackClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        //使用完毕之后解除注册
    }

    /**
     * 显示popupWindow
     */
    private void showPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view_window = inflater.inflate(R.layout.view_dingdan_shuxing, null);

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

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window.setBackgroundDrawable(dw);
//        //在参照的View控件下方显示
//        window.showAsDropDown(MainActivity.this.findViewById(R.id.start));

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        //设置在底部显示
        window.showAtLocation(view.findViewById(R.id.btn_jiesuan),
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(getActivity(), 1.0f);
            }
        });


        /**
         *选择个人订单
         */
        dingdan_checbox = (CheckBox) view_window.findViewById(R.id.person_dingdan_check);
        dingdan_checbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dingdan_checbox.setChecked(true);
                tuangou_checbox.setChecked(false);
                fenqi_checbox.setChecked(false);
                zhengfu_checbox.setChecked(false);
                qingmifu_checbox.setChecked(false);
                startFragment(new PersonDingDanFragment(), null);
                closePopupWindow();
            }
        });

        /**
         *选择团购订单
         */
        tuangou_checbox = (CheckBox) view_window.findViewById(R.id.tuangou_dingdan_check);
        tuangou_checbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dingdan_checbox.setChecked(false);
                tuangou_checbox.setChecked(true);
                fenqi_checbox.setChecked(false);
                zhengfu_checbox.setChecked(false);
                qingmifu_checbox.setChecked(false);
                startFragment(new TuanGouDingDanFragment(), null);
                closePopupWindow();
            }
        });

        /**
         *选择分期订单
         */
        fenqi_checbox = (CheckBox) view_window.findViewById(R.id.fenqi_dingdan_check);
        fenqi_checbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dingdan_checbox.setChecked(false);
                tuangou_checbox.setChecked(false);
                fenqi_checbox.setChecked(true);
                zhengfu_checbox.setChecked(false);
                qingmifu_checbox.setChecked(false);
                closePopupWindow();
                Intent intent=new Intent(getContext(), FenQiDingDanDialogActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_bottom_in,R.anim.push_bottom_out);
            }
        });


        /**
         *选择政府订单
         */
        zhengfu_checbox = (CheckBox) view_window.findViewById(R.id.zhengfu_dingdan_check);
        zhengfu_checbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dingdan_checbox.setChecked(false);
                tuangou_checbox.setChecked(false);
                fenqi_checbox.setChecked(false);
                zhengfu_checbox.setChecked(true);
                qingmifu_checbox.setChecked(false);
                startFragment(new ZhengFuBuyFragment(), null);
                closePopupWindow();
            }
        });


        /**
         *选择亲密付订单
         */
        qingmifu_checbox = (CheckBox) view_window.findViewById(R.id.qinmifu_dingdan_check);
        qingmifu_checbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dingdan_checbox.setChecked(false);
                tuangou_checbox.setChecked(false);
                fenqi_checbox.setChecked(false);
                zhengfu_checbox.setChecked(false);
                qingmifu_checbox.setChecked(true);
                startFragment(new QinMiFuDingDanFragment(), null);
                closePopupWindow();
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
    private void closePopupWindow() {
        if (window != null && window.isShowing()) {
            window.dismiss();
            window = null;
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha = 1.0f;
            getActivity().getWindow().setAttributes(params);
        }
    }


//    /**
//     * 显示分期订单窗口
//     */
//    private void showPopwindowfenqi(View v) {
//        // 利用layoutInflater获得View
//        LayoutInflater inflater = LayoutInflater.from(getActivity());
//        View view_window = inflater.inflate(R.layout.activity_fenqidingdan_dialog, null);
//
//        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
//        window_point = new PopupWindow(view_window,
//                WindowManager.LayoutParams.MATCH_PARENT,
//                WindowManager.LayoutParams.WRAP_CONTENT);
//
//        //调用父亲变暗的方法
//        changeWindowAlpha(getActivity(), 0.5f);
//
//        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
//        window_point.setFocusable(true);
//        window_point.setTouchable(true);
//
//        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
//        window_point.setBackgroundDrawable(new BitmapDrawable());
//
//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xFFffffff);
//        window_point.setBackgroundDrawable(dw);
//
//        // 设置popWindow的显示和消失动画
//        window_point.setAnimationStyle(R.style.SiginAnimi);
////        int[] location = new int[2];
////        v.getLocationOnScreen(location);
//
//        //设置在底部显示
//        window_point.showAtLocation(v,Gravity.CENTER,0,0);
//        /**
//         * *popWindow消失监听方法
//         */
//        window_point.setOnDismissListener(new PopupWindow.OnDismissListener() {
//
//            @Override
//            public void onDismiss() {
//                changeWindowAlpha(getActivity(), 1.0f);
//            }
//        });
//
//
//    }
//

    @Override
    protected void initData() {

    }
}
