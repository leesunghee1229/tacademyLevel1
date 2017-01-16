package com.begentgroup.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    TextView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        messageView = (TextView)findViewById(R.id.text_message);
        Button btn = (Button)findViewById(R.id.btn_selected);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageView.setSelected(!messageView.isSelected());
            }
        });

        btn = (Button)findViewById(R.id.btn_chage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                messageView.setText(R.string.change_text_message);
                String message = getResources().getString(R.string.change_text_message);
                messageView.setText(message);
            }
        });

        btn = (Button)findViewById(R.id.btn_html);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String html = getResources().getString(R.string.html_text);
                messageView.setText(Html.fromHtml(html));
            }
        });
    }
}
