package com.example.pizzahut.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizzahut.Feedback;
import com.example.pizzahut.R;
import com.example.pizzahut.SignUp;

public class FragmentFeedback extends Fragment {

    EditText firstName, lastName, contact,email,message;
    Button btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feedback, container, false);

        firstName = root.findViewById(R.id.fName);
        lastName = root.findViewById(R.id.lName);
        contact = root.findViewById(R.id.contact);
        email = root.findViewById(R.id.email);
        message = root.findViewById(R.id.editTextTextMultiLine2);
        btnAdd = root.findViewById(R.id.btnfeedback);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });

        return root;
    }

    public void add(View view){
        if (!validatefname() || !validatelname() || !validatecontact() || !validateEmail() ||  !validatemessage()){
            return;
        }else {
            firstName.setText("");
            lastName.setText("");
            contact.setText("");
            email.setText("");
            message.setText("");
            Toast.makeText(getActivity(),"Feedback Saved", Toast.LENGTH_LONG).show();
        }
    }

    private Boolean validatefname() {
        String val = firstName.getText().toString();

        if (val.isEmpty()) {
            firstName.setError("Field cannot be empty");
            return false;
        } else {
            firstName.setError(null);
            return true;
        }
    }

    private Boolean validatelname() {
        String val = lastName.getText().toString();

        if (val.isEmpty()) {
            lastName.setError("Field cannot be empty");
            return false;
        } else {
            lastName.setError(null);
            return true;
        }
    }

    private Boolean validatecontact() {
        String val = contact.getText().toString();

        if (val.isEmpty()) {
            contact.setError("Field cannot be empty");
            return false;
        } else {
            contact.setError(null);
            return true;
        }
    }

    private Boolean validatemessage() {
        String val = message.getText().toString();

        if (val.isEmpty()) {
            message.setError("Field cannot be empty");
            return false;
        } else {
            message.setError(null);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

}