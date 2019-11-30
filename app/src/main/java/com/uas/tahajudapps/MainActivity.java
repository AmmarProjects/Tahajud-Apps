package com.uas.tahajudapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.adapter.artikelAdapter;
import com.uas.tahajudapps.modal.Artikel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private artikelAdapter adapterArtikel;
    private ArrayList<Artikel> artikelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addArtikel();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_artikel);
        adapterArtikel = new artikelAdapter(artikelArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterArtikel);
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

    void addArtikel() {
        artikelArrayList = new ArrayList<>();
        artikelArrayList.add(new Artikel("The Power of Tahajud", "Jum’at 15 Nov 2019", "Tahajud adalah salah satu"));
        artikelArrayList.add(new Artikel("The Infinity", "Jum’at 15 Nov 2019", "Tahajud adalah salah satu"));
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
}
