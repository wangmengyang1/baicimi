package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.UserIdentityAuthenticationAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserIdentityAuthenticationEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 * 个人中心  密码找回 验证身份
 */
public class UserIdentityAuthentication extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listView;
    private List<UserIdentityAuthenticationEntry> list = new ArrayList<>();
    private UserIdentityAuthenticationAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_identity_authentication , container , false);

        back = (ImageView) view.findViewById(R.id.user_identity_authentication_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();
        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_identity_authentication_listview);
        list.clear();
        list.add(new UserIdentityAuthenticationEntry("通过绑定银行卡" , "绑定你的银行卡进行验证"));
        list.add(new UserIdentityAuthenticationEntry("通过绑定银行卡" , "绑定你的银行卡进行验证"));
        list.add(new UserIdentityAuthenticationEntry("通过绑定银行卡" , "绑定你的银行卡进行验证"));
        list.add(new UserIdentityAuthenticationEntry("通过绑定银行卡" , "绑定你的银行卡进行验证"));
        adapter = new UserIdentityAuthenticationAdapter(list , getContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //个人中心  密码找回 验证身份手机号验证+证件验证
                startFragment(new UserIdentityAuthenticationSecond());
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_identity_authentication_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
