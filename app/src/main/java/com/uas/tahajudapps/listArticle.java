package com.uas.tahajudapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.uas.tahajudapps.adapter.crud_artikelAdapter;
import com.uas.tahajudapps.conf.Controller;
import com.uas.tahajudapps.conf.config;
import com.uas.tahajudapps.modal.Artikel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class listArticle extends AppCompatActivity {
    RecyclerView recyclerArticle;
    RecyclerView.Adapter adapterArticle;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog pd;
    ArrayList<Artikel> articleArrayList;

    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.value = extras.getString("key");
        }

        pd = new ProgressDialog(listArticle.this);
        recyclerArticle = (RecyclerView) findViewById(R.id.list_article);
        articleArrayList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(listArticle.this, LinearLayoutManager.VERTICAL, false);
        recyclerArticle.setLayoutManager(layoutManager);
        adapterArticle = new crud_artikelAdapter(listArticle.this, articleArrayList);
        recyclerArticle.setAdapter(adapterArticle);

        getJSON();
    }

    private void getJSON() {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.POST, config.URL_GET_ARTICLE, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                pd.cancel();
                Log.d("volley", "response : " + response.toString());

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject data = response.getJSONObject(i);
                        Artikel zz = new Artikel();
                        zz.setId(data.getString("id_article"));
                        zz.setTitle(data.getString("title_article"));
                        zz.setDate(data.getString("date_article"));
                        zz.setContent(data.getString("content_article"));
                        zz.setImage(data.getString("img_article"));

                        articleArrayList.add(zz);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterArticle.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pd.cancel();
                Log.d("volley", "error guys: " + error.getMessage());
            }
        });
        Controller.getInstance().addToRequestQueue(arrayRequest);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tambah){
            Intent intent = new Intent(listArticle.this, insertArticle.class);
            intent.putExtra("key",value);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}