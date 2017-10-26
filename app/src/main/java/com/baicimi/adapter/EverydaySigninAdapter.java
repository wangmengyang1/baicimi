package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.EverydaySigninEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class EverydaySigninAdapter extends BaseAdapter{

    private List<EverydaySigninEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public EverydaySigninAdapter(List<EverydaySigninEntry> list, Context context) {
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
        EverydaySigninHolder holder = null;
        EverydaySigninEntry init = (EverydaySigninEntry) getItem(i);

        if (view == null && (!init.isState()) && (!init.isNotreachState())){//已签到
            view = inflater.inflate(R.layout.everyday_signin_adapter, null);
            holder = new EverydaySigninHolder();
            holder.signinDate = (TextView) view.findViewById(R.id.every_day_signin_adapter_signindate);
            holder.signinNumber = (TextView) view.findViewById(R.id.every_day_signin_adapter_signinNumber);
            holder.layout_01 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_01);
            holder.layout_02 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_02);
            holder.layout_03 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_03);
            holder.layout_04 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_04);

            view.setTag(holder);
        }else if (view == null && init.isState() && (!init.isNotreachState())){//错过签到
            view = inflater.inflate(R.layout.everyday_signin_adapter, null);
            holder = new EverydaySigninHolder();
            holder.signinDate = (TextView) view.findViewById(R.id.everyday_sigini_adapter_layout02_signinDate);
            holder.layout_01 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_01);
            holder.layout_02 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_02);
            holder.layout_03 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_03);
            holder.layout_04 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_04);

            view.setTag(holder);
        }else if (view == null && init.isNotreachState() && (!init.isState())){//签到时间未到
            view = inflater.inflate(R.layout.everyday_signin_adapter, null);
            holder = new EverydaySigninHolder();
            holder.signinDate = (TextView) view.findViewById(R.id.everyday_sigini_adapter_layout03_signinDate);
            holder.layout_01 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_01);
            holder.layout_02 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_02);
            holder.layout_03 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_03);
            holder.layout_04 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_04);

            view.setTag(holder);
        }else if (view == null && (init.isState()) && (init.isNotreachState())){//奖励
            view = inflater.inflate(R.layout.everyday_signin_adapter, null);
            holder = new EverydaySigninHolder();
            holder.layout_01 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_01);
            holder.layout_02 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_02);
            holder.layout_03 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_03);
            holder.layout_04 = (RelativeLayout) view.findViewById(R.id.every_day_signin_adapter_relativelayout_04);
            view.setTag(holder);
        }else{
            holder = (EverydaySigninHolder) view.getTag();
        }



        if (holder.signinDate != null){
            holder.signinDate.setText(init.getSigninDate());
        }
        if (holder.signinNumber != null){
            holder.signinNumber.setText(init.getSigninNumber());
        }

        if (init.isState() && init.isNotreachState()){
            holder.layout_01.setVisibility(View.GONE);
            holder.layout_02.setVisibility(View.GONE);
            holder.layout_03.setVisibility(View.GONE);
            holder.layout_04.setVisibility(View.VISIBLE);
        }else if (init.isState() && (!init.isNotreachState())){
            holder.layout_01.setVisibility(View.GONE);
            holder.layout_02.setVisibility(View.GONE);
            holder.layout_03.setVisibility(View.VISIBLE);
            holder.layout_04.setVisibility(View.GONE);
        }else if ((!init.isState()) && init.isNotreachState()){
            holder.layout_01.setVisibility(View.GONE);
            holder.layout_02.setVisibility(View.VISIBLE);
            holder.layout_03.setVisibility(View.GONE);
            holder.layout_04.setVisibility(View.GONE);
        }else if ((!init.isState()) && (!init.isNotreachState())){
            holder.layout_01.setVisibility(View.VISIBLE);
            holder.layout_02.setVisibility(View.GONE);
            holder.layout_03.setVisibility(View.GONE);
            holder.layout_04.setVisibility(View.GONE);
        }



        return view;
    }

    public class EverydaySigninHolder{
        private TextView signinDate;//日期
        private TextView signinNumber;//积分数量
        private RelativeLayout layout_01 , layout_02 , layout_03 ,layout_04 ;
    }

}
