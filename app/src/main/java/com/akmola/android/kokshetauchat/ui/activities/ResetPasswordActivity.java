package com.akmola.android.kokshetauchat.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.akmola.android.kokshetauchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText email;
    private Button reset;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        email = findViewById(R.id.email);
        reset = findViewById(R.id.btn_reset_password);
        progressBar = findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();
        
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString = email.getText().toString().trim();

                if (TextUtils.isEmpty(emailString)) {
                    email.setError("Введите email!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(emailString).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ResetPasswordActivity.this, "Мы отправили вам ссылку на email для сброса пароля!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ResetPasswordActivity.this, "Не удалось сбросить пароль! Введите зарегистрированный email или подключение к интернету отсутствует.", Toast.LENGTH_SHORT).show();
                        }
                        progressBar.setVisibility(View.GONE);
                    }
                });

            }
        });
    }
}
