package com.baicimi.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.ui.SharedPreferencesUtil;

import org.xutils.view.annotation.ViewInject;

import java.util.Arrays;
import java.util.List;

public class ListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView lvCountry;
    private List<String> country;
    private String SPLIT_STR = "\\+";
    @ViewInject(R.id.login_back)
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lvCountry = (ListView) findViewById(R.id.lv_country);
        String[] data = getResources().getStringArray(R.array.cities_data);
        country = Arrays.asList(data);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, country);
        lvCountry.setAdapter(adapter);
        lvCountry.setOnItemClickListener(this);

    }

    @Override
    protected void initData() {
//        btn_back.setOnClickListener(new View.OnClickListener() {//返回上一层
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (country != null && country.get(position) != null) {
            String[] params = country.get(position).split(SPLIT_STR);
            if (params.length >= 1 && params[1] != null)
                SharedPreferencesUtil.putCountry(this, "+" + params[1]);
        }
        finish();
    }
}
