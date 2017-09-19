package com.baicimi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tan on 2016/9/21.
 * 物流信息View
 */
public class WuliuViewThree extends View {
    private int mMaginTop;          //物流信息距离顶部magin
    private int mMaginMsg;          //时间距离物流信息magin
    private int mWidth;             //屏幕宽度
    private int mLineWidth;         //竖直线占条目的宽度
    private TextPaint mTextPaint;   //画物流信息的画笔

    private int mTextHeight;        //物流信息的高度
    private int mMaginBottom;       //时间距离条目底部的宽度
    private int mHeight;                    //条目高度
    private StaticLayout mStaticLayout;
    private Rect mBound;
    private String mMsg;
    private Paint mTimePaint;        //时间画笔
    private int mTimeHeight;         //时间文字高度

    public WuliuViewThree(Context context) {
        super(context);
        init();
    }

    public WuliuViewThree(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WuliuViewThree(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mMaginTop = dp2px(10);            //15dp
        mMaginBottom = mMaginTop;

        mMaginMsg = dp2px(5);             //时间和信息距离5dp

        mLineWidth = dp2px(40);          //竖直线占40dp

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);  //抗锯齿
        mTextPaint.setDither(true);                           //仿抖动
        mTextPaint.setColor(0xFFCBCBCB);
        mTextPaint.setTextSize(dp2px(14));                  //
        mTextPaint.setTextAlign(Paint.Align.LEFT);          //左下角对齐

        mMsg = "【广州市】广东广州公司已发出                            ";
        mBound = new Rect(); //通过边框可以获得文字的高度
        mTextPaint.getTextBounds(mMsg, 0, mMsg.length(), mBound);
        mTextHeight = mBound.height(); //得到文字高度
        mTimePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTimePaint.setDither(true);
        mTimePaint.setColor(0xFFCBCBCB);
        mTimePaint.setTextSize(dp2px(12));
        mTimePaint.setTextAlign(Paint.Align.LEFT);
        mTimePaint.setTypeface(Typeface.DEFAULT_BOLD);
        Rect boun = new Rect(); //同上理得到时间文字的高度
        mTimePaint.getTextBounds("7",0,1,boun);
        mTimeHeight = boun.height();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mStaticLayout=new StaticLayout(mMsg, mTextPaint, mWidth - mLineWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, false);
        mTextHeight = mStaticLayout.getHeight();
        mHeight = mMaginTop + mTextHeight + mMaginMsg + mTimeHeight + mMaginBottom;//条目高度
        setMeasuredDimension(mWidth, mHeight); //由此确定条目的高度
    }




    @Override
    protected void onDraw(Canvas canvas) {
        mTimePaint.setColor(0xFFCBCBCB);
        canvas.save();
        canvas.translate(mLineWidth, mMaginTop);
//        canvas.drawText(mMsg,mLineWidth,mMaginTop+mTextHeight,mTextPaint); //画信息
        mStaticLayout.draw(canvas);  //画信息
        canvas.restore();
        canvas.drawText(getFormateTime(new Date(System.currentTimeMillis())), mLineWidth, mMaginTop + mTextHeight +
                mMaginMsg + mTimeHeight, mTimePaint);//画时间

        mTimePaint.setColor(Color.GRAY);//左边那条线 //参数一线起点x坐标,参数二线起点y坐标，参数3,4是终点坐标
        canvas.drawLine(mLineWidth/2,mMaginTop + mBound.height(),mLineWidth/2,mHeight,mTimePaint);

        mTimePaint.setColor(0xFFFFFFFF);//外面的更大的圆，但带点透明
        canvas.drawCircle(mLineWidth/2,mMaginTop + mBound.height() /2,mBound.height()/2,mTimePaint);

        mTimePaint.setColor(0xFFCBCBCB); //内部更小的圆不透明和外面圆形成光晕
        canvas.drawCircle(mLineWidth/2,mMaginTop + mBound.height() /2,mBound.height()/2 - dp2px(2),mTimePaint);

        mTimePaint.setColor(Color.GRAY);  //画底部那条线
        canvas.drawLine(mLineWidth,mHeight,mWidth,mHeight,mTimePaint);
    }

    public int dp2px(float dp) {
        return (int) (getResources().getDisplayMetrics().density * dp + .5f);
    }

    public String getFormateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}