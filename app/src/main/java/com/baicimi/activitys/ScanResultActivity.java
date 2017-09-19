package com.baicimi.activitys;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseActivity;
import com.baicimi.conf.Constant;
import com.baicimi.ui.SharedPreferencesUtil;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

@ContentView(R.layout.fragment_scan_result)
public class ScanResultActivity extends BaseActivity {
    @ViewInject(R.id.scan_result)
    private WebView webview;
    @ViewInject(R.id.tv_scan_result)
    private TextView tv_webview;

    @Override
    protected void initData() {

        String scant_result = SharedPreferencesUtil.getString(getApplicationContext(), Constant.SCAN_RESULT, "");
        // 判断是否是网址，如果是，调用浏览器打开网址,不是就打印出字符串
        if (scant_result.contains("http://")) {
            // 设置支持javascript
            webview.getSettings().setJavaScriptEnabled(true);
            // 设置缓存模式
            webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
            // 启动缓存
            webview.getSettings().setAppCacheEnabled(true);
//            // 在当前的浏览器中响应,最好不要调用当前浏览器，不然像扫描微信等二维码，无法加载出来
//            webview.setWebViewClient(new WebViewClient());
            webview.setWebChromeClient(new WebChromeClient());
            webview.loadUrl(scant_result);

        } else {
            tv_webview.setText(scant_result);
        }
    }


    @OnClick({R.id.login_back})
    public void OnBackClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
               this.finish();
                break;
        }
    }

}
