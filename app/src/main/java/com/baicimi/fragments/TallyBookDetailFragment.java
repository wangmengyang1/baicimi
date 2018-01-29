package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.TallyBookDetailAdater;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 * 个人中心  我的生活助手  记账本 明细
 */
public class TallyBookDetailFragment extends BaseFragment{

    private View view;

    private ListView listViewFirst , listViewSecond;
    private List<TallyBookDetailEntry> listFirst = new ArrayList<>();
    private List<TallyBookDetailEntry> listSecond = new ArrayList<>();
    private TallyBookDetailAdater adaterFirst , adaterSecond;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tally_book_detail_fragment , container , false);

        //listview 布局填充
        initListView();
        initListViewSecond();

        return view;
    }

    private void initListViewSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.tally_book_detail_fragment_listviewsecond);
        listSecond.clear();
        listSecond.add(new TallyBookDetailEntry(R.drawable.tally_book_datail_image_06 , "嘉怡（谢嘉怡）-转账"  , "-25.00"));
        listSecond.add(new TallyBookDetailEntry(R.drawable.tally_book_datail_image_07 , "连衣裙女2016新款潮..."  , "-66.00"));
        adaterSecond = new TallyBookDetailAdater(listSecond , getContext());
        listViewSecond.setAdapter(adaterSecond);
        fixGrdiViewHeight03(listViewSecond);
    }

    private void initListView() {
        listViewFirst = (ListView) view.findViewById(R.id.tally_book_detail_fragment_listviewfirst);
        listFirst.clear();
        listFirst.add(new TallyBookDetailEntry(R.drawable.tally_book_datail_image_01 , "消费产品名称..."  , "-98.00"));
        listFirst.add(new TallyBookDetailEntry(R.drawable.tally_book_datail_image_02 , "转账明细..."  , "-137.00"));
        listFirst.add(new TallyBookDetailEntry(R.drawable.tally_book_datail_image_03 , "还款明细..."  , "44.82"));
        listFirst.add(new TallyBookDetailEntry(R.drawable.tally_book_datail_image_04 , "收发红包明细..."  , "-8.00"));
        listFirst.add(new TallyBookDetailEntry(R.drawable.tally_book_datail_image_05 , "付款卡互转..."  , "97.75"));
        adaterFirst = new TallyBookDetailAdater(listFirst , getContext());
        listViewFirst.setAdapter(adaterFirst);
        fixGrdiViewHeight03(listViewFirst);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        TallyBookDetailAdater listAdapter = (TallyBookDetailAdater) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 24;
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
