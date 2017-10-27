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
 * Created by Administrator on 2017/9/27.
 * 个人中心，设置，隐私设置
 */
public class SettingPrivacySetting extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView myorderform , usercenterprivacy , userdateprivacy ,mifriends_privacy , blockmanagement  ,remfriendsprivacy
             , comment_manager , address , message;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_privacy_setting , container , false);
        back = (ImageView) view.findViewById(R.id.setting_privacy_fragment_back);
        back.setOnClickListener(this);
        myorderform = (TextView) view.findViewById(R.id.setting_privacy_fragment_myorderform);
        myorderform.setOnClickListener(this);
        usercenterprivacy = (TextView) view.findViewById(R.id.setting_privacy_fragment_usercenterprivacy);
        usercenterprivacy.setOnClickListener(this);

        userdateprivacy = (TextView) view.findViewById(R.id.setting_privacy_fragment_userdateprivacy);
        userdateprivacy.setOnClickListener(this);

        mifriends_privacy = (TextView) view.findViewById(R.id.setting_privacy_mifriends_privacy);
        mifriends_privacy.setOnClickListener(this);

        blockmanagement = (TextView) view.findViewById(R.id.setting_privacy_fragment_blockmanagement);
        blockmanagement.setOnClickListener(this);

        remfriendsprivacy = (TextView) view.findViewById(R.id.setting_privacy_fragment_remfriendsprivacy);
        remfriendsprivacy.setOnClickListener(this);

        comment_manager = (TextView) view.findViewById(R.id.setting_privacy_comment_manager);
        comment_manager.setOnClickListener(this);

        address = (TextView) view.findViewById(R.id.setting_privacy_fragment_address);
        address.setOnClickListener(this);

        message = (TextView) view.findViewById(R.id.setting_privacy_message);
        message.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_privacy_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.setting_privacy_fragment_myorderform:
                //查找权限
                startFragment(new SettingPrivacySettingFindJurisdiction());
                break;
            case R.id.setting_privacy_fragment_usercenterprivacy:
                //个人中心查找权限
                startFragment(new UserCenterFindJurisdiction());
                break;
            case R.id.setting_privacy_fragment_userdateprivacy:
                //个人资料查看权限
                startFragment(new UserDateFindJurisdiction());
                break;
            case R.id.setting_privacy_mifriends_privacy:
                //幂友权限
                startFragment(new MiFriendsJurisdiction());
                break;
            case R.id.setting_privacy_fragment_blockmanagement:
                //屏蔽管理
                startFragment(new BlockManagementJurisdiction());
                break;
            case R.id.setting_privacy_fragment_remfriendsprivacy:
                //推荐好友权限
                startFragment(new RemFriendsPrivacyJurisdiction());
                break;
            case R.id.setting_privacy_comment_manager:
                //评论管理
                startFragment(new CommentManagerJurisdiction());
                break;
            case R.id.setting_privacy_fragment_address:
                //位置权限
                startFragment(new AddressJurisdiction());
                break;
            case R.id.setting_privacy_message:
                //消息权限管理
                startFragment(new MessageJurisdiction());
                break;
        }
    }
}
