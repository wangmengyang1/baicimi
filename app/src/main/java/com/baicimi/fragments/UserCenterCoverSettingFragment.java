package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.CustomGovernmentEntry;
import com.baicimi.view.AutomaticSelectionDialog;
import com.baicimi.view.CoverSettingFirstDialog;
import com.baicimi.view.CustomExpandableListView;
import com.baicimi.view.IntegerParticularsDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 * 个人中心  封面设置
 */

public class UserCenterCoverSettingFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private CustomExpandableListView customExpandableListView  , customExpandableListViewSecond;
    private List<CustomGovernmentEntry> gruopList = new ArrayList<>();
    private List<CustomGovernmentEntry> gruopListSecond = new ArrayList<>();
    private List<List<View>> childList = new ArrayList<>();
    private List<List<View>> childListSecond = new ArrayList<>();
    private UserCenterCoverSettingFragment.PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapter;
    private UserCenterCoverSettingFragment.PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapterSecond;
    private TextView management;

    private CheckBox checkBox;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_cover_setting_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.usercenter_cover_setting_fragment_back);
        back.setOnClickListener(this);


        //下拉菜单布局添加
        initCusListView();

        //second下拉布局添加
        initSecondSusListView();

        management = (TextView) view.findViewById(R.id.usercenter_cover_setting_fragment_management);
        management.setOnClickListener(this);

        checkBox = (CheckBox) view.findViewById(R.id.usercenter_cover_setting_fragment_checkbox);
        checkBox.setOnClickListener(this);

        return view;
    }

    //second下拉布局添加
    private void initSecondSusListView() {
        customExpandableListViewSecond = (CustomExpandableListView) view.findViewById(R.id.usercenter_cover_setting_fragment_customlistview_second);
        customExpandableListViewSecond.setGroupIndicator(null);
        gruopListSecond.clear();
        gruopListSecond.add(new CustomGovernmentEntry("七月菊"  , null));
        gruopListSecond.add(new CustomGovernmentEntry("七月菊"  , null));

        List<View> childView01  = new ArrayList<>();
        childView01.clear();
        childView01.add(LayoutInflater.from(getContext()).inflate(R.layout.user_center_cover_setting_custom_listview_childitme , null));
        childListSecond.add(childView01);
        adencyGovernmentCusAdaapterSecond = new PaymentAdencyGovernmentCusAdaapter();
        customExpandableListViewSecond.setAdapter(adencyGovernmentCusAdaapterSecond);
    }

    //下拉菜单布局添加
    private void initCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.usercenter_cover_setting_fragment_customlistview);
        customExpandableListView.setGroupIndicator(null);
        gruopList.clear();
        gruopList.add(new CustomGovernmentEntry("宁菲"  , null));
        gruopList.add(new CustomGovernmentEntry("七月菊"  , null));

        List<View> childView01  = new ArrayList<>();
        childView01.clear();
        childView01.add(LayoutInflater.from(getContext()).inflate(R.layout.user_center_cover_setting_custom_listview_childitme , null));
        childList.add(childView01);
        adencyGovernmentCusAdaapter = new PaymentAdencyGovernmentCusAdaapter();
        customExpandableListView.setAdapter(adencyGovernmentCusAdaapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_cover_setting_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.usercenter_cover_setting_fragment_management:
                CoverSettingFirstDialog coverSettingFirstDialog = new CoverSettingFirstDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                coverSettingFirstDialog.show();
                break;
            case R.id.usercenter_cover_setting_fragment_checkbox:
                AutomaticSelectionDialog automaticSeoectionDialog = new AutomaticSelectionDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                automaticSeoectionDialog.show();
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
            return childList.size();
        }

        @Override
        public Object getGroup(int i) {
            return gruopList.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return childList.get(i1);
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
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            UserCenterCoverGroupHolder holder = null;
            if (view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.usercenter_coversetting_group , null);
                holder = new UserCenterCoverGroupHolder();
                holder.lible = (TextView) view.findViewById(R.id.usercenter_coversetting_group_lible);
                view.setTag(holder);
            }else{
                holder = (UserCenterCoverGroupHolder) view.getTag();
            }

            holder.lible.setText(gruopList.get(i).getLible());

            return view;
        }

        public class UserCenterCoverGroupHolder{
            private TextView lible;
        }


        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView integer = null;
            if (view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.user_center_cover_setting_custom_listview_childitme , null);
                integer = (TextView) view.findViewById(R.id.user_center_cover_setting_custom_listview_childitem_integer);
                integer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        IntegerParticularsDialog intgerParticularsDialog = new IntegerParticularsDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                        intgerParticularsDialog.show();
                    }
                });
            }

            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }
}
