package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class FragmentClassifySearch extends BaseFragment {

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		view=inflater.inflate(R.layout.fragment_classify_search,container,false);
		return view;
	}

	@Override
	protected void initData() {

	}

	@OnClick(R.id.login_back)
	public void OnClicks(View view){
		((MainActivity) getActivity()).goBack();
	}

}
