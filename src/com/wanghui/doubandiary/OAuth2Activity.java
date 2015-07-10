package com.wanghui.doubandiary;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OAuth2Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WebView webView = new WebView(this);
		setContentView(webView);

		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				if (url.startsWith(DoubanUtil.CALLBACK)) {
					view.stopLoading();
					Uri uri = Uri.parse(url);
					if (uri.getQueryParameter("error") == null) {
						try {
						    String str = DoubanService.getAccessToken(uri.getQueryParameter("code"));
							JSONObject retJsonObject = new JSONObject(str);
							String token = retJsonObject.getString("access_token");
							String user = retJsonObject.getString("douban_user_id");
							SharedPreferences preference = getSharedPreferences(DoubanUtil.PREF, MODE_PRIVATE);
							preference.edit().putString(DoubanUtil.PREF_ACCESS_TOKEN, token).putString(DoubanUtil.PREF_USER, user).commit();
							Log.i("oauth", token);
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
					finish();
				}
			}
		});

		webView.loadUrl(DoubanUtil.AuthenticateURL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
