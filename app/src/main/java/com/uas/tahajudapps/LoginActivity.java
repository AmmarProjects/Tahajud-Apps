package com.uas.tahajudapps;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        if (view.getId() == R.id.btn_login) {
            if (validateInputs()){
                sendLogin();
            }
        }else if(view.getId() == R.id.btn_cant_login){
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean validateInputs() {
        if(edtUserID.getText().toString().trim().equals("")){
            edtUserID.setError("Username tidak boleh kosong");
            edtUserID.requestFocus();
            return false;
        }
        if(edtPassword.getText().toString().trim().equals("")){
            edtPassword.setError("Password tidak boleh kosong");
            edtPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void sendLogin() {
        StringRequest loginRequest = new StringRequest(Request.Method.POST, "https://tugas.ammarprojects.com/Tahajud/user/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            String status = json.getString("status");
                            if(status.equals("success")){
                                Intent intent = new Intent(LoginActivity.this, TampilanAdmin.class);
                                Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(), "Username & Password Salah", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("username", edtUserID .getText().toString());
                params.put("password", edtPassword.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(loginRequest);
    }
}
