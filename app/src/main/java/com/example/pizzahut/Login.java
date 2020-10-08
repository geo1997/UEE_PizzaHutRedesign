package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText inputPassword,inputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputPassword = findViewById(R.id.inputPassword);
        inputEmail = findViewById(R.id.inputEmail);
    }

    public void add(View view){
        if (!validateEmail() || !validatePassword()){
            return;
        }
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
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
}