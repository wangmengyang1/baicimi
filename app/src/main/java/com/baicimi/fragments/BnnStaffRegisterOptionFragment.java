package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 * bnn分销商以及员工注册入口
 */

public class BnnStaffRegisterOptionFragment extends BaseFragment implements View.OnClickListener {

    private View view;

    private List<Fragment> list = new ArrayList<>();
    private FragmentManager fm;
    private int showIndex;
    private FragmentTransaction fragmentTransaction;

//    private TextView distributor_textview , staff_textview;

    private ImageView back;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.bnn_staff_register_option_fragment , container , false);
        fm = getActivity().getSupportFragmentManager();
        //分销人员与员工注册切换
        initStaff();

        back = (ImageView) view.findViewById(R.id.back_staff_register_option);
        back.setOnClickListener(this);

        return view;
    }

    //分销人员与员工注册切换
    private void initStaff() {
        list.add(new BnnDistributorRegisterOptionFragment());
//        list.add(new BnnStaffSecondRegisterOptionFragment());
//        distributor_textview = (TextView) view.findViewById(R.id.bnn_staff_register_option_distributor_textview);
//        distributor_textview.setOnClickListener(this);
//        staff_textview = (TextView) view.findViewById(R.id.bnn_staff_register_option_staff_textview);
//        staff_textview.setOnClickListener(this);
        setShowFragment(0);

    }

    @Override
    protected void initData() {

    }


    private void setShowFragment(int index){
        if (index > list.size()){
            return;
        }else{
            if(list.get(index) == null){
                return;
            }else{
                String tag = list.get(index).getTag();
                fragmentTransaction = fm.beginTransaction();
                // 3 控制Fragment 的动画
                fragmentTransaction.setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit, R.anim.slide_right_enter,
                        R.anim.slide_left_exit);
                if(list.get(index).isAdded()){
                    //如果已经添加了，则显示
                    fragmentTransaction.hide(list.get(showIndex));
                    fragmentTransaction.show(list.get(index));
                }else{
                    //如果没有添加，则添加之后显示
                    fragmentTransaction.add(R.id.bnn_staff_register_option_fragment_framelayout , list.get(index) , tag).show(list.get(index));
                }
                showIndex = index;
                fragmentTransaction.commit();
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.bnn_staff_register_option_distributor_textview:
//                distributor_textview.setBackgroundColor(Color.parseColor("#ce2538"));
//                distributor_textview.setTextColor(Color.WHITE);
//                staff_textview.setBackgroundColor(Color.WHITE);
//                staff_textview.setTextColor(Color.parseColor("#ce2538"));
//                setShowFragment(0);
//                break;
//            case R.id.bnn_staff_register_option_staff_textview:
//                staff_textview.setBackgroundColor(Color.parseColor("#ce2538"));
//                staff_textview.setTextColor(Color.WHITE);
//                distributor_textview.setBackgroundColor(Color.WHITE);
//                distributor_textview.setTextColor(Color.parseColor("#ce2538"));
//                setShowFragment(1);
//                break;
            case R.id.back_staff_register_option:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
