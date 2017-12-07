package com.baicimi.fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页 运动
 */
public class FootPaintPlayFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView playTextview;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.foot_paint_play_fragment , container , false);

        playTextview = (TextView) view.findViewById(R.id.foot_play_fragment_play);
        playTextview.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.foot_play_fragment_play:
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://ditu.google.cn/maps?hl=zh&mrt=loc&q=31.1198723,121.1099877(上海青浦大街100号)"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK & Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intent);
                break;
        }
    }
}
