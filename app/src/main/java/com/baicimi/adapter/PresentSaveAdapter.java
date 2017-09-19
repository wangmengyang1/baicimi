package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.dialog.NoticeDialog;
import com.baicimi.entity.PresentSave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */
public class PresentSaveAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;
    private LayoutInflater inflater;
    private List<PresentSave> date = new ArrayList();
    private int count;
    private int item;

    public void setItem(int item) {
        this.item = item;
    }

    public PresentSaveAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public List<PresentSave> getDate() {
        return date;
    }

    public void setDate(List<PresentSave> date) {
        this.date = date;
    }

    @Override
    public int getCount() {
        return date.size();
    }

    @Override
    public Object getItem(int i) {
        return date.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PresentSaveHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.activity_present_check_adapter , null);
            holder = new PresentSaveHolder();
            holder.presentcheck = (ImageView) view.findViewById(R.id.present_check_adapter_product);
            holder.lible = (TextView) view.findViewById(R.id.present_check_adapter_lible);
            holder.describe = (TextView) view.findViewById(R.id.present_check_adapter_synopsis);
            holder.validitydate = (TextView) view.findViewById(R.id.present_check_adapter_date);
            holder.examine = (Button) view.findViewById(R.id.present_check_adapter_btn_examine);
            holder.get = (Button) view.findViewById(R.id.present_check_adapter_btn_get);
            holder.givepresent = (Button) view.findViewById(R.id.present_check_adapter_btn_givepresent);
            holder.share = (TextView) view.findViewById(R.id.present_check_share);
            view.setTag(holder);
        }else{
            holder = (PresentSaveHolder) view.getTag();
        }

        count = i;
        //找控件
        holder.presentcheck.setImageResource(R.drawable.ic_product);
        holder.lible.setText(date.get(i).getLible());
        holder.describe.setText(date.get(i).getDescribe());
        holder.validitydate.setText(date.get(i).getValiditydate());
        //设置监听事件（查看）
        holder.examine.setOnClickListener(this);
        //设置监听事件（领取）
        if(item != 1){
            holder.get.setVisibility(View.VISIBLE);
            holder.get.setOnClickListener(this);
        }

        //设置监听事件（转赠好友）
        holder.givepresent.setOnClickListener(this);
        //设置监听事件（一键分享）
        holder.share.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.present_check_adapter_btn_examine:
                //点击时触发弹出对话框
                final NoticeDialog dialog = new NoticeDialog(context , R.style.MeiGuiMeiShiSecondMyorder);
                dialog.setContentView(R.layout.dialog_notice_choise);
                dialog.setStr(date.get(count).getDescribe());
                dialog.setLible(date.get(count).getLible());
                dialog.setDate(date.get(count).getValiditydate());
                dialog.show();
                break;
            case R.id.present_check_adapter_btn_get:
                Toast.makeText(context , "点击了领取" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.present_check_adapter_btn_givepresent:
                Toast.makeText(context , "点击了转赠好友" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.present_check_share:
                Toast.makeText(context , "点击了一键分享" , Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public class PresentSaveHolder{
        private ImageView presentcheck;//商品图片
        private TextView lible;//标题
        private TextView describe;//描述
        private TextView validitydate;//有效期
        private Button examine;//查看
        private Button get;//领取
        private Button givepresent;//转增好友
        private TextView share;//一键分享

    }
}
