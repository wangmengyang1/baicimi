package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/27.
 * 试用申请 试用报告 查看全部试用报告页面 详情页
 */
public class TryoutApplyForSecondMoreReportDetails extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tryout_apply_for_second_more_report_details , container , false);

        back = (ImageView) view.findViewById(R.id.tryout_apply_for_second_more_report_details_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tryout_apply_for_second_more_report_details_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
