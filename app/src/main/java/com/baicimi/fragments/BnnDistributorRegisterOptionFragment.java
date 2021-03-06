package com.baicimi.fragments;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.addressseloct.GetJsonDataUtil;
import com.baicimi.addressseloct.JsonBean;
import com.baicimi.base.BaseFragment;
import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */

public class BnnDistributorRegisterOptionFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private Spinner  spinner_02;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;


    private LinearLayout spinner;
    private TextView spinner_tv;

    private TextView licenseTv;//营业执照图片添加
    private TextView addLayout;//店铺门面照添加
    private LinearLayout layout;

    //地址选择器

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private boolean isLoaded = false;


    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread==null){//如果已创建就不再重新创建子线程了

                        //开始进行数据解析
//                        Toast.makeText(JsonDateActivity.this,"Begin Parse Data",Toast.LENGTH_SHORT).show();
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 写子线程中的操作,解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
                    //数据解析成功
//                    Toast.makeText(JsonDateActivity.this,"Parse Succeed",Toast.LENGTH_SHORT).show();
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
                    //数据解析失败
//                    Toast.makeText(JsonDateActivity.this,"Parse Failed",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.bnn_distributor_register_option , container , false);

        spinner = (LinearLayout) view.findViewById(R.id.bnn_distributor_register_spinner);
        spinner_tv = (TextView) view.findViewById(R.id.bnn_distributor_register_spinner_tv);

        mHandler.sendEmptyMessage(MSG_LOAD_DATA);


        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLoaded){
                    ShowPickerView();
                }else {
                    Toast.makeText(getContext(),"Please waiting until the data is parsed",Toast.LENGTH_SHORT).show();
                }

            }
        });


        spinner_02 = (Spinner) view.findViewById(R.id.bnn_distributor_register_spinner_02);
        initSpinnerSecond(spinner_02);


        licenseTv = (TextView) view.findViewById(R.id.bnn_distributor_register_option_license);
        licenseTv.setOnClickListener(this);

        addLayout = (TextView) view.findViewById(R.id.bnn_distributor_register_option_addlayout);
        addLayout.setOnClickListener(this);

        layout = (LinearLayout) view.findViewById(R.id.bnn_distributor_register_option_layout);
        return view;
    }

    //数字选择器进行适配
    private void initSpinnerSecond(Spinner spinner) {
        //数据
        data_list = new ArrayList<String>();

        data_list.add(" 零售 ");
        data_list.add("  批发  ");


        //适配器
        arr_adapter= new ArrayAdapter<String>(getContext(), R.layout.person_centered_spinner_item_textview, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }



    @Override
    protected void initData() {

    }


    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }


    private void ShowPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(getContext(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()+
                        options2Items.get(options1).get(options2)+
                        options3Items.get(options1).get(options2).get(options3);

                //弹窗，提示选择地址位置
                spinner_tv.setText(tx);
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(14)
                .build();

        pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(getContext(),"province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i=0;i<jsonBean.size();i++){//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c=0; c<jsonBean.get(i).getCityList().size(); c++){//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        ||jsonBean.get(i).getCityList().get(c).getArea().size()==0) {
                    City_AreaList.add("");
                }else {

                    for (int d=0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bnn_distributor_register_option_license:
                licenseTv.setText("图片");
                licenseTv.setPadding(12 , 12 , 12 , 12);
                break;
            case R.id.bnn_distributor_register_option_addlayout:
                addLayout.setText("图片");
                addLayout.setPadding(12 , 12 , 12 , 12);
                layout.setVisibility(View.VISIBLE);
                break;
        }
    }
}
