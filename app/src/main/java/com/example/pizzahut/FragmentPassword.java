package com.example.pizzahut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPassword extends Fragment {
    EditText currentPassword, newPassword, confirmPassword;
    Button btnUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragement_password_layout, container, false);

        currentPassword = root.findViewById(R.id.currentPassword);
        newPassword = root.findViewById(R.id.newPassword);
        confirmPassword = root.findViewById(R.id.confirmPassword);
        btnUpdate = root.findViewById(R.id.btnResetPassword);

        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                add(v);
            }
        });

        return root;
    }

    public void add(View view){
        if (!validateCurrentPassword() || !validateNewPassword() || !validateConfirmPassword() ){
            return;
        }
        String currentEmails = currentPassword.getText().toString();
        String newEmails = newPassword.getText().toString();
        String confirmEmails = confirmPassword.getText().toString();
    }

    private Boolean validateCurrentPassword() {
        String val = currentPassword.getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                ".{4,}" +
                "$";

        if (val.isEmpty()) {
            currentPassword.setError("Field cannot be empty");
            return false;
        } else {
            currentPassword.setError(null);
            return true;
        }
    }

    private Boolean validateNewPassword() {
        String val = newPassword.getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                ".{4,}" +
                "$";

        if (val.isEmpty()) {
            newPassword.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            newPassword.setError("Password is too weak");
            return false;
        } else {
            newPassword.setError(null);
            return true;
        }
    }

    private Boolean validateConfirmPassword() {
        String val = confirmPassword.getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                ".{4,}" +
                "$";

        if (val.isEmpty()) {
            confirmPassword.setError("Field cannot be empty");
            return false;
        } else if (!newPassword.getText().toString().equals(confirmPassword.getText().toString())) {
            confirmPassword.setError("Password does not match");
            return false;
        } else {
            confirmPassword.setError(null);
            return true;
        }
    }
}
