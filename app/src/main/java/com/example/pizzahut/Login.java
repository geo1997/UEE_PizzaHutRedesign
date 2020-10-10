package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pizzahut.ui.firstpage.FragmentHomePage;
import android.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzahut.ui.home.HomeFragment;

import prihanofficial.com.kokis.logics.Kokis;

public class Login extends AppCompatActivity {

    EditText inputPassword,inputEmail;
  Button buttonLogin;
  TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputPassword = findViewById(R.id.inputPassword);
        inputEmail = findViewById(R.id.inputEmail);
        buttonLogin = findViewById(R.id.btnLogin);
        register = findViewById(R.id.newUser);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });
    }

    private Boolean validateEmail() {
        String val = inputEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            inputEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            inputEmail.setError("Invalid email address");
            return false;
        } else {
            inputEmail.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = inputPassword.getText().toString();

        if (val.isEmpty()) {
            inputPassword.setError("Field cannot be empty");
            return false;
        }else {
            inputPassword.setError(null);
            return true;
        }
    }

    private void loginUser(){
     if(validateEmail() && validatePassword()) {
         Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();
         Kokis.setKokisBoolean("loginStatus", true);
         finish();
     }else {
         Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_LONG).show();
     }
    }
}