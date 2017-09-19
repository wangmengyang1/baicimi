package com.baicimi.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/18.
 */
@ContentView(R.layout.activity_add_address)
public class AddAdressActivity extends BaseActivity{
    @ViewInject(R.id.info_pla)
    private TextView mTvShowAddress;


    @OnClick({R.id.login_back,R.id.btn_save,R.id.info_place})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                finish();
                break;
            case R.id.btn_save:
                finish();
                break;
            case R.id.info_place:
                Intent addIntent = new Intent(getApplicationContext(),
                        SelectCitiesDialogActivity.class);
                addIntent.putExtra("address", mTvShowAddress.getText().toString());//不传参数也可以，就不会有默认选中某个值
                startActivityForResult(addIntent, 1001);
                break;
        }
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1001&&resultCode==1002){
            mTvShowAddress.setText(data.getStringExtra("address"));
        }
    }
}
