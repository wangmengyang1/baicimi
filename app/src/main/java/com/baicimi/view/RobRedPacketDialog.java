package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.fragments.RedPacketGetthedetailsFragment;

/**
 * Created by Administrator on 2017/9/19.
 * 上传回执单添加图片页面
 */

public class RobRedPacketDialog extends Dialog {
    public RobRedPacketDialog(Context context) {
        super(context);
    }

    public RobRedPacketDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    private ImageView dissmess;
    private boolean ischecked;
    private LinearLayout ischeckedLayout_first , ischeckedLayout_Second;
    private TextView flaunt , rob  ,record;

    private BaseFragment baseFragment;

    public RobRedPacketDialog(Context context, int themeResId , boolean ischecked , BaseFragment baseFragment ) {
        super(context, themeResId);
        this.ischecked = ischecked;
        this.baseFragment = baseFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rob_redpacket_dialog);

        dissmess = (ImageView) findViewById(R.id.rob_redpacket_dialog_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        ischeckedLayout_first = (LinearLayout) findViewById(R.id.rob_redpacket_dialog_ischecklayout);
        ischeckedLayout_Second = (LinearLayout) findViewById(R.id.rob_redpacket_dialog_ischecklayout_02);

        flaunt = (TextView) findViewById(R.id.rob_redpacket_dialog_flaunt);
        rob = (TextView) findViewById(R.id.rob_redpacket_dialog_rob);

        if (ischecked){
            ischeckedLayout_first.setVisibility(View.INVISIBLE);
            ischeckedLayout_Second.setVisibility(View.VISIBLE);

            flaunt.setText("求安慰");
            rob.setText("我来发红包");
        }else {
            ischeckedLayout_first.setVisibility(View.VISIBLE);
            ischeckedLayout_Second.setVisibility(View.INVISIBLE);
        }

        record = (TextView) findViewById(R.id.rob_redpacket_dialog_record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baseFragment != null){
                    //红包领取详情
                    baseFragment.startFragment(new RedPacketGetthedetailsFragment());
                }

            }
        });


//        deny = (TextView) findViewById(R.id.add_frienda_dialog_false);
//        deny.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });

    }
}
