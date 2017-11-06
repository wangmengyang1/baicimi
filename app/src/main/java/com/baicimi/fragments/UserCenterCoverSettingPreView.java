package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.CoverSettingFirstReplaceDialog;

/**
 * Created by Administrator on 2017/10/30.
 * 个人中心，封面设置  封面预览
 */
public class UserCenterCoverSettingPreView extends BaseFragment implements View.OnClickListener {

    private View view;

    private ImageView back;
    private TextView use;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_cover_setting_preview , container , false);

        back = (ImageView) view.findViewById(R.id.usercenter_cover_setting_preview_back);
        back.setOnClickListener(this);

        use = (TextView) view.findViewById(R.id.user_center_cover_setting_preview_use);
        use.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_cover_setting_preview_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.user_center_cover_setting_preview_use:
                //确定替换
                CoverSettingFirstReplaceDialog coverSettingFirstReplaceDialog = new CoverSettingFirstReplaceDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                coverSettingFirstReplaceDialog.show();
                break;
        }
    }
}
