package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.TeacherEducationFirstAdapter;
import com.baicimi.adapter.TeacherEducationSecondtAdapter;
import com.baicimi.adapter.TeacherStatusRegisterAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TeacherEducationEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 * 师生专区，教育快讯
 */
public class TeacherStatusRegisterEducation extends BaseFragment implements View.OnClickListener {

    private View view;
    private LinearLayout horizontal_layout;
    private ListView listviewFirst , listviewSecond;
    private List<TeacherEducationEntry> list = new ArrayList<>();
    private List<TeacherEducationEntry> listSecond = new ArrayList<>();
    private TeacherEducationFirstAdapter adapterFirst;
    private TeacherEducationSecondtAdapter adapterSecond;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.teacher_status_register_education , container , false);

        //横向滑动layout布局添加
        initHorizontalLayout();

        //头部listview布局填充
        initHeadListView();

        //底部listview布局填充
        initBottomListView();

        back = (ImageView) view.findViewById(R.id.teacher_status_register_education_back);
        back.setOnClickListener(this);

        return view;
    }

    //底部listview布局填充
    private void initBottomListView() {
        listviewSecond = (ListView) view.findViewById(R.id.teacher_status_register_education_listview_second);
        listSecond.clear();
        listSecond.add(new TeacherEducationEntry("无偿资助——6岁孩子重返校园" , "河南信阳小山城一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书费用"));
        listSecond.add(new TeacherEducationEntry("无偿资助——6岁孩子重返校园" , "河南信阳小山城一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书费用"));
        listSecond.add(new TeacherEducationEntry("无偿资助——6岁孩子重返校园" , "河南信阳小山城一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书费用"));
        listSecond.add(new TeacherEducationEntry("无偿资助——6岁孩子重返校园" , "河南信阳小山城一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书费用"));
        adapterSecond = new TeacherEducationSecondtAdapter(listSecond , getContext());
        listviewSecond.setAdapter(adapterSecond);
        fixListViewHeight(listviewSecond , 36);
    }

    //头部listview布局填充
    private void initHeadListView() {
        listviewFirst = (ListView) view.findViewById(R.id.teacher_status_register_education_listview_first);
        list.clear();
        list.add(new TeacherEducationEntry(R.drawable.teacher_education_image_04 , "教育快讯" , "班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，"));
        list.add(new TeacherEducationEntry(R.drawable.teacher_education_image_04 , "教育快讯" , "班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，"));
        list.add(new TeacherEducationEntry(R.drawable.teacher_education_image_04 , "教育快讯" , "班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，"));
        list.add(new TeacherEducationEntry(R.drawable.teacher_education_image_04 , "教育快讯" , "班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，"));
        list.add(new TeacherEducationEntry(R.drawable.teacher_education_image_04 , "教育快讯" , "班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，班宁赞助，百次幂主办的2017高校花作展即日在上海展出，"));
        adapterFirst = new TeacherEducationFirstAdapter(list , getContext());
        listviewFirst.setAdapter(adapterFirst);
        fixListViewHeight(listviewFirst , 20);
    }

    private void initHorizontalLayout() {
        horizontal_layout  = (LinearLayout) view.findViewById(R.id.teacher_status_register_education_horizontal_layout);
        View horiontalViewItem1 = LayoutInflater.from(getContext()).inflate(R.layout.teacher_status_register_education_horiontalviewitem_first , null);
        View horiontalViewItem2 = LayoutInflater.from(getContext()).inflate(R.layout.teacher_status_register_education_horiontalviewitem_first , null);
        View horiontalViewItem3 = LayoutInflater.from(getContext()).inflate(R.layout.teacher_status_register_education_horiontalviewitem_first , null);
        View horiontalViewItem4 = LayoutInflater.from(getContext()).inflate(R.layout.teacher_status_register_education_horiontalviewitem_first , null);
        horizontal_layout.addView(horiontalViewItem1);
        horizontal_layout.addView(horiontalViewItem2);
        horizontal_layout.addView(horiontalViewItem3);
        horizontal_layout.addView(horiontalViewItem4);
    }

    @Override
    protected void initData() {

    }

    //动态计算GridView的高度
    public void fixListViewHeight(ListView listView , int marginTopBot) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        BaseAdapter listAdapter = (BaseAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
//            ViewGroup.MarginLayoutParams itempraams = (ViewGroup.MarginLayoutParams) listViewItem.getLayoutParams();
//            int topM = itempraams.topMargin;
//            int botM = itempraams.bottomMargin;
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight() + marginTopBot;
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.teacher_status_register_education_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
