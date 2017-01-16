package com.begentgroup.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;
//    ArrayAdapter<String> mAdapter;

    MySpinnerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = (Spinner)findViewById(R.id.spinner);
//        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
//        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAdapter = new MySpinnerAdapter();
        spinner.setAdapter(mAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this, "item : " + mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        initData();
    }

    private void initData() {
        String[] items = getResources().getStringArray(R.array.items);
        mAdapter.addAll(items);
    }
}
