package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.SwitchButton;
import com.baicimi.view.ViewPopubWindow;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/15.
 */
public class PersonSetFragment extends BaseFragment implements ViewPopubWindow.OnPopupClickListener {
    @ViewInject(R.id.liuliang_on)
    private SwitchButton liuliang;
    @ViewInject(R.id.mishangceng_on)
    private SwitchButton mishangcheng;
    @ViewInject(R.id.shangcheng_on)
    private SwitchButton shangcheng;
    @ViewInject(R.id.zhiwen_on)
    private SwitchButton zhiwen;
    @ViewInject(R.id.kouling_on)
    private SwitchButton kouling;
    @ViewInject(R.id.share_on)
    private SwitchButton share;
    @ViewInject(R.id.chuangkou)
    private ImageView imageView_cehua;


    private PopupWindow popupWindow;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_person_set,container,false);
        return view;
    }




    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //省流量开关
        liuliang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.liuliang_on:
                    if (isChecked) {
                        Toast.makeText(getActivity(), "开启了省流量流畅版", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "关闭了省流量流畅版", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    default:
                        break;
                }
            }
        });

        //开启幂商城位置服务
        mishangcheng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.mishangceng_on:
                        if (isChecked) {
                            Toast.makeText(getActivity(), "开启了幂商城位置服务", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "关闭了幂商城位置服务", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });


        //商城摇一摇开关
        shangcheng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.shangcheng_on:
                        if (isChecked) {
                            Toast.makeText(getActivity(), "开启了商城摇一摇", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "关闭了商城摇一摇", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        //指纹支付开关
        zhiwen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.zhiwen_on:
                        if (isChecked) {
                            Toast.makeText(getActivity(), "开启了指纹支付", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "关闭了指纹支付", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        //展示自己发出的口令开关
        kouling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.kouling_on:
                        if (isChecked) {
                            Toast.makeText(getActivity(), "开启了展示自己发出的口令", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "关闭了展示自己发出的口令", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        //截屏分享开关
        share.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.share_on:
                        if (isChecked) {
                            Toast.makeText(getActivity(), "开启了截屏分享", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "关闭了截屏分享", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @OnClick({R.id.login_back,R.id.chuangkou,R.id.re1,R.id.re2,R.id.re3,R.id.re4,R.id.re5,R.id.btregist,R.id.clean_huancun})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.re1:
                    startFragment(new PersonDateFragment(),null);
                break;
            case R.id.re2:
                startFragment(new SafeFragment(),null);
                break;
            case R.id.re3:
                startFragment(new TuisongMessageFragment(),null);
                break;
            case R.id.re4:
                startFragment(new PersonlySetFragment(),null);
                break;
            case R.id.btregist:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.clean_huancun:
                Toast.makeText(getContext(),"缓存清除成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.re5:
                startFragment(new AboutBaicimiFragment(),null);
                break;
//            case R.id.chuangkou:
////                ViewPopupMenu popupView = new ViewPopupMenu(getActivity());
//                ViewPopubWindow viewPopubWindow= new ViewPopubWindow(getActivity());
////                viewPopubWindow = new PopupWindow(viewPopubWindow,
////                        LinearLayout.LayoutParams.WRAP_CONTENT,
////                        LinearLayout.LayoutParams.WRAP_CONTENT, true);
//                PopupWindow popupWindow=new PopupWindow(getActivity());
//                popupWindow==new ViewPopubWindow(viewPopubWindow,LinearLayout.LayoutParams
//                        .WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,null);
//                popupWindow.setBackgroundDrawable(getResources().getDrawable(
//                        android.R.color.transparent));
//                popupWindow.showAsDropDown(view);
//                viewPopubWindow.setOnPopupClickListener(this);
//                break;
        }
    }


    //右上角弹窗
    @Override
    public void onPopupClick(View view) {
        switch (view.getId()) {
            case R.id.tv_message:
                popupWindow.dismiss();
                break;
            case R.id.tv_shouye:
                popupWindow.dismiss();
                break;
            case R.id.tv_hele:
                popupWindow.dismiss();
                break;
        }
    }
}
