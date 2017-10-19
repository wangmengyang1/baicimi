package com.baicimi.fragments;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.addressseloct.GetJsonDataUtil;
import com.baicimi.addressseloct.JsonBean;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.BooleanEntry;
import com.baicimi.entity.CustomGovernmentEntry;
import com.baicimi.view.CommonalityTransferDialog;
import com.baicimi.view.CustomExpandableListView;
import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 * 政府采购，快速申请通道
 */
public class GovernmentPurchaseFastTrackProcedure extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private LinearLayout spinner;
    private TextView address;

    //地址选择器

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private boolean isLoaded = false;


    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread==null){//如果已创建就不再重新创建子线程了

                        //开始进行数据解析
//                        Toast.makeText(JsonDateActivity.this,"Begin Parse Data",Toast.LENGTH_SHORT).show();
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 写子线程中的操作,解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
                    //数据解析成功
//                    Toast.makeText(JsonDateActivity.this,"Parse Succeed",Toast.LENGTH_SHORT).show();
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
                    //数据解析失败
//                    Toast.makeText(JsonDateActivity.this,"Parse Failed",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };



    //下拉菜单布局添加
    private CustomExpandableListView customExpandableListView;
    private List<CustomGovernmentEntry> gruopList = new ArrayList<>();
    private List<List<View>> childList = new ArrayList<>();
    private GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapter;

    private List<List<BooleanEntry>> groupBoolean = new ArrayList<>();//用来保存并记录下拉菜单的数据

    GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFirst holder_01 = null;
    GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSecond holder_02 = null;
    GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderThread holder_03 = null;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.government_purchase_fast_track_procedure , container , false);


        address = (TextView) view.findViewById(R.id.government_purchase_fast_track_procedure_address);


        mHandler.sendEmptyMessage(MSG_LOAD_DATA);

        spinner = (LinearLayout) view.findViewById(R.id.government_purchase_fast_track_procedure_layout);

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLoaded){
                    ShowPickerView();
                }else {
                    Toast.makeText(getContext(),"Please waiting until the data is parsed",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //下拉菜单布局添加
        initCusListView();

        back = (ImageView) view.findViewById(R.id.government_purchase_fast_track_procedure_back);
        back.setOnClickListener(this);

        return view;
    }


    //下拉菜单布局添加
    private void initCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.government_purchase_fast_track_procedure_customlistview);
        customExpandableListView.setGroupIndicator(null);
        gruopList.clear();
        gruopList.add(new CustomGovernmentEntry("发票要求", ""));
        gruopList.add(new CustomGovernmentEntry("发票内容", ""));
        gruopList.add(new CustomGovernmentEntry("支付方式", ""));
//        gruopList.add(new CustomGovernmentEntry("分期支付", "【激活分期】免息购买"));
//        gruopList.add(new CustomGovernmentEntry("使用积分", "有可用积分"));
//        gruopList.add(new CustomGovernmentEntry("优惠券", "有可用券"));

        childList.clear();
        List<View> list_01 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.government_purchase_fast_track_procedure_first_itme, null));
        List<View> list_02 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.government_purchase_fast_track_procedure_second_itme, null));
        List<View> list_03 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_thread, null));
//        List<View> list_04 = new ArrayList<>();
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        List<View> list_05 = new ArrayList<>();
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        List<View> list_06 = new ArrayList<>();
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
//        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.fragment_null, null));
        childList.add(list_01);
        childList.add(list_02);
        childList.add(list_03);
//        childList.add(list_04);
//        childList.add(list_05);
//        childList.add(list_06);
        adencyGovernmentCusAdaapter = new GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter();
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.government_purchase_fast_track_procedure_back:
                ((MainActivity)getActivity()).goBack();//返回
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
            GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusGroupHolder holder = null;

            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adeny_government_sus_group_adapter, null);
                holder = new GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusGroupHolder();
                holder.lible = (TextView) view.findViewById(R.id.payment_adeny_government_susgroup_adapter_lible);
                holder.conbtent = (TextView) view.findViewById(R.id.payment_adeny_government_susgroup_adapter_content);
                view.setTag(holder);
            } else {
                holder = (GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusGroupHolder) view.getTag();
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

                    view = LayoutInflater.from(getContext()).inflate(R.layout.government_purchase_fast_track_procedure_first_itme, null);
                    holder_01 = new GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFirst();
                    holder_01.layout_01 = (LinearLayout) view.findViewById(R.id.government_purchase_fast_track_procedure_first_itme_layout_01);
                    holder_01.layout_02 = (LinearLayout) view.findViewById(R.id.government_purchase_fast_track_procedure_first_itme_layout_02);
                    holder_01.checkBox01 = (CheckBox) view.findViewById(R.id.government_purchase_fast_track_procedure_first_itme_checkbox_01);
                    holder_01.checkBox02 = (CheckBox) view.findViewById(R.id.government_purchase_fast_track_procedure_first_itme_checkbox_02);
                    view.setTag(holder_01);
                } else {
                    holder_01 = (GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderFirst) view.getTag();
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
                    }
                });

                holder_01.layout_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);
                        holder_01.checkBox02.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });
                holder_01.checkBox01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(true);

                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });
                holder_01.checkBox02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_01.checkBox01.setChecked(false);

                        holder_01.checkBox02.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });


                return view;

            } else if (i == 1) {
                view = null;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.government_purchase_fast_track_procedure_second_itme, null);
                    holder_02 = new GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSecond();
                    holder_02.layout_01 = (LinearLayout) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_layout_01);
                    holder_02.layout_02 = (LinearLayout) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_layout_02);
                    holder_02.layout_03 = (LinearLayout) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_layout_03);
                    holder_02.layout_04 = (LinearLayout) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_layout_04);
                    holder_02.checkBox01 = (CheckBox) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_checkbox_01);
                    holder_02.checkBox02 = (CheckBox) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_checkbox_02);
                    holder_02.checkBox03 = (CheckBox) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_checkbox_03);
                    holder_02.checkBox04 = (CheckBox) view.findViewById(R.id.government_purchase_fast_track_procedure_second_itme_checkbox_04);

                    view.setTag(holder_02);
                } else {
                    holder_02 = (GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderSecond) view.getTag();
                }


                if (groupBoolean.get(i).get(i1).getIndex() == 0) {
                    holder_02.checkBox01.setChecked(true);
                    holder_02.checkBox02.setChecked(false);
                    holder_02.checkBox03.setChecked(false);
                    holder_02.checkBox04.setChecked(false);
                } else if (groupBoolean.get(i).get(i1).getIndex() == 1) {
                    holder_02.checkBox01.setChecked(false);
                    holder_02.checkBox02.setChecked(true);
                    holder_02.checkBox03.setChecked(false);
                    holder_02.checkBox04.setChecked(false);
                }else if (groupBoolean.get(i).get(i1).getIndex() == 2) {
                    holder_02.checkBox01.setChecked(false);
                    holder_02.checkBox02.setChecked(false);
                    holder_02.checkBox03.setChecked(true);
                    holder_02.checkBox04.setChecked(false);
                }else if (groupBoolean.get(i).get(i1).getIndex() == 3) {
                    holder_02.checkBox01.setChecked(false);
                    holder_02.checkBox02.setChecked(false);
                    holder_02.checkBox03.setChecked(false);
                    holder_02.checkBox04.setChecked(true);
                }

                holder_02.layout_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(true);
                        holder_02.checkBox02.setChecked(false);
                        holder_02.checkBox03.setChecked(false);
                        holder_02.checkBox04.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });

                holder_02.layout_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(true);
                        holder_02.checkBox03.setChecked(false);
                        holder_02.checkBox04.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });

                holder_02.layout_03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(false);
                        holder_02.checkBox03.setChecked(true);
                        holder_02.checkBox04.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(2);
                    }
                });

                holder_02.layout_04.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(false);
                        holder_02.checkBox03.setChecked(false);
                        holder_02.checkBox04.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(3);
                    }
                });


                holder_02.checkBox01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(true);
                        holder_02.checkBox02.setChecked(false);
                        holder_02.checkBox03.setChecked(false);
                        holder_02.checkBox04.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(0);
                    }
                });
                holder_02.checkBox02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(true);
                        holder_02.checkBox03.setChecked(false);
                        holder_02.checkBox04.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(1);
                    }
                });

                holder_02.checkBox03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(false);
                        holder_02.checkBox03.setChecked(true);
                        holder_02.checkBox04.setChecked(false);
                        groupBoolean.get(i).get(i1).setIndex(2);
                    }
                });

                holder_02.checkBox04.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder_02.checkBox01.setChecked(false);
                        holder_02.checkBox02.setChecked(false);
                        holder_02.checkBox03.setChecked(false);
                        holder_02.checkBox04.setChecked(true);
                        groupBoolean.get(i).get(i1).setIndex(3);
                    }
                });


                return view;
            } else if (i == 2) {
                view = null;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.payment_adency_gov_child_adapter_thread, null);
                    holder_03 = new GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderThread();
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
                    holder_03 = (GovernmentPurchaseFastTrackProcedure.PaymentAdencyGovernmentCusAdaapter.PaymentAdencyGovernmentCusChildHolderThread) view.getTag();
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
            } else {

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
            private LinearLayout layout_03;
            private LinearLayout layout_04;
            private CheckBox checkBox01;
            private CheckBox checkBox02;
            private CheckBox checkBox03;
            private CheckBox checkBox04;
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



    @Override
    protected void initData() {

    }




    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

    private void ShowPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()+
                        options2Items.get(options1).get(options2)+
                        options3Items.get(options1).get(options2).get(options3);

                //弹窗，提示选择地址位置
                address.setText(tx);
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(14)
                .build();

        pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(getContext(),"province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i=0;i<jsonBean.size();i++){//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c=0; c<jsonBean.get(i).getCityList().size(); c++){//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        ||jsonBean.get(i).getCityList().get(c).getArea().size()==0) {
                    City_AreaList.add("");
                }else {

                    for (int d=0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);

    }


}
