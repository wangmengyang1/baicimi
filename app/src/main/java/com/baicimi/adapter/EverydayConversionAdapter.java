package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.EverydayConversionEntry;
import com.baicimi.fragments.ConversionRuleFragment;
import com.baicimi.fragments.HomeConversionSubscribeFragment;
import com.baicimi.fragments.HomeIntegerConversionDetails;
import com.baicimi.fragments.HomeIntegerSubscribeDetails;
import com.baicimi.view.EveryDayConversionDialog;
import com.baicimi.view.ImmediatelyConversionDialog;
import com.baicimi.view.MessageWarmRequestDialog;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */
public class EverydayConversionAdapter extends BaseAdapter {

    private List<EverydayConversionEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private int count = 5;
    private BaseFragment fragment;
    private int dialogIndex;

    public EverydayConversionAdapter(List<EverydayConversionEntry> list, Context context ,BaseFragment fragment) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    public EverydayConversionAdapter(List<EverydayConversionEntry> list, Context context, int count ) {
        this.list = list;
        this.context = context;
        this.count = count;
        this.inflater = LayoutInflater.from(context);
    }


    public EverydayConversionAdapter(List<EverydayConversionEntry> list, Context context, int count, BaseFragment fragment) {
        this.list = list;
        this.context = context;
        this.count = count;
        this.fragment = fragment;
        this.inflater = LayoutInflater.from(context);
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
        EverydayConversionHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.every_conversion_adapter, null);
            holder = new EverydayConversionHolder();
            holder.time = (TextView) view.findViewById(R.id.every_conversion_adapter_time);
            holder.state = (TextView) view.findViewById(R.id.every_conversion_adapter_state);
            holder.imageUrl = (ImageView) view.findViewById(R.id.every_conversion_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.every_conversion_adapter_lible);
            holder.money = (TextView) view.findViewById(R.id.every_conversion_adapter_money);
            holder.integerMoney = (TextView) view.findViewById(R.id.every_conversion_adapter_integer);
            holder.number = (TextView) view.findViewById(R.id.every_conversion_adapter_number);
            holder.rule = (TextView) view.findViewById(R.id.every_conversion_adapter_rule);
            holder.conversion = (TextView) view.findViewById(R.id.every_conversion_adapter_conversion);
            holder.rushpurchase = (TextView) view.findViewById(R.id.every_conversion_adapter_rushpurchase);
            holder.headImage = (ImageView) view.findViewById(R.id.every_conversion_adapter_head_image);

            view.setTag(holder);
        } else {
            holder = (EverydayConversionHolder) view.getTag();
        }

        EverydayConversionEntry init = (EverydayConversionEntry) getItem(i);

        holder.time.setText(init.getTime());
        if (init.getState().equals("兑换结束")) {
            holder.conversion.setText("兑换详情");
            holder.rushpurchase.setVisibility(View.INVISIBLE);
            if (((EverydayConversionEntry) getItem(i)).getState().equals("进行中")){
                holder.rushpurchase.setBackgroundResource(R.drawable.every_conversion_adapter_layout_shapes);
            }

            holder.conversion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (fragment != null){
                        fragment.startFragment(new HomeIntegerConversionDetails());//兑换详情
                    }
                }
            });
        } else if (count == 0) {
            holder.conversion.setText("设置提醒");
            holder.conversion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EveryDayConversionDialog everyDayConversionDialog = new EveryDayConversionDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive);
                    everyDayConversionDialog.show();
                }
            });

            if (((EverydayConversionEntry) getItem(i)).getState().equals("进行中")){
//                holder.conversion.setVisibility(View.INVISIBLE);
            }

        }else if (count == 2){
            holder.headImage.setVisibility(View.GONE);
            holder.conversion.setText("预约详情");
            holder.rushpurchase.setText("立即预约");

            if (((EverydayConversionEntry) getItem(i)).getState().equals("进行中")){
                holder.rushpurchase.setBackgroundResource(R.drawable.every_conversion_adapter_layout_shapes);
            }

            holder.conversion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (fragment != null){
                        fragment.startFragment(new HomeIntegerSubscribeDetails());//预约详情
                    }
                }
            });
            holder.rushpurchase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //立即预约
                    dialogIndex++;
                    if (dialogIndex % 4 == 0){
                        ImmediatelyConversionDialog immediatelyConversionDialog = new ImmediatelyConversionDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive , false);
                        immediatelyConversionDialog.show();
                    }else if (dialogIndex % 4 == 1){
                        ImmediatelyConversionDialog immediatelyConversionDialog = new ImmediatelyConversionDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive , true);
                        immediatelyConversionDialog.show();
                    }else if (dialogIndex % 4 == 2){
                        MessageWarmRequestDialog messageWarmRequestDialog = new MessageWarmRequestDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive);
                        messageWarmRequestDialog.show();
                    }else if (dialogIndex % 4 == 3){
                        fragment.startFragment(new HomeConversionSubscribeFragment());//兑换预约
                    }
                }
            });
        }else if (count == 4){
            holder.conversion.setText("预约详情");
            holder.rushpurchase.setText("立即预约");

            if (((EverydayConversionEntry) getItem(i)).getState().equals("进行中")){
                holder.rushpurchase.setBackgroundResource(R.drawable.every_conversion_adapter_layout_shapes);
            }
            holder.conversion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (fragment != null){
                        fragment.startFragment(new HomeIntegerSubscribeDetails());//预约详情
                    }
                }
            });
//            holder.rushpurchase.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (fragment != null){
////                        fragment.startFragment(new HomeConversionSubscribeFragment());//兑换预约
//
//
//                    }
//                }
//            });
        }
        holder.state.setText(init.getState());
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getName());
        holder.money.setText(init.getMoney());
        holder.integerMoney.setText(init.getIntegerMoney());
        holder.number.setText(init.getNumber());
        holder.rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fragment != null){
                    //兑换规则
                    fragment.startFragment(new ConversionRuleFragment());
                }
            }
        });

        if (((EverydayConversionEntry) getItem(i)).getState().equals("进行中")){
            holder.rushpurchase.setBackgroundResource(R.drawable.every_conversion_adapter_layout_shapes);
//                holder.conversion.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    public class EverydayConversionHolder {
        private TextView time;
        private TextView state;
        private ImageView imageUrl;
        private TextView lible;
        private TextView money;
        private TextView integerMoney;
        private TextView number;
        private TextView rule;
        private TextView rushpurchase;
        private TextView conversion;
        private ImageView headImage;

    }

}
