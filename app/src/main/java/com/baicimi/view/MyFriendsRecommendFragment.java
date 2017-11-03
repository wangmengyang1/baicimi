package com.baicimi.view;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.HomePageViewButtonAdapte;
import com.baicimi.adapter.MyFriendsRecommendAdapte;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MyFriendsRecommendFragmentEntry;
import com.baicimi.fragments.MyFriendsRecommendAddFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  百万行动计划  推荐好友
 */

@SuppressLint("ValidFragment")
public class MyFriendsRecommendFragment extends BaseFragment implements View.OnClickListener {


    private String libleString;//标题内容
    private String contentString;//内容
    private int listIndex;
    private String nextContentString;//下次推荐
    private View view;

    private TextView lible;
    private TextView content;
    private TextView nextContent;
    private ImageView back;

    private GridView gridview;
    private List<MyFriendsRecommendFragmentEntry> list = new ArrayList<>();
    private MyFriendsRecommendAdapte adapter;

    public MyFriendsRecommendFragment(String libleString, String contentString, int listIndex, String nextContentString) {
        this.libleString = libleString;
        this.contentString = contentString;
        this.listIndex = listIndex;
        this.nextContentString = nextContentString;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_friends_recommend_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.my_friends_recommend_fragment_back);
        back.setOnClickListener(this);

        init();

        //listview布局填充
        initListView(listIndex);

        return view;
    }

    //listview布局填充
    private void initListView(int count) {
        if (count == 4){
            gridview = (GridView) view.findViewById(R.id.my_friends_recommend_fragment_gridview);
            list.clear();
            list.add(new MyFriendsRecommendFragmentEntry("姓名：张三" , "电话：1325463832135" , "邮箱：132546383@qq.com" , "微信号：1325463832135" , "推荐状态：成功" , true));
            list.add(new MyFriendsRecommendFragmentEntry("姓名：张三" , "电话：1325463832135" , "邮箱：132546383@qq.com" , "微信号：1325463832135" , "推荐状态：等待" , true));
            list.add(new MyFriendsRecommendFragmentEntry("姓名：张三" , "电话：1325463832135" , "邮箱：132546383@qq.com" , "微信号：1325463832135" , "推荐状态：超时" , true));
            list.add(new MyFriendsRecommendFragmentEntry("姓名：张三" , "电话：1325463832135" , "邮箱：132546383@qq.com" , "微信号：1325463832135" , "推荐状态：添加" , true));
            adapter = new MyFriendsRecommendAdapte(list , getContext());
            gridview.setAdapter(adapter);
            fixGridViewHeight(gridview);
        }else if (count == 2){
            gridview = (GridView) view.findViewById(R.id.my_friends_recommend_fragment_gridview);
            list.clear();
            list.add(new MyFriendsRecommendFragmentEntry("姓名：张三" , "电话：1325463832135" , "邮箱：132546383@qq.com" , "微信号：1325463832135" , "推荐状态：无" , false));
            list.add(new MyFriendsRecommendFragmentEntry("姓名：张三" , "电话：1325463832135" , "邮箱：132546383@qq.com" , "微信号：1325463832135" , "推荐状态：添加" , true));
            adapter = new MyFriendsRecommendAdapte(list , getContext());
            gridview.setAdapter(adapter);
            fixGridViewHeight(gridview);
        }

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (list.get(i).getState().equals("推荐状态：成功")){
                    RecommendSucceedDialog recommendSucceedDialog = new RecommendSucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    recommendSucceedDialog.show();
                }else if (list.get(i).getState().equals("推荐状态：等待")){
                    RecommendUnreceivedDialog recommendUnreceivedDialog = new RecommendUnreceivedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    recommendUnreceivedDialog.show();
                }else if (list.get(i).getState().equals("推荐状态：超时")){
                    RecommendOvertimeDialog recommendOvertimeDialog = new RecommendOvertimeDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    recommendOvertimeDialog.show();
                }else if (list.get(i).getState().equals("推荐状态：添加")){
                    startFragment(new MyFriendsRecommendAddFragment());
                }
            }
        });



    }


    //动态计算listview的高度
    public void fixGridViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MyFriendsRecommendAdapte listAdapter = (MyFriendsRecommendAdapte) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/2; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 60;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
    }


    private void init() {
        lible = (TextView) view.findViewById(R.id.my_friends_recommend_fragment_libles);
        content = (TextView) view.findViewById(R.id.my_friends_recommend_fragment_recommend_usernumber);
        nextContent = (TextView) view.findViewById(R.id.my_friends_recommend_fragment_nextrecommend);
        lible.setText(libleString);
        content.setText(contentString);
        nextContent.setText(nextContentString);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_friends_recommend_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
