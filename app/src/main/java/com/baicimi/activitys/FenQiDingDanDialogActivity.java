package com.baicimi.activitys;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ContentView;

/**
 * Created by tan on 2017/1/16.
 * 分期订单窗口
 */
@ContentView(R.layout.activity_fenqidingdan_dialog)
public class FenQiDingDanDialogActivity extends BaseActivity{

    @Override
    protected void initData() {
        this.setFinishOnTouchOutside(true);//点击空白处关闭窗口方法
    }
}
