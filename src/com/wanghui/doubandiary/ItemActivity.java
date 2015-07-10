package com.wanghui.doubandiary;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ItemActivity extends AbstractActivity{
	private Note item;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.item);
		SharedPreferences preference = this.getSharedPreferences(DoubanUtil.PREF, MODE_PRIVATE);
		service = new DoubanService(preference.getString(DoubanUtil.PREF_ACCESS_TOKEN, null), preference.getString(DoubanUtil.PREF_USER, null), this);

		TextView title = (TextView) findViewById(R.id.title);
		TextView content = (TextView) findViewById(R.id.content);

		try {
			item = new Note(new JSONObject(getIntent().getStringExtra("json")));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		title.setText(item.getTitle());
		content.setText(item.getContent());
	}
}
