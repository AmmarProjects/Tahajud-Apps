package com.uas.tahajudapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_register, btn_cant_register;
    EditText edtUsername, edtFullname, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtUsername = findViewById(R.id.edt_username);
        edtFullname = findViewById(R.id.edt_fullname);
        edtPassword = findViewById(R.id.edt_password);

        btn_register = findViewById(R.id.btn_signup);
        btn_cant_register = findViewById(R.id.btn_cant_signup);

        btn_register.setOnClickListener(this);
        btn_cant_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_signup){

        }else if(v.getId() == R.id.btn_cant_signup){

        }
    }
}
