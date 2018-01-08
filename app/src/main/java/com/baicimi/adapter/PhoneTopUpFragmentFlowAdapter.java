package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.PhoneTopUpFragmentPhoneEntry;

import java.util.List;

/**
 * Created by Administrator on 2018/1/8.
 */
public class PhoneTopUpFragmentFlowAdapter extends BaseAdapter{
    private List<PhoneTopUpFragmentPhoneEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public PhoneTopUpFragmentFlowAdapter(List<PhoneTopUpFragmentPhoneEntry> list, Context context) {
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
       PhoneTopUpFragmentPhoneHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.phone_topup_fragment_flow_adapter , null);
            holder = new PhoneTopUpFragmentPhoneHolder();
            holder.lible = (TextView) view.findViewById(R.id.phone_topup_fragment_flow_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.phone_topup_fragment_flow_adapter_content);
            holder.checkBox = (CheckBox) view.findViewById(R.id.phone_topup_fragment_flow_adapter_checkbox);

            view.setTag(holder);
        }else{
            holder = (PhoneTopUpFragmentPhoneHolder) view.getTag();
        }

        PhoneTopUpFragmentPhoneEntry init = (PhoneTopUpFragmentPhoneEntry) getItem(i);

        holder.lible.setText(init.getLible());
        holder.checkBox.setChecked(init.isState());
        return view;
    }

    public class PhoneTopUpFragmentPhoneHolder{
        private TextView lible;
        private TextView content;
        private CheckBox checkBox;
    }
}
