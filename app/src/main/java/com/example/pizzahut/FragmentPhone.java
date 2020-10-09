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

public class FragmentPhone extends Fragment {
    EditText currentPhone, newPhone, confirmPhone;
    Button btnUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_phone_layout, container, false);

        currentPhone = root.findViewById(R.id.currentPhone);
        newPhone = root.findViewById(R.id.newPhone);
        confirmPhone = root.findViewById(R.id.confirmPhone);
        btnUpdate = root.findViewById(R.id.btnResetPhone);

        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                add(v);
            }
        });

        return root;
    }

    public void add(View view){
        if (!validateCurrentPhone() || !validateNewPhone() || !validateConfirmPhone()){
            return;
        }
        String currentPhones = currentPhone.getText().toString();
        String newPhones = newPhone.getText().toString();
        String confirmPhones = confirmPhone.getText().toString();
    }

    private Boolean validateCurrentPhone() {
        String val = currentPhone.getText().toString();

        if (val.isEmpty()) {
            currentPhone.setError("Field cannot be empty");
            return false;
        } else {
            currentPhone.setError(null);
            return true;
        }
    }

    private Boolean validateNewPhone() {
        String val = newPhone.getText().toString();

        if (val.isEmpty()) {
            newPhone.setError("Field cannot be empty");
            return false;
        } else {
            newPhone.setError(null);
            return true;
        }
    }

    private Boolean validateConfirmPhone() {
        String val = confirmPhone.getText().toString();

        if (val.isEmpty()) {
            confirmPhone.setError("Field cannot be empty");
            return false;
        }else if (!newPhone.getText().toString().equals(confirmPhone.getText().toString())) {
            confirmPhone.setError("Phone does not match");
            return false;
        } else {
            confirmPhone.setError(null);
            return true;
        }
    }
}
