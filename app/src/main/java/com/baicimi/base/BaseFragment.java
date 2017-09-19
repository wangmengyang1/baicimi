package com.baicimi.base;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.lidroid.xutils.ViewUtils;

import java.util.LinkedList;

public abstract class BaseFragment extends Fragment{
	protected View view;

	private int fId;

	public BaseFragment() {
		fId++;
	}

	public static final int LAST_CLICK_GAP = 600;
	public long lastClickTime = 0;
//	private long mExitTime = 0;
//	public static final int EXIT_TIME_GAP = 2000;
	private LinkedList<String> mFragments = new LinkedList<String>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		view = initView(inflater, container);
		ViewUtils.inject(this, view);
		onGetBundle(getArguments());
		view.setClickable(true);     //把View的click属性设为true，截断点击时间段扩散,防止Fragment击穿
		return view;
	}

	public String getMTag() {
		return this.getClass().getName() + fId;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		initMState();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//加载数据在子线程中
//		ThreadPoolUtils.runInThreadTask(new Runnable() {
//			@Override
//			public void run() {
//				initData();// 必须实现，但要不知道怎么实现，给子类
//			}
//		});

	}

	// 必须实现，但要不知道怎么实现，给子类
	protected abstract View initView(LayoutInflater inflater,
									 ViewGroup container);


	/**
	 * 初始化监听器
	 */
	protected void initListener(){
	}


	/**
	 * 初始化数据
	 */
	protected abstract void initData();

	// 子类初始化一些状态
	protected void initMState() {

	}

	// 可以获取上一个Fragment传过来的数据
	protected void onGetBundle(Bundle bundle) {

	}

	public View getRootView() {
		return view;
	}

	// 把控制返回键的权利交给了Fragment
	public boolean onBack() {
		return false;
	}

	// 子类可以控制生命
	public boolean finish() {
		return false;
	}

	// Fragment 开启
	public void startFragment(BaseFragment fragment, Bundle bundle ) {
		if (getActivity() instanceof MainActivity) {
			((MainActivity) getActivity()).startFragment(fragment, bundle);
		}
	}


	public void startFragment(BaseFragment fragment) {
		startFragment(fragment, null);
	}


	@Override
	public void onDestroyView() {
		super.onDestroyView();
		System.gc();
	}
}
