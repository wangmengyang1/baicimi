package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.MyPopupWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 * 个人中心首页 幂聊首页
 */
public class MiPeopleChatAddFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private MiChatFragment miChatFragment;//幂聊
    private MiChatAddFriends miChatAddFriends;//添加朋友
    private MiChatInviteFriends miChatInviteFriends;//邀请朋友页面


    private MiChatFriendsCircle miChatFriendsCircle;//幂友圈
    private MiChatAddressBookFragment miChatAddressBookFragment;//通讯录


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 6;
    private ImageView addImage;
    private PopupWindow popupWindow;
    private boolean statePopup = false;

    private LinearLayout  layoutFirst ,layoutSecond ,mifriendscircle ,layoutFour;
    private ImageView firstImage , secondImage , circleImage ;
    private TextView firstTextView ,secondTextView , circleTextView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_people_chat_add_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.mi_people_chat_add_fragment_back);
        back.setOnClickListener(this);

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);


        addImage = (ImageView) view.findViewById(R.id.mi_people_chat_add_fragment_addimage);
        addImage.setOnClickListener(this);

        popupWindow = new PopupWindow(getContext());

        mifriendscircle = (LinearLayout) view.findViewById(R.id.mi_people_chat_add_fragment_mifriendscircle);
        mifriendscircle.setOnClickListener(this);

        layoutFirst = (LinearLayout) view.findViewById(R.id.mi_people_chat_add_fragment_layoutfirst);
        layoutFirst.setOnClickListener(this);
        layoutSecond = (LinearLayout) view.findViewById(R.id.mi_people_chat_add_fragment_layoutsecond);
        layoutSecond.setOnClickListener(this);
        layoutFour = (LinearLayout) view.findViewById(R.id.mi_people_chat_add_fragment_layoutfour);
        layoutFour.setOnClickListener(this);

        firstImage = (ImageView) view.findViewById(R.id.mi_people_chat_add_fragment_imagefirst);
        secondImage = (ImageView) view.findViewById(R.id.mi_people_chat_add_fragment_imagesecond);
        circleImage = (ImageView) view.findViewById(R.id.mi_people_chat_add_fragment_mifriendscircle_image);

        firstTextView = (TextView) view.findViewById(R.id.mi_people_chat_add_fragment_textviewfirst);
        secondTextView = (TextView) view.findViewById(R.id.mi_people_chat_add_fragment_textviewsecond);
        circleTextView = (TextView) view.findViewById(R.id.mi_people_chat_add_fragment_mifriendscircle_textview);

        return view;
    }

    @Override
    protected void initData() {

    }


    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(miChatFragment = new MiChatFragment());//幂聊
        listFragment.add(miChatAddFriends = new MiChatAddFriends());//添加朋友
        listFragment.add(miChatInviteFriends = new MiChatInviteFriends());//邀请朋友见面
        listFragment.add(miChatFriendsCircle = new MiChatFriendsCircle());//幂友圈
        listFragment.add(miChatAddressBookFragment = new MiChatAddressBookFragment());//通讯录
    }


    //fragment切换
    public void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag() + "i";
        FragmentTransaction transaction =  fm.beginTransaction();
        if (fragmentTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));
            index = i;
        }else {
            if (fragmentTag.isEmpty()){
                fragmentTag.add(tag);
                transaction.add(R.id.mi_people_chat_add_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.mi_people_chat_add_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }


    @SuppressLint("NewApi")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_people_chat_add_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_people_chat_add_fragment_addimage:
                //加号选项
//                if (!statePopup){
//                    View popupView = LayoutInflater.from(getContext()).inflate(R.layout.mi_people_chat_add_popup, null);
//                    popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//                    popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//                    popupWindow.setContentView(popupView);
//                    popupWindow.showAsDropDown(addImage);
//                    popupWindow.setOutsideTouchable(false);
//                    popupWindow.setFocusable(true);
//                    popupWindow.setBackgroundDrawable(new ColorDrawable(0));
//                    TextView textView = (TextView) popupView.findViewById(R.id.mi_people_chat_add_popup_addfriends);
//                    textView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            //添加朋友
//                            popupWindow.dismiss();
//
//                        }
//                    });


                View mainView = LayoutInflater.from(getContext()).inflate(R.layout.mi_people_chat_add_popup, null);
                final MyPopupWindow myPopupWindow = new MyPopupWindow(getActivity(), mainView, 260, 300);
                //设置默认获取焦点
                myPopupWindow.setFocusable(true);
                //以某个控件的x和y的偏移量位置开始显示窗口
                myPopupWindow.showAsDropDown(addImage, 0, 0);
                //如果窗口存在，则更新
                myPopupWindow.update();

                TextView addFriends = (TextView) mainView.findViewById(R.id.mi_people_chat_add_popup_addfriends);
                addFriends.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myPopupWindow.dismiss();
                        initShowFragment(1);//添加朋友
                    }
                });

                TextView invitefriends = (TextView) mainView.findViewById(R.id.mi_people_chat_add_popup_invitefriends);
                invitefriends.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myPopupWindow.dismiss();
                        initShowFragment(2);//邀请赢积分
                    }
                });

                break;
            case R.id.mi_people_chat_add_fragment_mifriendscircle:
                //幂友圈
                initShowFragment(3);
                break;
            case R.id.mi_people_chat_add_fragment_layoutfirst:
                //幂聊
                initShowFragment(0);
                break;
            case R.id.mi_people_chat_add_fragment_layoutsecond:
                //通讯录
                initShowFragment(4);
                break;

        }
    }
}
