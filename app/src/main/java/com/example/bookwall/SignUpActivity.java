package com.example.bookwall;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button signup;
    EditText username ,password , passwordconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = findViewById(R.id.sign_up_toolbar);
        signup = findViewById(R.id.sign_up);
        username = findViewById(R.id.sign_up_username);
        password = findViewById(R.id.sign_up_password);
        passwordconfirm = findViewById(R.id.sign_up_password_confirm);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().length()>0){
                    if (password.getText().toString().length()>0){
                        if (passwordconfirm.getText().toString().length()>0){
                            startActivity(new Intent(SignUpActivity.this,MainPageActivity.class));
                            Toast.makeText(SignUpActivity.this, "خوش آمدید", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SignUpActivity.this, "پسورد خود را وارد کنید", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignUpActivity.this, "پسورد خود را وارد کنید", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SignUpActivity.this, "نام کاربری خود را وارد کنید", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
