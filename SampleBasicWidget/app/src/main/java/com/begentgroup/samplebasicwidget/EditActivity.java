package com.begentgroup.samplebasicwidget;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText emailView, passwordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        emailView = (EditText)findViewById(R.id.edit_email);
        passwordView = (EditText)findViewById(R.id.edit_password);

        passwordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                String pass = s.toString();
                if (pass.length() < 5) {
                    passwordView.setTextColor(Color.RED);
                } else {
                    passwordView.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String email = emailView.getText().toString();
                    String password = passwordView.getText().toString();
                    if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(EditActivity.this, "send email & password", Toast.LENGTH_SHORT).show();
                        return false;
                    } else {
                        Toast.makeText(EditActivity.this, "incorrect email address", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
