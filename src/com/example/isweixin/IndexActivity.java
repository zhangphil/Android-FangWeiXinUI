package com.example.isweixin;

import java.util.Timer;
import java.util.TimerTask;

import com.tencent.weibo.oauthv2.OAuthV2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class IndexActivity extends Activity {
	private String app_key = "801416605"; // 获取的appkey
	private String clientSecret = "afb3b09cc0ae263d8d992c141b71973a"; // 注册应用获取
	private String app_uri = "http://www.xiaoxiu.com";
	public  static OAuthV2 oAuth;
	private int index = 0;
	private Timer timer;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
//			if(index>0){
				//txfenxiang();
				timer.cancel();
//			}
			Intent intent = new Intent(IndexActivity.this,
					MainActivity.class);
			startActivity(intent);
			finish();
			super.handleMessage(msg);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.index);
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				index = index+1;
				handler.sendEmptyMessage(0);
			}
		},1500,1000);
	}
	
	//这里做的是腾讯微博QQ授权
	private void txfenxiang(){
		oAuth = SaveDate.getDate(IndexActivity.this);
		if("".equals(oAuth.getAccessToken())){
			oAuth = new OAuthV2(app_uri);
			oAuth.setClientId(app_key);
			oAuth.setClientSecret(clientSecret); 
			Intent intent = new Intent(IndexActivity.this, MyWebView.class);
			intent.putExtra("oauth", oAuth); 
			startActivityForResult(intent,2);
		}else{
			Intent intent = new Intent(IndexActivity.this,
					MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 2) {
			if (resultCode == 2) {
				/*******此处没有执行！！！！！！！！！！！！！***********/
				oAuth = (OAuthV2) data.getExtras().getSerializable("oauth");
				SaveDate.saveDate(IndexActivity.this, oAuth);
				// 调用API获取用户信息
//				UserAPI userAPI = new UserAPI(OAuthConstants.OAUTH_VERSION_2_A);
//				String response = null;
//				try {
//					response = userAPI.info(oAuth, "json");// 获取用户信息
//					Log.i(TAG,"qq::"+response);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				userAPI.shutdownConnection();
				Intent intent = new Intent(IndexActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		}
	}
}
