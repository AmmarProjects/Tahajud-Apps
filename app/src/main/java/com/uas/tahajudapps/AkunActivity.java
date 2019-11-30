package com.uas.tahajudapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.uas.tahajudapps.adapter.aslabAdapter;
import com.uas.tahajudapps.adapter.dosenAdapter;
import com.uas.tahajudapps.adapter.userAdapter;
import com.uas.tahajudapps.conf.DatabaseHelper;
import com.uas.tahajudapps.modal.User;

import java.util.ArrayList;
import java.util.List;

public class AkunActivity extends AppCompatActivity {

    private RecyclerView recyclerDeveloper, recyclerDosen, recyclerAslab;
    private DatabaseHelper db = new DatabaseHelper(this);
    private userAdapter adapterUser;
    private dosenAdapter adapterDosen;
    private aslabAdapter adapterAslab;
    private List<User> userArrayList = new ArrayList<>();
    private List<User> dosenArrayList = new ArrayList<>();
    private List<User> aslabArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        userArrayList = db.readDeveloper();
        recyclerDeveloper = (RecyclerView) findViewById(R.id.recycler_developer);
        adapterUser = new userAdapter(userArrayList);

        dosenArrayList = db.readDosen();
        recyclerDosen = (RecyclerView) findViewById(R.id.recycler_dosen);
        adapterDosen = new dosenAdapter(dosenArrayList);

        aslabArrayList = db.readAslab();
        recyclerAslab = (RecyclerView) findViewById(R.id.recycler_aslab);
        adapterAslab = new aslabAdapter(aslabArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(AkunActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerDeveloper.setLayoutManager(layoutManager);
        recyclerDeveloper.setAdapter(adapterUser);
        recyclerDeveloper.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(AkunActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerDosen.setLayoutManager(layoutManager2);
        recyclerDosen.setAdapter(adapterDosen);
        recyclerDosen.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(AkunActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerAslab.setLayoutManager(layoutManager3);
        recyclerAslab.setAdapter(adapterAslab);
        recyclerAslab.setNestedScrollingEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.masuk){
            int status = 1;
            if (status == 1){
                Intent intent = new Intent(AkunActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }else{
                Intent intent = new Intent(AkunActivity.this, TampilanAdmin.class);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
