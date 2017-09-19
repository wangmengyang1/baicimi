package com.baicimi;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.adapter.CelaCategoryAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.CelaProject;
import com.baicimi.fragments.BnnStaffRegisterOptionFragment;
import com.baicimi.fragments.DistributionOrderGoodsFragment;
import com.baicimi.fragments.DistributorPurchaseOption;
import com.baicimi.fragments.FragmentHeadWelcom;
import com.baicimi.fragments.IntegralCeLaFragment;
import com.baicimi.fragments.SerchGoodsFragment;
import com.baicimi.fragments.TeacherStatusRegisterFragment;
import com.baicimi.fragments.TeacherStatusRegisterGallery;
import com.baicimi.view.IntegralSlideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private FragmentManager fm;

    private LinkedList<String> mFragments = new LinkedList<String>();

    public static final int LAST_CLICK_GAP = 600;
    public long lastClickTime = 0;
    private long mExitTime = 0;
    public static final int EXIT_TIME_GAP = 2000;
    private DrawerLayout drawer;

    public DrawerLayout getDrawer() {
        return drawer;
    }

    private int index;


    //侧拉菜单及下拉分菜单
    private ListView listView_cela;
    private ListViewCelaAdapter adapter;
    private List<CelaProject> date  = new ArrayList();
    private int celaListview = -1;//侧拉菜单状态


    private IntegralSlideView integralSlideView;//移动小球
    private float startViewX, startViewY;
    float viewx, viewy, dx, dy, weightView, heightView;
    private int width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout) findViewById(R.id.home_drawlayout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fm = getSupportFragmentManager();
        FragmentHeadWelcom fWelcom = new FragmentHeadWelcom();
        String tag = fWelcom.getMTag();
        mFragments.add(tag);
        fm.beginTransaction().add(R.id.fragment_container, fWelcom, tag).addToBackStack(tag).commit();
        //侧拉菜单中的控件查找
        initUI();

        //移动小球
        initIntegralSlideView();


    }

    //移动小球
    private void initIntegralSlideView() {

        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        integralSlideView = (IntegralSlideView) findViewById(R.id.activity_main_integralslideview);
        integralSlideView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN://按下
                        startViewX = event.getRawX();
                        startViewY = event.getRawY();
                        viewx = integralSlideView.getX();
                        viewy = integralSlideView.getY();
                        weightView = 0;
                        heightView = 0;
                        break;
                    case MotionEvent.ACTION_MOVE://滑动
                        //确定滑动距离
                        float x = event.getRawX();
                        float y = event.getRawY();

                        dx = x - startViewX;
                        dy = y - startViewY;

                        weightView = dx;
                        heightView = dy;
                        dx += viewx;
                        dy += viewy;

                        integralSlideView.setY(dy);
                        integralSlideView.setX(dx);

                        break;
                    case MotionEvent.ACTION_UP://放开
                        if (Math.abs(weightView) < 3 && Math.abs(heightView) < 3) {
                            return false;
                        } else {
                            if (integralSlideView.getX() >= width / 2) {

                                ObjectAnimator.ofFloat(integralSlideView, "translationX", -(width-Math.abs(dx)), 0).setDuration(170).start();
                            } else {
                                ObjectAnimator.ofFloat(integralSlideView, "translationX", -(width - dx), -width+80).setDuration(180).start();
                            }
                            return true;
                        }
                }
                return false;
            }
        });

        integralSlideView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new IntegralCeLaFragment() , null);
            }
        });


    }

    private void initUI() {
        //111111111
        listView_cela = (ListView)findViewById(R.id.view_choudi_listview);
        //添加数据源
        date.add(new CelaProject(R.mipmap.meigui_mingxing , "洗护用品" , new String[]{"头发护理" , "身体护理" }));
        date.add(new CelaProject(R.mipmap.meigui_meizhuang , "家居清洁" , new String[]{"厨房清洁" , "衣物清洁" , "卫浴清洁"}));
        date.add(new CelaProject(R.mipmap.meigui_img , "美妆个护" , new String[]{"面膜" , "护肤" , "彩妆" , "美妆工具"}));
        date.add(new CelaProject(R.mipmap.meigui_lvxing , "母婴用品" , new String[]{"孕妇护理" , "婴童护理" }));
        date.add(new CelaProject(R.mipmap.meigui_meishi , "个人用品" , new String[]{"配饰" , "包包" , "个护电器" , "床上用品","居家休闲" , "旅行用品"}));
        date.add(new CelaProject(R.mipmap.meigui_shipin , "男士专区" , new String[]{"护肤产品" , "洗护用品" , "个护电器"}));
        date.add(new CelaProject(R.mipmap.meigui_mingxing , "输入积分码" , new String[]{}));
        date.add(new CelaProject(R.mipmap.meigui_zhuce_open , "注册通道入口" , new String[]{"教师/学生注册入口" , "BNN分销/员工注册入口"}));
        date.add(new CelaProject(R.mipmap.meigui_img , "师生选购专区" , new String[]{}));
        date.add(new CelaProject(R.mipmap.meigui_lvxing , "分销订货入口" , new String[]{}));
        date.add(new CelaProject(R.mipmap.meigui_meishi , "分销物品申请入口" , new String[]{}));
        adapter = new ListViewCelaAdapter(this);
        adapter.setList(date);
        listView_cela.setAdapter(adapter);
        fixListViewHeight(listView_cela , 1);
        listView_cela.setOnItemClickListener(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {// 返回键处理
            if (!backCurrentFragment()) {
                goBack();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // 处理默认返回的
    public void goBack() {

        int count = fm.getBackStackEntryCount();
        if (count == 1) {
            // 只存在一个Fragment时候，进行二次提醒
            if (SystemClock.uptimeMillis() - mExitTime > EXIT_TIME_GAP) {
//                 ViewMyToast.showToast(getApplicationContext(), "再按一次退出");
                mExitTime = SystemClock.uptimeMillis();
            } else {
                // 假如多个Activity，清除多个Activity
                MainActivity.this.finish();
            }
        } else {
            if (mFragments.size() > 0) {
                mFragments.pollLast();
            }
            fm.popBackStack();// 把Framgent移除出去
        }
    }

    public boolean backCurrentFragment() {
        BaseFragment currFragment = getCurrentFrament();
        if (currFragment != null) {
            return currFragment.onBack();
        }
        return false;
    }

    // Fragment 的启动
    public void startFragment(BaseFragment fragment, Bundle bundle) {
        if (fragment == null) {
            throw new IllegalArgumentException("fragment is null");
        }

        if (lastClickTime + LAST_CLICK_GAP < SystemClock.uptimeMillis()) {
            // 1 获取tag
            String tag = fragment.getMTag();

            // 2 获取事务
            FragmentTransaction ft = fm.beginTransaction();
            // 3 控制Fragment 的动画
            ft.setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit, R.anim.slide_right_enter,
                    R.anim.slide_left_exit);
            // 4 添加Fragment
            ft.add(R.id.fragment_container, fragment, tag);
            if (bundle != null) {
                fragment.setArguments(bundle);
                String lible = bundle.getString("option");
                if(lible.equals("option")){
                    integralSlideView.setVisibility(View.VISIBLE);//如果首页开启 ，显示移动小球
                }
            }
            // 5 隐藏当前或者finish的Fragment
            BaseFragment currFragment = getCurrentFrament();
            if (currFragment != null) {
                if (currFragment.finish()) {
                    mFragments.pollLast();
                    fm.popBackStack();// finish
                } else {
                    ft.hide(currFragment);// hide
                }
            }
            // 6 把tag 添加到mFragments
            mFragments.add(tag);
            // 7 添加到返回栈
            ft.addToBackStack(tag);
            // 8 添加事务
            ft.commit();
            lastClickTime = SystemClock.uptimeMillis();
        }
    }

    // 怎么获取当前的Fragment
    public BaseFragment getCurrentFrament() {
        return mFragments.size() > 0 ? (BaseFragment) fm.findFragmentByTag(mFragments.peekLast()) : null;
    }


    @Override
    protected void onResume() {
        super.onResume();
        //极光推动统计代码
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //极光推动统计代码
        JPushInterface.onPause(this);
    }


    //侧拉菜单相关
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        index = i;

        if(i == 6){
            drawer.closeDrawers();
            //跳转到积分页面
            startFragment(new IntegralCeLaFragment() , null);

        }

        if(i == 8){
            drawer.closeDrawers();
            //跳转到教师/学生选购专区
            startFragment(new TeacherStatusRegisterFragment() , null);
        }

        if(i == 9){
            drawer.closeDrawers();
            //跳转到分销订货入口
            startFragment(new DistributionOrderGoodsFragment() , null);
        }

        if(i == 10){
            drawer.closeDrawers();
            //跳转到分销商购买入口
            startFragment(new DistributorPurchaseOption() , null);
        }

        if(i == celaListview){
            celaListview = -1;
        }else{
            celaListview = i;
        }
        adapter.notifyDataSetChanged();
    }


    //关于侧拉菜单中的listview中的子菜单的点击事件
    private class ListViewCelaAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;
        private List<CelaProject> list  = new ArrayList();

        public List<CelaProject> getList() {
            return list;
        }

        public void setList(List<CelaProject> list) {
            this.list = list;
        }

        public ListViewCelaAdapter(MainActivity context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            CelaHolder holder = null;
            if(view == null){
                view = inflater.inflate(R.layout.cela_listview_fragment , null);
                holder = new CelaHolder();
                holder.imageView = (ImageView) view.findViewById(R.id.cela_listview_image);
                holder.textView = (TextView) view.findViewById(R.id.cela_listview_name);
                holder.v = (LinearLayout)view.findViewById(R.id.cela_listview_linearlayou_lv);
                holder.categorylistView = (ListView) view.findViewById(R.id.cela_listview_category_lv);
                view.setTag(holder);
            }else{
                holder = (CelaHolder) view.getTag();
            }
            //找控件
            holder.imageView.setImageResource(list.get(i).getImageId());
            holder.textView.setText(list.get(i).getCategoryName());
            holder.v.setVisibility(i == celaListview ? View.VISIBLE : View.GONE);
//            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext() , R.layout.cela_listview_item_textview , list.get(i).getCategory());
            CelaCategoryAdapter adapter1 = new CelaCategoryAdapter(MainActivity.this);
            List<String> celadate = new ArrayList<>();
            for(int l = 0 ; l < list.get(i).getCategory().length ; l++){
                celadate.add(list.get(i).getCategory()[l]);
            }
            adapter1.setList(celadate);
            holder.categorylistView.setAdapter(adapter1);
            fixListViewHeight(holder.categorylistView , 2);
            //设置二级分类的点击事件
            holder.categorylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    /**
                     * 点击事件需要从服务器拿到数据值，并且要通过数据值进行再一次网络访问，通过返回的数据进行分类（暂无数据）
                     * date:2017-03-27
                     * name:王梦阳
                     */
//                    mMenu.setOpen(true);
//                    mMenu.toggle();
                    if(index == 7){
                        if(i == 0){
                            drawer.closeDrawers();
                            startFragment(new TeacherStatusRegisterGallery(),null);
                            celaListview = -1;
                            adapter.notifyDataSetChanged();
                        }else if(i == 1){
                            drawer.closeDrawers();
                            startFragment(new BnnStaffRegisterOptionFragment(),null);
                            celaListview = -1;
                            adapter.notifyDataSetChanged();
                        }
                    }else{
                        drawer.closeDrawers();
                        startFragment(new SerchGoodsFragment(date.get(index).getCategory()[i]),null);
                        celaListview = -1;
                        adapter.notifyDataSetChanged();

                    }
                }
            });
            return view;
        }


        //设置分菜单监听事件
        private OnMenuClickListenser mOnMenuClickListenser = new OnMenuClickListenser();

        public class CelaHolder{
            private ImageView imageView;
            private TextView textView;
            private ListView categorylistView;
            private View v;
        }
        //设置分菜单监听事件
        private class OnMenuClickListenser implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
            }
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


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.home_drawlayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
