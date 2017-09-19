package com.baicimi.image;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * 关于图片轮播的页面图片轮播的图片加载器
 * Created by Administrator on 2017/3/29.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.with(context)
                .load((Integer) path)
                .into(imageView);
    }
    @Override
    public ImageView createImageView(Context context) {
        return super.createImageView(context);
    }
}
