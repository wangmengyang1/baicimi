package com.baicimi.interfaces;

import android.view.View;
import android.widget.BaseAdapter;

/**
 * Created by Administrator on 2017/8/22.
 * 订货清单底部listview接口
 */

public interface DistributionNumberOnitemClickVP {
    void setNumberOnitemClick(View view, int i, long l , BaseAdapter adapter);
}
