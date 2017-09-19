package com.baicimi.http;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

public class ImageUtils {
	private static BitmapUtils mButils;

	private static BitmapDisplayConfig mconfig;

	public static void getImageByUrl(Context context, String url,
			ImageView imageView) {
		mButils = new BitmapUtils(context);
		mconfig = new BitmapDisplayConfig();
		mconfig.setBitmapConfig(Bitmap.Config.RGB_565);
		mButils.display(imageView, url, mconfig);
	}

}
