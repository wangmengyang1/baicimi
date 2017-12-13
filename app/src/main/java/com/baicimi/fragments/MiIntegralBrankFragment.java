package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.MiIntegralBrankListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.AuthenticationEntry;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 * 幂积分银行
 */
public class MiIntegralBrankFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<AuthenticationEntry> list = new ArrayList<>();
    private MiIntegralBrankListAdapter adapterListview;

    //下拉菜单布局添加
    private CustomExpandableListView customExpandableListView;
    private List<String> gruopList = new ArrayList<>();
    private List<List<View>> childList = new ArrayList<>();
    private PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapter;


    private ImageView back;

    private LinearLayout storage;//存储

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_fragment, container, false);

        //listview布局填充
        initListView();


        //下拉菜单布局添加
        initCusListView();

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_fragment_back);
        back.setOnClickListener(this);

        storage = (LinearLayout) view.findViewById(R.id.mi_integral_brank_fragment_storage);
        storage.setOnClickListener(this);
        return view;
    }


    //下拉菜单布局添加
    private void initCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.mi_integral_brank_fragment_cusendlistview);
        customExpandableListView.setGroupIndicator(null);
        gruopList.clear();
        gruopList.add("今日积分市值");
        gruopList.add("银行储备积分动态");
        gruopList.add("我的资产概括");
        gruopList.add("幂银行积分");
        gruopList.add("幂银行积分流向");
        gruopList.add("幂银行积分回收计划");



        List<View> list_01 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childfirst, null));
        List<View> list_02 = new ArrayList<>();
        list_02.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childsecond, null));
        List<View> list_03 = new ArrayList<>();
        list_03.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childthread, null));
        List<View> list_04 = new ArrayList<>();
        list_04.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childfour, null));
        List<View> list_05 = new ArrayList<>();
        list_05.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childfive, null));
        List<View> list_06 = new ArrayList<>();
        list_06.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childsix, null));

        childList.add(list_01);
        childList.add(list_02);
        childList.add(list_03);
        childList.add(list_04);
        childList.add(list_05);
        childList.add(list_06);

        adencyGovernmentCusAdaapter = new PaymentAdencyGovernmentCusAdaapter();
        customExpandableListView.setAdapter(adencyGovernmentCusAdaapter);
    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.mi_integral_brank_fragment_listview);
        list.clear();
        list.add(new AuthenticationEntry(R.drawable.mi_code_brank_image_09, "柜台"));
        list.add(new AuthenticationEntry(R.drawable.mi_code_brank_image_10, "理财产品"));
        list.add(new AuthenticationEntry(R.drawable.mi_code_brank_image_11, "话费充值"));
        list.add(new AuthenticationEntry(R.drawable.mi_code_brank_image_12, "积分商城"));
        list.add(new AuthenticationEntry(R.drawable.mi_code_brank_image_13, "生活服务"));
        list.add(new AuthenticationEntry(R.drawable.mi_code_brank_image_14, "商城首页"));
        list.add(new AuthenticationEntry(R.drawable.mi_code_brank_image_15, "返回个人中心"));
        adapterListview = new MiIntegralBrankListAdapter(list, getContext());
        listView.setAdapter(adapterListview);
        fixGrdiViewHeight03(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    //柜台
                    startFragment(new MiIntegralBrankCounterFragment());
                }
            }
        });
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MiIntegralBrankListAdapter listAdapter = (MiIntegralBrankListAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 24;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_fragment_storage:
                //存储
                startFragment(new MiIntegralBrankStorageFragment());
                break;
        }
    }


    public class PaymentAdencyGovernmentCusAdaapter extends BaseExpandableListAdapter {


        @Override
        public int getGroupCount() {
            return gruopList.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return 1;
        }

        @Override
        public Object getGroup(int i) {
            return gruopList.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return childList.get(i).get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            PaymentAdencyGovernmentCusGroupHolder holder = null;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_fragmetn, null);
                holder = new PaymentAdencyGovernmentCusGroupHolder();
                holder.lible = (TextView) view.findViewById(R.id.mi_integral_brank_fragment_lible);
                view.setTag(holder);
            } else {
                holder = (PaymentAdencyGovernmentCusGroupHolder) view.getTag();
            }

            holder.lible.setText(gruopList.get(i));

            return view;
        }

        //标题holder
        public class PaymentAdencyGovernmentCusGroupHolder {
            private TextView lible;
            private TextView conbtent;
        }


        @Override
        public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
            view = null;
            if (i == 0){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childfirst , null);
            }else if (i == 1){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childsecond , null);
            }else if (i == 2){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childthread , null);
            }else if (i == 3){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childfour , null);
            }else if (i == 4){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childfive , null);
            }else if (i == 5){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_childsix , null);
            }

            return view;

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
