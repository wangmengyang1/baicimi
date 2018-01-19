package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
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
 * Created by Administrator on 2017/10/16.
 * 个人中心，政府采购订单  订单支付详情页面
 */
public class PaymentAdencyFragmentGovernment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter;
    //下拉菜单布局添加
    private CustomExpandableListView customExpandableListView;
    private List<CustomGovernmentEntry> gruopList = new ArrayList<>();
    private List<List<View>> childList = new ArrayList<>();
    private PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapter;

    private List<List<BooleanEntry>> groupBoolean = new ArrayList<>();//用来保存并记录下拉菜单的数据

    PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFirst holder_01 = null;
    PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSecond holder_02 = null;
    PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderThread holder_03 = null;
    PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFour holder_04 = null;
    PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFive holder_05 = null;
    PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSix holder_06 = null;


    private TextView dissmess;

    private int index;
    private PopupWindow popupWindow;

    private TextView lible;
    private String libleS = "";


    private LinearLayout address;

    @SuppressLint("ValidFragment")
    public PaymentAdencyFragmentGovernment(String libleS) {
        this.libleS = libleS;
    }

    public PaymentAdencyFragmentGovernment() {
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.pryment_adency_fragment_government, container, false);

        back = (ImageView) view.findViewById(R.id.government_purchase_fragment_myorderform_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        //下拉菜单布局添加
        initCusListView();

        dissmess = (TextView) view.findViewById(R.id.pryment_adency_fragment_government_dismesstv);
        dissmess.setOnClickListener(this);

        if (libleS.equals("我的预售订单")){
            lible = (TextView) view.findViewById(R.id.government_purchase_fragment_myorderform_lible);
            lible.setText("支付尾款");
        }


        address = (LinearLayout) view.findViewById(R.id.pryment_adency_fragment_government_listview_address);
        address.setOnClickListener(this);

        return view;
    }

    //下拉菜单布局添加
    private void initCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.pryment_adency_fragment_government_customlistview);
        customExpandableListView.setGroupIndicator(null);
        gruopList.clear();
        gruopList.add(new CustomGovernmentEntry("配送方式", ""));
        gruopList.add(new CustomGovernmentEntry("配送时间", ""));
        gruopList.add(new CustomGovernmentEntry("支付方式", ""));
        gruopList.add(new CustomGovernmentEntry("分期支付", "【激活分期】免息购买"));
        gruopList.add(new CustomGovernmentEntry("使用积分", "有可用积分"));
        gruopList.add(new CustomGovernmentEntry("优惠券", "有可用券"));

        childList.clear();
        List<View> list_01 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_first, null));
        List<View> list_02 = new ArrayList<>();
        list_02.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_second, null));
        List<View> list_03 = new ArrayList<>();
        list_03.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_thread, null));
        List<View> list_04 = new ArrayList<>();
        list_04.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_four , null));
        List<View> list_05 = new ArrayList<>();
        list_05.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_five, null));
        List<View> list_06 = new ArrayList<>();
        list_06.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_six, null));
        childList.add(list_01);
        childList.add(list_02);
        childList.add(list_03);
        childList.add(list_04);
        childList.add(list_05);
        childList.add(list_06);
        adencyGovernmentCusAdaapter = new PaymentAdencyGovernmentCusAdaapter();
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

        if (index == 1){
            listView = (ListView) view.findViewById(R.id.pryment_adency_fragment_government_listview);
            list.clear();
            list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01, new String("链条式连帽运动衫"), new String("白色 编号-5644/216"), new String("L(175/96A)"), new String("¥339.00")));
            adencyAdapter = new PaymentAdencyAdapter(list, getContext() , true);
            listView.setAdapter(adencyAdapter);
        }else{
            listView = (ListView) view.findViewById(R.id.pryment_adency_fragment_government_listview);
            list.clear();
            list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01, new String("链条式连帽运动衫"), new String("白色 编号-5644/216"), new String("L(175/96A)"), new String("¥339.00")));
            adencyAdapter = new PaymentAdencyAdapter(list, getContext());
            listView.setAdapter(adencyAdapter);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.government_purchase_fragment_myorderform_back:
                ((MainActivity) getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.pryment_adency_fragment_government_dismesstv:
                //订单提交
                if (groupBoolean.get(0).get(0).getIndex() == 0 && groupBoolean.get(1).get(0).getIndex() == 0) {
                    startFragment(new ExpressageDeliveryFragment());//分销点送货并且为快捷送货
                } else if (groupBoolean.get(0).get(0).getIndex() == 1 && groupBoolean.get(1).get(0).getIndex() == 0) {
                    //自取货
                    startFragment(new SelfHelpClaimGoods());
                }
                break;
            case R.id.pryment_adency_fragment_government_listview_address:
                //地址管理
                startFragment(new UserCenterHomePagerSettingAddressManager());
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
                view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adeny_government_sus_group_adapter, null);
                holder = new PaymentAdencyGovernmentCusGroupHolder();
                holder.lible = (TextView) view.findViewById(R.id.payment_adeny_government_susgroup_adapter_lible);
                holder.conbtent = (TextView) view.findViewById(R.id.payment_adeny_government_susgroup_adapter_content);
                holder.image = (ImageView) view.findViewById(R.id.payment_adeny_government_susgroup_adapter_checkbox);
                view.setTag(holder);
            } else {
                holder = (PaymentAdencyGovernmentCusGroupHolder) view.getTag();
            }

            holder.lible.setText(gruopList.get(i).getLible());
            if (i >= 3) {
                holder.conbtent.setText(gruopList.get(i).getContent());
                holder.conbtent.setVisibility(View.VISIBLE);
                holder.conbtent.setTextColor(0xffeeeeee);
            } else {
                holder.conbtent.setVisibility(View.INVISIBLE);
            }


            if (gruopList.get(i).getLible().equals("分期支付")){
                holder.lible.setTextColor(0xffeeeeee);
                holder.image.setVisibility(View.INVISIBLE);
            }else if (gruopList.get(i).getLible().equals("使用积分")){
                holder.lible.setTextColor(0xffeeeeee);
                holder.image.setVisibility(View.INVISIBLE);
            }else if (gruopList.get(i).getLible().equals("优惠券")){
                holder.lible.setTextColor(0xffeeeeee);
                holder.image.setVisibility(View.INVISIBLE);
            }else {
                holder.lible.setTextColor(0xff979797);
                holder.image.setVisibility(View.VISIBLE);
            }



            return view;
        }

        //标题holder
        public class PaymentAdencyGovernmentCusGroupHolder {
            private TextView lible;
            private TextView conbtent;
            private ImageView image;
        }


        @Override
        public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {

            if (i == 0) {
                view = null;
                if (view == null) {

                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_first, null);
                    holder_01 = new PaymentAdencyGovernmentCusChildHolderFirst();
                    holder_01.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_first_layout_01);
                    holder_01.layout_02 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_first_layout_02);
                    holder_01.checkBox01 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_first_checkbox_01);
                    holder_01.checkBox02 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_first_checkbox_02);
                    view.setTag(holder_01);
                } else {
                    holder_01 = (PaymentAdencyGovernmentCusChildHolderFirst) view.getTag();
                }

                if (groupBoolean.get(i).get(i1).getIndex() == 0) {
                    holder_01.checkBox01.setChecked(true);
                    holder_01.checkBox02.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 1) {
                    holder_01.checkBox01.setChecked(false);
                    holder_01.checkBox02.setChecked(true);
                }

                holder_01.layout_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(true);
                        holder_01.checkBox02.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);

                        gruopList.add(1 ,new CustomGovernmentEntry("配送时间", ""));
                        List<View> list_02 = new ArrayList<>();
                        list_02.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_second, null));
                        childList.add(1 ,list_02);
                        notifyDataSetChanged();
                    }
                });

                holder_01.layout_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);
                        holder_01.checkBox02.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(1);
                        gruopList.remove(1);
                        childList.remove(1);
                        notifyDataSetChanged();
                    }
                });
//
                holder_01.checkBox01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(true);
                        holder_01.checkBox02.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);


                        gruopList.add(1 ,new CustomGovernmentEntry("配送时间", ""));
                        List<View> list_02 = new ArrayList<>();
                        list_02.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_second, null));
                        childList.add(1 ,list_02);
                        notifyDataSetChanged();
                    }
                });
                holder_01.checkBox02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);
                        holder_01.checkBox02.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(1);

                        gruopList.remove(1);
                        childList.remove(1);
                        notifyDataSetChanged();
                    }
                });

                return view;

            } else if (i == 1) {
                view = null;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_second, null);
                    holder_02 = new PaymentAdencyGovernmentCusChildHolderSecond();
                    holder_02.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_second_layout_01);
                    holder_02.layout_02 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_second_layout_02);
                    holder_02.checkBox01 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_second_checkbox_01);
                    holder_02.checkBox02 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_second_checkbox_02);

                    view.setTag(holder_02);
                } else {
                    holder_02 = (PaymentAdencyGovernmentCusChildHolderSecond) view.getTag();
                }


                if (groupBoolean.get(i).get(i1).getIndex() == 0) {
                    holder_02.checkBox01.setChecked(true);
                    holder_02.checkBox02.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 1) {
                    holder_02.checkBox01.setChecked(false);
                    holder_02.checkBox02.setChecked(true);
                }

                holder_02.layout_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(true);
                        holder_02.checkBox02.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });

                holder_02.layout_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(1);
                        initShowPopularWindow();
                    }
                });

                holder_02.checkBox01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(true);
                        holder_02.checkBox02.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });
                holder_02.checkBox02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(1);
                        initShowPopularWindow();
                    }
                });

                return view;
            } else if (i == 2) {
                view = null;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_thread, null);
                    holder_03 = new PaymentAdencyGovernmentCusChildHolderThread();
                    holder_03.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_01);
                    holder_03.layout_02 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_02);
                    holder_03.layout_03 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_03);
                    holder_03.layout_04 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_04);
                    holder_03.layout_05 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_layout_05);
                    holder_03.checkBox01 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_01);
                    holder_03.checkBox02 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_02);
                    holder_03.checkBox03 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_03);
                    holder_03.checkBox04 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_04);
                    holder_03.checkBox05 = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_thread_checkbox_05);

                    view.setTag(holder_03);
                } else {
                    holder_03 = (PaymentAdencyGovernmentCusChildHolderThread) view.getTag();
                }


                if (groupBoolean.get(i).get(i1).getIndex() == 0) {
                    holder_03.checkBox01.setChecked(true);
                    holder_03.checkBox02.setChecked(false);
                    holder_03.checkBox03.setChecked(false);
                    holder_03.checkBox04.setChecked(false);
                    holder_03.checkBox05.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 1) {
                    holder_03.checkBox01.setChecked(false);
                    holder_03.checkBox02.setChecked(true);
                    holder_03.checkBox03.setChecked(false);
                    holder_03.checkBox04.setChecked(false);
                    holder_03.checkBox05.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 2) {
                    holder_03.checkBox01.setChecked(false);
                    holder_03.checkBox02.setChecked(false);
                    holder_03.checkBox03.setChecked(true);
                    holder_03.checkBox04.setChecked(false);
                    holder_03.checkBox05.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 3) {
                    holder_03.checkBox01.setChecked(false);
                    holder_03.checkBox02.setChecked(false);
                    holder_03.checkBox03.setChecked(false);
                    holder_03.checkBox04.setChecked(true);
                    holder_03.checkBox05.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 4) {
                    holder_03.checkBox01.setChecked(false);
                    holder_03.checkBox02.setChecked(false);
                    holder_03.checkBox03.setChecked(false);
                    holder_03.checkBox04.setChecked(false);
                    holder_03.checkBox05.setChecked(true);
                }


                holder_03.layout_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(true);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });

                holder_03.layout_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(true);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });
                holder_03.layout_03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(true);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(2);
                    }
                });
                holder_03.layout_04.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(true);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(3);
                    }
                });
                holder_03.layout_05.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(4);
                        CommonalityTransferDialog dialog = new CommonalityTransferDialog(getContext(), R.style.MeiGuiMeiShiSecondMyorderFive);
                        dialog.show();

                    }
                });

                holder_03.checkBox01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(true);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });
                holder_03.checkBox02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(true);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });
                holder_03.checkBox03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(true);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(2);
                    }
                });
                holder_03.checkBox04.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(true);
                        holder_03.checkBox05.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(3);
                    }
                });
                holder_03.checkBox05.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_03.checkBox01.setChecked(false);
                        holder_03.checkBox02.setChecked(false);
                        holder_03.checkBox03.setChecked(false);
                        holder_03.checkBox04.setChecked(false);
                        holder_03.checkBox05.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(4);
                        CommonalityTransferDialog dialog = new CommonalityTransferDialog(getContext(), R.style.MeiGuiMeiShiSecondMyorderFive);
                        dialog.show();
                    }
                });

                return view;
            }else if (i == 3){
                view = null;
                view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_null , null);
                return view;
            }else if (i == 4){
                view = null;
                view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_null , null);
                return view;
            }else if (i == 5){
                view = null;
                view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_null , null);
                return view;
            }
//            else if (i == 3){
//                view = null;
//                if (view == null){
//                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_four , null);
//                    holder_04 = new PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFour();
//                    holder_04.first_checkbox = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_four_checkbox_first);
//                    holder_04.second_checkbox = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_four_checkbox_seconc);
//                    holder_04.thread_checkbox = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_four_checkbox_thread);
//
//                    view.setTag(holder_04);
//                }else{
//                    holder_04 = (PaymentAdencyGovernmentCusChildHolderFour) view.getTag();
//                }
//
//                holder_04.first_checkbox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_04.first_checkbox.setChecked(true);
//                        holder_04.second_checkbox.setChecked(false);
//                        holder_04.thread_checkbox.setChecked(false);
//                    }
//                });
//                holder_04.second_checkbox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_04.first_checkbox.setChecked(false);
//                        holder_04.second_checkbox.setChecked(true);
//                        holder_04.thread_checkbox.setChecked(false);
//                    }
//                });
//                holder_04.thread_checkbox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_04.first_checkbox.setChecked(false);
//                        holder_04.second_checkbox.setChecked(false);
//                        holder_04.thread_checkbox.setChecked(true);
//                    }
//                });
//
//                return view;
//            }else if (i == 4){
//                view = null;
//                if (view == null){
//                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_five , null);
//                    holder_05 = new PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFive();
//                    holder_05.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_five_layout_01);
//                    holder_05.layout_02 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_five_layout_02);
//                    holder_05.layout_03 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_five_layout_03);
//
//                    holder_05.first_checkbox = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_five_checkbox_01);
//                    holder_05.second_checkbox = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_five_checkbox_02);
//                    holder_05.thread_checkbox = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_five_checkbox_03);
//
//                    view.setTag(holder_05);
//                }else{
//                    holder_05 = (PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFive) view.getTag();
//                }
//
//                holder_05.layout_01.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_05.first_checkbox.setChecked(true);
//                        holder_05.second_checkbox.setChecked(false);
//                        holder_05.thread_checkbox.setChecked(false);
//                    }
//                });
//                holder_05.layout_02.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_05.first_checkbox.setChecked(false);
//                        holder_05.second_checkbox.setChecked(true);
//                        holder_05.thread_checkbox.setChecked(false);
//                    }
//                });
//                holder_05.layout_03.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_05.first_checkbox.setChecked(false);
//                        holder_05.second_checkbox.setChecked(false);
//                        holder_05.thread_checkbox.setChecked(true);
//                    }
//                });
//
//
//                holder_05.first_checkbox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_05.first_checkbox.setChecked(true);
//                        holder_05.second_checkbox.setChecked(false);
//                        holder_05.thread_checkbox.setChecked(false);
//                    }
//                });
//                holder_05.second_checkbox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_05.first_checkbox.setChecked(false);
//                        holder_05.second_checkbox.setChecked(true);
//                        holder_05.thread_checkbox.setChecked(false);
//                    }
//                });
//                holder_05.thread_checkbox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_05.first_checkbox.setChecked(false);
//                        holder_05.second_checkbox.setChecked(false);
//                        holder_05.thread_checkbox.setChecked(true);
//                    }
//                });
//
//                return view;
//            }else if (i == 5){
//                view = null;
//                if (view == null){
//                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_six , null);
//                    holder_06 = new PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSix();
//                    holder_06.layout_01 = (LinearLayout) view.findViewById(R.id.payment_adency_gov_child_adapter_six_layout_01);
//                    holder_06.first_checkbox = (CheckBox) view.findViewById(R.id.payment_adency_gov_child_adapter_six_checkbox_01);
//
//                    view.setTag(holder_06);
//                }else{
//                    holder_06 = (PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSix) view.getTag();
//                }
//
//                holder_06.layout_01.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_06.first_checkbox.setChecked(!holder_06.first_checkbox.isChecked());
//                    }
//                });
//                holder_06.first_checkbox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        holder_06.first_checkbox.setChecked(!holder_06.first_checkbox.isChecked());
//                    }
//                });
//
//                return view;
//            }
            else {

                return null;
            }

        }

        private class PaymentAdencyGovernmentCusChildHolderFirst {
            private LinearLayout layout_01;
            private LinearLayout layout_02;
            private CheckBox checkBox01;
            private CheckBox checkBox02;
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

        private class PaymentAdencyGovernmentCusChildHolderFour{
            private CheckBox first_checkbox;
            private CheckBox second_checkbox;
            private CheckBox thread_checkbox;
        }
        private class PaymentAdencyGovernmentCusChildHolderFive{

            private LinearLayout layout_01 , layout_02 ,layout_03 ;
            private CheckBox first_checkbox;
            private CheckBox second_checkbox;
            private CheckBox thread_checkbox;
        }

        private class PaymentAdencyGovernmentCusChildHolderSix{
            private LinearLayout layout_01;
            private CheckBox first_checkbox;
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



    private void initShowPopularWindow(){
        View window = LayoutInflater.from(getContext()).inflate(R.layout.date_time_fragment , null);
        NumberPicker month = (NumberPicker) window.findViewById(R.id.date_time_fragment_month);
        month.setMaxValue(12);
        month.setMinValue(1);
        month.setValue(10);
        month.setFocusable(true);
        NumberPicker day = (NumberPicker) window.findViewById(R.id.date_time_fragment_day);
        day.setMaxValue(30);
        day.setMinValue(1);
        day.setValue(19);
        day.setFocusable(true);
        NumberPicker apm = (NumberPicker) window.findViewById(R.id.date_time_fragment_apm);
        String[] city = {"上午","下午"};
        apm.setDisplayedValues(city);
        apm.setMinValue(0);
        apm.setMaxValue(city.length - 1);
        apm.setFocusable(true);
        NumberPicker hour = (NumberPicker) window.findViewById(R.id.date_time_fragment_hour);
        hour.setMaxValue(12);
        hour.setMinValue(1);
        hour.setValue(10);
        hour.setFocusable(true);
        NumberPicker minute = (NumberPicker) window.findViewById(R.id.date_time_fragment_minute);
        minute.setMaxValue(59);
        minute.setMinValue(0);
        minute.setValue(10);
        minute.setFocusable(true);

        popupWindow = new PopupWindow(window,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFffffff);
        popupWindow.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        popupWindow.setAnimationStyle(R.style.AnimBottom);
        //设置在底部显示
        popupWindow.showAtLocation(window.findViewById(R.id.date_time_fragment_linearlayout),
                Gravity.BOTTOM, 0, 0);

        TextView textView = (TextView) window.findViewById(R.id.date_time_fragment_affirm);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

    }


}
