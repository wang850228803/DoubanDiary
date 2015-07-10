package com.wanghui.doubandiary;

import org.json.JSONArray;
import org.json.JSONException;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DoubanListAdapter extends BaseAdapter {
	private AbstractActivity context;
	private JSONArray notes;

	public DoubanListAdapter(AbstractActivity context, JSONArray notes) {
		this.context = context;
		this.notes = notes;
	}

	public int getCount() {
		return notes.length();
	}

	public Object getItem(int position) {
		try {
			return notes.getJSONObject(position);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		try {
			return new NoteView(context, notes.getJSONObject(position));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}