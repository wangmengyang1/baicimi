package com.baicimi.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/8/14.
 * 幂钱包生活服务首页
 */
public class MiWalletLiveServer extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back , seek;
    private LinearLayout paythefees , refer ,weather;

    private EditText edittext;
    private TextView cancel;
    private boolean isCheck;
    private ImageView image_sousuo;

    private LinearLayout layout_seek;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_live_server, container , false);

        //控件查找
        init();

        return view;
    }

    //控件查找
    private void init() {
        back = (ImageView) view.findViewById(R.id.login_back_live_server);
        seek = (ImageView) view.findViewById(R.id.mi_wallet_live_server_seek);
        back.setOnClickListener(this);
        seek.setOnClickListener(this);
        paythefees = (LinearLayout) view.findViewById(R.id.mi_wallet_live_server_paythefees);
        refer = (LinearLayout) view.findViewById(R.id.mi_wallet_live_server_refer);
        weather = (LinearLayout) view.findViewById(R.id.mi_wallet_live_server_weather);
        paythefees.setOnClickListener(this);
        refer.setOnClickListener(this);
        weather.setOnClickListener(this);

        edittext = (EditText) view.findViewById(R.id.mi_wallet_live_server_edittext);
        image_sousuo = (ImageView) view.findViewById(R.id.mi_wallet_live_server_sousuo);
        cancel = (TextView) view.findViewById(R.id.mi_wallet_live_server_cancle);
        cancel.setOnClickListener(this);

        layout_seek = (LinearLayout) view.findViewById(R.id.mi_wallet_live_server_seek_layout);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_back_live_server:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.mi_wallet_live_server_paythefees:
                startFragment(new MiWalletLiveServerPaythefeesFragment());
                break;
            case R.id.mi_wallet_live_server_refer:
                break;
            case R.id.mi_wallet_live_server_weather:
                startFragment(new MiWalletLiveServerWeatherFragment());
                break;
            case R.id.mi_wallet_live_server_seek:
                if(isCheck == false){
                    edittext.setVisibility(View.VISIBLE);
                    image_sousuo.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                    seek.setVisibility(View.INVISIBLE);
                    layout_seek.setVisibility(View.VISIBLE);
                    isCheck = !isCheck;
                }
                break;
            case R.id.mi_wallet_live_server_cancle:
                if(isCheck == true){
                    edittext.setVisibility(View.GONE);
                    image_sousuo.setVisibility(View.GONE);
                    cancel.setVisibility(View.GONE);
                    layout_seek.setVisibility(View.GONE);
                    seek.setVisibility(View.VISIBLE);
                    isCheck = !isCheck;
                }
                break;


        }
    }
}
