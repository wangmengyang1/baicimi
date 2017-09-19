package com.baicimi.fragments;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseApplication;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.WelcomViewpageView;


public class FragmentHeadWelcom extends BaseFragment {
	private ImageView iView;

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater
				.inflate(R.layout.welcom_head_pic, container, false);
		iView = (ImageView) view.findViewById(R.id.welcomhead_pic);
		gotoTimer();





		return view;
	}
	/**
	 * 跳转定时器
	 */
	private void gotoTimer() {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				if (BaseApplication.getInt("first") == -1) {
					startFragment(new WelcomViewpageView(), null);
				} else {
					Bundle bundle = new Bundle();
					bundle.putString("option" , "option");
					startFragment(new MainFragment(), bundle);
				}
			}
		}, 2000);
	}

	@Override
	public boolean finish() {
		return true;
	}

	@Override
	protected void initData() {
	}

}
