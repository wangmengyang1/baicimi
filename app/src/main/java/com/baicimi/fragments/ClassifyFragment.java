package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.AdapterClassifyGV;
import com.baicimi.adapter.AdapterClassifyLV;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.Categories;
import com.baicimi.conf.Constant;
import com.baicimi.ui.DownUtils;
import com.baicimi.ui.JSONUtils;
import com.baicimi.ui.L;
import com.lidroid.xutils.view.annotation.ViewInject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by tan on 2016/8/10.
 * 分类主页
 */
public class ClassifyFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    //    @ViewInject(R.id.gv_classify)
    private GridView gridView;
    //    @ViewInject(R.id.lv_classify_name)
    private ListView listView_classify;

    AdapterClassifyLV classifyAdapter;
    private List<Categories> datas;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_classify_rv, container, false);
        listView_classify = (ListView) view.findViewById(R.id.lv_classify_name);
        gridView = (GridView) view.findViewById(R.id.gv_classify);
        classifyAdapter = new AdapterClassifyLV(getActivity(), R.layout.view_classify_lv_item);

        // 设置标题
        String[] gv_title = new String[]{"", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "", "", "",
                "", ""};

        int[] imageId = new int[]{R.mipmap.fenlei1, R.mipmap.fenlei2, R.mipmap.fenlei3, R.mipmap.fenlei4,
                R.mipmap.fenlei5, R.mipmap.fenlei6, R.mipmap.fenlei7, R.mipmap.fenlei8, R.mipmap.fenlei9, R.mipmap.fenlei10,
                R.mipmap.fenlei11, R.mipmap.fenlei12, R.mipmap.fenlei13, R.mipmap.fenlei14, R.mipmap.fenlei15, R.mipmap.fenlei16,
                R.mipmap.fenlei17, R.mipmap.fenlei18, R.mipmap.fenlei19};
        List<Map<String, Object>> gv_listitem = new ArrayList<Map<String, Object>>();

        for (int j = 0; j < gv_title.length; j++) {
            Map<String, Object> map_gv = new HashMap<String, Object>();
            map_gv.put("image", imageId[j]);
            map_gv.put("gv_title", gv_title[j]);
            gv_listitem.add(map_gv);
        }
        AdapterClassifyGV adapterClassifyGV = new AdapterClassifyGV(getContext(), gv_listitem);
        gridView.setAdapter(adapterClassifyGV);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startFragment(new SerchGoodsFragment(), null);
            }
        });

        listView_classify.setAdapter(classifyAdapter);
        listView_classify.setOnItemClickListener(this);
        DownUtils.downJSON(Constant.MyURL.GIFT_CLASSIFY, getActivity(), new DownUtils.OnDownCompelet() {

            @Override
            public void downSucc(String url, Object obj) {
                if (obj != null) {
                    datas = JSONUtils.getClassifyData((JSONObject) obj);
                    classifyAdapter.setDatas(datas);
//                    adapter.setDatas(datas.get(0).subcategories);
//                    tvContent.setText(datas.get(0).name);
                }
            }
        });


        return view;
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    private int currentPosition;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.lv_classify_name:
//                adapter.setDatas(datas.get(position).subcategories);
//                tvContent.setText(datas.get(position).name);
                classifyAdapter.setFlag(position);
                currentPosition = position;
                break;
        }
    }

}
