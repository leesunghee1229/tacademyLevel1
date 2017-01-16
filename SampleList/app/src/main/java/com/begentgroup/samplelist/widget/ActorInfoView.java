package com.begentgroup.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.begentgroup.samplelist.R;
import com.begentgroup.samplelist.data.Actor;

/**
 * Created by Administrator on 2016-07-15.
 */
public class ActorInfoView extends FrameLayout {
    public ActorInfoView(Context context) {
        super(context);
        init();
    }

    ImageView photoView;
    TextView nameView, ageView, descView;
    private void init() {
        inflate(getContext(), R.layout.view_actor_info, this);
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
        descView = (TextView)findViewById(R.id.text_description);
    }

    Actor actor;
    public void setActor(Actor actor) {
        this.actor = actor;
        photoView.setImageDrawable(actor.photo);
        nameView.setText(actor.name);
        ageView.setText(""+actor.age);
        descView.setText(actor.description);
    }

    public Actor getActor() {
        return actor;
    }
}
