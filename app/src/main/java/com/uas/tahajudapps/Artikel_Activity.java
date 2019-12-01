package com.uas.tahajudapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Artikel_Activity extends AppCompatActivity {

    private String id, title, date, content, image;
    TextView tvTitle, tvDate, tvArticle;
    ImageView imgContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);
        getSupportActionBar().hide();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.id = extras.getString("id");
            this.title = extras.getString("title");
            this.date = extras.getString("date");
            this.content = extras.getString("content");
            this.image = extras.getString("image");
        }

        tvTitle = findViewById(R.id.tv_Title);
        tvDate = findViewById(R.id.tv_Date);
        tvArticle = findViewById(R.id.tv_Article);

        tvTitle.setText(this.title);
        tvDate.setText(this.date);
        tvArticle.setText(this.content);
    }
}
