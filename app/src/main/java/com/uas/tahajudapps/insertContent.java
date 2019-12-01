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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.uas.tahajudapps.conf.Controller;
import com.uas.tahajudapps.conf.config;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class insertContent extends AppCompatActivity implements View.OnClickListener {
    private String value;

    ProgressDialog pd;

    Button btnSave;
    EditText edtSubtitle, edtBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_content);

        edtSubtitle = findViewById(R.id.edt_title_content);
        edtBody = findViewById(R.id.edt_body_content);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.value = extras.getString("key");
            Toast.makeText(insertContent.this, value , Toast.LENGTH_SHORT).show();
        }

        btnSave = findViewById(R.id.btn_add_content);
        btnSave.setOnClickListener(this);
    }

    private void simpanData()
    {
        StringRequest sendData = new StringRequest(Request.Method.POST, config.URL_ADD_CONTENT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.setMessage("Menyimpan Data");
                        pd.setCancelable(false);
                        pd.show();
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(insertContent.this, "Data Berhasil Disimpan" , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity( new Intent(insertContent.this,listContent.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(insertContent.this, "pesan : Gagal Insert Data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("subtitle_content",edtSubtitle.getText().toString().trim());
                map.put("body_content",edtBody.getText().toString().trim());
                map.put("id_category",value);

                return map;
            }
        };
        Controller.getInstance().addToRequestQueue(sendData);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_content){
            simpanData();
        }
    }
}
