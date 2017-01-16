package com.begentgroup.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.begentgroup.samplelist.R;
import com.begentgroup.samplelist.data.ReceiveData;

/**
 * Created by Administrator on 2016-07-13.
 */
public class ReceiveView extends FrameLayout {
    public ReceiveView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    ImageView photoView;

    private void init() {
        inflate(getContext(), R.layout.view_receive, this);
        messageView = (TextView)findViewById(R.id.text_message);
        photoView = (ImageView)findViewById(R.id.image_photo);
    }

    ReceiveData data;
    public void setData(ReceiveData data) {
        this.data = data;
        messageView.setText(data.getMessage());
        photoView.setImageDrawable(data.getPhoto());
    }
}
