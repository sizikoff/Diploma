package com.example.diploma.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diploma.R;

public class PasswordActivity extends AppCompatActivity {

    EditText admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_password);
        admin = findViewById(R.id.pass_admmin);

        admin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                Intent intent;
                switch (s.toString()){
                    case "12345":
                        intent = new Intent(PasswordActivity.this, AdminActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });

    }
}