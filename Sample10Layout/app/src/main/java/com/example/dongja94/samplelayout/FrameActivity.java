package com.example.dongja94.samplelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    ImageView dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        dialogView = (ImageView)findViewById(R.id.image_dialog);
        ImageView buttonView = (ImageView)findViewById(R.id.image_small);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogView.getVisibility() == View.GONE) {
                    dialogView.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation(FrameActivity.this, android.R.anim.slide_in_left);
                    dialogView.startAnimation(anim);
                } else {
                    dialogView.setVisibility(View.GONE);
                }
            }
        });

        dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView.setVisibility(View.GONE);
            }
        });
    }
}
