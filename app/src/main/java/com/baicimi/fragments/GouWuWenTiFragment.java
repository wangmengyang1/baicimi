package com.baicimi.fragments;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/30.
 * 购物问题界面
 */
public class GouWuWenTiFragment extends BaseFragment {
    ExpandableListView expd_lv;
    ExpandableAdapter adapter;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;
    private List<List<String>> list_content = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_wenti, container, false);
        expd_lv = (ExpandableListView) view.findViewById(R.id.expd_lv);
        LoadListData();
        adapter = new ExpandableAdapter();
        expd_lv.setAdapter(adapter);
        expd_lv.setChildIndicator(null);
        initView();
        return view;
    }

    private void LoadListData() {
        // TODO Auto-generated method stub
        GroupData = new ArrayList<String>();
        GroupData.add("退款咨询");
        GroupData.add("售货咨询");
        GroupData.add("支付咨询");
        GroupData.add("促销咨询");
        GroupData.add("积分兑换");

        ChildrenData = new ArrayList<List<String>>();
        List<String> child1 = new ArrayList<String>();
        child1.add("1、退货后什么时候退款？");
        child1.add("2、退货后退款到哪里？");
        child1.add("3、拒收包裹后什么时候退款？");
        List<String> list_ch1 = new ArrayList<>();
        list_ch1.add("退货后填写运单号与物流公司，24小时内款项自动退到支付账户内。");
        list_ch1.add("退款退还到支付账户，如用幂钱包支付的款项，则退款直接退到幂钱包内。");
        list_ch1.add("拒收包裹后，百次幂收到拒收信息，在24小时内安排退款。");
        list_content.add(list_ch1);

        ChildrenData.add(child1);
        List<String> child2 = new ArrayList<String>();
        child2.add("1、如何使用积分抵扣现金？");
        child2.add("2、在加入购物袋后，是不是该商品已经被我预定了？");
        child2.add("3、如何查看商品规格、功效等信息？");
        child2.add("4、账户里积分用完了，如何享受积分价?");
        ChildrenData.add(child2);
        List<String> list_ch2 = new ArrayList<>();
        list_ch2.add("选购商品时，在宝贝详情页勾选积分抵扣现金选项，即可使用积分抵扣现金。");
        list_ch2.add("商品加入购物袋后，此商品不属于被预定，需要以成功提交订单为准。");
        list_ch2.add("进入宝贝详情页，点击右上角“信息”，可查看产品成分、使用指南等详细信息。同时还可点击客服咨询，与在线客服即时沟通。");
        list_ch2.add("百次幂商城上商品积分价是基于“积分抵扣现金”的基础上享受的，如账户没有积分，可通过好友推荐、评价晒单、发布文章、登录、签到等形式赚取积分，然后享受商品积分价。");
        list_content.add(list_ch2);



        List<String> child3 = new ArrayList<String>();
        child3.add("1、百次幂商城支持哪种支付方式？");
        child3.add("2、百次幂支持货到付款吗？");
        child3.add("3、订单重复支付怎么办?");
        child3.add("4、在线支付时提示有“超过限额”，该怎么办?");
        ChildrenData.add(child3);

        List<String> list_ch3 = new ArrayList<>();
        list_ch3.add("百次幂商城拥有幂钱包支付工具，支付简单、快捷。同时还附有支付宝、微信、银联等支付工具。如遇政府采购等需大额支付的订单款项，可通过对公转账形式完成支付。");
        list_ch3.add("百次幂商城暂不支持货到付款，您可通过官网查询附近的百次幂分销点/店，直接到分销点/店购买相应产品。");
        list_ch3.add("多支付的款项在财务对帐后，系统会将您多支付的款项退到您的百次幂钱包。");
        list_ch3.add("普通银行卡（储蓄卡/信用卡）设置有支付上限，超过支付限额您将无法支付，您可以拨打相关银行支付卡电话，提高支付限额或将钱分批存入支付平台进行支付。");
        list_content.add(list_ch3);


        List<String> child4 = new ArrayList<String>();
        child4.add("1、为什么我没有收到百次幂赠送的限量优惠券？");
        child4.add("2、为什么总是抢购失败？");
        child4.add("3、我秒杀/抢购成功时订单显示有货，过一会为什么订单显示缺货/无货？");
        child4.add("4、我没有抢到，下次什么时间开始秒杀/抢购？");
        ChildrenData.add(child4);
        List<String> list_ch4 = new ArrayList<>();
        list_ch4.add("百次幂赠送的限量优惠券数量有限，每次赠送在众多用户中，根据用户的活跃度、购买率、会员等级等综合评估。同时，百次幂在赠送限量优惠券时会综合考虑用户的购买习惯，针对性赠送。如想获取限量优惠券，可适当增加活跃度、购买率，也可随时关注百次幂商城的促销活动。");
        list_ch4.add("同时抢购这款商品的客户非常多，商品短时间就会被抢光，就会导致抢购失败。最终以秒杀价支付成功做为判断标准。");
        list_ch4.add("由于同一时间下单客户较多，导致系统没有及时更新库存状态，所以订单显示是缺货状态，我们会尽快的补货，争取第一时间为您发货。请您保持手机畅通，耐心等待即可。");
        list_ch4.add("您可以关注周五之夜，每个周五都有限量秒杀，同时随时关注百次幂商城最新促销公告，尤其是大型节假日活动促销。");
        list_content.add(list_ch4);


        List<String> child5 = new ArrayList<String>();
        child5.add("1、如何进行积分兑换？");
        child5.add("2、为什么每次都抢不到我想要兑换的商品？");
        child5.add("3、积分不够怎么办？");
        child5.add("4、积分兑换的商品质量有保障吗？");
        ChildrenData.add(child5);

        List<String> list_ch5 = new ArrayList<>();
        list_ch5.add("方法一：百次幂商城上所有产品都可以使用积分抵扣现金，在购物时勾选上此选项即可。\n" +
                "方法二：可随时关注积分商城，百次幂会随时更新积分商城上的兑换商品，可无需现金，只使用积分兑换到所需商品。\n" +
                "方法三：您可以通过推荐好友，每开通一个关卡都有相应积分兑换礼品。");
        list_ch5.add("积分兑换商品数量有限，抢购的客户非常多，商品短时间就会被抢光，就会导致抢购失败。最终以积分支付成功做为判断标准。");
        list_ch5.add("您可通过好友推荐、评价晒单、发布文章、登录、签到等形式赚取积分。");
        list_ch5.add("百次幂商城上所有商品以“最高质量”为基本进驻标准。积分商城上所兑换的商品均选自国际国内大品牌正规商品，请放心选购。");
        list_content.add(list_ch5);

    }


    private void initView() {
        expd_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                startFragment(new WenTiDetailsFragment(ChildrenData.get(groupPosition).get(childPosition) , list_content.get(groupPosition).get(childPosition) , 2), null);
                return true;
            }
        });
    }


    private class ExpandableAdapter extends BaseExpandableListAdapter {

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return ChildrenData.get(groupPosition).get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                                 ViewGroup parent) {
            // TODO Auto-generated method stub
            TextView myText = null;
            if (convertView != null) {
                myText = (TextView) convertView;
                myText.setText(ChildrenData.get(groupPosition).get(childPosition));
            } else {
                myText = createView(ChildrenData.get(groupPosition).get(childPosition));
                myText.setMaxLines(1);
                myText.setEllipsize(TextUtils.TruncateAt.END);
            }
            return myText;
        }

        private TextView createView(String content) {
            // TODO Auto-generated method stub
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 110);
            TextView myText = new TextView(getContext());
            myText.setLayoutParams(params);
            myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            myText.setPadding(90, 0, 0, 0);
            myText.setText(content);
            myText.setTextColor(0xFF8C8C8C);
            myText.setTextSize(15);
            return myText;
        }


        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            return ChildrenData.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return GroupData.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return GroupData.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            // TODO Auto-generated method stub
            TextView myText = new TextView(getContext());
            if (convertView != null) {
                myText = (TextView) convertView;
                myText.setText(GroupData.get(groupPosition));
            } else {
                myText = createView(GroupData.get(groupPosition));
                myText.setMaxLines(1);
                myText.setEllipsize(TextUtils.TruncateAt.END);
            }
            return myText;
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return true;
        }

    }

    @Override
    protected void initData() {

    }
}
