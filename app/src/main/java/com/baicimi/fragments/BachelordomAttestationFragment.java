package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.DissmessDramDialog;

/**
 * Created by Administrator on 2017/11/15.
 * 个人中心，设置，人生重要时刻认证，发起认证界面 单身认证详情页
 */
public class BachelordomAttestationFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmess;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.bache_lordom_attestation_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.bache_lordom_attestation_fragment_back);
        back.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.bache_lordom_attestation_fragment_dissmess);
        dissmess.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bache_lordom_attestation_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.bache_lordom_attestation_fragment_dissmess:
                //提交梦想单
                DissmessDramDialog dissmessDramDialog = new  DissmessDramDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                dissmessDramDialog.show();
                break;
        }
    }
}
