package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/19.
 * 上传回执单添加图片页面
 */

public class RecommendRegisterSucceedDialog extends Dialog {
    public RecommendRegisterSucceedDialog(Context context) {
        super(context);
    }

    public RecommendRegisterSucceedDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView are ,deny ;
    private BaseFragment baseFragment;

    public RecommendRegisterSucceedDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_register_succeed_dialog);

        are = (TextView) findViewById(R.id.recommend_register_succeed_dialog_true);
        are.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                AddFriendsDialog addFriendsDialog = new AddFriendsDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                addFriendsDialog.show();
            }
        });


        deny = (TextView) findViewById(R.id.recommend_register_succeed_dialog_false);
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                FriendsInformDialog friendsInformDialog = new FriendsInformDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                friendsInformDialog.show();
            }
        });

    }
}
