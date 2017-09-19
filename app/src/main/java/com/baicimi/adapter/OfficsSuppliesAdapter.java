package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.OfficsSuppliesEntry;
import com.baicimi.interfaces.OfficeSuppliesOnitemClick;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class OfficsSuppliesAdapter extends BaseAdapter{

    private Context context;
    private List<OfficsSuppliesEntry> list;
    private LayoutInflater inflater;
    private OfficeSuppliesOnitemClick officeSuppliesOnitemClick;

    public OfficsSuppliesAdapter(Context context, List<OfficsSuppliesEntry> list , OfficeSuppliesOnitemClick officeSuppliesOnitemClick) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.officeSuppliesOnitemClick = officeSuppliesOnitemClick;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        OfficsSuppliesHoldre holdre = null;
        if(view == null){
            view = inflater.inflate(R.layout.offise_supplies_adapter , null);
            holdre = new OfficsSuppliesHoldre();
            holdre.lible = (TextView) view.findViewById(R.id.office_supplies_fragment_lible);
            holdre.imageUrl = (ImageView) view.findViewById(R.id.office_supplies_fragment_imageurl);
            holdre.money = (TextView) view.findViewById(R.id.office_supplies_fragment_money);
            holdre.number = (TextView) view.findViewById(R.id.office_supplies_adapter_number);
            holdre.add = (ImageView) view.findViewById(R.id.office_supplies_adapter_add);
            holdre.subtract = (ImageView) view.findViewById(R.id.office_supplies_adapter_subtract);
            view.setTag(holdre);
        }else{
            holdre = (OfficsSuppliesHoldre) view.getTag();
        }
        OfficsSuppliesEntry init = (OfficsSuppliesEntry) getItem(i);
        holdre.lible.setText(init.getLible());
        holdre.imageUrl.setImageResource(init.getImageUrl());
        holdre.money.setText(init.getMoney());
        holdre.number.setText(init.getNumber() + "");
        holdre.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                officeSuppliesOnitemClick.setOfficeSuppliesOnitemClick(view , i , R.id.office_supplies_adapter_add);
            }
        });

        holdre.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                officeSuppliesOnitemClick.setOfficeSuppliesOnitemClick(view , i , R.id.office_supplies_adapter_subtract);
            }
        });

        return view;
    }

    public class OfficsSuppliesHoldre{
        private TextView lible;
        private ImageView imageUrl;
        private TextView money;
        private TextView number;
        private ImageView add;
        private ImageView subtract;
    }

}
