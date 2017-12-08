package com.baicimi.fragments;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.MiPeopleChatAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.AuthenticationEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 * 个人中心首页 幂聊首页
 */
public class MiPeopleChatFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private GridView gridViewFirst , gridViewSecond;
    private List<AuthenticationEntry> listFirst , listSecond;
    private MiPeopleChatAdapter adapterFirst , adapterSecond;
    private LinearLayout layout;
    private boolean state = false;
    private int girdViewHeight;
    private RelativeLayout layout_frist;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_people_chat_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.mi_people_chat_fragment_back);
        back.setOnClickListener(this);

        //GridView布局填充
        initFirstGridView();
        initSecondGridView();

        layout = (LinearLayout) view.findViewById(R.id.mi_people_chat_fragment_gridview_first_layout);
        layout.setOnClickListener(this);
        layout_frist = (RelativeLayout) view.findViewById(R.id.mi_people_chat_fragment_gridview_first_layout_first);
        return view;
    }

    private void initSecondGridView() {
        gridViewSecond = (GridView) view.findViewById(R.id.mi_people_chat_fragment_gridview_second);
        listSecond = new ArrayList<>();
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_11 , "订单中心"));
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_13 , "幂银行"));
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_14 , "我的积分"));
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_15 , "亲密付"));
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_16 , "红包"));
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_17 , "我的购物袋"));
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_18 , "幂钱包"));
        listSecond.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_19 , "帮助中心"));
        adapterSecond = new MiPeopleChatAdapter(listSecond , getContext());
        gridViewSecond.setAdapter(adapterSecond);
        fixGridViewHeight(gridViewSecond);
        gridViewSecond.setVisibility(View.INVISIBLE);

    }

    //GridView布局填充
    private void initFirstGridView() {
        gridViewFirst = (GridView) view.findViewById(R.id.mi_people_chat_fragment_gridview_first);
        listFirst = new ArrayList<>();
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_03 , "扫一扫"));
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_04 , "运动"));
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_05 , "全球生活汇"));
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_06 , "添加朋友"));
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_07 , "发布"));
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_08 , "照片/相机"));
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_09 , "文件夹"));
        listFirst.add(new AuthenticationEntry(R.drawable.mi_people_chat_fragment_image_10 , "幂聊"));
        adapterFirst = new MiPeopleChatAdapter(listFirst , getContext());
        gridViewFirst.setAdapter(adapterFirst);
        fixGridViewHeight(gridViewFirst);

        gridViewFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //加号页面幂聊
                startFragment(new MiPeopleChatAddFragment());
            }
        });

    }


    //动态计算listview的高度
    public void fixGridViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MiPeopleChatAdapter listAdapter = (MiPeopleChatAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/4; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 24;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
        girdViewHeight = params.height;
//        System.out.println(girdViewHeight + "_______________________________");
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_people_chat_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_people_chat_fragment_gridview_first_layout:
                if (!state){
//                    Animation animas = AnimationUtils.loadAnimation(getContext() , R.anim.mi_people_chat_fragment_gridview_trastion);
//                    layout_frist.startAnimation(animas);

                    ObjectAnimator.ofFloat(layout_frist , "translationY" , -350).setDuration(400).start();
//                    gridViewFirst.setVisibility(View.INVISIBLE);
                    gridViewSecond.setVisibility(View.VISIBLE);
                    Animation anima = AnimationUtils.loadAnimation(getContext() , R.anim.mi_people_chat_fragment_gridview_alpha);
                    gridViewSecond.startAnimation(anima);
                }else{
                    ObjectAnimator.ofFloat(layout_frist , "translationY" , 0).setDuration(400).start();
                    Animation anima = AnimationUtils.loadAnimation(getContext() , R.anim.mi_people_chat_fragment_gridview_alpha_second);
                    gridViewSecond.startAnimation(anima);
                    gridViewSecond.setVisibility(View.INVISIBLE);
                }

                state = !state;
                break;
        }
    }
}
