package com.begentgroup.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

    CheckBox checkView;

    boolean isForced = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        checkView = (CheckBox)findViewById(R.id.check_check);
        checkView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!isForced) {
                    Toast.makeText(CheckActivity.this, "checked changed : " + b, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btn = (Button)findViewById(R.id.btn_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = checkView.isChecked();
                isForced = true;
                checkView.setChecked(!checked);
                isForced = false;
            }
        });

    }
}
