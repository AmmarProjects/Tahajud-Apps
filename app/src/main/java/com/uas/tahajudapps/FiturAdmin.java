package com.uas.tahajudapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FiturAdmin extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur_admin);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.card_tentang){
            Intent intent = new Intent(FiturAdmin.this, listContent.class);
            intent.putExtra("key","1");
            startActivity(intent);
        }else if (v.getId() == R.id.card_manfaat){
            Intent intent = new Intent(FiturAdmin.this, listContent.class);
            intent.putExtra("key","2");
            startActivity(intent);
        }else if (v.getId() == R.id.card_cara){
            Intent intent = new Intent(FiturAdmin.this, listContent.class);
            intent.putExtra("key","3");
            startActivity(intent);
        }else if (v.getId() == R.id.card_doa){
            Intent intent = new Intent(FiturAdmin.this, listContent.class);
            intent.putExtra("key","4");
            startActivity(intent);
        }
    }
}
