package com.baicimi.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.ChoosePayWayActivity;
import com.baicimi.bean.BackMonyBean;
import com.baicimi.fragments.FenQiFragmented;

import java.util.List;

/**
 * Created by tan on 2016/9/5.
 */
public class BackMonyListAdapter extends BaseAdapter {

    private Context mContext;
    private List<BackMonyBean> mList;
    private LayoutInflater mLayoutInflater;
    private FenQiFragmented fenQiFragment;

    private PopupWindow window;
    private RelativeLayout payway_choose;
    private ImageView clouse_pay;
    private Button btn_Yespay;


    public BackMonyListAdapter(FenQiFragmented fragment, Context context, List<BackMonyBean> mList) {
        this.fenQiFragment = fragment;
        this.mContext = context;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.fenqi_listview_item, null);
            mViewHolder.tv = (TextView) convertView.findViewById(R.id.back_mony_num);
            mViewHolder.btn_huankuan = (Button) convertView.findViewById(R.id.btn_huankuan);
            mViewHolder.linearLayout = (LinearLayout) convertView.findViewById(R.id.fenqi_goods_details);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tv.setSelected(true);
        mViewHolder.tv.setText(mList.get(position).getMony());

        /**
         * 弹出付款详情界面
         * */
        mViewHolder.btn_huankuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopwindowPayway(v);
            }
        });

        /**
         * 跳转到我的分期界面
         * */
        mViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenQiFragment.starEduFenqiFragment();
            }
        });

        return convertView;
    }

    class ViewHolder {
        private TextView tv;
        private Button btn_huankuan;
        private LinearLayout linearLayout;
    }


    /**
     * 显示付款详情窗口
     */
    private void showPopwindowPayway(View v) {
        // 利用layoutInflater获得View
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view_window = inflater.inflate(R.layout.fenqi_payway_dialog, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window = new PopupWindow(view_window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        //调用父亲变暗的方法
        changeWindowAlpha(((MainActivity) mContext), 0.5f);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        window.setTouchable(true);

        // 必须要给调用这个方法，否则点击popWindow以外部分，popWindow不会消失
        window.setBackgroundDrawable(new BitmapDrawable());

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.AnimBottom);
        //设置在底部显示
        window.showAtLocation(v,
                Gravity.BOTTOM, 0, 0);

        /**
         * *popWindow消失监听方法
         */
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                changeWindowAlpha(((MainActivity) mContext), 1.0f);
            }
        });

        payway_choose = (RelativeLayout) view_window.findViewById(R.id.payways_choose);
        payway_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,ChoosePayWayActivity.class);
                mContext.startActivity(intent);
            }
        });
        btn_Yespay = (Button) view_window.findViewById(R.id.btn_fenqi_paymony);
        btn_Yespay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeWindowpayway();
                fenQiFragment.starSeceesePayFragment();
            }
        });
        clouse_pay = (ImageView) view_window.findViewById(R.id.stop_paymony);
        clouse_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeWindowpayway();
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
    private void closeWindowpayway() {
        if (window != null && window.isShowing()) {
            window.dismiss();
            window = null;
            WindowManager.LayoutParams params = ((MainActivity) mContext).getWindow().getAttributes();
            params.alpha = 1.0f;
            ((MainActivity) mContext).getWindow().setAttributes(params);
        }
    }


}
