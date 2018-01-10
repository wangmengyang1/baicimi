package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/10.
 * 全球生活汇  首页 他的图片
 */
public class RosePerSonalFragmentPicture extends BaseFragment implements View.OnClickListener {

    private View view;
    private LinearLayout layoutBrowse , layoutFanse,layoutAttention;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rose_personal_fragment_picture , container , false);

        layoutBrowse = (LinearLayout) view.findViewById(R.id.rose_personal_fragment_picture_browse);
        layoutBrowse.setOnClickListener(this);

        layoutFanse = (LinearLayout) view.findViewById(R.id.rose_personal_fragment_picture_fanse);
        layoutFanse.setOnClickListener(this);

        layoutAttention = (LinearLayout) view.findViewById(R.id.rose_personal_fragment_picture_attention);
        layoutAttention.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rose_personal_fragment_picture_browse:
                //浏览量
                startFragment(new RosePerSonalFragmentPictureBrowse());
                break;
            case R.id.rose_personal_fragment_picture_fanse:
                //他的粉丝
                startFragment(new RosePerSonalFragmentPictureFanse("他的粉丝"));
                break;
            case R.id.rose_personal_fragment_picture_attention:
                //他的关注
                startFragment(new RosePerSonalFragmentPictureFanse("他的关注"));
                break;
        }
    }
}
