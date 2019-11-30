package com.uas.tahajudapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.uas.tahajudapps.adapter.contentAdapter;
import com.uas.tahajudapps.conf.Controller;
import com.uas.tahajudapps.conf.config;
import com.uas.tahajudapps.modal.Content;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {
    RecyclerView recyclerContent;
    RecyclerView.Adapter adapterContent;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog pd;
    ArrayList<Content> contentArrayList;
    private String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.value = extras.getString("key");
        }

        pd = new ProgressDialog(ContentActivity.this);
        recyclerContent = (RecyclerView) findViewById(R.id.recycler_content);
        contentArrayList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(ContentActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerContent.setLayoutManager(layoutManager);
        adapterContent = new contentAdapter(ContentActivity.this, contentArrayList);
        recyclerContent.setAdapter(adapterContent);

        getJSON();
    }
    private void getJSON(){
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.POST, config.getURL(value), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                pd.cancel();
                Log.d("volley", "response : " + response.toString());

                for (int i=0; i < response.length(); i++){
                    try {
                        JSONObject data = response.getJSONObject(i);
                        Content zz = new Content();
                        zz.setId(data.getString("id_content"));
                        zz.setSubtitle(data.getString("subtitle_content"));
                        zz.setBody(data.getString("body_content"));
                        zz.setCategory(data.getString("id_category"));
                        contentArrayList.add(zz);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterContent.notifyDataSetChanged();
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                pd.cancel();
                Log.d("volley", "error guys: " + error.getMessage());
            }
        });
        Controller.getInstance().addToRequestQueue(arrayRequest);
    }
}
