package com.baicimi.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public abstract class BaseView extends LinearLayout {

	protected View view;
	protected Context mcontext;
	public BaseView(Context context) {
		super(context);
		this.mcontext = context;
		initData();
		initView();
		initEvent();
	}
	public abstract void initEvent();
	protected abstract void initData(); 
	public abstract void initView();

}
