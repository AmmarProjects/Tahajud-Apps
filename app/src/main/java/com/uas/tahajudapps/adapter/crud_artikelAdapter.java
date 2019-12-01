package com.uas.tahajudapps.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.R;
import com.uas.tahajudapps.modal.Artikel;
import com.uas.tahajudapps.viewArticle;

import java.util.ArrayList;

public class crud_artikelAdapter extends RecyclerView.Adapter<crud_artikelAdapter.crudArtikelViewHolder> {
    private ArrayList<Artikel> dataList;
    Context context;

    public crud_artikelAdapter(Context context, ArrayList<Artikel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public crudArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_crud_artikel, parent, false);
        crudArtikelViewHolder zz = new crudArtikelViewHolder(view);
        return zz;
    }

    @Override
    public void onBindViewHolder(@NonNull crudArtikelViewHolder holder, final int position) {
        final Artikel data = dataList.get(position);
        holder.tvSubtitle.setText(dataList.get(position).getTitle());
        holder.tvBody.setText(dataList.get(position).getContent());

        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, viewArticle.class);
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

    public class crudArtikelViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSubtitle, tvBody;
        private Button btnView;

        public crudArtikelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubtitle = (TextView)itemView.findViewById(R.id.subtitle_admin);
            tvBody = (TextView)itemView.findViewById(R.id.body_admin);
            btnView = (Button)itemView.findViewById(R.id.btn_view);
        }
    }
}
