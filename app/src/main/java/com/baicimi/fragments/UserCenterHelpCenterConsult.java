package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.UserCenterHelpCenterConsultAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHelpCenterConsultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 * 个人中心，帮助中心首页 点此咨询提问跳转页面
 */
public class UserCenterHelpCenterConsult extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private GridView gridView;
    private List<UserCenterHelpCenterConsultEntry> list = new ArrayList<>();
    private UserCenterHelpCenterConsultAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_help_center_consult, container, false);

        back = (ImageView) view.findViewById(R.id.user_center_help_center_consult_back);
        back.setOnClickListener(this);


        //GridView布局填充
        initGridView();
        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.user_center_help_center_consult_gridview);
        list.clear();
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_15, "订单咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_16, "购买咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_17, "账户咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_18, "支付咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_19, "积分咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_20, "卡券咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_21, "会员咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_22, "物流咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_23, "认证咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_24, "亲密付咨询"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_25, "投诉与建议"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_26, "分销点/店"));
        list.add(new UserCenterHelpCenterConsultEntry(R.drawable.usercenter_help_center_image_27, "百万行动计划"));
        adapter = new UserCenterHelpCenterConsultAdapter(list, getContext());
        gridView.setAdapter(adapter);
        fixGrdiViewHeight03(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //订单咨询
                    startFragment(new UserCenterHelpIndentConvertion("订单咨询"));
                } else if (i == 1) {
                    //购买咨询
                    startFragment(new UserCenterHelpIndentConvertion("购买咨询"));
                }else if (i == 2) {
                    //账户咨询
                    startFragment(new UserCenterHelpIndentConvertion("账户咨询"));
                }else if (i == 3){
                    //支付咨询
                    startFragment(new UserCenterHelpIndentConvertion("支付咨询"));
                }else if (i == 4){
                    //积分咨询
                    startFragment(new UserCenterHelpIndentConvertion("积分咨询"));
                }else if (i == 5){
                    //卡券咨询
                    startFragment(new UserCenterHelpIndentConvertion("卡券咨询"));
                }else if (i == 6){
                    //会员咨询
                    startFragment(new UserCenterHelpIndentConvertion("会员咨询"));
                }else if (i == 7){
                    //物流咨询
                    startFragment(new UserCenterHelpIndentConvertion("物流咨询"));
                }else if (i == 8){
                    //认证咨询
                    startFragment(new UserCenterHelpIndentConvertion("认证咨询"));
                }else if (i == 9){
                    //亲密付咨询
                    startFragment(new UserCenterHelpIndentConvertion("亲密付咨询"));
                }else if (i == 10){
                    //投诉与建议
                    startFragment(new UserCenterHelpIndentConvertion("投诉与建议"));
                }else if (i == 11){
                    //分销点/店
                    startFragment(new UserCenterHelpIndentConvertion("分销点/店"));
                }else if (i == 12){
                    //百万行动计划
                    startFragment(new ActionPlanFragment());
                }
            }
        });

    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHelpCenterConsultAdapter listAdapter = (UserCenterHelpCenterConsultAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount() / 4); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 60;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_center_help_center_consult_back:
                ((MainActivity) getActivity()).goBack();
                break;
        }
    }
}
