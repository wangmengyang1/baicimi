package com.baicimi.activitys;

import android.content.Intent;
import android.view.View;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/18.
 */
@ContentView(R.layout.activity_guanli_address)
public class AdressGuanliActivity extends BaseActivity{


    @OnClick({R.id.login_back,R.id.add_new_address})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                finish();
                break;
            case R.id.add_new_address:
                Intent addadressintent=new Intent(this,AddAdressActivity.class);
                startActivity(addadressintent);
                break;
        }
    }

    @Override
    protected void initData() {

    }
}
