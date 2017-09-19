package com.baicimi.view;


import com.baicimi.R;
import com.baicimi.base.BaseApplication;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ViewPopupMenu extends LinearLayout {
    private Context context;
    private OnPopupClickListener onPopupClickListener;

    private RadioGroup rg;
    @ViewInject(R.id.rb_sort_default)
    private RadioButton faqi;
    @ViewInject(R.id.rb_sort_hot)
    private RadioButton simi;

    public void setOnPopupClickListener(
            OnPopupClickListener onPopupClickListener) {
        this.onPopupClickListener = onPopupClickListener;
    }

    public ViewPopupMenu(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = inflate(context, R.layout.view_massge_my_news,
                this);
        ViewUtils.inject(this, view);
        initSelect(BaseApplication.getInt("currentSelect"));
    }


    private void initSelect(int currentSelect) {
        switch (currentSelect) {
            case 0:
                faqi.setSelected(true);
                break;
            case 1:
                simi.setSelected(true);
                break;
        }
    }

        @OnClick({R.id.rb_sort_default,R.id.rb_sort_hot})
        public void onClicks (View view){
            switch (view.getId()) {
                case R.id.rb_sort_default:
                    BaseApplication.putInt("currentSelect", 0);
                    if (onPopupClickListener != null) {
                        onPopupClickListener.onPopupClick(view);
                        selectState(true, false);

                    }

                    break;

                case R.id.rb_sort_hot:
                    BaseApplication.putInt("currentSelect", 1);
                    if (onPopupClickListener != null) {
                        onPopupClickListener.onPopupClick(view);
                        selectState(true, false);
                    }

            }
        }


    private void selectState(boolean b, boolean c) {
        faqi.setSelected(b);
        simi.setSelected(c);
    }


    public interface OnPopupClickListener {
        void onPopupClick(View view);
    }

}
