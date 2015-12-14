package com.example.isweixin;


import com.tencent.weibo.oauthv2.OAuthV2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SaveDate {
	private static SharedPreferences preferences;


	public SaveDate(Context context) {

	}
	public static void saveDate(Context context, OAuthV2 token) {
	preferences = context
	.getSharedPreferences("notekey", Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString("token", token.getAccessToken());   //token
		editor.putString("expiresTime", token.getExpiresIn()); //过期时间
		editor.putString("openid", token.getOpenid());  
		editor.putString("opkey", token.getOpenkey());
		editor.putString("key", token.getClientId());
		editor.putString("url", token.getClientSecret());
		editor.commit();
	
	}
	public static OAuthV2 getDate(Context context)
	{
		OAuthV2 oAuth=new OAuthV2();
		preferences = context
		.getSharedPreferences("notekey", Context.MODE_PRIVATE);
	
		oAuth.setAccessToken(preferences.getString("token", ""));
		oAuth.setExpiresIn(preferences.getString("expiresTime", null));
		oAuth.setOpenid(preferences.getString("openid", null));
		oAuth.setOpenkey(preferences.getString("opkey", null));
		oAuth.setClientId(preferences.getString("key", null));
		oAuth.setClientSecret(preferences.getString("url", null));
		return oAuth;
	}
}
