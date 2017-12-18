package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.UserIntegralSignInShoppingAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserIntegralSignInShoppingEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 * 个人中心首页fragment 购物所得
 */
public class UserIntegralSignInShopping extends BaseFragment implements View.OnClickListener {

    private View view;

    private ImageView back;

    private ListView listView;
    private List<UserIntegralSignInShoppingEntry> list = new ArrayList<>();
    private UserIntegralSignInShoppingAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_integral_sign_int_shopping , container , false);

        back = (ImageView) view.findViewById(R.id.user_integral_sign_int_shopping_back);
        back.setOnClickListener(this);

        //listview布局填充、
        initListView();
        return view;
    }

    //listview布局填充、
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_integral_sign_int_shopping_listview);
        list.clear();
        list.add(new UserIntegralSignInShoppingEntry("时间：2017.08.25" , "类型：政府采购" + "\n "+ "价格：10000" + "\n" + "积分：2000" + "\n" + "状态：交易成功" , R.drawable.user_integral_fragment_09 , "2017秋季新款女鞋板鞋小白鞋女韩版白搭休闲" , "颜色分类：图色  尺码：L"));
        list.add(new UserIntegralSignInShoppingEntry("时间：2017.08.25" , "类型：政府采购" + "\n "+ "价格：10000" + "\n" + "积分：2000" + "\n" + "状态：交易成功" , R.drawable.user_integral_fragment_09 , "2017秋季新款女鞋板鞋小白鞋女韩版白搭休闲" , "颜色分类：图色  尺码：L"));
        list.add(new UserIntegralSignInShoppingEntry("时间：2017.08.25" , "类型：政府采购" + "\n "+ "价格：10000" + "\n" + "积分：2000" + "\n" + "状态：交易成功" , R.drawable.user_integral_fragment_09 , "2017秋季新款女鞋板鞋小白鞋女韩版白搭休闲" , "颜色分类：图色  尺码：L"));
        list.add(new UserIntegralSignInShoppingEntry("时间：2017.08.25" , "类型：政府采购" + "\n "+ "价格：10000" + "\n" + "积分：2000" + "\n" + "状态：交易成功" , R.drawable.user_integral_fragment_09 , "2017秋季新款女鞋板鞋小白鞋女韩版白搭休闲" , "颜色分类：图色  尺码：L"));
        adapter = new UserIntegralSignInShoppingAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserIntegralSignInShoppingAdapter listAdapter = (UserIntegralSignInShoppingAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 35;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_integral_sign_int_shopping_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
