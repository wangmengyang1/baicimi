package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/8/15.
 * 教师/学生注册入口
 */

public class TeacherStatusRegisterGallery extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.meigui_teacher_status_register_gallery , container , false);
        back = (ImageView) view.findViewById(R.id.login_back_teacher_status);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_back_teacher_status:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }
}
