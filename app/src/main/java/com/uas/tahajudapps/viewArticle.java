package com.uas.tahajudapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class viewArticle extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTitle;
    private EditText edtContent;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id, title,  date, content, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_article);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.id = extras.getString("id");
            this.title = extras.getString("title");
            this.date = extras.getString("body");
            this.content = extras.getString("content");
            this.image = extras.getString("image");
        }

        edtTitle = findViewById(R.id.edt_title_article);
        edtContent= findViewById(R.id.edt_body_article);

        edtTitle.setText(title);
        edtContent.setText(content);

        buttonDelete = findViewById(R.id.btn_delete_article);
        buttonUpdate = findViewById(R.id.btn_update_article);

        buttonDelete.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
    }

    private void updateArticle()
    {
        StringRequest updateReq = new StringRequest(Request.Method.POST, config.URL_UPDATE_ARTICLE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(viewArticle.this ,"Data berhasil diupdate" , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(viewArticle.this, TampilanAdmin.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(viewArticle.this, "pesan : Gagal Update Data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("id",id);
                map.put("title_article",edtTitle.getText().toString().trim());
                map.put("content_article",edtContent.getText().toString().trim());

                return map;
            }
        };

        Controller.getInstance().addToRequestQueue(updateReq);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_update_article){
            updateArticle();
        }else if(v.getId() == R.id.btn_delete_article){
//            deleteArticle();
        }
    }
}
