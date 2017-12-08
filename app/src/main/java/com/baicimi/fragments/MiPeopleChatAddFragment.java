package com.baicimi.fragments;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

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


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 6;
    private ImageView addImage;
    private PopupWindow popupWindow;
    private boolean statePopup = false;

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

        return view;
    }

    @Override
    protected void initData() {

    }



    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(miChatFragment = new MiChatFragment());
//        listFragment.add(footPaintNewPeopleTaskFragment = new FootPaintEveryTaskFragmentSecond());
//        listFragment.add(footPaintPlayFragment = new FootPaintPlayFragment());
//        listFragment.add(footPaintActivityFragment = new FootPaintActivityFragment());
//        listFragment.add(footPaintHealthManagerFragment = new FootPaintHealthManagerFragment());
    }


    //fragment切换
    private void initShowFragment(int i) {
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



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_people_chat_add_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_people_chat_add_fragment_addimage:
                //加号选项

                if (!statePopup){
                    popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setContentView(LayoutInflater.from(getContext()).inflate(R.layout.mi_people_chat_add_popup , null));
                    popupWindow.showAsDropDown(addImage);
                    popupWindow.setOutsideTouchable(false);
                    popupWindow.setFocusable(true);
                    popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                }else{
                    popupWindow.dismiss();
                }

                statePopup = !statePopup;
                break;
        }
    }
}
