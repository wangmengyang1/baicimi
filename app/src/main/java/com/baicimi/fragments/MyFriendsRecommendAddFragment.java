package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.RecommendAddRequestDialog;
import com.baicimi.view.RecommendAddSucceedDialog;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  好友推荐  推荐好友
 */
public class MyFriendsRecommendAddFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmess;
    private boolean ischeck;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_friends_recommend_add_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.my_friends_recommend_add_fragment_back);
        back.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.my_friends_recommend_add_fragment_dissmessrecommend);
        dissmess.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_friends_recommend_add_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.my_friends_recommend_add_fragment_dissmessrecommend:
                if (ischeck){
                    RecommendAddSucceedDialog recommendAddSucceedDialog = new  RecommendAddSucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    recommendAddSucceedDialog.show();
                }else{
                    RecommendAddRequestDialog recommendAddRequestDialog = new RecommendAddRequestDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    recommendAddRequestDialog.show();
                }
                ischeck = (!ischeck);
                break;
        }
    }
}
