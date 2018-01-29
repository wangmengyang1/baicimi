package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.GenderManagerInterface;

/**
 * Created by Administrator on 2018/1/17.
 * 个人中心，设置，个人信息界面 基本资料
 */
public class SettingUserMessageBasicDate extends BaseFragment implements View.OnClickListener , GenderManagerInterface {

    private View view;
    private ImageView back;
    private LinearLayout nickname;//昵称
    private LinearLayout manageraddress;//管理收货地址

    private LinearLayout headPortrait;
    private LinearLayout gender;

    private TextView genderLible;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_user_message_basic_date , container , false);
        back = (ImageView) view.findViewById(R.id.setting_user_message_basic_date_back);
        back.setOnClickListener(this);

        nickname = (LinearLayout) view.findViewById(R.id.setting_user_message_basic_date_nickname);
        nickname.setOnClickListener(this);

        manageraddress = (LinearLayout) view.findViewById(R.id.setting_user_message_basic_date_manageraddress);
        manageraddress.setOnClickListener(this);

        //头像
        headPortrait = (LinearLayout) view.findViewById(R.id.setting_user_message_basic_date_headportrait);
        headPortrait.setOnClickListener(this);

        //性别
        gender = (LinearLayout) view.findViewById(R.id.setting_user_message_basic_date_gender);
        gender.setOnClickListener(this);

        genderLible = (TextView) view.findViewById(R.id.setting_user_message_basic_date_genderlible);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_user_message_basic_date_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.setting_user_message_basic_date_nickname:
                //昵称
                startFragment(new SettingUserMessageBasicDateNickName());
                break;
            case R.id.setting_user_message_basic_date_manageraddress:
                //管理收货地址
                startFragment(new SettingUserMessageBasicDateManagerAddress());
                break;
            case R.id.setting_user_message_basic_date_headportrait:
                //头像更换
//                SettingUserMessageBasicDateDialog settingUserMessageBasicDateDialog = new SettingUserMessageBasicDateDialog(getContext()
//                        ,R.style.MeiGuiMeiShiSecondMyorderFive ,this );
//                settingUserMessageBasicDateDialog.show();
                break;
            case R.id.setting_user_message_basic_date_gender:
                //性别
//                SettingUserMessageBasicDateGenderDialog settingUserMessageBasicDateGenderDialog =
//                        new SettingUserMessageBasicDateGenderDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , this);
//                settingUserMessageBasicDateGenderDialog.show();
                break;
        }
    }

    @Override
    public void getGender(String gender) {
        genderLible.setText(gender);
    }
}
