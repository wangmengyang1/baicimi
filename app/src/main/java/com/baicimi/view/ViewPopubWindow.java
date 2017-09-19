package com.baicimi.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.baicimi.R;
import com.lidroid.xutils.ViewUtils;

/**
 * Created by tan on 2016/8/16.
 */
public class ViewPopubWindow extends LinearLayout {
    private Context context;
    private OnPopupClickListener onPopupClickListener;

    public void setOnPopupClickListener(
            OnPopupClickListener onPopupClickListener) {
        this.onPopupClickListener = onPopupClickListener;
    }

    public ViewPopubWindow(Context context) {
        super(context);
    }

    private void initView() {
        View view = inflate(context, R.layout.fragment_person_cehua,
                this);
        ViewUtils.inject(this, view);
    }


    public interface OnPopupClickListener{
        void onPopupClick(View view);
    }

}
