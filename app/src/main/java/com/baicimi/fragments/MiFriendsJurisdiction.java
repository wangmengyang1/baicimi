package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.MiFriendsJurisdictionDialog;

/**
 * Created by Administrator on 2017/10/27.
 * 个人中心  设置  隐私管理  幂友权限
 */
public class MiFriendsJurisdiction extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ImageView image_first , image_second;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_friends_jurisdition , container , false);
        back = (ImageView) view.findViewById(R.id.mi_fridends_jurisdiction_back);
        back.setOnClickListener(this);
        image_first = (ImageView) view.findViewById(R.id.mi_friends_jurisdtion_image_first);
        image_second = (ImageView) view.findViewById(R.id.mi_friends_jurisdtion_image_second);
        image_first.setOnClickListener(this);
        image_second.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_fridends_jurisdiction_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.mi_friends_jurisdtion_image_first:
//                MiFriendsJurisdictionDialog miFriendsJurisdictionDialog = new MiFriendsJurisdictionDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
//                miFriendsJurisdictionDialog.show();
                break;
            case R.id.mi_friends_jurisdtion_image_second:
                MiFriendsJurisdictionDialog miFriendsJurisdictionDialog = new MiFriendsJurisdictionDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                miFriendsJurisdictionDialog.show();
                break;
        }
    }
}
