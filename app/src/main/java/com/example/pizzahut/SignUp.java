package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText firstName, lastName, inputEmail, inputPhone, inputPassword, inputConfPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = findViewById(R.id.currentPhone);
        lastName = findViewById(R.id.newPhone);
        inputEmail = findViewById(R.id.inputEmail);
        inputPhone = findViewById(R.id.inputPhone);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfPassword = findViewById(R.id.inputConfPassword);
    }

    public void add(View view){
        if (!validateFirstName() || !validateLastName() || !validateEmail() || !validatePhoneNo() || !validatePassword()){
            return;
        }
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String email = inputEmail.getText().toString();
        String phone = inputPhone.getText().toString();
        String password = inputPassword.getText().toString();
    }

    private Boolean validateFirstName() {
        String val = firstName.getText().toString();

        if (val.isEmpty()) {
            firstName.setError("Field cannot be empty");
            return false;
        }
        else {
            firstName.setError(null);
            return true;
        }
    }

    private Boolean validateLastName() {
        String val = lastName.getText().toString();

        if (val.isEmpty()) {
            lastName.setError("Field cannot be empty");
            return false;
        }
        else {
            lastName.setError(null);
            return true;
        }
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

    private Boolean validatePhoneNo() {
        String val = inputPhone.getText().toString();

        if (val.isEmpty()) {
            inputPhone.setError("Field cannot be empty");
            return false;
        } else {
            inputPhone.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = inputPassword.getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                ".{4,}" +
                "$";

        if (val.isEmpty()) {
            inputPassword.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            inputPassword.setError("Password is too weak");
            return false;
        } else {
            inputPassword.setError(null);
            return true;
        }
    }
}