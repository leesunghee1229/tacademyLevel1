package com.begentgroup.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button btn = (Button)findViewById(R.id.btn_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "Button Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onButtonClick(View view) {
        Toast.makeText(this, "onButtonClick", Toast.LENGTH_SHORT).show();
    }

}
