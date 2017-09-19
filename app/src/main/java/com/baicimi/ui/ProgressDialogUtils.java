package com.baicimi.ui;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2016/3/14.
 */
public class ProgressDialogUtils {

    static ProgressDialog progressDlg = null;

    /**
     * 启动进度条
     *
     * @param strMessage
     *            进度条显示的信息
     */
    public static void showProgressDlg(String strMessage, Context ctx) {

        if (null == progressDlg) {
            progressDlg = new ProgressDialog(ctx);
            //提示的消息
            progressDlg.setMessage(strMessage);
            progressDlg.setIndeterminate(false);
            progressDlg.setCancelable(false);
            progressDlg.show();
        }
    }

    /**
     * 结束进度条
     */
    public static void stopProgressDlg() {
        if (null != progressDlg) {
            progressDlg.dismiss();
            progressDlg = null;
        }
    }
}
