package com.wanghui.doubandiary;

import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteView extends LinearLayout {
    private Note item;
    
    public NoteView(Context context) {
        super(context);
    }

    public NoteView(final AbstractActivity context, final JSONObject json) {
        super(context);
        this.item = new Note(json);

        //TODO: cache avatar.
        setOrientation(VERTICAL);
        setPadding(0, 12, 25, 12);

        TextView title = new TextView(context);
        title.setText(item.getTitle());
        title.setTextColor(0xff606060);
        addView(title);

        //TODO: use fragment.
        if (context instanceof MainActivity) this.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra("json", json.toString());
                context.startActivity(intent);
            }
        });
    }

}
