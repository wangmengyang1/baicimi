package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心，封面设置分类页
 */
public class UserCenterCoverSettingCatalogyFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView appreciation;

    private ImageView back;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_cover_setting_catalogy_fragment , container , false);

        appreciation= (TextView) view.findViewById(R.id.usercenter_cover_setting_catalog_fragment_appreciation);
        appreciation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //封面设置
                startFragment(new UserCenterCoverSettingFragment());
            }
        });

        back = (ImageView) view.findViewById(R.id.usercenter_cover_setting_catalogy_fragment_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_cover_setting_catalogy_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
