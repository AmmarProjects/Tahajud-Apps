package com.uas.tahajudapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TampilanAdmin extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_admin);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.card_content) {
            Intent intent = new Intent(TampilanAdmin.this, FiturAdmin.class);
            startActivity(intent);
        }
//        else if (view.getId() == R.id.card_artikel){
//            Intent intent = new Intent(AdminFitur.this, CRUDArtikel.class);
//            startActivity(intent);
//        }
    }
}
