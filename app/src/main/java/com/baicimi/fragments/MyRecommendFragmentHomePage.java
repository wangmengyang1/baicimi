package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.MyFriendsRecommendFragment;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  百万行动计划  好友推荐首页
 */
@SuppressLint("ValidFragment")
public class MyRecommendFragmentHomePage extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView firstRecommend , secondRecommend ,threadRecommend ,fourRecommend ,fiveRecommend ,sixRecommend ;
    private ImageView back;
    private CheckBox firstCheckBox , secondCheckBox , threadCheckBox , fourCheckBox , fiveCheckBox , sixCheckBox;

//

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_recommend_fragment_homepage , container , false);


        init();

        return view;
    }

    private void init() {

        back = (ImageView) view.findViewById(R.id.my_recommend_fragment_homepage_back);
        back.setOnClickListener(this);

        firstRecommend = (TextView) view.findViewById(R.id.my_recommend_fragment_homepage_firstrecommend);
        secondRecommend = (TextView) view.findViewById(R.id.my_recommend_fragment_homepage_secondrecommend);
        threadRecommend = (TextView) view.findViewById(R.id.my_recommend_fragment_homepage_threadrecommend);
        fourRecommend = (TextView) view.findViewById(R.id.my_recommend_fragment_homepage_fourrecommend);
        fiveRecommend = (TextView) view.findViewById(R.id.my_recommend_fragment_homepage_fiverecommend);
        sixRecommend = (TextView) view.findViewById(R.id.my_recommend_fragment_homepage_sixrecommend);

        firstRecommend.setOnClickListener(this);
        secondRecommend.setOnClickListener(this);
        threadRecommend.setOnClickListener(this);
        fourRecommend.setOnClickListener(this);
        fiveRecommend.setOnClickListener(this);
        sixRecommend.setOnClickListener(this);

        firstCheckBox = (CheckBox) view.findViewById(R.id.my_recommend_fragment_homepage_firstcheckbox);
        secondCheckBox = (CheckBox) view.findViewById(R.id.my_recommend_fragment_homepage_secondcheckbox);
        threadCheckBox = (CheckBox) view.findViewById(R.id.my_recommend_fragment_homepage_threadcheckbox);
        fourCheckBox = (CheckBox) view.findViewById(R.id.my_recommend_fragment_homepage_fourcheckbox);
        fiveCheckBox = (CheckBox) view.findViewById(R.id.my_recommend_fragment_homepage_fivecheckbox);
        sixCheckBox = (CheckBox) view.findViewById(R.id.my_recommend_fragment_homepage_sixcheckbox);

        firstCheckBox.setOnClickListener(this);
        secondCheckBox.setOnClickListener(this);
        threadCheckBox.setOnClickListener(this);
        fourCheckBox.setOnClickListener(this);
        fiveCheckBox.setOnClickListener(this);
        sixCheckBox.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_recommend_fragment_homepage_firstrecommend:
                startFragment(new MyRecommendFragment("首次推荐礼品"));
                break;
            case R.id.my_recommend_fragment_homepage_secondrecommend:
                startFragment(new MyRecommendFragment("二次推荐礼品"));
                break;
            case R.id.my_recommend_fragment_homepage_threadrecommend:
                startFragment(new MyRecommendFragment("三次推荐礼品"));
                break;
            case R.id.my_recommend_fragment_homepage_fourrecommend:
                startFragment(new MyRecommendFragment("四次推荐礼品"));
                break;
            case R.id.my_recommend_fragment_homepage_fiverecommend:
                startFragment(new MyRecommendFragment("五次推荐礼品"));
                break;
            case R.id.my_recommend_fragment_homepage_sixrecommend:
                startFragment(new MyRecommendFragment("六次推荐礼品"));
                break;
            case R.id.my_recommend_fragment_homepage_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.my_recommend_fragment_homepage_firstcheckbox:
                firstCheckBox.setChecked(true);
                if (firstCheckBox.isChecked()){
                    startFragment(new MyFriendsRecommendFragment("首次推荐任务" , "首次推荐任务" , 4 , "解锁二次推荐"));
                    firstCheckBox.setChecked(false);
                }

                break;
            case R.id.my_recommend_fragment_homepage_secondcheckbox:
                secondCheckBox.setChecked(true);
                if (secondCheckBox.isChecked()){
                    startFragment(new MyFriendsRecommendFragment("二次推荐任务" , "二次推荐名额：3人" , 4 , "解锁三次推荐"));
                    secondCheckBox.setChecked(false);
                }

                break;
            case R.id.my_recommend_fragment_homepage_threadcheckbox:
                threadCheckBox.setChecked(true);
                if (threadCheckBox.isChecked()){
                    startFragment(new MyFriendsRecommendFragment("三次推荐任务" , "二次推荐名额：6-15人" , 4 , "解锁四次推荐"));
                    threadCheckBox.setChecked(false);
                }

                break;
            case R.id.my_recommend_fragment_homepage_fourcheckbox:
                fourCheckBox.setChecked(true);
                if (fourCheckBox.isChecked()){
                    startFragment(new MyFriendsRecommendFragment("四次推荐任务" , "二次推荐名额：15-30人" , 2 , "解锁五次推荐"));
                    fourCheckBox.setChecked(false);
                }

                break;
            case R.id.my_recommend_fragment_homepage_fivecheckbox:
                fiveCheckBox.setChecked(true);
                if (fiveCheckBox.isChecked()){
                    startFragment(new MyFriendsRecommendFragment("五次推荐任务" , "二次推荐名额：30-40人" , 2 , "解锁六次推荐"));
                    fiveCheckBox.setChecked(false);
                }
                break;
            case R.id.my_recommend_fragment_homepage_sixcheckbox:
                sixCheckBox.setChecked(true);
                if (sixCheckBox.isChecked()){
                    startFragment(new MyFriendsRecommendFragment("六次推荐任务" , "二次推荐名额：40-50人" , 2 , "完成"));
                    sixCheckBox.setChecked(false);
                }
                break;
        }
    }
}
