package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.SpinnerDialogAdapterAdapters;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.SettingUerMesMoerDateClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 * 上传回执单添加图片页面
 */

public class SettingUerMessageMoreDateDialog extends Dialog {


    private SettingUerMesMoerDateClick listener;

    public SettingUerMessageMoreDateDialog(Context context) {
        super(context);
    }

    public SettingUerMessageMoreDateDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    private ListView listView;
    private SpinnerDialogAdapterAdapters adapterAdapters;
    private List<String> list = new ArrayList<>();
    private int id;

    public SettingUerMessageMoreDateDialog(Context context, int themeResId , List<String> list
            , SettingUerMesMoerDateClick listener , int id) {
        super(context, themeResId);
        this.list = list;
        this.listener = listener;
        this.id = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_dialog_adapter);

        initListView();

    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) findViewById(R.id.spinner_dialog_adapter_listview);
        adapterAdapters = new SpinnerDialogAdapterAdapters(list , getContext());
        listView.setAdapter(adapterAdapters);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listener.getShowLible(list.get(i) , id);
                dismiss();
            }
        });

    }
}
