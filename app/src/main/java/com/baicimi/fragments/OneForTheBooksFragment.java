package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.OneForTheBooksAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.AuthenticationEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 * 个人中心  我的生活助手  记账本 记一笔
 */
public class OneForTheBooksFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private GridView gridView;
    private List<AuthenticationEntry> list = new ArrayList<>();
    private OneForTheBooksAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.one_for_the_books_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.one_for_the_books_fragment_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        return view;
    }

    private void initListView() {
        gridView = (GridView) view.findViewById(R.id.onefor_the_books_fragment_gridview);
        list.clear();
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_06 , "一般"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_12 , "餐饮"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_13 , "购物"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_14 , "服饰"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_15 , "交通"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_16 , "娱乐"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_17 , "社交"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_18 , "居家"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_19 , "通讯"));
        list.add(new AuthenticationEntry(R.drawable.tally_book_datail_image_20 , "零食"));
        adapter = new OneForTheBooksAdapter(list , getContext());
        gridView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.one_for_the_books_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
