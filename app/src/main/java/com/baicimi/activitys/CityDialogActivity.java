package com.baicimi.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.Constants;
import com.baicimi.R;
import com.baicimi.adapter.InfoCityAdapter;
import com.baicimi.base.BaseActivity;
import com.baicimi.entity.CityEneity;
import com.baicimi.event.CityEvent;
import com.baicimi.ui.InfoCityUtils;
import com.baicimi.ui.SharedPreferencesUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;


import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * 文件名：CityDialogActivity
 * 描    述：城市列表页
 * 作    者：穆琨
 * 时    间：2016-03-01
 * 版    权：
 */
@ContentView(R.layout.activity_dialog_info_place)
public class CityDialogActivity extends BaseActivity {

    ArrayList<CityEneity> city;
    ListView city_list;
    private TextView title;
    @ViewInject(R.id.place_city)
    private TextView place_city;

    @Override
    protected void initData() {
        title = (TextView) findViewById(R.id.title_place).findViewById(R.id.info_title);
        title.setText("选择地区");

        String pcode = getIntent().getStringExtra("pcode");
        final String provinceName = getIntent().getStringExtra("province");
        city = InfoCityUtils.getInstance(this).queryCityByProvince(pcode);
        city_list = (ListView) findViewById(R.id.pla_list);
        InfoCityAdapter adapter = new InfoCityAdapter(CityDialogActivity.this, city);
        city_list.setAdapter(adapter);
        city_list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String cityName = city.get(position).getName();
                place_city.setText(provinceName + " " + cityName);
                SharedPreferencesUtil.putString(getApplicationContext(), Constants.INFO_PLACE, place_city.getText().toString());
                EventBus.getDefault().post(new CityEvent(place_city.getText().toString()));
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//		CityInfoDataSupport.getInstance(this).close();
    }
}
