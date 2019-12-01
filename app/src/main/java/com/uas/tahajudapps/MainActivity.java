package com.uas.tahajudapps;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.uas.tahajudapps.adapter.artikelAdapter;
import com.uas.tahajudapps.adapter.crud_contentAdapter;
import com.uas.tahajudapps.conf.Controller;
import com.uas.tahajudapps.conf.config;
import com.uas.tahajudapps.modal.Artikel;
import com.uas.tahajudapps.modal.Content;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerArtikel;
    RecyclerView.Adapter adapterArtikel;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog pd;
    ArrayList<Artikel> artikelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerArtikel = (RecyclerView) findViewById(R.id.recycler_artikel);
        artikelArrayList = new ArrayList<>();

        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerArtikel.setLayoutManager(layoutManager);

        adapterArtikel = new artikelAdapter(MainActivity.this, artikelArrayList);
        recyclerArtikel.setAdapter(adapterArtikel);

        getJSON();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.akun) {
            Intent intent = new Intent(MainActivity.this, AkunActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.card_tentang) {
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            intent.putExtra("key", "1");
            startActivity(intent);
        } else if (v.getId() == R.id.card_manfaat) {
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            intent.putExtra("key", "2");
            startActivity(intent);
        } else if (v.getId() == R.id.card_cara) {
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            intent.putExtra("key", "3");
            startActivity(intent);
        } else if (v.getId() == R.id.card_doa) {
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            intent.putExtra("key", "4");
            startActivity(intent);
        }
    }

    private void getJSON() {
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.POST, config.URL_GET_ARTICLE, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
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

                        artikelArrayList.add(zz);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterArtikel.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("volley", "error guys: " + error.getMessage());
            }
        });
        Controller.getInstance().addToRequestQueue(arrayRequest);
    }
}
