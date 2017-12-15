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
 * Created by Administrator on 2017/12/15.
 *   //定期储蓄，查看详情
 */
public class MiintegralbrankMyTFFdFirst extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private TextView fdfirst , fdsecond;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_my_tf_fd_first , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_my_tf_fd_first_back);
        back.setOnClickListener(this);

        fdfirst = (TextView) view.findViewById(R.id.mi_integral_brank_my_tf_fd_first_childthread_fdfirst);
        fdfirst.setOnClickListener(this);


        fdsecond = (TextView) view.findViewById(R.id.mi_integral_brank_my_tf_fd_first_childthread_fdsecond);
        fdsecond.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_my_tf_fd_first_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_my_tf_fd_first_childthread_fdfirst:
                //定期储蓄，查看详情二级页面
                startFragment(new MiintegralbrankMyTFFdFirstSecond());
                break;
            case R.id.mi_integral_brank_my_tf_fd_first_childthread_fdsecond:
                //定期储蓄，查看详情二级页面
                startFragment(new MiintegralbrankMyTFFdFirstSecond());
                break;
        }
    }
}
