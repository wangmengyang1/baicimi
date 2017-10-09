package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/9.]
 * 商品详情，信息，客户服务，问题详情，在线客服
 */
public class WenTidetailsOnlineServer extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.wenti_details_online_server , container , false);
        back = (ImageView) view.findViewById(R.id.wenti_detalis_online_server_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.wenti_detalis_online_server_back:
                ((MainActivity)getActivity()).goBack();//返回到上一界面
                break;
        }
    }
}
