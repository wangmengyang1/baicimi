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

public class RedPacketSharedDialog extends Dialog {
    public RedPacketSharedDialog(Context context) {
        super(context);
    }

    public RedPacketSharedDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private TextView dissmess , deny;
    private BaseFragment baseFragment;

    public RedPacketSharedDialog(Context context, int themeResId , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red_packet_shard_dialog);

//        dissmess = (TextView) findViewById(R.id.add_frienda_dialog_true);
//        dissmess.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });
//        deny = (TextView) findViewById(R.id.add_frienda_dialog_false);
//        deny.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });

    }
}
