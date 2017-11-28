package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.SlideImageView;

/**
 * Created by Administrator on 2017/11/28.
 * 个人中心  密码找回
 */
public class UserPasswordFindFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmess;
    private SlideImageView deblocking;
    private int stateX , moveX;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_password_find_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.user_password_find_fragment_back);
        back.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.user_password_find_fragment_slide_dissmess);
        dissmess.setOnClickListener(this);

        deblocking = (SlideImageView) view.findViewById(R.id.user_password_find_fragment_slide_deblocking);
        deblocking.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
//                        stateX =  (int) motionEvent.getX();
//                        System.out.println(stateX + "************************");
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        moveX = (int) motionEvent.getX();
////
//                        int distance = moveX - stateX;
////                        System.out.println(distance + "1111111111111111111");
//                        deblocking.setX(stateX + distance);
//                        stateX = moveX;
                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }
                return true;
            }
        });
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_password_find_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_password_find_fragment_slide_dissmess:
                //密码找回 验证身份
                startFragment(new UserIdentityAuthentication());
                break;
        }
    }
}
