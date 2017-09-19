package com.baicimi.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.baicimi.BuildConfig;

import org.xutils.x;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by tan on 2016/8/10.
 */
public class BaseApplication extends Application {
	private static SharedPreferences share;
	private static SharedPreferences.Editor editor;
	public Context context;
	@Override
	public void onCreate() {
		super.onCreate();

		context = getApplicationContext();
		initShared();

		//注册xutils3
		x.Ext.init(this);
		x.Ext.setDebug(BuildConfig.DEBUG);

		//极光推送
		JPushInterface.setDebugMode(true);
		JPushInterface.init(getApplicationContext());

//		SDKInitializer.initialize(getApplicationContext());

		//此处用于oom的堆栈分析
//		if (LeakCanary.isInAnalyzerProcess(this)) {
//			// This process is dedicated to LeakCanary for heap analysis.
//			// You should not init your app in this process.
//			return;
//		}
//		LeakCanary.install(this);


	}

	/**
	 * 初始化共享参数
	 */
	private void initShared() {
		share = getSharedPreferences("config", MODE_PRIVATE);
		editor = share.edit();

	}

	/**
	 * 操作共享参数
	 *
	 * @param key
	 * @param value
	 */
	public static void putString(String key, String value) {
		editor.putString(key, value);
		editor.commit();
	}

	public static String getString(String key) {
		return share.getString(key, null);
	}

	public static int getInt(String key) {
		return share.getInt(key, -1);
	}

	public static void putInt(String key, int value) {
		editor.putInt(key, value);
		editor.commit();
	}
	

}