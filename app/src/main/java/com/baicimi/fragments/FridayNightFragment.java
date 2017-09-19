package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.FridayNightGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.FridayNightGvBean;
import com.baicimi.interfaces.DistributionNumberOnitemClickSecond;
import com.baicimi.ui.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/14.
 * 首页周五之夜页面
 */
public class FridayNightFragment extends BaseFragment implements AdapterView.OnItemClickListener , DistributionNumberOnitemClickSecond, View.OnClickListener {
    private MyGridView gridView_01, gridView_02, gridView_03;
    private List<FridayNightGvBean> listBeen , listBeen_02 , listBeen_03;
    private FridayNightGvAdapter xuanGvAdapter , xuanGvAdapter_02 , xuanGvAdapter_03;

    private View head;

    private LinearLayout layout_tagnumber;
    private TextView tagNumber;
    private int countNumber = 1234;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_friday_night, container, false);

        head = view.findViewById(R.id.fragment_friday_night_head);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new SerchGoodsFragment(), null);
            }
        });

        //GridView布局填充
        initGridViewFirst();

        initGridViewSecond();
        initGridViewThread();

        //标记填充
        initTagNumber();

        return view;
    }
    //标记填充
    private void initTagNumber() {
        layout_tagnumber = (LinearLayout) view.findViewById(R.id.fragment_friday_night_layout_tagnumber);
        tagNumber = (TextView) view.findViewById(R.id.fragment_friday_night_textview_tagnumber);
        layout_tagnumber.setOnClickListener(this);
    }

    private void initGridViewThread() {
        gridView_03 = (MyGridView) view.findViewById(R.id.buying_three);
        listBeen_03 = new ArrayList<>();
        listBeen_03.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_5));
        listBeen_03.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_6));
        listBeen_03.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_7));
        listBeen_03.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_9));
        xuanGvAdapter_03 = new FridayNightGvAdapter(getContext(), listBeen_03 , this , 2);
        gridView_03.setAdapter(xuanGvAdapter_03);
        gridView_03.setOnItemClickListener(this);
    }

    private void initGridViewSecond() {
        gridView_02 = (MyGridView) view.findViewById(R.id.buying_two);
        listBeen_02 = new ArrayList<>();
        listBeen_02.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_5));
        listBeen_02.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_6));
        listBeen_02.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_7));
        listBeen_02.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_9));
        xuanGvAdapter_02 = new FridayNightGvAdapter(getContext(), listBeen_02 , this , 1);
        gridView_02.setAdapter(xuanGvAdapter_02);
        gridView_02.setOnItemClickListener(this);
    }

    private void initGridViewFirst() {

        gridView_01 = (MyGridView) view.findViewById(R.id.buying_one);
        listBeen = new ArrayList<>();
        listBeen.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_5));
        listBeen.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_6));
        listBeen.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_7));
        listBeen.add(new FridayNightGvBean(new String("官方授权 自然堂乐园补水保湿保湿"), new String("¥ 100"), new String("¥ 39"), 1, R.mipmap.new_friday_9));
        xuanGvAdapter = new FridayNightGvAdapter(getContext(), listBeen , this , 0);
        gridView_01.setAdapter(xuanGvAdapter);
        gridView_01.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startFragment(new GoodsDetailsFragment(), null);
    }

    @Override
    public void setNumberOnitemClick(View view, int postion, long id , int indexView) {

        if(indexView == 0){
            if(view != null){
                switch ((int) id){
                    case R.id.fridaynight_buying_gv_item_subtract:
                        TextView textView = (TextView) this.view.findViewById(R.id.fridaynight_buying_gv_item_number_textview);
                        int number = listBeen.get(postion).getNumber()-1;
                        if(number <= 0){
                            number = 0;
                        }
                        textView.setText(number + "");
                        listBeen.get(postion).setNumber(number);
                        xuanGvAdapter.notifyDataSetChanged();
                        xuanGvAdapter_02.notifyDataSetChanged();
                        break;
                    case R.id.fridaynight_buying_gv_item_add:
                        TextView textViews = (TextView) this.view.findViewById(R.id.fridaynight_buying_gv_item_number_textview);
                        int numbers = listBeen.get(postion).getNumber()+1;
                        textViews.setText(numbers + "");
                        listBeen.get(postion).setNumber(numbers);
                        xuanGvAdapter.notifyDataSetChanged();
                        xuanGvAdapter_02.notifyDataSetChanged();
                        break;
                }
            }
        }else if (indexView == 1){
            if(view != null){
                switch ((int) id){
                    case R.id.fridaynight_buying_gv_item_subtract:
                        TextView textView = (TextView) this.view.findViewById(R.id.fridaynight_buying_gv_item_number_textview);
                        int number = listBeen_02.get(postion).getNumber()-1;
                        if(number <= 0){
                            number = 0;
                        }
                        textView.setText(number + "");
                        listBeen_02.get(postion).setNumber(number);
                        xuanGvAdapter_02.notifyDataSetChanged();
                        xuanGvAdapter.notifyDataSetChanged();
                        break;
                    case R.id.fridaynight_buying_gv_item_add:
                        TextView textViews = (TextView) this.view.findViewById(R.id.fridaynight_buying_gv_item_number_textview);
                        int numbers = listBeen_02.get(postion).getNumber()+1;
                        textViews.setText(numbers + "");
                        listBeen_02.get(postion).setNumber(numbers);
                        xuanGvAdapter_02.notifyDataSetChanged();
                        xuanGvAdapter.notifyDataSetChanged();
                        break;
                }
            }
        }else if (indexView == 2){
            if(view != null){
                switch ((int) id){
                    case R.id.fridaynight_buying_gv_item_subtract:
                        TextView textView = (TextView) this.view.findViewById(R.id.fridaynight_buying_gv_item_number_textview);
                        int number = listBeen_03.get(postion).getNumber()-1;
                        if(number <= 0){
                            number = 0;
                        }
                        textView.setText(number + "");
                        listBeen_03.get(postion).setNumber(number);
                        xuanGvAdapter_02.notifyDataSetChanged();
                        xuanGvAdapter.notifyDataSetChanged();
                        xuanGvAdapter_03.notifyDataSetChanged();
                        break;
                    case R.id.fridaynight_buying_gv_item_add:
                        TextView textViews = (TextView) this.view.findViewById(R.id.fridaynight_buying_gv_item_number_textview);
                        int numbers = listBeen_03.get(postion).getNumber()+1;
                        textViews.setText(numbers + "");
                        listBeen_03.get(postion).setNumber(numbers);
                        xuanGvAdapter_02.notifyDataSetChanged();
                        xuanGvAdapter.notifyDataSetChanged();
                        xuanGvAdapter_03.notifyDataSetChanged();
                        break;
                }
            }
        }

    }

    @Override
    public void onDetach() {
        if (view != null){
            xuanGvAdapter = null;
            xuanGvAdapter_02 = null;
            xuanGvAdapter_03 = null;
            view = null;
        }
        System.gc();
        super.onDetach();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_friday_night_layout_tagnumber:
                tagNumber.setText((countNumber++) + "");
                break;
        }
    }
}
