package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/3.
 * 个人中心  客户服务  投诉与建议
 */
public class ComplaintSuggestFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmess;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.complain_suggest_fragment, container, false);
        back = (ImageView) view.findViewById(R.id.complain_suggest_fragment_back);
        back.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.complain_suggest_fragment_dissmess);
        dissmess.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.complain_suggest_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.complain_suggest_fragment_dissmess:
//                ComplaintSuggestSecondFragment complaintSuggestSecondFragment = new ComplaintSuggestSecondFragment();
                //投诉与建议排行榜
                startFragment(new ComplaintSuggestSecondFragment());
                break;
        }
    }
}
