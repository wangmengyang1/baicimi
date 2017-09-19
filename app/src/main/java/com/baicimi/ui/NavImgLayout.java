package com.baicimi.ui;




import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.R;

/**
 *  ����Сͼ��ؼ�
 */
public class NavImgLayout extends LinearLayout{

    private int checkedimg, uncheckedimg, imgcount;
    private LayoutParams layoutParams;
    private int index = 0;

    public NavImgLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        paresAttr(attrs);
        initView();
    }

    private void initView() {
        this.removeAllViews();
        layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 5;
        layoutParams.rightMargin = 5;
        this.setGravity(Gravity.CENTER);
        if(imgcount > 0){
            for(int i = 0; i < imgcount; i++){
                ImageView iv = new ImageView(getContext());
                if(i == index){
                    iv.setImageResource(checkedimg);
                    iv.setTag("checked");
                } else {
                    iv.setImageResource(uncheckedimg);
                }
                iv.setLayoutParams(layoutParams);
                this.addView(iv);
            }
        }
    }

    /**
     * �����Զ�������
     * @param attrs
     */
    private void paresAttr(AttributeSet attrs){
        TypedArray ta = getResources().obtainAttributes(attrs, R.styleable.navattr);
        checkedimg = ta.getResourceId(R.styleable.navattr_checkedimg, 0);
        uncheckedimg = ta.getResourceId(R.styleable.navattr_uncheckedimg, 0);
        imgcount = ta.getInt(R.styleable.navattr_count, 0);
    }


    /**
     * ���������Ϊ�±�Ϊindex��ѡ�е�״̬
     * @param index
     */
    public void selectByIndex(int index){
        ImageView checkedIv = (ImageView) this.findViewWithTag("checked");
        checkedIv.setImageResource(uncheckedimg);
        checkedIv.setTag(null);

        ImageView iv = (ImageView) this.getChildAt(index);
        iv.setImageResource(checkedimg);
        iv.setTag("checked");
    }

    public void setCount(int imgcount){
        this.imgcount = imgcount;
        initView();
    }

    public void next(){
        if(index != imgcount - 1){
            index++;
            selectByIndex(index);
        }
    }


    public void above(){
        if(index != 0){
            index--;
            selectByIndex(index);
        }
    }

    public int getImgcount() {
        return imgcount;
    }

    public int getIndex() {
        return index;
    }
}
