package com.baicimi.view;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.baicimi.R;

public class ViewLoad extends FrameLayout {

	private ImageView imageView;

	private AnimationDrawable animationDrawable;

	public ViewLoad(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		LayoutInflater.from(getContext()).inflate(R.layout.view_load, this,true);
		imageView = (ImageView) this.findViewById(R.id.iv_wait);
		animationDrawable = (AnimationDrawable) imageView.getBackground();
	}

	public void start(){
		this.setVisibility(View.VISIBLE);
		animationDrawable.start();
	}
	
	public void stop(){
		this.setVisibility(View.GONE);
		animationDrawable.stop();
	}

}
