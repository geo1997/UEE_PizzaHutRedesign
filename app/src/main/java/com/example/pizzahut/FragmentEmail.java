package com.example.pizzahut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentEmail extends Fragment {

    EditText currentEmail, newEmail, confirmEmail;
    Button btnUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragement_email_layout, container, false);

        currentEmail = root.findViewById(R.id.currentEmail);
        newEmail = root.findViewById(R.id.newEmail);
        confirmEmail = root.findViewById(R.id.confirmEmail);
        btnUpdate = root.findViewById(R.id.btnResetEmail);

        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                add(v);
            }
        });

        return root;
    }

    public void add(View view){
        if (!validateCurrentEmail() || !validateNewEmail() || !validateConfirmEmail()){
            return;
        }else {
            currentEmail.setText("");
            newEmail.setText("");
            confirmEmail.setText("");
            Toast.makeText(getActivity(),"Email Changed", Toast.LENGTH_LONG).show();
        }
        String currentEmails = currentEmail.getText().toString();
        String newEmails = newEmail.getText().toString();
        String confirmEmails = confirmEmail.getText().toString();
    }

    private Boolean validateCurrentEmail() {
        String val = currentEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            currentEmail.setError("Field cannot be empty");
            return false;
        } else {
            currentEmail.setError(null);
            return true;
        }
    }

    private Boolean validateNewEmail() {
        String val = newEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            newEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            newEmail.setError("Invalid email address");
            return false;
        } else {
            newEmail.setError(null);
            return true;
        }
    }

    private Boolean validateConfirmEmail() {
        String val = currentEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            confirmEmail.setError("Field cannot be empty");
            return false;
        } else if (!newEmail.getText().toString().equals(confirmEmail.getText().toString())) {
            confirmEmail.setError("Email address does not match");
            return false;
        } else {
            confirmEmail.setError(null);
            return true;
        }
    }

}
