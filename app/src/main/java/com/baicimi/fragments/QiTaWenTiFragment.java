package com.baicimi.fragments;

import android.graphics.Color;
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
 * 其他问题界面
 */
public class QiTaWenTiFragment extends BaseFragment{
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
        GroupData.add("积分咨询");
        GroupData.add("幂友咨询");
        GroupData.add("政府采购咨询");
        GroupData.add("积分银行咨询");

        ChildrenData = new ArrayList<List<String>>();
        List<String> child1 = new ArrayList<String>();
        child1.add("1、百次幂积分有什么用？");
        child1.add("2、我怎样才能赚取更多的积分？");
        child1.add("3、我如何查询我的积分？");
        child1.add("4、我可以将我的积分全部转给我的朋友吗？");
        ChildrenData.add(child1);

        List<String> list_ch1 = new ArrayList<>();
        list_ch1.add("积分可以在您购买商品时抵扣现金，也可以在百次幂商城-积分商城上兑换所需商品。还可以通过积分银行进行积分提现、理财、投资。");
        list_ch1.add("您可通过好友推荐、评价晒单、发布文章、登录、签到等形式赚取积分。");
        list_ch1.add("您可到个人中心-资产中心-幂钱包中查询您的积分账户余额，同时可点击“我的积分”查询积分的具体收支明细。");
        list_ch1.add("积分不可通过转账的形式流通，您可以通过给朋友发积分红包的形式转积分给朋友，但每月限额200积分。");
        list_content.add(list_ch1);


        List<String> child2 = new ArrayList<String>();
        child2.add("1、什么是幂友？");
        child2.add("2、我不想让我的幂友看我的购物袋怎么办？");
        child2.add("3、我如何知道别人是否设置我为幂友？");
        child2.add("4、我如何帮幂友付款？");
        ChildrenData.add(child2);

        List<String> list_ch2 = new ArrayList<>();
        list_ch2.add("幂友是你认为的最亲密的家人、朋友，幂友之间可互相查看购物袋，帮忙付款。");
        list_ch2.add("方法一：您可在个人中心——账户设置——幂友权限中，设置不允许ta查看我的购物袋。\n" +
                "方法二：您可在好友管理中设置不允许ta查看我的购物袋。");
        list_ch2.add("为保护个人隐私，百次幂会员的好友分组不公开，如您可以进入好友购物袋，说明您一定是对方幂友。但不能进入购物袋，也不能说明您一定不是对方幂友。如想获悉准确消息，建议和好友直接确认。");
        list_ch2.add("订单中心-亲密付订单-发起亲密付，可进入好友购物袋，帮其付款。");
        list_content.add(list_ch2);


        List<String> child3 = new ArrayList<String>();
        child3.add("1、政府采购是什么？");
        child3.add("2、如何申请政府采购特权？");
        child3.add("3、政府采购有发票吗？");
        ChildrenData.add(child3);

        List<String> list_ch3 = new ArrayList<>();
        list_ch3.add("MICI政府采购优惠针对政府机关、企事业单位、社区单位等组织机构，一次性购买商品，数额超过2000元，即可申请政府采购，认证成功后，立即享受低至5折优惠。MICI以原价开据正规发票，同时赠送200-1000元不等现金优惠券。");
        list_ch3.add("订单中心—政府采购订单—快速申请通道，可申请政府采购，填写相关信息，审核通过后可进行政府采购。");
        list_ch3.add("MICI以原价开据正规发票，同时赠送200-1000元不等现金优惠券。");
        list_content.add(list_ch3);


        List<String> child4 = new ArrayList<String>();
        child4.add("1、积分银行是什么？");
        child4.add("2、积分银行可以提现吗？");
        child4.add("3、在积分银行存储积分利息高吗？");
        ChildrenData.add(child4);

        List<String> list_ch4 = new ArrayList<>();
        list_ch4.add("幂积分银行是幂积分的交易平台，可购买、存储、提取积分，还可以进行积分理财。");
        list_ch4.add("只有到达V6等级的会员才可在积分银行进行积分提现交易。普通会员无法进行积分提现。");
        list_ch4.add("在积分银行存储积分，利息相对于银行平均高出5%。");
        list_content.add(list_ch4);

    }


    private void initView() {
        expd_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                startFragment(new WenTiDetailsFragment(ChildrenData.get(groupPosition).get(childPosition) , list_content.get(groupPosition).get(childPosition) , 3), null);
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
                myText = createViewPull(ChildrenData.get(groupPosition).get(childPosition));
            }
            myText.setMaxLines(1);
            myText.setEllipsize(TextUtils.TruncateAt.END);
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
            myText.setMaxLines(1);
            myText.setEllipsize(TextUtils.TruncateAt.END);
            return myText;
        }

        private TextView createViewPull(String content) {
            // TODO Auto-generated method stub
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 110);
            TextView myText = new TextView(getContext());
            params.height = 80;
            myText.setLayoutParams(params);
            myText.setGravity(Gravity.CENTER_VERTICAL| Gravity.LEFT );
            myText.setPadding(90, 0, 0, 0);
            myText.setText(content);
            myText.setTextColor(0xFF8C8C8C);
            myText.setTextSize(14);
            myText.setMaxLines(1);
            myText.setEllipsize(TextUtils.TruncateAt.END);
            myText.setBackgroundColor(Color.parseColor("#eeeeee"));
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
            }
            myText.setMaxLines(1);
            myText.setEllipsize(TextUtils.TruncateAt.END);
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
