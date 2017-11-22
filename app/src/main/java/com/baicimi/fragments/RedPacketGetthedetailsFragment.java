package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.RedPacketGetthedetailsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.RedPacketGetthedetailsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 * 个人中心  我的生活助手  红包  红包领取详情
 */
public class RedPacketGetthedetailsFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listView;
    private List<RedPacketGetthedetailsEntry> list = new ArrayList<>();
    private RedPacketGetthedetailsAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.red_packet_getthe_deatails_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.red_packet_getthe_deatails_fragment_back);
        back.setOnClickListener(this);

        //listview 布局填充
        initListView();

        return view;
    }

    //listview 布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.red_packet_getthe_deatails_fragment_listview);
        list.clear();
        list.add(new RedPacketGetthedetailsEntry(R.drawable.red_packet_getthe_details_adapter_image_02 , "陈坤" , "领到33.33元" , "2017.08.08  13:09:25" , false));
        list.add(new RedPacketGetthedetailsEntry(R.drawable.red_packet_getthe_details_adapter_image_02 , "小琪琪" , "领到33.33元" , "2017.08.08  13:09:25" , false));
        list.add(new RedPacketGetthedetailsEntry(R.drawable.red_packet_getthe_details_adapter_image_02 , "丽丽哥哥" , "领到33.33元" , "2017.08.08  13:09:25" , false));
        list.add(new RedPacketGetthedetailsEntry(R.drawable.red_packet_getthe_details_adapter_image_02 , "惊天" , "领到33.33元" , "2017.08.08  13:09:25" , false));
        list.add(new RedPacketGetthedetailsEntry(R.drawable.red_packet_getthe_details_adapter_image_02 , "夏叶亮" , "领到33.33元" , "2017.08.08  13:09:25" , false));
        list.add(new RedPacketGetthedetailsEntry(R.drawable.red_packet_getthe_details_adapter_image_02 , "好奇怪" , "领到33.33元" , "2017.08.08  13:09:25" , false));
        adapter = new RedPacketGetthedetailsAdapter(list , getContext());
        listView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.red_packet_getthe_deatails_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
