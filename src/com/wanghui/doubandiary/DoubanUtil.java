package com.wanghui.doubandiary;

import android.util.Log;

public class DoubanUtil {
	public static final String PREF = "PrefDouban";
	
	public static final String AuthenticateURL = "https://www.douban.com/service/auth2/auth?client_id="+DoubanUtil.API_KEY+
            "&redirect_uri="+DoubanUtil.CALLBACK+"&response_type=code";
	public static final String TokenURL = "https://www.douban.com/service/auth2/token";
	
	public static final String API_KEY = "083c5c0f730900f518b5142e591b02df";
	public static final String SECRET = "d0ccfd9a6556407b";
	public static final String CALLBACK = "http://myapp.com/callback";
	public static final String PREF_ACCESS_TOKEN = "access_token";
	public static final String PREF_USER = "user";
	
	//Douban Diary related API
	public static final String DIARY_LIST = "https://api.douban.com/v2/note/user_created/";
	public static final String ADD_DIARY = "https://api.douban.com/v2/notes";
	//public static final String SCOPE = "douban_basic_common，community_basic_note";

/*    public static String stripText(String text) {
    	Log.i("before", text);
    	text = text.replaceFirst("\\[score\\]", " ( ")
    			.replaceFirst("\\[/score\\]", "�� )")
    			.replaceAll("\\r", "")
    			.replaceAll("\\n", "")
    			.replaceAll(" +", " ");
    	Log.i("after", text);
    	return text;
    }*/
}
