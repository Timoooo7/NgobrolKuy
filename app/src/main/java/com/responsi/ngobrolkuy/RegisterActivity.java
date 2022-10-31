package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private EditText conf;
    private CardView regBtn;
    private TextView loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        conf = findViewById(R.id.conf);
        regBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginBtn);


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals(conf.getText().toString())){
                    Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                    login.putExtra("username", username.getText().toString());
                    login.putExtra("password", password.getText().toString());
                    login.putExtra("email", email.getText().toString());
                    startActivity(login);
                }else{
                    Toast.makeText(RegisterActivity.this, "Passsword tidak cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }
}