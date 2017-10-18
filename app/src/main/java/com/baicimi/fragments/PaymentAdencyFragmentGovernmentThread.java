package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.PaymentAdencyAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.BooleanEntry;
import com.baicimi.entity.CustomGovernmentEntry;
import com.baicimi.entity.PaymentAdencyEntry;
import com.baicimi.view.CommonalityTransferDialog;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 * 个人中心，政府采购订单  订单支付详情页面03
 */
public class PaymentAdencyFragmentGovernmentThread extends BaseFragment implements View.OnClickListener {

    private View view;

    private ImageView back;

    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter;
    //下拉菜单布局添加
    private CustomExpandableListView customExpandableListView;
    private List<CustomGovernmentEntry> gruopList = new ArrayList<>();
    private List<List<View>> childList = new ArrayList<>();
    private PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapter;

    private List<List<BooleanEntry>> groupBoolean = new ArrayList<>();//用来保存并记录下拉菜单的数据

    PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFirst holder_01 = null;
    PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSecond holder_02 = null;
    PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderThread holder_03 = null;


    private TextView dissmess;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.payment_adency_fragment_government_thread , container , false);

        back = (ImageView) view.findViewById(R.id.government_purchase_fragment_myorderform_thread_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        //下拉菜单布局添加
        initCusListView();

        dissmess = (TextView) view.findViewById(R.id.pryment_adency_fragment_government_thread_dismesstv);
        dissmess.setOnClickListener(this);


        return view;
    }


    //下拉菜单布局添加
    private void initCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.pryment_adency_fragment_government_thread_customlistview);
        customExpandableListView.setGroupIndicator(null);
        gruopList.clear();
        gruopList.add(new CustomGovernmentEntry("配送方式", ""));
//        gruopList.add(new CustomGovernmentEntry("配送时间", ""));
//        gruopList.add(new CustomGovernmentEntry("支付方式", ""));
//        gruopList.add(new CustomGovernmentEntry("分期支付", "【激活分期】免息购买"));
//        gruopList.add(new CustomGovernmentEntry("使用积分", "有可用积分"));
        gruopList.add(new CustomGovernmentEntry("优惠券", "有可用券"));

        childList.clear();
        List<View> list_01 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_first_second, null));
//        List<View> list_02 = new ArrayList<>();
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_second, null));
//        List<View> list_03 = new ArrayList<>();
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_thread, null));
//        List<View> list_04 = new ArrayList<>();
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        List<View> list_05 = new ArrayList<>();
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
        List<View> list_06 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
        childList.add(list_01);
//        childList.add(list_02);
//        childList.add(list_03);
//        childList.add(list_04);
//        childList.add(list_05);
        childList.add(list_06);
        adencyGovernmentCusAdaapter = new PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter();
        customExpandableListView.setAdapter(adencyGovernmentCusAdaapter);

        List<BooleanEntry> childBoolean01 = new ArrayList<>();
        childBoolean01.add(new BooleanEntry(0));
        List<BooleanEntry> childBoolean02 = new ArrayList<>();
        childBoolean02.add(new BooleanEntry(0));
        List<BooleanEntry> childBoolean03 = new ArrayList<>();
        childBoolean03.add(new BooleanEntry(0));
        groupBoolean.add(childBoolean01);
        groupBoolean.add(childBoolean02);
        groupBoolean.add(childBoolean03);

    }

    @Override
    protected void initData() {

    }

    //listview布局填充
    private void initListView() {

//        if (index == 1){
            listView = (ListView) view.findViewById(R.id.pryment_adency_fragment_government_thread_listview);
            list.clear();
            list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01, new String("链条式连帽运动衫"), new String("白色 编号-5644/216"), new String("L(175/96A)"), new String("¥339.00")));
            adencyAdapter = new PaymentAdencyAdapter(list, getContext() , true);
            listView.setAdapter(adencyAdapter);
//        }else{
//        listView = (ListView) view.findViewById(R.id.pryment_adency_fragment_government_thread_listview);
//        list.clear();
//        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01, new String("链条式连帽运动衫"), new String("白色 编号-5644/216"), new String("L(175/96A)"), new String("¥339.00")));
//        adencyAdapter = new PaymentAdencyAdapter(list, getContext());
//        listView.setAdapter(adencyAdapter);
//        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.government_purchase_fragment_myorderform_thread_back:
                ((MainActivity) getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.pryment_adency_fragment_government_thread_dismesstv:
                //订单提交
                if (groupBoolean.get(0).get(0).getIndex() == 0 && groupBoolean.get(1).get(0).getIndex() == 0) {
                    startFragment(new ExpressageDeliveryFragment());//分销点送货并且为快捷送货
                } else if (groupBoolean.get(0).get(0).getIndex() == 1 && groupBoolean.get(1).get(0).getIndex() == 0) {
                    //自取货
                    startFragment(new SelfHelpClaimGoods());
                }
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

            if (i >= 3) {
                return 0;
            }
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
            PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusGroupHolder holder = null;

            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adeny_government_sus_group_adapter, null);
                holder = new PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusGroupHolder();
                holder.lible = (TextView) view.findViewById(R.id.payment_adeny_government_susgroup_adapter_lible);
                holder.conbtent = (TextView) view.findViewById(R.id.payment_adeny_government_susgroup_adapter_content);
                view.setTag(holder);
            } else {
                holder = (PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusGroupHolder) view.getTag();
            }

            holder.lible.setText(gruopList.get(i).getLible());
            if (i >= 3) {
                holder.conbtent.setText(gruopList.get(i).getContent());
                holder.conbtent.setVisibility(View.VISIBLE);
            } else {
                holder.conbtent.setVisibility(View.INVISIBLE);
            }


            return view;
        }

        //标题holder
        public class PaymentAdencyGovernmentCusGroupHolder {
            private TextView lible;
            private TextView conbtent;
        }


        @Override
        public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {

            if (i == 0) {
                view = null;
                if (view == null) {

                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_first_second, null);
                    holder_01 = new PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFirst();
                    holder_01.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_first_layout_second_01);
                    holder_01.layout_02 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_first_layout_second_02);
                    holder_01.layout_03 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_first_layout_second_03);
                    holder_01.checkBox01 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_first_checkbox_second_01);
                    holder_01.checkBox02 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_first_checkbox_second_02);
                    holder_01.checkBox03 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_first_checkbox_second_03);
                    view.setTag(holder_01);
                } else {
                    holder_01 = (PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFirst) view.getTag();
                }

                if (groupBoolean.get(i).get(i1).getIndex() == 0) {
                    holder_01.checkBox01.setChecked(true);
                    holder_01.checkBox02.setChecked(false);
                    holder_01.checkBox03.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 1) {
                    holder_01.checkBox01.setChecked(false);
                    holder_01.checkBox02.setChecked(true);
                    holder_01.checkBox03.setChecked(false);
                }else if (groupBoolean.get(i).get(i1).getIndex() == 2) {
                    holder_01.checkBox01.setChecked(false);
                    holder_01.checkBox02.setChecked(false);
                    holder_01.checkBox03.setChecked(true);
                }

                holder_01.layout_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(true);
                        holder_01.checkBox02.setChecked(false);
                        holder_01.checkBox03.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });

                holder_01.layout_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);
                        holder_01.checkBox02.setChecked(true);
                        holder_01.checkBox03.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });
                holder_01.layout_03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);
                        holder_01.checkBox02.setChecked(false);
                        holder_01.checkBox03.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(2);
                    }
                });
//
                holder_01.checkBox01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(true);
                        holder_01.checkBox02.setChecked(false);
                        holder_01.checkBox03.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });
                holder_01.checkBox02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);
                        holder_01.checkBox03.setChecked(false);
                        holder_01.checkBox02.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });
                holder_01.checkBox03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);
                        holder_01.checkBox03.setChecked(true);
                        holder_01.checkBox02.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(2);
                    }
                });


                return view;

            }
//            else if (i == 1) {
//                view = null;
//                if (view == null) {
//                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_second, null);
//                    holder_02 = new PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSecond();
//                    holder_02.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_second_layout_01);
//                    holder_02.layout_02 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_second_layout_02);
//                    holder_02.checkBox01 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_second_checkbox_01);
//                    holder_02.checkBox02 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_second_checkbox_02);
//
//                    view.setTag(holder_02);
//                } else {
//                    holder_02 = (PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSecond) view.getTag();
//                }
//
//
//                if (groupBoolean.get(i).get(i1).getIndex() == 0) {
//                    holder_02.checkBox01.setChecked(true);
//                    holder_02.checkBox02.setChecked(false);
//                } else if (groupBoolean.get(i).get(i1).getIndex() == 1) {
//                    holder_02.checkBox01.setChecked(false);
//                    holder_02.checkBox02.setChecked(true);
//                }
//
//                holder_02.layout_01.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_02.checkBox01.setChecked(true);
//                        holder_02.checkBox02.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(0);
//                    }
//                });
//
//                holder_02.layout_02.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_02.checkBox01.setChecked(false);
//                        holder_02.checkBox02.setChecked(true);
//                        groupBoolean.get(i).get(i1).setIndex(1);
//                    }
//                });
//
//                holder_02.checkBox01.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_02.checkBox01.setChecked(true);
//                        holder_02.checkBox02.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(0);
//                    }
//                });
//                holder_02.checkBox02.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_02.checkBox01.setChecked(false);
//                        holder_02.checkBox02.setChecked(true);
//                        groupBoolean.get(i).get(i1).setIndex(1);
//                    }
//                });
//
//                return view;
//            } else if (i == 2) {
//                view = null;
//                if (view == null) {
//                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_thread, null);
//                    holder_03 = new PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderThread();
//                    holder_03.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_01);
//                    holder_03.layout_02 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_02);
//                    holder_03.layout_03 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_03);
//                    holder_03.layout_04 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_04);
//                    holder_03.layout_05 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_05);
//                    holder_03.checkBox01 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_01);
//                    holder_03.checkBox02 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_02);
//                    holder_03.checkBox03 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_03);
//                    holder_03.checkBox04 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_04);
//                    holder_03.checkBox05 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_05);
//
//                    view.setTag(holder_03);
//                } else {
//                    holder_03 = (PaymentAdencyFragmentGovernmentThread.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderThread) view.getTag();
//                }
//
//
//                if (groupBoolean.get(i).get(i1).getIndex() == 0) {
//                    holder_03.checkBox01.setChecked(true);
//                    holder_03.checkBox02.setChecked(false);
//                    holder_03.checkBox03.setChecked(false);
//                    holder_03.checkBox04.setChecked(false);
//                    holder_03.checkBox05.setChecked(false);
//                } else if (groupBoolean.get(i).get(i1).getIndex() == 1) {
//                    holder_03.checkBox01.setChecked(false);
//                    holder_03.checkBox02.setChecked(true);
//                    holder_03.checkBox03.setChecked(false);
//                    holder_03.checkBox04.setChecked(false);
//                    holder_03.checkBox05.setChecked(false);
//                } else if (groupBoolean.get(i).get(i1).getIndex() == 2) {
//                    holder_03.checkBox01.setChecked(false);
//                    holder_03.checkBox02.setChecked(false);
//                    holder_03.checkBox03.setChecked(true);
//                    holder_03.checkBox04.setChecked(false);
//                    holder_03.checkBox05.setChecked(false);
//                } else if (groupBoolean.get(i).get(i1).getIndex() == 3) {
//                    holder_03.checkBox01.setChecked(false);
//                    holder_03.checkBox02.setChecked(false);
//                    holder_03.checkBox03.setChecked(false);
//                    holder_03.checkBox04.setChecked(true);
//                    holder_03.checkBox05.setChecked(false);
//                } else if (groupBoolean.get(i).get(i1).getIndex() == 4) {
//                    holder_03.checkBox01.setChecked(false);
//                    holder_03.checkBox02.setChecked(false);
//                    holder_03.checkBox03.setChecked(false);
//                    holder_03.checkBox04.setChecked(false);
//                    holder_03.checkBox05.setChecked(true);
//                }
//
//
//                holder_03.layout_01.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(true);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(0);
//                    }
//                });
//
//                holder_03.layout_02.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(true);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(1);
//                    }
//                });
//                holder_03.layout_03.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(true);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(2);
//                    }
//                });
//                holder_03.layout_04.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(true);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(3);
//                    }
//                });
//                holder_03.layout_05.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(true);
//                        groupBoolean.get(i).get(i1).setIndex(4);
//                        CommonalityTransferDialog dialog = new CommonalityTransferDialog(getContext(), R.style.MeiGuiMeiShiSecondMyorderFive);
//                        dialog.show();
//
//                    }
//                });
//
//                holder_03.checkBox01.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(true);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(0);
//                    }
//                });
//                holder_03.checkBox02.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(true);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(1);
//                    }
//                });
//                holder_03.checkBox03.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(true);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(2);
//                    }
//                });
//                holder_03.checkBox04.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(true);
//                        holder_03.checkBox05.setChecked(false);
//                        groupBoolean.get(i).get(i1).setIndex(3);
//                    }
//                });
//                holder_03.checkBox05.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_03.checkBox01.setChecked(false);
//                        holder_03.checkBox02.setChecked(false);
//                        holder_03.checkBox03.setChecked(false);
//                        holder_03.checkBox04.setChecked(false);
//                        holder_03.checkBox05.setChecked(true);
//                        groupBoolean.get(i).get(i1).setIndex(4);
//                        CommonalityTransferDialog dialog = new CommonalityTransferDialog(getContext(), R.style.MeiGuiMeiShiSecondMyorderFive);
//                        dialog.show();
//                    }
//                });
//
//                return view;
//            } else {

                return null;
//            }

        }

        private class PaymentAdencyGovernmentCusChildHolderFirst {
            private LinearLayout layout_01;
            private LinearLayout layout_02;
            private LinearLayout layout_03;
            private CheckBox checkBox01;
            private CheckBox checkBox02;
            private CheckBox checkBox03;
        }

        private class PaymentAdencyGovernmentCusChildHolderSecond {
            private LinearLayout layout_01;
            private LinearLayout layout_02;
            private CheckBox checkBox01;
            private CheckBox checkBox02;
        }

        private class PaymentAdencyGovernmentCusChildHolderThread {
            private LinearLayout layout_01;
            private LinearLayout layout_02;
            private LinearLayout layout_03;
            private LinearLayout layout_04;
            private LinearLayout layout_05;
            private CheckBox checkBox01;
            private CheckBox checkBox02;
            private CheckBox checkBox03;
            private CheckBox checkBox04;
            private CheckBox checkBox05;
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


}
