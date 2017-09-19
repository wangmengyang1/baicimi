package com.baicimi.activitys;

import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.InfoCityAdapter;
import com.baicimi.base.BaseActivity;
import com.baicimi.entity.CityEneity;
import com.baicimi.ui.InfoCityUtils;

import org.xutils.view.annotation.ContentView;

import java.util.ArrayList;


/**
 * 文件名：DistrictDialogActivity
 * 描    述：省列表页
 * 作    者：穆琨
 * 时    间：2016-03-01
 * 版    权：
 */
@ContentView(R.layout.activity_dialog_info_place)
public class DistrictDialogActivity extends BaseActivity {

    ArrayList<CityEneity> district;
    ListView district_list;
    private TextView title;

    @Override
    protected void initData() {
        title = (TextView) findViewById(R.id.title_place).findViewById(R.id.info_title);
        title.setText("选择地区");

        String cityId = getIntent().getStringExtra("cityCode");
        district = InfoCityUtils.getInstance(this).queryDistrictByCity(
                cityId);
        district_list = (ListView) findViewById(R.id.pla_list);
        InfoCityAdapter adapter = new InfoCityAdapter(DistrictDialogActivity.this,
                district);
        district_list.setAdapter(adapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//		CityInfoDataSupport.getInstance(this).close();
    }
}
