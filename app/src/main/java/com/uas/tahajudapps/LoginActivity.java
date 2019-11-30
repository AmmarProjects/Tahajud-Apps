package com.uas.tahajudapps;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    Button btn_login, btn_cant_login;
    EditText edtUserID, edtPassword;

    private ProgressDialog pDialog;
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        btn_cant_login = findViewById(R.id.btn_cant_login);
        btn_cant_login.setOnClickListener(this);

        edtUserID = findViewById(R.id.edt_userid);
        edtPassword = findViewById(R.id.edt_password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                String username = edtUserID.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (validateInputs()){
                    if (username.equals("admin") && password.equals("admin")){
                        loadDashboard();
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                break;
            case R.id.btn_cant_login:
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private boolean validateInputs() {
        if(edtUserID.equals("")){
            edtUserID.setError("Username tidak boleh kosong");
            edtUserID.requestFocus();
            return false;
        }
        if(edtPassword.equals("")){
            edtPassword.setError("Password tidak boleh kosong");
            edtPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void loadDashboard() {
        Intent i = new Intent(getApplicationContext(), TampilanAdmin.class);
        startActivity(i);
        finish();
    }
}
