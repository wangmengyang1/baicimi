package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.MifridedsJurisdtionAdapter;
import com.baicimi.entity.MifridedsJurisdtionEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public class BolckManagementDialog extends Dialog{
    public BolckManagementDialog(Context context) {
        super(context);
    }

    public BolckManagementDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BolckManagementDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    private ListView listView;
    private List<MifridedsJurisdtionEntry> list = new ArrayList<>();
    private MifridedsJurisdtionAdapter adapter;

    private TextView dissmess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bolck_managment_dialog);

//        listView = (ListView) findViewById(R.id.mi_fridends_jurisdiction_listview);
//        list.clear();
//        list.add(new MifridedsJurisdtionEntry(R.drawable.mi_friends_jurisdtion_image_02 , "越努力越幸运" , true));
//        list.add(new MifridedsJurisdtionEntry(R.drawable.mi_friends_jurisdtion_image_02 , "云淡风轻" , false));
//        list.add(new MifridedsJurisdtionEntry(R.drawable.mi_friends_jurisdtion_image_02 , "sophia" , false));
//        list.add(new MifridedsJurisdtionEntry(R.drawable.mi_friends_jurisdtion_image_02 , "MIKE" , false));
//        list.add(new MifridedsJurisdtionEntry(R.drawable.mi_friends_jurisdtion_image_02 , "TOMORROW" , false));
//        list.add(new MifridedsJurisdtionEntry(R.drawable.mi_friends_jurisdtion_image_02 , "越努力越幸运" , false));
//        adapter = new MifridedsJurisdtionAdapter(list , getContext());
//        listView.setAdapter(adapter);

        dissmess = (TextView) findViewById(R.id.bolck_namegment_dissmess);
        dissmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
