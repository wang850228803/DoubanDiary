package com.wanghui.doubandiary;

import org.json.JSONException;
import org.json.JSONObject;

public class Note extends JSONObject {
    private JSONObject obj;

    public Note(JSONObject object) {
        obj = object;
    }
    
    public String getTitle() {
        try {
            return obj.getString("title");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public String getSummary() {
        try {
            return obj.getString("summary");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public String getContent() {
        try {
            return obj.getString("content");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
