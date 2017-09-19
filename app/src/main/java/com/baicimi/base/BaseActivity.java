package com.baicimi.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.lidroid.xutils.ViewUtils;

import org.xutils.x;


/**
 * 文件名：BaseAvtivity
 * 描    述：共有属性基类
 * 作    者：tan
 * 时    间：2016-09-18
 * 版    权：
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        x.view().inject(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initData();
    }


    /**
     * 后退按钮
     *
     * @param v
     */
    public void btnFinish(View v) {
        finish();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();


}
