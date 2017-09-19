/*
* @Title:  ShareAdapter.java
* @Copyright:  XXX Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
* @data:  2014-7-21 ����2:30:32
* @version:  V1.0
*/

package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;

/**
 * TODO< 分享Adapter >
 * @version:  V1.0
 */

public class ShareAdapter extends BaseAdapter {

     private static String[] shareNames = new String[] {"微信好友", "QQ好友", "新浪微博","微信朋友圈", "QQ空间", "复制链接"};
        private int[] shareIcons = new int[] {R.mipmap.weixinyouhao, R.mipmap.qqhaoyou,
                R.mipmap.xinlangweisbo,R.mipmap.weixinfriend,
                R.mipmap.qqkongjian,R.mipmap.fuzhilianjie};

        private LayoutInflater inflater;

        public ShareAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount()
        {
            return shareNames.length;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null){
                convertView = inflater.inflate(R.layout.share_item, null);
            }
            ImageView shareIcon = (ImageView) convertView.findViewById(R.id.share_icon);
            TextView shareTitle = (TextView) convertView.findViewById(R.id.share_title);
            shareIcon.setImageResource(shareIcons[position]);
            shareTitle.setText(shareNames[position]);

            return convertView;
        }
    }
