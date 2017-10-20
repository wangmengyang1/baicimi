package com.baicimi.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.TeacherStatusRegisterAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TeacherStatusRegisterEntry;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Administrator on 2017/7/13.
 * 教师/学生专用注册通道
 */
public class TeacherStatusRegisterFragment extends BaseFragment implements View.OnClickListener {

    private View view;

    private ImageView add_image;
    private String sdPath;//SD卡的路径
    private String picPath;//图片存储路径

    private ImageView back;

    private GridView gridView;
    private List<TeacherStatusRegisterEntry> list = new ArrayList<>();
    private TeacherStatusRegisterAdapter adapter;


    private TextView more , educatioin_more;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.teacher_status_register_fragment , container , false);
//
//        //点击打开相机进行拍照
//        initAddImage();

        back = (ImageView) view.findViewById(R.id.teacher_status_login_back);
        back.setOnClickListener(this);

        //GridView布局填充
        initGridView();

        more = (TextView) view.findViewById(R.id.teacher_status_register_fragment_more_textview);
        more.setOnClickListener(this);


        educatioin_more = (TextView) view.findViewById(R.id.teacher_stats_register_fragment_education_more);
        educatioin_more.setOnClickListener(this);
        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.teacher_status_regiseter_fragment_gridview);
        list.clear();
        list.add(new TeacherStatusRegisterEntry(R.drawable.teacher_status_register_fragment_image_04  , new String("日化用品")));
        list.add(new TeacherStatusRegisterEntry(R.drawable.teacher_status_register_fragment_image_03  , new String("美妆用品")));
        list.add(new TeacherStatusRegisterEntry(R.drawable.teacher_status_register_fragment_image_02  , new String("个人用品")));
        list.add(new TeacherStatusRegisterEntry(R.drawable.teacher_status_register_fragment_image_05  , new String("母婴用品")));
        list.add(new TeacherStatusRegisterEntry(R.drawable.teacher_status_register_fragment_image_04  , new String("日化用品")));
        adapter = new TeacherStatusRegisterAdapter(list , getContext());
        gridView.setAdapter(adapter);
        fixListViewHeight(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startFragment(new TeacherPurchaseOptionFragment());
            }
        });

    }

//    //点击调用相机添加图片
//    private void initAddImage() {
//        add_image = (ImageView) view.findViewById(R.id.teacher_status_register_fragment_add_picture);
//        add_image.setOnClickListener(this);
//    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.teacher_status_register_fragment_add_picture:
//                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);        // 启动相机
//                startActivityForResult(intent1, 0x10);
//                break;
            case R.id.teacher_status_login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
            case R.id.teacher_status_register_fragment_more_textview:
                startFragment(new TeacherPurchaseOptionFragment());
                break;
            case R.id.teacher_stats_register_fragment_education_more:
                startFragment(new TeacherStatusRegisterEducation());
                break;
        }
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK){
//            if (requestCode == 0x10){
//                Bundle bundle = data.getExtras();
//                Bitmap bitmap = (Bitmap) bundle.get("data");
//                add_image.setImageBitmap(bitmap);
//            }
//        }
//    }


    //动态计算GridView的高度
    public void fixListViewHeight(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        TeacherStatusRegisterAdapter listAdapter = (TeacherStatusRegisterAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/2); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}
