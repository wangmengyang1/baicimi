package com.baicimi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.baicimi.R;

/**
 * Created by Administrator on 2017/9/11.
 */

public class IntegralSlideViewFootPaint extends View {

    private Paint paint;
    private Rect rect;

    private Context content;
    private int width;
    private int height;

    public IntegralSlideViewFootPaint(Context context) {
        super(context);
        initPaint();
        content = context;
    }

    public IntegralSlideViewFootPaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        content = context;
    }

    public IntegralSlideViewFootPaint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        content = context;
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        rect = new Rect();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_footpaint_springview, options);
        bitmap = zoomImg(bitmap , 55 , 55);
        canvas.drawBitmap(bitmap , 0 , 0 , paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(55 , 55);
    }

    // 缩放图片
    public static Bitmap zoomImg(Bitmap bm, int newWidth , int newHeight){
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }


}
