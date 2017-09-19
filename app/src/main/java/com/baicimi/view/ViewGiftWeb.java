package com.baicimi.view;



import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.baicimi.R;

public class ViewGiftWeb extends LinearLayout{

	private Context context;
	private WebView webView;
	
	
	public ViewGiftWeb(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}
	


   private void initView() {
	   View view = View.inflate(getContext(), R.layout.view_web, this);
	   webView = (WebView) view.findViewById(R.id.wv_default);
	}


   public void initState(String url) {
	   WebSettings webSettings = webView.getSettings();
		// ����WebView���ԣ��ܹ�ִ��Javascript�ű�
		webSettings.setJavaScriptEnabled(true);
		// ���ÿ��Է����ļ�
		webSettings.setAllowFileAccess(true);
		// ����֧������
		webSettings.setBuiltInZoomControls(true);

		// ��������
		webView.getSettings().setAppCacheEnabled(true);
		// ���û���ģʽ
		webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		// ������Ҫ��ʾ����ҳ
		webView.loadUrl(url);
		// ����Web��ͼ
		webView.setWebViewClient(new webViewClient());
	
}


   private class webViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}
}
