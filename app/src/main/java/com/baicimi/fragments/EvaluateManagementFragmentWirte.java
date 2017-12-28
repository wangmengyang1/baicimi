package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/27.
 * 评价管理   物流评价 写评价
 */
public class EvaluateManagementFragmentWirte extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.evaluate_mange_ment_fragment_write , container , false);

        back = (ImageView) view.findViewById(R.id.evaluate_mange_ment_fragment_write_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.evaluate_mange_ment_fragment_write_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
