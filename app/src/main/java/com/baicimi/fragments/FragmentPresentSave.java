package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.PresentSaveAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PresentSave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */

public class FragmentPresentSave extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private View view;

    private ListView listView;
    private PresentSaveAdapter adapter;//适配器
    private List<PresentSave> list = new ArrayList<>();//数据源
    private PresentSave presentsave;

    private ImageView back;
    private ImageView menu;

    private RadioGroup radioGroup;
    private RadioButton card_voucher;//卡券
    private RadioButton check;//寄存
    private RadioButton present;//礼品


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_present_check , container , false);
        //进行控件查找，数据适配

        initUI();
        return view;
    }

    @Override
    protected void initData() {

    }

    private void initUI() {
        //顶部导航栏
        back = (ImageView) view.findViewById(R.id.present_check_back);
        menu = (ImageView) view.findViewById(R.id.present_check_menu);
        //设置点击事件
        back.setOnClickListener(this);

        //中部礼品，卡券，以及寄存栏
        radioGroup = (RadioGroup) view.findViewById(R.id.present_check_radiogroup);
        card_voucher = (RadioButton) view.findViewById(R.id.present_check_card_voucher);
        check = (RadioButton) view.findViewById(R.id.present_check_check);
        present = (RadioButton) view.findViewById(R.id.present_check_present);
        radioGroup.setOnCheckedChangeListener(this);

        listView = (ListView)view.findViewById(R.id.activity_present_check_lv);

        //添加数据源(虚假数据)
        for(int k = 0 ; k < 4 ; k++){
            presentsave = new PresentSave(R.id.present_check_adapter_product ,"寄存有效时长：16.09.15-16.10.15" , "PINCH洁面乳5ML+PINCH精华" , "中秋节活动礼包");
            list.add(presentsave);
        }
        //创建适配器
        adapter = new PresentSaveAdapter(getContext());
        //添加适配器数据
        adapter.setDate(list);
        adapter.setItem(2);
        //添加适配器
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.present_check_back:
                ((MainActivity) getActivity()).goBack();
                break;
            case R.id.present_check_menu:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.present_check_card_voucher:
                adapter.setItem(0);
                break;
            case R.id.present_check_check:
                list.clear();
                //添加数据源(虚假数据)
                for(int k = 0 ; k < 4 ; k++){
                    presentsave = new PresentSave(R.id.present_check_adapter_product ,"寄存有效时长：16.09.15-16.10.15" , "PINCH洁面乳5ML+PINCH精华" , "中秋节活动礼包");
                    list.add(presentsave);
                }
                //创建适配器
                adapter = new PresentSaveAdapter(getContext());
                //添加适配器数据
                adapter.setDate(list);
                adapter.setItem(1);
                //添加适配器
                listView.setAdapter(adapter);
                break;
            case R.id.present_check_present:
                list.clear();
                //添加数据源(虚假数据)
                for(int k = 0 ; k < 4 ; k++){
                    presentsave = new PresentSave(R.id.present_check_adapter_product ,"寄存有效时长：16.09.15-16.10.15" , "PINCH洁面乳5ML+PINCH精华" , "中秋节活动礼包");
                    list.add(presentsave);
                }
                //创建适配器
                adapter = new PresentSaveAdapter(getContext());
                //添加适配器数据
                adapter.setDate(list);
                adapter.setItem(2);
                //添加适配器
                listView.setAdapter(adapter);
                break;
        }
    }
}
