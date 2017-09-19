package com.baicimi.view;

import java.util.ArrayList;
import java.util.List;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.fragments.MainFragment;
import com.baicimi.ui.NavImgLayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomViewpageView extends BaseFragment implements
		OnPageChangeListener {

	Context context;
	private ViewPager vp;
	private ViewPagerAdapter vpa;
	private NavImgLayout nil;
	private Button btn;
	private List<Integer> id = new ArrayList<Integer>();

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater
				.inflate(R.layout.view_welcom, container, false);
		vp = (ViewPager) view.findViewById(R.id.vp_nav);
		nil = (NavImgLayout) view.findViewById(R.id.welcom_navlayout);

		btn = (Button) view.findViewById(R.id.btn_welcom);
		id.add(R.mipmap.welcome1);
		id.add(R.mipmap.welcome2);
		id.add(R.mipmap.welcome3);
		id.add(R.mipmap.welcome4);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Bundle bundle = new Bundle();
				bundle.putString("option" , "option");
				startFragment(new MainFragment(), bundle);
			}
		});
		return view;
	}

	@Override
	protected void initMState() {
		vpa = new ViewPagerAdapter(id);
		vp.setAdapter(vpa);
		vp.setOnPageChangeListener(this);
		nil.setCount(id.size());

	}

	@Override
	protected void initData() {
	}

	@Override
	public void onPageScrollStateChanged(int state) {
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int position) {
		nil.selectByIndex(position);
		if (position == 3) {
			nil.setVisibility(View.GONE);
			btn.setVisibility(View.VISIBLE);
		} else if (position != 3) {
			nil.setVisibility(View.VISIBLE);
			btn.setVisibility(View.GONE);
		}
	}

	// Viewpage��������
	class ViewPagerAdapter extends PagerAdapter {
		private List<ImageView> vpdatas;// ���ĸ�д���ģ����صģ�ͼƬ

		public ViewPagerAdapter(List<Integer> datas) {
			vpdatas = new ArrayList<ImageView>();
			if (datas != null && datas.size() > 0) {
				for (int i = 0; i < datas.size(); i++) {
					Integer civ = datas.get(i);
					ImageView imageView = new ImageView(getActivity());
					imageView.setBackgroundResource(civ);
					vpdatas.add(imageView);
				}
			}
		}

		@Override
		public int getCount() {
			return vpdatas.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(vpdatas.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(vpdatas.get(position));
			return vpdatas.get(position);
		}
	}

	@Override
	public boolean finish() {
		return true;
	}
}
