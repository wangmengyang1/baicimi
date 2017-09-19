package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.IntimacPaymentFirstInterface;

/**
 * Created by Administrator on 2017/8/16.
 */

public class IntimacyPaymentFirstFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private Button nextStep;

    private int index;

    private TextView title;

    private IntimacPaymentFirstInterface intimacPaymentFirstInterface;


    public IntimacyPaymentFirstFragment(int index , IntimacPaymentFirstInterface intimacPaymentFirstInterface) {
        this.index = index;
        this.intimacPaymentFirstInterface = intimacPaymentFirstInterface;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.intimacy_payment_first_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.back_intimacy_payment_first);
        back.setOnClickListener(this);

        nextStep = (Button) view.findViewById(R.id.intimacy_payment_first_button_nextStep);
        nextStep.setOnClickListener(this);

        title = (TextView) view.findViewById(R.id.intimacy_payment_first_fragment_title);
        if(index == 0){
            title.setText("为ta开通亲密付");
        }else{
            title.setText("求开通亲密付");
        }

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_intimacy_payment_first:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.intimacy_payment_first_button_nextStep:
                //下一步
                if(index == 0){
                    startFragment(new IntimacyPaymentDredgeSucceedFragment());
                }else {
//                    Toast.makeText(getContext() , "请求已发送" , Toast.LENGTH_SHORT).show();
                    if(intimacPaymentFirstInterface != null){
                        intimacPaymentFirstInterface.getMessage(true);
                    }
                    ((MainActivity)getActivity()).goBack();//返回到上一级页面

                }

                break;
        }
    }
}
