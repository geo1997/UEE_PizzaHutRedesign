package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pizzahut.ui.firstpage.FragmentHomePage;
import android.app.Fragment;
import android.widget.Toast;

import com.example.pizzahut.ui.home.HomeFragment;

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
        else{

            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();

//
//            Fragment someFragment = new Fragment();
//            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//            transaction.replace(R.id.fragment_menuid, someFragment ); // give your fragment container id in first parameter
//            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//            transaction.commit();



            Intent intent=new Intent(getApplicationContext(),HomeFragment.class);
            //intent.putExtra("pos",1);
            startActivity(intent);
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