package com.baicimi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.ActuenticationAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.AuthenticationEntry;
import com.baicimi.fragments.PersonCenteredActhenticationEnterprise;
import com.baicimi.fragments.PersonCenteredActhenticationUser;
import com.baicimi.fragments.PersonCenteredFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 * //账号认证弹出对话框
 */

public class AuthenticationDialog extends Dialog {

    private GridView gridView;
    private List<AuthenticationEntry> list = new ArrayList<>();
    private ActuenticationAdapter adapter;
    private BaseFragment personCenteredFragment;
    private String tag;

    private List<String> list_lible = new ArrayList<>();
    private String enterprise  = "普通企业认证";
    private String catering = "餐饮企业认证" ;
    private String government = "政府机构认证" ;
    private String teacher = "教师/学生认证" ;
    private String lvxing = "旅游企业认证" ;
    private String user = "个人认证" ;


    private Context context;
    public AuthenticationDialog(Context context) {
        super(context);
        this.context = context;
    }

    public AuthenticationDialog(Context context, int themeResId , BaseFragment fragment , String tag) {
        super(context, themeResId);
        this.context = context;
        personCenteredFragment = fragment;
        this.tag = tag;
    }

    protected AuthenticationDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_lible.clear();
        setContentView(R.layout.person_centered_acthentication_fragment);
        //GridView布局填充
        initGridView();

    }

    //GridView布局填充
    private void initGridView() {
        if (tag == null){
            gridView = (GridView) findViewById(R.id.person_centered_acthentication_fragment_grdiview);
            list.clear();
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_01 , new String("普通企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_02 , new String("餐饮企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_03 , new String("政府机构认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_04 , new String("教师/学生认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_05 , new String("旅游企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_06 , new String("个人认证")));
            list_lible.add(enterprise);
            list_lible.add(catering);
            list_lible.add(government);
            list_lible.add(teacher);
            list_lible.add(lvxing);
            list_lible.add(user);

        }else if (tag.equals("个人认证")){
            gridView = (GridView) findViewById(R.id.person_centered_acthentication_fragment_grdiview);
            list.clear();
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_01 , new String("普通企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_02 , new String("餐饮企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_03 , new String("政府机构认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_04 , new String("教师/学生认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_05 , new String("旅游企业认证")));
            list_lible.add(enterprise);
            list_lible.add(catering);
            list_lible.add(government);
            list_lible.add(teacher);
            list_lible.add(lvxing);
        }else if (tag.equals("普通企业认证")){
            gridView = (GridView) findViewById(R.id.person_centered_acthentication_fragment_grdiview);
            list.clear();
//            list.add(new AuthenticationEntry(R.drawable.actuentication_image_01 , new String("普通企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_02 , new String("餐饮企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_03 , new String("政府机构认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_04 , new String("教师/学生认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_05 , new String("旅游企业认证")));
            list.add(new AuthenticationEntry(R.drawable.actuentication_image_06 , new String("个人认证")));

            list_lible.add(catering);
            list_lible.add(government);
            list_lible.add(teacher);
            list_lible.add(lvxing);
            list_lible.add(user);

        }

        adapter = new ActuenticationAdapter(getContext() , list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (list_lible.get(i)){
                    case "个人认证":
                        dismiss();
                        personCenteredFragment.startFragment(new PersonCenteredActhenticationUser() );
                        break;
                    case "普通企业认证":
                        dismiss();
                        personCenteredFragment.startFragment(new PersonCenteredActhenticationEnterprise() );
                        break;
                }

            }
        });


    }

}
