package com.wanghui.doubandiary;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class AddDiary extends AbstractActivity{
    EditText title;
    EditText content;
    String priv;
    String rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_diary);
        title = (EditText)findViewById(R.id.title);
        content = (EditText)findViewById(R.id.content);
        RadioGroup privacy = (RadioGroup) findViewById(R.id.privacy);
        RadioGroup reply = (RadioGroup) findViewById(R.id.can_reply);
        Button btn = (Button) findViewById(R.id.submit);
        
        privacy.setOnCheckedChangeListener(new OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch(checkedId) {
                    case R.id.public_radio:
                        priv = "public";
                        break;
                    case R.id.friend_radio:
                        priv = "friend";
                        break;
                    case R.id.private_radio:
                        priv = "private";
                        break;
                    default:
                        break;
                }
            }
            
        });
        
        reply.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.yes:
                        rep = "true";
                        break;
                    case R.id.no:
                        rep = "false";
                        break;
                    default:
                        break;
                }
            }
        });
        
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                SharedPreferences preference = AddDiary.this.getSharedPreferences(DoubanUtil.PREF, MODE_PRIVATE);
                DoubanService service = new DoubanService(preference.getString(DoubanUtil.PREF_ACCESS_TOKEN, null), 
                        preference.getString(DoubanUtil.PREF_USER, null), AddDiary.this);
                service.addDiary(title.getText().toString(), content.getText().toString(), priv, rep);
            }
            
        });
    }

}
