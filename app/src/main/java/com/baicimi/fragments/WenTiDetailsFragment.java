package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/10/8.
 * 问题详情界面
 */
@SuppressLint("ValidFragment")
public class WenTiDetailsFragment extends BaseFragment{

    private TextView lible;
    private String libles = "";
    private TextView content;
    private String content_tv = "";
    private int indent;
    private ImageView image_integer;

    private RelativeLayout frequently_question , online_server , live_message;


    public WenTiDetailsFragment(String libles) {
        this.libles = libles;
    }

    public WenTiDetailsFragment(String libles, String content_tv , int indent) {
        this.libles = libles;
        this.content_tv = content_tv;
        this.indent = indent;

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_wenti_details,container,false);

        lible = (TextView) view.findViewById(R.id.fragment_wenti_details_lible);
        lible.setText(libles);

        content = (TextView) view.findViewById(R.id.fragment_wenti_details_textview_content);
        content.setText(content_tv);
        image_integer = (ImageView) view.findViewById(R.id.fragment_wenti_details_textview_image_integer);
        if (indent == 2){
            if (libles.equals("1、如何使用积分抵扣现金？")){
                //显示图片
                image_integer.setVisibility(View.VISIBLE);
            }
        }

        //常见问题，在线客服，留言反馈
        initQuestion();

        return view;
    }
    //常见问题，在线客服，留言反馈
    private void initQuestion() {
        frequently_question = (RelativeLayout) view.findViewById(R.id.fragment_wenti_details_frequently_question);
        online_server = (RelativeLayout) view.findViewById(R.id.fragment_wenti_details_online_server);
        live_message = (RelativeLayout) view.findViewById(R.id.fragment_wenti_details_leavemessage);

    }

    @OnClick({R.id.login_back ,R.id.fragment_wenti_details_frequently_question ,R.id.fragment_wenti_details_online_server , R.id.fragment_wenti_details_leavemessage })
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.fragment_wenti_details_frequently_question://常见问题
                startFragment(new WentiDetailsFrequentlyQuention());
                break;
            case R.id.fragment_wenti_details_online_server://在线客服
                startFragment(new WenTidetailsOnlineServer());
                break;
            case R.id.fragment_wenti_details_leavemessage://留言反馈
                startFragment(new WentidetailsLeavMessage());
                break;
        }
    }
    @Override
    protected void initData() {

    }
}
