package com.baicimi.fragments;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/30.
 * 订单问题界面
 */
public class DingDanWenTiFragment extends BaseFragment{

    ExpandableListView expd_lv;
    ExpandableAdapter adapter;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;
    private List<List<String>> list_content = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_wenti,container,false);
        expd_lv = (ExpandableListView)view.findViewById(R.id.expd_lv);
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
        GroupData.add("物流问题");
        GroupData.add("订单咨询");
        GroupData.add("退货咨询");
//        GroupData.add("退货换货");


        ChildrenData = new ArrayList<List<String>>();

        List<String> child1 = new ArrayList<String>();
        child1.add("1、百次幂物流是怎样的模式？");
        child1.add("2、偏远地区可以送到吗？");
        child1.add("3、分销点/店送货拖拉，服务态度不好怎么办？");
        child1.add("4、到分销点/店自取商品时，如何操作？");
        ChildrenData.add(child1);

        List<String> list_ch_01 = new ArrayList<>();
        list_ch_01.add("百次幂自拥完整的物流系统，目前分销点/店（物流网点）已辐射至河南、广西、河北三省，延伸至35个市、县。预计在2020年，物流网点辐射全国32个省市自治区，数量将达500家。百次幂物流采取快递与自取两种模式，可选择快递或分销点/店送货上门，也可到就近的分销点/店自取商品，每次自取可获得10积分回馈。");
        list_ch_01.add("一般偏远地区快递都可以普及到，特别偏远的地区可选择EMS。");
        list_ch_01.add("遇到分销点/店派送不配合，服务态度差的情况，可直接拨打投诉热线400-883-2055进行投诉。百次幂设置了严格的分销点/店奖惩制度，您可以在订单详情-查看物流，对分销点/店的服务进行评价，如分销点/店评价低于平均分，或被投诉超过3次，百次幂将通过一系列措施整顿分销点/店，严重者取缔该分销点/店授权。");
        list_ch_01.add("在购买商品时，确认订单页选择配送方式时选择“自取”，提交订单后，您会获取“自取码”，以及系统就近自动为您分配的自取指定分销点/店地址、联系方式，您直接到指定的分销点/店提供“自取码”即可获取商品。");
        list_content.add(list_ch_01);

        List<String> child2 = new ArrayList<String>();
        child2.add("1、 订单提交后才发现信息填写错误怎么办？");
        child2.add("2、提交订单后什么时候发货？");
        child2.add("3、我要如何查询我的包裹到哪里了？");
        ChildrenData.add(child2);
        List<String> list_ch_02 = new ArrayList<>();
        list_ch_02.add("在未发货时，您可以取消订单，重新下单，也可点击“客服”浮标与百次幂客服联系，修改订单错误信息。如已发货，可通过拒收后重拍的方法重新下单。");
        list_ch_02.add("提交订单后一般在24小时内发货，如有缺货情况，百次幂客服会提前告知。");
        list_ch_02.add("在订单详情页中点击“查看物流”，可查询包裹的派送进度。也可自动联系百次幂分销点/店，询问包裹派送进度。");
        list_content.add(list_ch_02);



        List<String> child3 = new ArrayList<String>();
        child3.add("1、退换货的运费谁来承担？");
        child3.add("2、退货如何操作？");
        child3.add("3、忘了填运单号怎么办？");
        ChildrenData.add(child3);
        List<String> list_ch_03 = new ArrayList<>();
        list_ch_03.add("如因买家不喜欢、拍错、不合适或其他问题导致的退换货问题，运费由买家承担。如商品本身质量问题，或发错货等商城操作问题，运费由百次幂承担。");
        list_ch_03.add("点击订单详情页中的“售后”，选择退货退款，填写基本信息，提交退货申请。申请通过后，进行退货操作，填写物流公司与快递单号，退货成功。如商品是分销点/店配送或自取，可将商品直接退到分销点/店。退款将在24小时内退还到支付账户上。");
        list_ch_03.add("如果忘了填运单号，百次幂会在收到退货的24小时内，将退款退还到您的支付账户上。");
        list_content.add(list_ch_03);

    }


    private void initView() {
        expd_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                startFragment(new WenTiDetailsFragment(ChildrenData.get(groupPosition).get(childPosition) , list_content.get(groupPosition).get(childPosition) , 1),null);
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
            if(convertView != null){
                myText = (TextView) convertView;
                myText.setText(ChildrenData.get(groupPosition).get(childPosition));
            }else{
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
            myText.setGravity(Gravity.CENTER_VERTICAL| Gravity.LEFT );
            myText.setPadding(90, 0, 0, 0);
            myText.setText(content);
            myText.setTextColor(0xFF8C8C8C);
            myText.setTextSize(14);
            myText.setMaxLines(1);
            myText.setEllipsize(TextUtils.TruncateAt.END);
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
            if(convertView != null){
                myText = (TextView) convertView;
                myText.setText(GroupData.get(groupPosition));
            }else{
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
