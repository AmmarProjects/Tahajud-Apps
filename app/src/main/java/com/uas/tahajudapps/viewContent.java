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

public class viewContent extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTitle;
    private EditText edtContent;

    private Button buttonUpdate;
    private Button buttonDelete;
    String id, subtitle, body, category;

    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.id = extras.getString("key");
            this.subtitle = extras.getString("subtitle");
            this.body = extras.getString("body");
            this.category = extras.getString("category");
        }

        edtTitle = (EditText) findViewById(R.id.edt_title_content);
        edtContent = (EditText) findViewById(R.id.edt_content);

        buttonUpdate = (Button) findViewById(R.id.btn_update_content);
        buttonDelete = (Button) findViewById(R.id.btn_delete_content);

        edtTitle.setText(subtitle);
        edtContent.setText(body);

        buttonDelete.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
    }

    private void updateContent()
    {
        StringRequest updateReq = new StringRequest(Request.Method.POST, config.URL_UPDATE_CONTENT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(viewContent.this ,"Data berhasil diupdate" , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(viewContent.this, listContent.class);
                        intent.putExtra("key",category);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(viewContent.this, "pesan : Gagal Update Data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("id",id);
                map.put("subtitle_content",edtTitle.getText().toString().trim());
                map.put("body_content",edtContent.getText().toString().trim());
                map.put("id_category",category);

                return map;
            }
        };

        Controller.getInstance().addToRequestQueue(updateReq);
    }

    private void deleteContent(){
        
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_update_content){
            updateContent();
        }else if(v.getId() == R.id.btn_delete_content){
            deleteContent();
        }
    }
}
