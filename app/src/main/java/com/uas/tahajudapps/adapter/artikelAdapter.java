package com.uas.tahajudapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.R;
import com.uas.tahajudapps.modal.Artikel;

import java.util.ArrayList;

public class artikelAdapter extends RecyclerView.Adapter<artikelAdapter.ArtikelViewHolder> {
    private ArrayList<Artikel> dataList;

    public artikelAdapter(ArrayList<Artikel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_slide_article, parent, false);
        return new ArtikelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelViewHolder holder, int position) {
        holder.tvTitle.setText(dataList.get(position).getTitle());
        holder.tvContent.setText(dataList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ArtikelViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvContent;

        public ArtikelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_Artikel);
            tvContent = (TextView)itemView.findViewById(R.id.tv_Content);
        }
    }
}
