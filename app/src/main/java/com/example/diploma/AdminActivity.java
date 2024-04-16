package com.example.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    EditText etName,etEmail,etDolzhnost;

    Button btnAdd,btnRead,btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnRead = findViewById(R.id.btnRead);
        btnClear = findViewById(R.id.btnClear);
        etDolzhnost = findViewById(R.id.etDolzhnost);
        btnAdd = findViewById(R.id.btnAdd);
        ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.determinateBar);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty()|| etEmail.getText().toString().isEmpty() || etDolzhnost.getText().toString().isEmpty()) {
                    Toast.makeText(AdminActivity.this, "Проблема с вводом", Toast.LENGTH_SHORT).show();
                }else {
                    simpleProgressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    // Запустить Runnable через 10 секунд
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Скрыть ProgressBar
                            simpleProgressBar.setVisibility(View.GONE);
                            Toast.makeText(AdminActivity.this, "Данные отправлены в отдел кадров", Toast.LENGTH_SHORT).show();
                            etName.setText(null);
                            etEmail.setText(null);
                            etDolzhnost.setText(null);
                        }
                    }, 5000); // 10000 миллисекунд = 10 секунд
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
                builder.setTitle("FAQ")
                        .setMessage("Данный раздел существует для алминистрирования сотрудников")
                        .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Закрываем диалоговое окно
                                dialog.cancel();
                            }
                        });
                AlertDialog alert1 = builder.create();
                alert1.show();
            }
        });

    }

}