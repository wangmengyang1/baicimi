package com.baicimi.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.CommodityNumberEntry;
import com.baicimi.entity.ShopingPackageMessage;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tan on 2016/8/10.
 * 商城主页
 */
public class MainFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
//    private SlidingMenu mMenu;
    private RelativeLayout re_title;

    /**
     * 在radiogroup中间动态的添加radiobutton
     * 而radiobutton的属性采用xml和动态添加更加灵活
     */
    private RadioGroup rgNav;

    private static MainFragment fragment;
    private String[] tags = {"home", "classify", "search", "person"};
    private List<BaseFragment> fragments = new ArrayList<BaseFragment>();
    private LinkedList<String> mFragments2 = new LinkedList<String>();
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HeadFragment home;
    private ClassifyFragment classify;
    private SearchFragment search;
    private LoginFragment loginFragment;
    private ImageView shopping;

    //底部导航的图片id
    private int[] navDrawables = {R.drawable.nav_home, R.drawable.nav_classify, R.drawable.nav_search, R.drawable.nav_shopping};
    //底部导航的文字
    private String[] navText = {"首页", "分类", "搜索", "个人中心"};
    private Toolbar toolbar;

    private TextView homes , classifys , searchs , userContent;
    private ImageView homeImage , classifyImage , searchImage , userContentImage;

    private ShopingPackageMessage shopingPackageMessage;


    //单例
    public static MainFragment getFragment() {
        if (fragment == null) {
            synchronized (MainFragment.class) {
                if (fragment == null) {
                    fragment = new MainFragment();
                }
            }

        }
        return fragment;
    }

    //购物包数据变化
    private TextView shopPackageNumber;

    private int countNumber = 0;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main, container, false);


        //进行eventbus注册
        EventBus.getDefault().register(this);

        //Toolbar代替ActionBar
        toolbar = (Toolbar)view.findViewById(R.id.toolbar_main);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        DrawerLayout drawer = ((MainActivity)getActivity()).getDrawer();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        shopping = (ImageView) view.findViewById(R.id.geren_toobar);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new ShopingCarFragment(countNumber) , null);
            }
        });

        //底部导航栏布局填充
        initRadioGroup();

        initFragments();


        //购物包处数据变化
        shopPackageNumber = (TextView) view.findViewById(R.id.fragment_main_shoping_package_number);

        return view;
    }


    @Override
    public void onStop() {
        super.onStop();
        //使用完毕之后解除注册
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN )
    public void getMsgEvent(ShopingPackageMessage event){
        countNumber += event.getShopingPackageMessageNumber();
        shopPackageNumber.setText(countNumber + "");
        CommodityNumberEntry.commodityNumberEntryIntereal().setCount(countNumber);
    }



    //底部导航栏布局填充
    private void initRadioGroup() {
        rgNav = (RadioGroup) view.findViewById(R.id.rg_nav);
        homes = (TextView) view.findViewById(R.id.main_hometext);
        classifys = (TextView) view.findViewById(R.id.main_xiaoxitext);
        searchs = (TextView) view.findViewById(R.id.main_sousuotext);
        userContent = (TextView) view.findViewById(R.id.main_backshangchengtext);
        homeImage = (ImageView) view.findViewById(R.id.main_home);
        classifyImage = (ImageView) view.findViewById(R.id.main_xiaoxi);
        searchImage = (ImageView) view.findViewById(R.id.main_sousuo);
        userContentImage = (ImageView) view.findViewById(R.id.main_backshangcheng);
        RelativeLayout homeLayout = (RelativeLayout) view.findViewById(R.id.fragment_main_radiobtn_01);
        RelativeLayout classifysLayout = (RelativeLayout) view.findViewById(R.id.fragment_main_radiobtn_02);
        RelativeLayout searchsLayout = (RelativeLayout) view.findViewById(R.id.fragment_main_radiobtn_04);
        RelativeLayout userContentLayout = (RelativeLayout) view.findViewById(R.id.fragment_main_radiobtn_05);

        homeLayout.setOnClickListener(this);
        classifysLayout.setOnClickListener(this);
        searchsLayout.setOnClickListener(this);
        userContentLayout.setOnClickListener(this);

    }

    //初始化导航栏
    private void initTextViewImage(){
        homes.setTextColor(Color.parseColor("#808080"));
        classifys.setTextColor(Color.parseColor("#808080"));
        searchs.setTextColor(Color.parseColor("#808080"));
        userContent.setTextColor(Color.parseColor("#808080"));
        homeImage.setImageResource(R.mipmap.head2);
        classifyImage.setImageResource(R.mipmap.classify2);
        searchImage.setImageResource(R.mipmap.search2);
        userContentImage.setImageResource(R.mipmap.person_center_img);


    }


    @Override
    protected void initListener() {
    }

    private void initFragments() {
        home = new HeadFragment();
        classify = new ClassifyFragment();
        search = new SearchFragment();
        loginFragment = new LoginFragment();
        fragments.clear();
        fragments.add(home);
        fragments.add(classify);
        fragments.add(search);
        fragments.add(loginFragment);
        fm = getChildFragmentManager();
        selectFragment(fragments.get(0), tags[0]);

    }

    @Override
    protected void initData() {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        initTextViewImage();
        switch (checkedId) {
            case 0:
                selectFragment(fragments.get(0), tags[0]);
//                re_title.setVisibility(View.VISIBLE);
                toolbar.setVisibility(View.VISIBLE);

                homes.setTextColor(Color.RED);
                homeImage.setImageResource(R.mipmap.head1);

                break;
            case 1:
//                mMenu.closeMenu();
                selectFragment(fragments.get(1), tags[1]);
//                re_title.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                classifys.setTextColor(Color.RED);
                classifyImage.setImageResource(R.mipmap.head1);
                break;
            case 2:
//                mMenu.closeMenu();
                selectFragment(fragments.get(2), tags[2]);
//                re_title.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                searchs.setTextColor(Color.RED);
                searchImage.setImageResource(R.mipmap.head1);
                break;
            case 3:
//                mMenu.closeMenu();
                selectFragment(fragments.get(3), tags[3]);
//                re_title.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                userContent.setTextColor(Color.RED);
                userContentImage.setImageResource(R.mipmap.head1);
                break;
            case 4:
//                mMenu.closeMenu();
                selectFragment(fragments.get(4), tags[4]);
//                re_title.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 四个fragment的切换方法
     */
    public void selectFragment(BaseFragment f, String tag) {

        ft = fm.beginTransaction();
        if (mFragments2 != null) {
            if (mFragments2.contains(tag)) {//当含有标记的fragment时
                for (String str : mFragments2) {
                    if (tag.equals(str)) {
                        ft.show(fm.findFragmentByTag(tag));//显示标记的
                    } else {
                        ft.hide(fm.findFragmentByTag(str));//隐藏不是标记的
                    }
                }
            } else {//当不含该标记的fragment的时
                for (String str : mFragments2) {//隐藏其中已有的
                    ft.hide(fm.findFragmentByTag(str));
                }
                addNewFragment(f, tag);//添加该标记的fragment
            }

        } else {
            addNewFragment(f, tag);
        }
//        mMenu.setOpen(true);
        ft.commit();
    }

    //添加新的fragment
    public void addNewFragment(BaseFragment f, String tag) {
        ft.add(R.id.main_container, f, tag);
        mFragments2.add(tag);
    }

    //R.id.chouti_ningfei,
    //R.id.chouti_sevenmons, R.id.chouti_xifa, R.id.chouti_muyu,
    //R.id.chouti_xijiejing, R.id.chouti_xiyi, R.id.chouti_jifenma

    @OnClick({R.id.btn_head_cehua, R.id.geren,})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_head_cehua:
//                mMenu.toggle();

                break;
            case R.id.geren:

                break;
            case R.id.fragment_main_radiobtn_01:
                initTextViewImage();
                selectFragment(fragments.get(0), tags[0]);
//                re_title.setVisibility(View.VISIBLE);
                toolbar.setVisibility(View.VISIBLE);
                homes.setTextColor(Color.RED);
                homeImage.setImageResource(R.mipmap.head1);
                break;
            case R.id.fragment_main_radiobtn_02:
                initTextViewImage();
                selectFragment(fragments.get(1), tags[1]);
//                re_title.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                classifys.setTextColor(Color.RED);
                classifyImage.setImageResource(R.mipmap.classify1);
                break;
            case R.id.fragment_main_radiobtn_04:
                initTextViewImage();
                selectFragment(fragments.get(2), tags[2]);
//                re_title.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                searchs.setTextColor(Color.RED);
                searchImage.setImageResource(R.mipmap.search1);
                break;
            case R.id.fragment_main_radiobtn_05:
                initTextViewImage();
                selectFragment(fragments.get(3), tags[3]);
//                re_title.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                userContent.setTextColor(Color.RED);
                userContentImage.setImageResource(R.mipmap.person_center_imged);
                break;

        }
    }



    //动态计算listview的高度
    public void fixListViewHeight(ListView listView , int cont) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }
        for (int index = 0, len = listAdapter.getCount(); index < len; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        if(cont == 2){
            params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        }else{
            params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1))+totalHeight;
        }
        listView.setLayoutParams(params);
    }

}
