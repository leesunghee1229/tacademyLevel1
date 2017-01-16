package com.begentgroup.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.begentgroup.samplelist.R;
import com.begentgroup.samplelist.data.DateData;

/**
 * Created by Administrator on 2016-07-13.
 */
public class DateView extends FrameLayout {
    public DateView(Context context) {
        super(context);
        init();
    }

    TextView messageView;

    private void init() {
        inflate(getContext(), R.layout.view_date, this);
        messageView = (TextView)findViewById(R.id.text_message);
    }

    DateData data;
    public void setData(DateData data) {
        this.data = data;
        messageView.setText(data.getMessage());
    }
}
