package com.baicimi.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baicimi.Constants;
import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.WuLiuDetailsActivity;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.SharedPreferencesUtil;
import com.baicimi.view.AuthenticationDialog;
import com.baicimi.view.CircleImageView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;



/**
 * Created by tan on 2016/8/11.
 */
public class  PersonCenteredFragment extends BaseFragment{
    private static final String TAG = "vivi";
    private FrameLayout mContent;
    private RadioButton fenqi,zoushi,paihang,miyouquan,jingcaitupian,jingcaiwenzhang;
    private RadioGroup mRgTools,miyou_tab_group;
    private Fragment[] mFragments,mFragment;
    private int mIndex,nIndex;
    private CircleImageView user_head;
    private TextView user_name;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_personal,container,false);
        fenqi= (RadioButton) view.findViewById(R.id.wodefenqi);
        zoushi= (RadioButton) view.findViewById(R.id.jifenzoushi);
        paihang= (RadioButton) view.findViewById(R.id.paihangbang);
        mRgTools= (RadioGroup) view.findViewById(R.id.main_tab_group);
        ViewUtils.inject(this, view);
        initFragment();

        user_head= (CircleImageView) view.findViewById(R.id.user_head);
        user_name= (TextView) view.findViewById(R.id.user_name);
        String  head=SharedPreferencesUtil.getString(getContext(),Constants.INFO_HEADER,"");
        String name=SharedPreferencesUtil.getString(getContext(), Constants.INFO_LOVENAME,"");
        user_name.setText(String.valueOf(name));

        Log.d("获得的头像信息是....",head);
        Log.d("获得的头像信息是....",name);


        return view;
    }


    private void initFragment() {
        //我的分期
        MyFenQiFragment myFenQiFragment =new MyFenQiFragment();
        //积分走势
        JiFenZouShiFragment jiFenZouShiFragment =new JiFenZouShiFragment();
        //排行榜
        PaiHangBangFragment paiHangBangFragment =new PaiHangBangFragment();
        //添加到数组
        mFragments = new Fragment[]{myFenQiFragment,jiFenZouShiFragment,paiHangBangFragment};
        //开启事务
        FragmentTransaction ft =
                getActivity().getSupportFragmentManager().beginTransaction();
        //添加首页
        ft.add(R.id.id_content,myFenQiFragment).commit();
        //默认设置为第0个
        setIndexSelect(0);
    }


    private void setIndexSelect(int index) {
        if(mIndex==index){
            return;
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if(!mFragments[index].isAdded()){
            ft.add(R.id.id_content,mFragments[index]).show(mFragments[index]);
        }else {
            ft.show(mFragments[index]);
        }
        ft.commit();
        //再次赋值
        mIndex=index;
    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {

    }

    @OnClick({R.id.login_back,R.id.person_set,R.id.re_kehufuwu,R.id.tv_shaidan,R.id.tv_zhengfucaigou,R.id.wodefenqi
            ,R.id.tv_daishouhuo,R.id.kuaidi_more,R.id.jifenzoushi,R.id.paihangbang,R.id.tv_groubuy,R.id.tv_fenqidingdan
            ,R.id.tv_daifukuan,R.id.tv_daipingjia, R.id.tv_daifahuo,R.id.fenxiaokou,R.id.user_head,R.id.fragment_personal_present_save
            ,R.id.rv_miwallet, R.id.fragment_personal_get_integral , R.id.number_authentication_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.person_set:
                startFragment(new PersonSetFragment(),null);
                break;
            case R.id.re_kehufuwu:
                startFragment(new KeHuFuWuFragment(),null);
                break;
            case R.id.tv_groubuy:
                startFragment(new TuanGouDingDanFragment(),null);
                break;
            case R.id.tv_shaidan:
                startFragment(new ShaiDanPingJiaFragment(),null);
                break;
            case R.id.tv_zhengfucaigou:
                startFragment(new ZhengFuBuyFragment(),null);
                break;
            case R.id.tv_daifukuan:
                startFragment(new MyDingDanFragment(),null);
                break;
            case R.id.kuaidi_more:
                Intent intent_wuliu =new Intent(getContext(), WuLiuDetailsActivity.class);
                startActivity(intent_wuliu);
                break;
            case R.id.tv_daipingjia:
                startFragment(new MyDingDanFragment(),null);
                break;
            case R.id.tv_daifahuo:
                startFragment(new MyDingDanFragment(),null);
                break;
            case R.id.tv_daishouhuo:
                startFragment(new MyDingDanFragment(),null);
                break;
//            case R.id.grou_buy:
//                startFragment(new GrouBuyFragment(),null);
//                break;
            case R.id.user_head:
                startFragment(new PersonDateFragment(),null);
                break;
//            case R.id.fenxiaokou:
//                startFragment(new MyDingDanFragment(),null);
//                break;
//            case R.id.tv_fenqidingdan:
//                startFragment(new MyFenQiFragment(),null);
//                break;
            case R.id.wodefenqi:
                setIndexSelect(0);
                break;
            case R.id.jifenzoushi:
                setIndexSelect(1);
                break;
            case R.id.paihangbang:
                setIndexSelect(2);
                break;
            case R.id.fragment_personal_present_save:
                //跳转到礼品寄存界面
                startFragment(new FragmentPresentSave() , null);
                break;
            case R.id.rv_miwallet:
                //跳转到幂钱包界面
                startFragment(new MiWalletFragment() , null);
                break;
            case R.id.fragment_personal_get_integral:
                //跳转到领积分页面
                startFragment(new PersonCenteredGetIntegral() , null);
                break;
            case R.id.number_authentication_layout://账号认证
                AuthenticationDialog authenticationDialog = new AuthenticationDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderThere , this , null);
                authenticationDialog.show();
                break;
        }
    }

    //分期页跳转方法
    public void starFenQiFragmented(){
        startFragment(new FenQiFragmented(),null);
    }

    public void starFenQiFragment(){
        startFragment(new FenQiFragment(),null);
    }

    public void starKaFenqiFragment(){
        startFragment(new FenqiDingdanDetailsFragment(),null);
    }

}
