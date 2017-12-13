package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 * 幂积分银行 存储
 */
public class MiIntegralBrankStorageFragment extends BaseFragment implements View.OnClickListener {

    private View view;

    //下拉菜单布局添加
    private CustomExpandableListView customExpandableListView;
    private List<String> gruopList = new ArrayList<>();
    private List<List<View>> childList = new ArrayList<>();
    private PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapter;

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_storage_fragmetn , container , false);

        //下拉菜单布局添加
        initCusListView();

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_storage_fragmetn_back);
        back.setOnClickListener(this);
        return view;
    }

    //下拉菜单布局添加
    private void initCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.mi_integral_brank_storage_fragmetn_cusendlistview);
        customExpandableListView.setGroupIndicator(null);
        gruopList.clear();
        gruopList.add("活期储蓄");
        gruopList.add("定期储蓄∨");




        List<View> list_01 = new ArrayList<>();

        List<View> list_02 = new ArrayList<>();
        list_02.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_storage_childfirst, null));


        childList.add(list_01);
        childList.add(list_02);


        adencyGovernmentCusAdaapter = new PaymentAdencyGovernmentCusAdaapter();
        customExpandableListView.setAdapter(adencyGovernmentCusAdaapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_storage_fragmetn_back:
                ((MainActivity)getActivity()).goBack();
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
            if (i == 0){
                return 0;
            }else{
                return 1;
            }

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
            if (i == 1){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_storage_childfirst , null);
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
