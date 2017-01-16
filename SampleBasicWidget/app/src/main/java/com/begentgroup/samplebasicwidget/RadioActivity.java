package com.begentgroup.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioActivity extends AppCompatActivity {

    RadioGroup groupView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        groupView = (RadioGroup)findViewById(R.id.group_select_button);
        groupView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                displayRadio(id);
            }
        });

        Button btn = (Button)findViewById(R.id.btn_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = groupView.getCheckedRadioButtonId();
                displayRadio(id);
                groupView.check(R.id.radio_b2);
            }
        });
    }

    private void displayRadio(int id) {
        String message = null;
        switch (id) {
            case R.id.radio_b1 :
                message = "B1";
                break;
            case R.id.radio_b2 :
                message = "B2";
                break;
            case R.id.radio_b3 :
                message = "B3";
                break;
        }
        Toast.makeText(this, "Select : " + message, Toast.LENGTH_SHORT).show();
    }
}
