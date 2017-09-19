package com.baicimi.http;

import org.json.JSONObject;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.baicimi.ui.L;
import static com.android.volley.Request.Method.GET;


public class DownUtils {	
	public static void downJSON(final String url,final Context context, final OnDownCompelet onDownCompelet){
		RequestQueue queue= Volley.newRequestQueue(context);
		JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(GET, url, null,
				new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject jsonObject) {
				// TODO Auto-generated method stub
				onDownCompelet.downSucc(url, jsonObject);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				L.d("����ʧ��");
			}
		});
		queue.add(jsonObjectRequest);
	}

	public interface OnDownCompelet{
		void downSucc(String url, Object obj);
	};
}
