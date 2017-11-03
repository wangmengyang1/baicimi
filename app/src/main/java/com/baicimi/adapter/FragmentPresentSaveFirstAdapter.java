package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.dialog.NoticeDialog;
import com.baicimi.entity.FragmentPresentSaveFirstEntry;
import com.baicimi.view.PresentSaveFirstExamineDialog;
import com.baicimi.view.PresentSaveFirstExamineSecondDialog;
import com.baicimi.view.PresentSaveFirstGivenTooneDialog;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */
public class FragmentPresentSaveFirstAdapter extends BaseAdapter{

    private List<FragmentPresentSaveFirstEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public FragmentPresentSaveFirstAdapter(List<FragmentPresentSaveFirstEntry> list, Context context) {
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
        FragmentPresentSaveFirstHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.fragment_present_save_first_adapter , null);
            holder = new FragmentPresentSaveFirstHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.fragment_present_save_first_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_content);
            holder.deadline = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_deadline);
            holder.examine = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_examine);
            holder.draw = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_draw);
            holder.giventoone = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_giventoone);
            holder.share = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_share);
            holder.isExpire = (TextView) view.findViewById(R.id.fragment_present_save_first_adapter_isExpire);
            holder.isloseEfficacy = (ImageView) view.findViewById(R.id.fragment_present_save_first_adapter_isloseEfficacy);
            view.setTag(holder);
        }else{
            holder = (FragmentPresentSaveFirstHolder) view.getTag();
        }
        final FragmentPresentSaveFirstEntry init = (FragmentPresentSaveFirstEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());
        holder.deadline.setText(init.getDeadline());


        if (!init.isExpire() && !init.isloseEfficacy()){
            holder.isExpire.setVisibility(View.INVISIBLE);
            holder.isloseEfficacy.setVisibility(View.INVISIBLE);
        }else if (init.isExpire()){
            holder.isExpire.setVisibility(View.VISIBLE);
            holder.isloseEfficacy.setVisibility(View.INVISIBLE);
        }else if (init.isloseEfficacy()){
            holder.isExpire.setVisibility(View.INVISIBLE);
            holder.isloseEfficacy.setVisibility(View.VISIBLE);
        }

        holder.examine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (init.getDeadline().equals("寄存有效时长：2016-09-15 - 2017-10-10")){
                    PresentSaveFirstExamineSecondDialog presentSaveFirstExamineSecondDialog = new PresentSaveFirstExamineSecondDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive);
                    presentSaveFirstExamineSecondDialog.show();
                }else if (init.isloseEfficacy()){

                }else {
                    //查看
                    PresentSaveFirstExamineDialog presentSaveFirstExamineDialog = new  PresentSaveFirstExamineDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive);
                    presentSaveFirstExamineDialog.show();
                }


            }
        });

        holder.giventoone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //转赠好友
                PresentSaveFirstGivenTooneDialog presentSaveFirstGiventoone = new PresentSaveFirstGivenTooneDialog(context , R.style.MeiGuiMeiShiSecondMyorderFive);
                presentSaveFirstGiventoone.show();
            }
        });



        return view;
    }

    public class FragmentPresentSaveFirstHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;
        private TextView deadline;
        private TextView examine;
        private TextView draw;
        private TextView giventoone;
        private TextView share;

        private TextView isExpire;
        private ImageView isloseEfficacy;
    }

}
