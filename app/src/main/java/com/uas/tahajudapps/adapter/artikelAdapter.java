package com.uas.tahajudapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.R;
import com.uas.tahajudapps.modal.Artikel;
import com.uas.tahajudapps.viewArtikel;
import com.uas.tahajudapps.viewContent;

import java.util.ArrayList;

public class artikelAdapter extends RecyclerView.Adapter<artikelAdapter.ArtikelViewHolder> {
    private ArrayList<Artikel> dataList;
    Context context;

    public artikelAdapter(Context context, ArrayList<Artikel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public artikelAdapter.ArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_slide_article, parent, false);
        artikelAdapter.ArtikelViewHolder zz = new artikelAdapter.ArtikelViewHolder(view);
        return zz;
    }

    @Override
    public void onBindViewHolder(@NonNull artikelAdapter.ArtikelViewHolder holder, final int position) {
        final Artikel data = dataList.get(position);
        holder.tvTitle.setText(dataList.get(position).getTitle());
        holder.tvContent.setText(dataList.get(position).getContent());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, viewArtikel.class);
                intent.putExtra("id",dataList.get(position).getId());
                intent.putExtra("title",dataList.get(position).getTitle());
                intent.putExtra("date",dataList.get(position).getDate());
                intent.putExtra("content",dataList.get(position).getContent());
                intent.putExtra("image",dataList.get(position).getImage());
                context.startActivity(intent);
                Toast.makeText(context, "You Clicked "+dataList.get(position).getId(), Toast.LENGTH_LONG).show();
            }
        });

        holder.btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, viewArtikel.class);
                intent.putExtra("id",dataList.get(position).getId());
                intent.putExtra("title",dataList.get(position).getTitle());
                intent.putExtra("date",dataList.get(position).getDate());
                intent.putExtra("content",dataList.get(position).getContent());
                intent.putExtra("image",dataList.get(position).getImage());
                context.startActivity(intent);
                Toast.makeText(context, "You Clicked "+dataList.get(position).getId(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ArtikelViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvContent;
        private CardView card;
        private ImageButton btnImage;
        public ArtikelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_Title);
            tvContent = (TextView)itemView.findViewById(R.id.tv_Content);
            card = (CardView) itemView.findViewById(R.id.clickCard);
            btnImage = (ImageButton) itemView.findViewById(R.id.btn_image);
        }
    }
}

