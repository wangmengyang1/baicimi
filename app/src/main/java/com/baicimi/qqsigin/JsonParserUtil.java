package com.baicimi.qqsigin;

import com.google.gson.Gson;

public class JsonParserUtil {
   
	public static QQLoadInfo getQQLoadInfo(String result){
		Gson gson=new Gson();
		QQLoadInfo qQLoadInfo=gson.fromJson(result, QQLoadInfo.class);
		if(qQLoadInfo==null){
			qQLoadInfo=new QQLoadInfo();
		}
		return qQLoadInfo;
	}
	
	public static QQUserInfo getQQUserInfo(String result){
		Gson gson=new Gson();
		QQUserInfo qQUserInfo=gson.fromJson(result, QQUserInfo.class);
		if(qQUserInfo==null){
			qQUserInfo=new QQUserInfo();
		}
		return qQUserInfo;
	}
}
