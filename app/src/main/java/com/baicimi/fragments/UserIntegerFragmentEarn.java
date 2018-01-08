package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.ComplaintSuggestSecondAdapter;
import com.baicimi.adapter.EranListViewAdater;
import com.baicimi.adapter.GatherListViewAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.EranEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心，会员积分页面 赚取积分
 */
public class UserIntegerFragmentEarn extends BaseFragment{

    private View view;
    private ListView listView;
    private List<EranEntry> list = new ArrayList<>();
    private EranListViewAdater adater;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_integer_fragment_earn , container , false);

        //listview布局填充
        initListView();
        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_integre_fragment_earnint_listview);
        list.clear();
        list.add(new EranEntry(R.drawable.user_integer_image_06 , "01.推荐给好友" , "了解详情" , "现在推荐" , "推荐朋友成为百次幂会员，可获得积分，在被推荐者每次成功购买商品时，都会有相应比例积分自动转到您的个人账户下。"));
        list.add(new EranEntry(R.drawable.earm_code_image_02 , "02.晒图留言" , "null" , "我去晒图" , "您在百次幂商城购买商品后，在评论区晒图留言，即可获得相应积分，留言被其他人浏览，均有相应积分自动转入到您的个人账户。"));
        list.add(new EranEntry(R.drawable.earm_code_image_03 , "03.购买商品" , "null" , "去逛逛" , "线上购买：在百次幂商城购买任意产品都可获得积分，系统根据成交金额将自动获得的积分转到您的个人积分账户中，线下购买，在实体店购买产品，刮开瓶身积分码并输入，积分立即累计到个人账户。"));
        list.add(new EranEntry(R.drawable.earm_code_image_04 , "04.每日签到" , "null" , "马上签到" , "百次幂商城手机APP每日签到即可获得相应积分。"));
        list.add(new EranEntry(R.drawable.earm_code_image_05 , "05.积分活动" , "null" , "去看看" , "参加百次幂积分商城活动，即可赚取或获赠相应积分。"));
        list.add(new EranEntry(R.drawable.earm_code_image_06 , "06.社区评论" , "null" , "去全球生活汇" , "全球生活汇APP上发帖与互动也可获得相应积分。"));
        adater = new EranListViewAdater(list , getContext() , this);
        listView.setAdapter(adater);
        fixGrdiViewHeight03(listView);

    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        EranListViewAdater listAdapter = (EranListViewAdater) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 16;
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
}
