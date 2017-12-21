package com.baicimi.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MilimitFragmentEarnestCodeEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
public class MilimitFragmentEarnestCodeAdapter extends BaseAdapter{

    private List<MilimitFragmentEarnestCodeEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MilimitFragmentEarnestCodeAdapter(List<MilimitFragmentEarnestCodeEntry> list, Context context) {
        this.list = list;
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
        MilimitFragmentEarnestCodeHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mi_limit_fragment_earnest_code_adapter , null);
            holder = new MilimitFragmentEarnestCodeHolder();
            holder.layoutBackGround = (RelativeLayout) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_layoutbackground);
            holder.imageurl = (ImageView) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_content);
            holder.buttonFirst = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_buttonfirst);
            holder.layoutButtonFirst = (LinearLayout) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_buttonlayoutfirst);
            holder.buttonSecond = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_buttonsecond);
            holder.layoutButtonSecond = (LinearLayout) view.findViewById(R.id.mi_limit_fragment_earnest_code_adapter_buttonlayoutsecond);

            view.setTag(holder);
        }else{
            holder = (MilimitFragmentEarnestCodeHolder) view.getTag();
        }

        MilimitFragmentEarnestCodeEntry init = (MilimitFragmentEarnestCodeEntry) getItem(i);

        holder.layoutBackGround.setBackgroundColor(init.getBackgroundColor());
        holder.imageurl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());

        holder.buttonFirst.setText(init.getButtonFirst());
        holder.buttonSecond.setText(init.getButtonSecond());

        if (!init.isStateFirst()){
            holder.layoutButtonFirst.setVisibility(View.GONE);
        }else{
            holder.layoutButtonFirst.setVisibility(View.VISIBLE);
        }


        if (!init.isStateSecond()){
            holder.layoutButtonSecond.setVisibility(View.GONE);
        }else{
            holder.layoutButtonSecond.setVisibility(View.VISIBLE);
        }

        if (init.getBackgroundColor() == Color.parseColor("#c4c4c4")){
            holder.buttonFirst.setTextColor(Color.parseColor("#010101"));
            holder.buttonFirst.setBackgroundColor(Color.WHITE);
            holder.buttonSecond.setTextColor(Color.parseColor("#010101"));
            holder.buttonSecond.setBackgroundColor(Color.WHITE);
        }else {
            holder.buttonFirst.setTextColor(Color.WHITE);
            holder.buttonFirst.setBackgroundColor(Color.parseColor("#cccccc"));
            holder.buttonSecond.setTextColor(Color.WHITE);
            holder.buttonSecond.setBackgroundColor(Color.parseColor("#cccccc"));
        }

        return view;
    }

    public class MilimitFragmentEarnestCodeHolder{
        private RelativeLayout layoutBackGround;
        private ImageView imageurl;
        private TextView lible;
        private TextView content;
        private TextView buttonFirst;
        private TextView buttonSecond;
        private LinearLayout layoutButtonFirst;
        private LinearLayout layoutButtonSecond;

    }

}
